package com.example.demo.web.mapper.Transaction;

import com.example.demo.dto.SaveTransactionRequestDto;
import com.example.demo.entities.Transaction;
import com.example.demo.web.mapper.OrderLine.OrderLineMapper;
import com.example.demo.web.mapper.PaymentTypeEnumMapper;
import com.example.demo.web.mapper.StatusTypeEnumMapper;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

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
}
