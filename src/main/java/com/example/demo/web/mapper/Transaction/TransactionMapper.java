package com.example.demo.web.mapper.Transaction;

import com.example.demo.dto.TransactionDto;
import com.example.demo.dto.TransactionResponseDto;
import com.example.demo.entities.Transaction;
import com.example.demo.web.mapper.OrderLine.OrderLineMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class TransactionMapper {

    private final OrderLineMapper orderLineMapper;



    public TransactionResponseDto fromTransactionToTransactionResultDto(Transaction transaction) {
        TransactionResponseDto resultDto = new TransactionResponseDto();
        resultDto.setAmount(transaction.getAmount());
        resultDto.setPaymentType(transaction.getPaymentType());
        resultDto.setStatus(transaction.getStatus());
        resultDto.setOrders(orderLineMapper.fromOrderLinesToOrderLineResponseDto(transaction.getOrders()));
        return resultDto;
    }

    public Transaction fromTransactionDtoToTransaction(TransactionDto transactionDto) {
        Transaction transaction = new Transaction();
        transaction.setId(transactionDto.getId());
        transaction.setAmount(transactionDto.getAmount());
        transaction.setPaymentType(transactionDto.getPaymentType());
        transaction.setStatus(transactionDto.getStatus());
        transaction.setOrders(orderLineMapper.fromOrderLineDtoToOrderLines(transactionDto.getOrders()));
        return transaction;
    }


    public Transaction updateTransactionMapper(TransactionDto transactionDto, Transaction transaction) {
        if (transactionDto.getAmount() != null) transaction.setAmount(transactionDto.getAmount());
        if (transactionDto.getPaymentType() != null) transaction.setPaymentType(transactionDto.getPaymentType());
        if (transactionDto.getStatus() != null) transaction.setStatus(transactionDto.getStatus());
        if (transactionDto.getOrders() != null)
            transaction.setOrders(orderLineMapper.fromOrderLineDtoToOrderLines(transactionDto.getOrders()));
        return transaction;
    }


}
