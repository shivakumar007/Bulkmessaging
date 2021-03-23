package com.example.demo.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SendToNumber {

    private String PhoneNumber;

    @JsonProperty("PhoneNumber")
    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public SendToNumber(String phoneNumber) {
        this.PhoneNumber = phoneNumber;
    }
}
