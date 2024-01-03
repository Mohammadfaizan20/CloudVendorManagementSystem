package com.Restapi.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> responseBuilder(
            String message, HttpStatus httpStatus, Object responseObject
    )
    {
        Map<String,Object> respose = new HashMap<>();
        respose.put("message",message);
        respose.put("HttpStatus",httpStatus);
        respose.put("Object",responseObject);

        return new ResponseEntity<>(respose,httpStatus);

    }
}
