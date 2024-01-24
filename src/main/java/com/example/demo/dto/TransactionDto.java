package com.example.demo.dto;

import com.example.demo.entities.PaymentTypeEnum;
import com.example.demo.entities.StatusEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class TransactionDto {
    private Long id;
    private float amount;
    @JsonProperty("payment_type")
    private PaymentTypeEnum paymentType;
    private StatusEnum status;
    private List<OrderLineDto> orders;
}
