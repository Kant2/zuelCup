package com.example.competitiondemo.util.converter;

import com.example.competitiondemo.enums.GenderEnum;

import javax.persistence.AttributeConverter;

public class GenderConverter implements AttributeConverter<GenderEnum, String> {

    @Override
    public String convertToDatabaseColumn(GenderEnum attribute) {
        return attribute.getName();
    }

    @Override
    public GenderEnum convertToEntityAttribute(String dbData) {
        return GenderEnum.getEnumByName(dbData);
    }
}
