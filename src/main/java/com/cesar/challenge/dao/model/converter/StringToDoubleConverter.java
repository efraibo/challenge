package com.cesar.challenge.dao.model.converter;

import com.fasterxml.jackson.databind.util.StdConverter;

public class StringToDoubleConverter extends StdConverter<String, Double> {

    @Override
    public Double convert(String s) {

        s = s.replace(",", ".");

        return Double.valueOf(s);
    }
}
