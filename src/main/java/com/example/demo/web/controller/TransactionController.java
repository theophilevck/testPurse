package com.example.demo.web.controller;


import com.example.demo.dto.TransactionDto;
import com.example.demo.dto.TransactionResponseDto;
import com.example.demo.service.TransactionService;
import com.example.demo.web.mapper.Transaction.TransactionMapper;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Validated
@RequestMapping("/Transaction")
@RestController
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;




    @PostMapping("/save")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "create Transaction")})
    public Mono<TransactionResponseDto> createTransaction(@Valid @RequestBody TransactionDto transactionDTO) {
        return transactionService.createTransaction(transactionDTO);
    }

    @PostMapping("/update")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "update Transaction")})
    public Mono<TransactionResponseDto> updateTransaction(@Valid @RequestBody TransactionDto updateTransactionRequestDto ) {
        return transactionService.updateTransaction(updateTransactionRequestDto);
    }

    @GetMapping("/retrieveAll")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "retrieve Transaction")})
    public Flux<TransactionResponseDto> retrieveTransaction() {
        return transactionService.retrieveAllTransaction();
    }
}
