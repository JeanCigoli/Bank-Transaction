package com.transation.bank.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonFormatted {
	public static String stringify(Object object) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(object);
    }
}
