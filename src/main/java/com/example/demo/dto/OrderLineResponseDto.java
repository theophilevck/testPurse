package com.example.demo.dto;

import lombok.Data;

import java.math.BigDecimal;


@Data
public class OrderLineResponseDto {
    private String productName;
    private String productReference;
    private BigDecimal quantity;
    private BigDecimal price;
}
