package com.example.demo.web.mapper;

import com.example.demo.dto.StatusTypeEnumDto;
import com.example.demo.entities.StatusEnum;

public class StatusTypeEnumMapper {

    public StatusEnum fromStatusTypeEnumDtoToStatusTypeEnum(StatusTypeEnumDto statusTypeEnumDto) {
        return switch (statusTypeEnumDto) {
            case IN_PROGRESS -> StatusEnum.IN_PROGRESS;
            case CAPTURED -> StatusEnum.CAPTURED;
            case AUTHORIZED -> StatusEnum.AUTHORIZED;
            default -> throw new IllegalArgumentException("Invalid StatusTypeEnumDto value: " + statusTypeEnumDto);
        };
    }
}