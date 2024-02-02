package com.marufh.geoipservice.exception.handler;

import com.marufh.geoipservice.exception.ExceptionDto;
import com.marufh.geoipservice.exception.GeoIpLookUpException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(GeoIpLookUpException.class)
    public final ResponseEntity<ExceptionDto> handleGeoIpLookUpException(GeoIpLookUpException ex, WebRequest request) {
        ExceptionDto exceptionDto = ExceptionDto.builder()
                .timestamp(new Date())
                .message(ex.getMessage())
                .details(request.getDescription(false))
                .build();
        return new ResponseEntity<>(exceptionDto, ex.getHttpStatus());
    }
}
