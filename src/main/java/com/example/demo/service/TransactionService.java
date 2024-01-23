package com.example.demo.service;


import com.example.demo.dto.RetrieveTransactionRequestDto;
import com.example.demo.dto.RetrieveTransactionResponseDto;
import com.example.demo.dto.SaveTransactionRequestDto;
import com.example.demo.dto.UpdateTransactionRequestDto;
import com.example.demo.dto.UpdateTransactionResponseDto;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public interface TransactionService {

    Mono<Void> dEMO11(SaveTransactionRequestDto saveTransactionRequestDto, ServerWebExchange exchange);

    Mono<RetrieveTransactionResponseDto> dEMO12(RetrieveTransactionRequestDto retrieveTransactionRequestDto, ServerWebExchange exchange);

    Mono<UpdateTransactionResponseDto> dEMO13(UpdateTransactionRequestDto updateTransactionRequestDto, ServerWebExchange exchange);


}
