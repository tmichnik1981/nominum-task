package com.nomi.model.converters;

import com.nomi.model.Grade;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class GradeConverter implements AttributeConverter<Grade, String> {
    @Override
    public String convertToDatabaseColumn(Grade attribute) {
        return attribute.name();
    }

    @Override
    public Grade convertToEntityAttribute(String dbData) {
        return Grade.valueOf(dbData);
    }
}
