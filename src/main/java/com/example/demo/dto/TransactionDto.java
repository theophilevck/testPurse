package com.example.demo.dto;

import com.example.demo.entities.PaymentTypeEnum;
import com.example.demo.entities.StatusEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class TransactionDto {
    private Long id;
    private BigDecimal amount;
    private PaymentTypeEnum paymentType;
    private StatusEnum status;
    private List<OrderLineDto> orders;
}
