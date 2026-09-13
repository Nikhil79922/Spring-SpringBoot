package com.example.CRUDops.entity.attributes;

import jakarta.persistence.AttributeConverter;

public class BooleanToString implements AttributeConverter<Boolean, String> {
    @Override
    public String convertToDatabaseColumn(Boolean attribute) {
        if(attribute == null) return null;
        if(attribute) return "Yes";
        else return "No";
    }

    @Override
    public Boolean convertToEntityAttribute(String dbData) {
        if(dbData == null) return null;
        return dbData.equals("Yes");

    }
}
