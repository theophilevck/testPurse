package com.example.demo.service.impl;


import com.example.demo.dto.TransactionDto;
import com.example.demo.dto.TransactionResponseDto;
import com.example.demo.entities.OrderLine;
import com.example.demo.entities.StatusEnum;
import com.example.demo.entities.Transaction;
import com.example.demo.repository.OrderLineRepository;
import com.example.demo.repository.TransactionRepository;
import com.example.demo.service.TransactionService;
import com.example.demo.web.mapper.OrderLine.OrderLineMapper;
import com.example.demo.web.mapper.Transaction.TransactionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;
    private final OrderLineRepository orderLineRepository;
    private final OrderLineMapper orderLineMapper;
    private final DatabaseClient databaseClient;


    @Override
    public Mono<TransactionResponseDto> createTransaction(TransactionDto transactionDto) {
        Transaction transaction = transactionMapper.fromTransactionDtoToTransactionCreation(transactionDto);
        String nextValQuery = "CALL NEXT VALUE FOR transaction_id_seq";

        return databaseClient.sql(nextValQuery)
                .map(row -> row.get(0, Long.class))
                .one()
                .doOnNext(transaction::setId)
                .then(transactionRepository.save(transaction))
                .flatMap(savedTransaction -> {
                    List<Mono<OrderLine>> orderLineMonos = transactionDto.getOrders().stream()
                            .map(orderLineDto -> {
                                OrderLine orderLine = orderLineMapper.fromOrderLineDtoToOrderLine(orderLineDto);
                                orderLine.setTransactionId(savedTransaction.getId());
                                return orderLineRepository.save(orderLine);
                            })
                            .collect(Collectors.toList());

                    return Mono.when(orderLineMonos)
                            .thenReturn(savedTransaction);
                })
                .map(transactionMapper::fromTransactionToTransactionResultDto);
    }



    @Override
    public Flux<TransactionResponseDto> retrieveAllTransaction() {
        return transactionRepository.findAll()
                .flatMap(transaction ->
                        orderLineRepository.findByTransactionId(transaction.getId())
                                .collectList()
                                .map(orderLines -> {
                                    transaction.setOrders(orderLines);
                                    return transaction;
                                })
                )
                .map(transactionMapper::fromTransactionToTransactionResultDto)
                .doOnError(throwable -> Mono.error(new RuntimeException("Transaction not found")));
    }

    @Override
    public Mono<TransactionResponseDto> updateTransaction(TransactionDto updateTransactionDto) {
        return transactionRepository.findById(updateTransactionDto.getId())
                .flatMap(currentTransaction -> {
                    validateUpdate(updateTransactionDto, currentTransaction);
                    Transaction updatedTransaction = transactionMapper.updateTransactionMapper(updateTransactionDto, currentTransaction);
                    return transactionRepository.save(updatedTransaction);
                })
                .map(transactionMapper::fromTransactionToTransactionResultDto)
                .switchIfEmpty(Mono.error(new RuntimeException("Transaction not found")));
    }


    private void validateUpdate(TransactionDto transactionDto, Transaction currentTransaction) {
        StatusEnum newStatus = transactionDto.getStatus();
        StatusEnum currentStatus = currentTransaction.getStatus();

        if (newStatus.equals(StatusEnum.CAPTURED) && currentStatus != StatusEnum.AUTHORIZED) {
            throw new IllegalArgumentException("It's not possible to change the transaction status to 'CAPTURED' if the transaction is not in the 'AUTHORIZED' state");
        }

        if (currentStatus.equals(StatusEnum.CAPTURED)) {
            throw new IllegalArgumentException("It's not possible to modify the status of a 'CAPTURED' transaction");
        }
    }

}
