package com.example.demo.web.mapper.Transaction;

import com.example.demo.dto.RetrieveTransactionResponseDto;
import com.example.demo.dto.SaveTransactionRequestDto;
import com.example.demo.dto.UpdateTransactionRequestDto;
import com.example.demo.dto.UpdateTransactionResponseDto;
import com.example.demo.entities.Transaction;
import com.example.demo.web.mapper.OrderLine.OrderLineMapper;
import com.example.demo.web.mapper.PaymentTypeEnumMapper;
import com.example.demo.web.mapper.StatusTypeEnumMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@Component
@RequiredArgsConstructor
public class TransactionMapper {

    private final OrderLineMapper orderLineMapper;
    private final StatusTypeEnumMapper statusTypeEnumMapper;
    private final PaymentTypeEnumMapper paymentTypeEnumMapper;


    public Transaction fromSaveTransactionRequestDtoToTransaction(SaveTransactionRequestDto saveTransactionRequestDto) {
        Transaction transaction = new Transaction();
        transaction.setAmount(BigDecimal.valueOf(saveTransactionRequestDto.getAmount()));
        transaction.setPaymentType(paymentTypeEnumMapper.fromPaymentTypeEnumDtoToPaymentTypeEnum(saveTransactionRequestDto.getPaymentType()));
        transaction.setStatus(statusTypeEnumMapper.fromStatusTypeEnumDtoToStatusTypeEnum(saveTransactionRequestDto.getStatus()));
        transaction.setOrders(orderLineMapper.fromOrderLinesDtoToOrderLine(saveTransactionRequestDto.getOrders()));
        return transaction;
    }


    public RetrieveTransactionResponseDto fromTransactionToRetrieveTransactionResponseDto(Transaction transaction) {
        RetrieveTransactionResponseDto responseDto = new RetrieveTransactionResponseDto();
        responseDto.setTransactionId(String.valueOf(transaction.getId()));
        responseDto.setAmount(transaction.getAmount().floatValue());
        responseDto.setPaymentType(paymentTypeEnumMapper.fromPaymentTypeEnumToPaymentTypeEnumDto(transaction.getPaymentType()));
        responseDto.setStatus(statusTypeEnumMapper.fromStatusTypeEnumToStatusTypeEnumDto(transaction.getStatus()));
        responseDto.setOrders(orderLineMapper.fromOrderLineToOrderLinesDto(transaction.getOrders()));
        return responseDto;
    }


    public Transaction fromUpdateTransactionRequestDtoToTransaction(UpdateTransactionRequestDto updateTransactionRequestDto, Transaction currentTransaction) {
        currentTransaction.setAmount(BigDecimal.valueOf(updateTransactionRequestDto.getAmount()));
        currentTransaction.setPaymentType(paymentTypeEnumMapper.fromPaymentTypeEnumDtoToPaymentTypeEnum(updateTransactionRequestDto.getPaymentType()));
        currentTransaction.setStatus(statusTypeEnumMapper.fromStatusTypeEnumDtoToStatusTypeEnum(updateTransactionRequestDto.getStatus()));
        currentTransaction.setOrders(orderLineMapper.fromOrderLinesDtoToOrderLine(updateTransactionRequestDto.getOrders()));
        return currentTransaction;
    }


    public UpdateTransactionResponseDto fromTransactionToUpdateTransactionResponseDto(Transaction transaction) {
        UpdateTransactionResponseDto responseDto = new UpdateTransactionResponseDto();
        responseDto.setTransactionId(String.valueOf(transaction.getId()));
        responseDto.setAmount(transaction.getAmount().floatValue());
        responseDto.setPaymentType(paymentTypeEnumMapper.fromPaymentTypeEnumToPaymentTypeEnumDto(transaction.getPaymentType()));
        responseDto.setStatus(statusTypeEnumMapper.fromStatusTypeEnumToStatusTypeEnumDto(transaction.getStatus()));
        responseDto.setOrders(orderLineMapper.fromOrderLineToOrderLinesDto(transaction.getOrders()));
        return responseDto;
    }
}
