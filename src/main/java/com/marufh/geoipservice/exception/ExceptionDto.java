package com.marufh.geoipservice.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
@AllArgsConstructor
public class ExceptionDto {

    private Date timestamp;

    private String message;

    private String details;

}
