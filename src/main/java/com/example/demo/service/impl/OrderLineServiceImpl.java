package com.example.demo.service.impl;


import com.example.demo.repository.OrderLineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderLineServiceImpl {


    private final OrderLineRepository orderLineRepository;




}
