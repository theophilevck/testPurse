package com.example.demo.service;


import com.example.demo.dto.TransactionDto;
import com.example.demo.dto.TransactionResponseDto;
import reactor.core.publisher.Mono;

public interface TransactionService {

    Mono<Void> createTransaction(TransactionDto saveTransactionDto);

    Mono<TransactionResponseDto> retrieveTransaction(String transactionId);

    Mono<TransactionResponseDto> updateTransaction(TransactionDto updateTransactionDto);


}
