package com.example.demo;

import com.example.demo.controller.CallbackUrl;
import com.example.demo.controller.SendToNumber;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;


public class Campaign {
    private String CampaignID;
    private SendToNumber To;
    private HashMap<String,String> Parameters;
    private CallbackUrl Callback;

    @JsonProperty("CampaignID")
    public String getCampaignID() {
        return CampaignID;
    }

    public void setCampaignID(String campaignID) {
        CampaignID = campaignID;
    }

    @JsonProperty("Parameters")
    public HashMap<String, String> getParameters() {
        return Parameters;
    }

    public void setParameters(HashMap<String, String> parameters) {
        Parameters = parameters;
    }

    @JsonProperty("Callback")
    public CallbackUrl getCallback() {
        return Callback;
    }

    public void setCallback(CallbackUrl callback) {
        Callback = callback;
    }

    @JsonProperty("To")
    public SendToNumber getTo() {
        return To;
    }

    public void setTo(SendToNumber to) {
        To = to;
    }
}
