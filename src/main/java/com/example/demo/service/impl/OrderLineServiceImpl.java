package com.example.demo.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderLineServiceImpl {

/*
    private final OrderLineRepository orderLineRepository;


    //need rework
    @Override
    public RetrieveOrderLineResponseDto dEMO21(RetrieveOrderLineRequestDto retrieveOrderLineRequestDto) {
        return orderLineRepository.findById(Long.valueOf(retrieveOrderLineRequestDto.getOrderLineId()))
                .map(orderLine -> new RetrieveOrderLineResponseDto(orderLine.getProductName(), orderLine.getProductReference(), orderLine.getQuantity().floatValue(), orderLine.getPrice().floatValue()))
                .orElseThrow(() -> new RuntimeException("OrderLine not found"));
    }


    //need rework
    @Override
    public RetrieveOrderLinesResponseDto dEMO22() {
        List<RetrieveOrderLineResponseDto> orderLineResponseDtoList = orderLineRepository.findAll().stream()
                .map(orderLine -> new RetrieveOrderLineResponseDto(orderLine.getProductName(), orderLine.getProductReference(), orderLine.getQuantity().floatValue(), orderLine.getPrice().floatValue()))
                .collect(Collectors.toList());
        return new RetrieveOrderLinesResponseDto(orderLineResponseDtoList);
    }

 */
}
