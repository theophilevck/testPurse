package com.example.demo.web.controller;


import com.example.demo.dto.TransactionDto;
import com.example.demo.dto.TransactionResponseDto;
import com.example.demo.service.TransactionService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Validated
@RequestMapping("/Transaction")
@RestController
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;


    @PostMapping("/save")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "create Transaction")})
    public Mono<Void> createTransaction(@Valid @RequestBody TransactionDto transactionDTO) {
        return transactionService.createTransaction(transactionDTO);
    }

    @PostMapping("/update")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "update Transaction")})
    public Mono<TransactionResponseDto> updateTransaction(TransactionDto updateTransactionRequestDto, ServerWebExchange exchange) {
        return transactionService.updateTransaction(updateTransactionRequestDto);
    }

    @PostMapping("/retrieve")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "retrieve Transaction")})
    public Mono<TransactionResponseDto> retrieveTransaction(@Valid @RequestBody String transactionId) {
        return transactionService.retrieveTransaction(transactionId);
    }
}
