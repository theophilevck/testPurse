package com.example.demo.dto;

import lombok.Data;


@Data
public class OrderLineResponseDto {
    private String productName;
    private String productReference;
    private Integer quantity;
    private float price;
}
