package com.example.twilio.sms;

import java.util.Date;

public class ApiResponse {
    private String message;
    private String status;
    private Date date;
    
    public ApiResponse(String message, String status, Date date) {
        this.message = message;
        this.status = status;
        this.date = date;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
}
