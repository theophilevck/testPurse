package com.example.demo.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderLineDto {
    private Long id;
    private String productName;
    private String productReference;
    private Integer quantity;
    private float price;
}