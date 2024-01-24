package com.example.demo.service.impl;


import com.example.demo.dto.RetrieveOrderLineRequestDto;
import com.example.demo.dto.RetrieveOrderLineResponseDto;
import com.example.demo.dto.RetrieveOrderLinesResponseDto;
import com.example.demo.repository.OrderLineRepository;
import com.example.demo.service.OrderLineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderLineServiceImpl implements OrderLineService {


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
}
