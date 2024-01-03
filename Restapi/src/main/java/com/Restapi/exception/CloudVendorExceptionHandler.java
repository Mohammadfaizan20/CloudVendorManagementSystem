package com.Restapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class CloudVendorExceptionHandler {
    @ExceptionHandler(value = {CloudVendorNotFoundException.class})
    public ResponseEntity<Object> hendlerCloudVendorNotFoundException
            (CloudVendorNotFoundException cloudVendorNotFoundException)
    {
            CloudVedndorExecption cloudVedndorExecption = new CloudVedndorExecption(
                    cloudVendorNotFoundException.getMessage(),
                    cloudVendorNotFoundException.getCause(),
                    HttpStatus.NOT_FOUND
            );

            return  new ResponseEntity<>(cloudVedndorExecption,HttpStatus.NOT_FOUND);
    }

}
