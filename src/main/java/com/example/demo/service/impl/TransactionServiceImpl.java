package com.example.demo.service.impl;


import com.example.demo.dto.TransactionDto;
import com.example.demo.dto.TransactionResponseDto;
import com.example.demo.entities.StatusEnum;
import com.example.demo.entities.Transaction;
import com.example.demo.repository.TransactionRepository;
import com.example.demo.service.TransactionService;
import com.example.demo.web.mapper.Transaction.TransactionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;


    @Override
    public Mono<Void> createTransaction(TransactionDto saveTransactionRequestDto) {
        return Mono.just(transactionMapper.fromTransactionDtoToTransaction(saveTransactionRequestDto))
                .map(transactionRepository::save)
                .doOnError(throwable -> Mono.error(new RuntimeException("Transaction not saved")))
                .then();
    }

    @Override
    public Mono<TransactionResponseDto> retrieveTransaction(String TransactionId) {
        return transactionRepository.findById(Long.valueOf(TransactionId))
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
