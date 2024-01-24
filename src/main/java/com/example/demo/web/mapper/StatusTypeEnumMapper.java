package com.example.demo.web.mapper;

import com.example.demo.dto.StatusTypeEnumDto;
import com.example.demo.entities.StatusEnum;
import org.springframework.stereotype.Component;

@Component
public class StatusTypeEnumMapper {

    public StatusEnum fromStatusTypeEnumDtoToStatusTypeEnum(StatusTypeEnumDto statusTypeEnumDto) {
        return switch (statusTypeEnumDto) {
            case IN_PROGRESS -> StatusEnum.IN_PROGRESS;
            case CAPTURED -> StatusEnum.CAPTURED;
            case AUTHORIZED -> StatusEnum.AUTHORIZED;
            default -> throw new IllegalArgumentException("Invalid StatusTypeEnumDto value: " + statusTypeEnumDto);
        };
    }


    public StatusTypeEnumDto fromStatusTypeEnumToStatusTypeEnumDto(StatusEnum statusEnum) {
        return switch (statusEnum) {
            case IN_PROGRESS -> StatusTypeEnumDto.IN_PROGRESS;
            case CAPTURED -> StatusTypeEnumDto.CAPTURED;
            case AUTHORIZED -> StatusTypeEnumDto.AUTHORIZED;
            default -> throw new IllegalArgumentException("Invalid StatusTypeEnum value: " + statusEnum);
        };
    }
}