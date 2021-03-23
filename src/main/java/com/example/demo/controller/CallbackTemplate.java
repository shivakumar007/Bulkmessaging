package com.example.demo.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name="verloop")
public class CallbackTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @JsonProperty("MessageID")
    @Column(name="MessageID")
    private String MessageID;


    @JsonProperty("Status")
    @Column(name = "Status")
    private String Status;


    @JsonProperty("Timestamp")
    @Column(name = "Timestamp")
    private String Timestamp;

    @Column(name="message")
    private String message;


    public String getMessageID() {
        return MessageID;
    }

    public void setMessageID(String messageID) {
        MessageID = messageID;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(String timestamp) {
        Timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "CallbackTemplate{" +
                "MessageID='" + MessageID + '\'' +
                ", Status='" + Status + '\'' +
                ", Timestamp='" + Timestamp + '\'' +
                '}';
    }
}
