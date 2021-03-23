package com.example.demo.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Error {

    private String Message;

    @JsonProperty("Message")
    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
