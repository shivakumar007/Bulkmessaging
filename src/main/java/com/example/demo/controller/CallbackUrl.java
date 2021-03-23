package com.example.demo.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CallbackUrl {
    private String URL;

    @JsonProperty("URL")
    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public CallbackUrl(String URL) {
        this.URL = URL;
    }
}
