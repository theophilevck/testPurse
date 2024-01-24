package com.example.demo.web.controller;


import com.example.demo.dto.RetrieveOrderLineRequestDto;
import com.example.demo.dto.RetrieveOrderLineResponseDto;
import com.example.demo.dto.RetrieveOrderLinesResponseDto;
import com.example.demo.service.OrderLineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class OrderLineController implements OrderLineApi {


    private final OrderLineService orderLineService;

    @Override
    public Mono<RetrieveOrderLineResponseDto> dEMO21(Mono<RetrieveOrderLineRequestDto> retrieveOrderLineRequestDto, ServerWebExchange exchange) {
        return null;
    }

    @Override
    public Mono<RetrieveOrderLinesResponseDto> dEMO22(ServerWebExchange exchange) {
        return null;
    }
}
