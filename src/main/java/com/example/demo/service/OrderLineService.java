package com.example.demo.service;


import com.example.demo.dto.RetrieveOrderLineRequestDto;
import com.example.demo.dto.RetrieveOrderLineResponseDto;
import com.example.demo.dto.RetrieveOrderLinesResponseDto;
import org.springframework.stereotype.Service;


public interface OrderLineService {

    RetrieveOrderLineResponseDto dEMO21(RetrieveOrderLineRequestDto retrieveOrderLineRequestDto);

    RetrieveOrderLinesResponseDto dEMO22();



}
