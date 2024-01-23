package com.example.demo.service.impl;


import com.example.demo.dto.RetrieveTransactionRequestDto;
import com.example.demo.dto.RetrieveTransactionResponseDto;
import com.example.demo.dto.SaveTransactionRequestDto;
import com.example.demo.dto.UpdateTransactionRequestDto;
import com.example.demo.dto.UpdateTransactionResponseDto;
import com.example.demo.repository.TransactionRepository;
import com.example.demo.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;


    @Override
    public Mono<Void> dEMO11(SaveTransactionRequestDto saveTransactionRequestDto, ServerWebExchange exchange) {
        return null;
    }

    @Override
    public Mono<RetrieveTransactionResponseDto> dEMO12(RetrieveTransactionRequestDto retrieveTransactionRequestDto, ServerWebExchange exchange) {
        return null;
    }

    @Override
    public Mono<UpdateTransactionResponseDto> dEMO13(UpdateTransactionRequestDto updateTransactionRequestDto, ServerWebExchange exchange) {
        return null;
    }
}
