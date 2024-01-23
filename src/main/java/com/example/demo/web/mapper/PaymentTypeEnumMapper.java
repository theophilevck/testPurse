package com.example.demo.web.mapper;

import com.example.demo.dto.PaymentTypeEnumDto;
import com.example.demo.entities.PaymentTypeEnum;

public class PaymentTypeEnumMapper {

    public PaymentTypeEnum fromPaymentTypeEnumDtoToPaymentTypeEnum(PaymentTypeEnumDto paymentTypeEnumDto) {
        return switch (paymentTypeEnumDto) {
            case CREDIT_CARD -> PaymentTypeEnum.CREDIT_CARD;
            case PAYPAL -> PaymentTypeEnum.PAYPAL;
            case GIFT_CARD -> PaymentTypeEnum.GIFT_CARD;
            default -> throw new IllegalArgumentException("Invalid PaymentTypeEnumDto value: " + paymentTypeEnumDto);
        };
    }
}
