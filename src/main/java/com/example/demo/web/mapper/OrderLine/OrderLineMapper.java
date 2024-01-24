package com.example.demo.web.mapper.OrderLine;

import com.example.demo.dto.OrderLineDto;
import com.example.demo.dto.OrderLineResponseDto;
import com.example.demo.entities.OrderLine;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Component
public class OrderLineMapper {

    public OrderLine fromOrderLineDtoToOrderLine(OrderLineDto orderLineDto) {
        OrderLine orderLine = new OrderLine();
        orderLine.setId(orderLineDto.getId());
        orderLine.setProductName(orderLineDto.getProductName());
        orderLine.setProductReference(orderLineDto.getProductReference());
        orderLine.setQuantity(orderLineDto.getQuantity().intValue());
        orderLine.setPrice(orderLineDto.getPrice());
        return orderLine;
    }

    public List<OrderLine> fromOrderLineDtoToOrderLines(List<OrderLineDto> orderLinesDto) {
        List<OrderLine> result = new ArrayList<>();
        for (OrderLineDto orderLines : orderLinesDto) {
            result.add(fromOrderLineDtoToOrderLine(orderLines));
        }
        return result;
    }

    public OrderLineResponseDto fromOrderLineToOrderLineResponseDto(OrderLine orderLine) {
        OrderLineResponseDto orderLineResponseDto = new OrderLineResponseDto();
        orderLineResponseDto.setProductName(orderLine.getProductName());
        orderLineResponseDto.setProductReference(orderLine.getProductReference());
        orderLineResponseDto.setQuantity(orderLine.getQuantity());
        orderLineResponseDto.setPrice(orderLine.getPrice());
        return orderLineResponseDto;
    }

    public List<OrderLineResponseDto> fromOrderLinesToOrderLineResponseDto(List<OrderLine> orderLines) {
        List<OrderLineResponseDto> result = new ArrayList<>();
        for (OrderLine orderLine : orderLines) {
            result.add(fromOrderLineToOrderLineResponseDto(orderLine));
        }
        return result;
    }


}