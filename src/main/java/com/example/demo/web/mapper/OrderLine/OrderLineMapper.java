package com.example.demo.web.mapper.OrderLine;

import com.example.demo.dto.OrderLinesDto;
import com.example.demo.entities.OrderLine;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderLineMapper {

    public OrderLine fromOrderLinesDtoToOrderLine(OrderLinesDto orderLinesDto) {
        OrderLine orderLine = new OrderLine();
        orderLine.setProductName(orderLinesDto.getProductName());
        orderLine.setProductReference(orderLinesDto.getProductReference());
        orderLine.setQuantity(BigDecimal.valueOf(orderLinesDto.getQuantity()));
        orderLine.setPrice(BigDecimal.valueOf(orderLinesDto.getPrice()));
        return orderLine;
    }

    public List<OrderLine> fromOrderLinesDtoToOrderLine(List<OrderLinesDto> orderLinesDto) {
        List<OrderLine> orderLine = new ArrayList<>();
        for (OrderLinesDto orderLines : orderLinesDto) {
            orderLine.add(fromOrderLinesDtoToOrderLine(orderLines));
        }
        return orderLine;
    }
}