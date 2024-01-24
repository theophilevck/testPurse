package com.example.demo.web.mapper.OrderLine;

import com.example.demo.dto.OrderLinesDto;
import com.example.demo.entities.OrderLine;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Component
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



    public OrderLinesDto fromOrderLineToOrderLinesDto(OrderLine orderLine) {
        OrderLinesDto orderLinesDto = new OrderLinesDto();
        orderLinesDto.setProductName(orderLine.getProductName());
        orderLinesDto.setProductReference(orderLine.getProductReference());
        orderLinesDto.setQuantity(orderLine.getQuantity().floatValue());
        orderLinesDto.setPrice(orderLine.getPrice().floatValue());
        return orderLinesDto;
    }

    public List<OrderLinesDto> fromOrderLineToOrderLinesDto(List<OrderLine> orderLine) {
        List<OrderLinesDto> orderLinesDto = new ArrayList<>();
        for (OrderLine orderLines : orderLine) {
            orderLinesDto.add(fromOrderLineToOrderLinesDto(orderLines));
        }
        return orderLinesDto;
    }
}