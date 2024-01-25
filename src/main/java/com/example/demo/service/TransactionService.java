package com.example.demo.service;


import com.example.demo.dto.TransactionDto;
import com.example.demo.dto.TransactionResponseDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransactionService {

    Mono<TransactionResponseDto> createTransaction(TransactionDto transactionDto);

    Flux<TransactionResponseDto> retrieveAllTransaction();

    Mono<TransactionResponseDto> updateTransaction(TransactionDto updateTransactionDto);


}
