package com.foursquare.adapter.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

public class FoursquareException extends HttpStatusCodeException {

    HttpStatus statusCode;
    String statusText;
    HttpHeaders responseHeaders;

    public FoursquareException(HttpStatus statusCode, String statusText, HttpHeaders responseHeaders, Throwable cause) {
        super(statusCode);
        this.statusCode = statusCode;
        this.statusText = statusText;
        this.responseHeaders = responseHeaders;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public String getStatusText() {
        return statusText;
    }

    public HttpHeaders getResponseHeaders() {
        return responseHeaders;
    }
}
