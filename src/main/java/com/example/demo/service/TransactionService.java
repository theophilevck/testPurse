package com.example.demo.service;


import com.example.demo.dto.TransactionDto;
import com.example.demo.dto.TransactionResponseDto;
import com.example.demo.entities.Transaction;
import reactor.core.publisher.Mono;

public interface TransactionService {

    Mono<TransactionResponseDto> createTransaction(TransactionDto transactionDto);

    Mono<TransactionResponseDto> retrieveTransaction(String transactionId);

    Mono<TransactionResponseDto> updateTransaction(TransactionDto updateTransactionDto);


}
