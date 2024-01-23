package com.example.demo.web.controller;

import com.example.demo.dto.RetrieveTransactionRequestDto;
import com.example.demo.dto.RetrieveTransactionResponseDto;
import com.example.demo.dto.SaveTransactionRequestDto;
import com.example.demo.dto.UpdateTransactionRequestDto;
import com.example.demo.dto.UpdateTransactionResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class TransactionController implements TransactionApi {


    @Override
    public Mono<Object> dEMO11(Mono<SaveTransactionRequestDto> saveTransactionRequestDto, ServerWebExchange exchange) {
        return null;
    }

    @Override
    public Mono<RetrieveTransactionResponseDto> dEMO12(Mono<RetrieveTransactionRequestDto> retrieveTransactionRequestDto, ServerWebExchange exchange) {
        return null;
    }

    @Override
    public Mono<UpdateTransactionResponseDto> dEMO13(Mono<UpdateTransactionRequestDto> updateTransactionRequestDto, ServerWebExchange exchange) {
        return null;
    }
}