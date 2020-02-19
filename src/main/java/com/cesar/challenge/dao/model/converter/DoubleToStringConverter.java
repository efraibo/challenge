package com.cesar.challenge.dao.model.converter;

import com.fasterxml.jackson.databind.util.StdConverter;

public class DoubleToStringConverter extends StdConverter<Double, String> {
    @Override
    public String convert(Double aDouble) {
        return String.valueOf(aDouble);
    }
}
