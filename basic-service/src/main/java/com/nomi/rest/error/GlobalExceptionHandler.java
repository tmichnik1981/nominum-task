package com.nomi.rest.error;

import com.google.common.base.Throwables;
import com.nomi.exception.ServiceUnAvailableException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
@Component
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<ErrorInfoDto> handleError(Exception e) {
        ErrorInfoDto
            error =
            new ErrorInfoDto(HttpStatus.BAD_REQUEST.value(), e.getMessage(), Throwables.getStackTraceAsString(e));

        return new ResponseEntity<>(error, createExceptionDefaultHttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ServiceUnAvailableException.class)
    @ResponseBody
    public ResponseEntity<ErrorInfoDto> handleServiceDownError(ServiceUnAvailableException e) {
        ErrorInfoDto error =
            new ErrorInfoDto(HttpStatus.SERVICE_UNAVAILABLE.value(),
                StringUtils.defaultString(e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE.getReasonPhrase()));

        return new ResponseEntity<>(error, createExceptionDefaultHttpHeaders(), HttpStatus.SERVICE_UNAVAILABLE);
    }


    @ExceptionHandler(HttpClientErrorException.class)
    @ResponseBody
    public ResponseEntity<ErrorInfoDto> handleHttpClientError(HttpClientErrorException e) {

        HttpStatus httpStatus = e.getStatusCode();

        if (HttpStatus.FORBIDDEN.equals(httpStatus)) {
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        ErrorInfoDto error =
            new ErrorInfoDto(httpStatus.value(),
                StringUtils.defaultString(e.getMessage(), httpStatus.getReasonPhrase()));

        return new ResponseEntity<>(error, createExceptionDefaultHttpHeaders(), httpStatus);
    }






/*    @ExceptionHandler(RemoteServiceAccessException.class)
    @ResponseBody
    public ResponseEntity<ErrorInfoDto> handleNotFoundError(RemoteServiceAccessException e) {
        ErrorInfoDto error =
            new ErrorInfoDto(HttpStatus.UNAUTHORIZED.value(),
                StringUtils.defaultString(e.getMessage(), HttpStatus.UNAUTHORIZED.getReasonPhrase()));

        return new ResponseEntity<>(error, createExceptionDefaultHttpHeaders(), HttpStatus.UNAUTHORIZED);
    }*/


    private HttpHeaders createExceptionDefaultHttpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
        return httpHeaders;
    }
}
