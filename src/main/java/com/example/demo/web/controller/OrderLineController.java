package com.example.demo.web.controller;


import com.example.demo.service.OrderLineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderLineController {


    private final OrderLineService orderLineService;
}
