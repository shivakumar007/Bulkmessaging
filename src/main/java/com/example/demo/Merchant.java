package com.example.demo;


public class Merchant {
    String MobileNumber;
    String OrderNumber;
    String Amount;

    public String getMobileNumber() {
        return MobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        MobileNumber = mobileNumber;
    }

    public String getOrderNumber() {
        return OrderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        OrderNumber = orderNumber;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public Merchant(String mobileNumber, String orderNumber, String amount) {
        MobileNumber = mobileNumber;
        OrderNumber = orderNumber;
        Amount = amount;
    }
}
