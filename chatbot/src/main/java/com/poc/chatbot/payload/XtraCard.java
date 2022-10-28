package com.poc.chatbot.payload;

public class XtraCard implements Data{
    String xtraCardNumber;

    public XtraCard(String xtraCardNumber) {
        this.xtraCardNumber = xtraCardNumber;
    }

    public String getXtraCardNumber() {
        return xtraCardNumber;
    }
}
