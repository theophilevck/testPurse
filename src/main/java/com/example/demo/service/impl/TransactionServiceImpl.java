package com.example.demo.service.impl;


import com.example.demo.dto.RetrieveTransactionRequestDto;
import com.example.demo.dto.RetrieveTransactionResponseDto;
import com.example.demo.dto.SaveTransactionRequestDto;
import com.example.demo.dto.StatusTypeEnumDto;
import com.example.demo.dto.UpdateTransactionRequestDto;
import com.example.demo.dto.UpdateTransactionResponseDto;
import com.example.demo.entities.StatusEnum;
import com.example.demo.entities.Transaction;
import com.example.demo.repository.TransactionRepository;
import com.example.demo.service.TransactionService;
import com.example.demo.web.mapper.Transaction.TransactionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;


    @Override
    public Mono<Void> dEMO11(SaveTransactionRequestDto saveTransactionRequestDto, ServerWebExchange exchange) {
        return Mono.just(transactionMapper.fromSaveTransactionRequestDtoToTransaction(saveTransactionRequestDto))
                .map(transactionRepository::save)
                .doOnError(throwable -> Mono.error(new RuntimeException("Transaction not saved")))
                .then();
    }

    @Override
    public Mono<RetrieveTransactionResponseDto> dEMO12(RetrieveTransactionRequestDto retrieveTransactionRequestDto, ServerWebExchange exchange) {
        return Mono.justOrEmpty(transactionRepository.findById(Long.valueOf(retrieveTransactionRequestDto.getTransactionId())))
                .map(transactionMapper::fromTransactionToRetrieveTransactionResponseDto)
                .doOnError(throwable -> Mono.error(new RuntimeException("Transaction not found")));
    }

    @Override
    public Mono<UpdateTransactionResponseDto> dEMO13(UpdateTransactionRequestDto updateTransactionRequestDto, ServerWebExchange exchange) {
        return Mono.justOrEmpty(transactionRepository.findById(Long.valueOf(updateTransactionRequestDto.getTransactionId())))
                .map(currentTransaction -> {
                    validateUpdate(updateTransactionRequestDto, currentTransaction);
                    return transactionMapper.fromUpdateTransactionRequestDtoToTransaction(updateTransactionRequestDto, currentTransaction);
                })
                .flatMap(transaction -> Mono.justOrEmpty(transactionRepository.save(transaction)))
                .map(transactionMapper::fromTransactionToUpdateTransactionResponseDto)
                .switchIfEmpty(Mono.error(new RuntimeException("Transaction not found")));
    }


    private void validateUpdate(UpdateTransactionRequestDto updateTransactionRequestDto, Transaction currentTransaction) {
        StatusTypeEnumDto newStatus = updateTransactionRequestDto.getStatus();
        StatusEnum currentStatus = currentTransaction.getStatus();

        if (newStatus == StatusTypeEnumDto.IN_PROGRESS && currentStatus != StatusEnum.IN_PROGRESS) {
            throw new IllegalArgumentException("A new transaction must be in the 'IN_PROGRESS' state");
        }

        if (newStatus == StatusTypeEnumDto.CAPTURED && currentStatus != StatusEnum.AUTHORIZED) {
            throw new IllegalArgumentException("It's not possible to change the transaction status to 'CAPTURED' if the transaction is not in the 'AUTHORIZED' state");
        }
    }



}
