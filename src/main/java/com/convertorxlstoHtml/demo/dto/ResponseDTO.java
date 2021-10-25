package com.convertorxlstoHtml.demo.dto;

import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.Date;

public class ResponseDTO {

    /**
     * The timestamp attribute key.
     */
    private Date timestamp;

    /**
     * The status attribute key.
     */
    private Integer status;

    /**
     * The message attribute key.
     */
    private String message;

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResponseDTO(Date timestamp, Integer status, String message) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
    }
    public ResponseDTO(Date timestamp, Integer status) {
        this.timestamp = timestamp;
        this.status = status;
    }

    public ResponseDTO(){}


    @Override
    public String toString() {
        return "ResponseDTO{" +
                "timestamp=" + timestamp +
                ", status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}
