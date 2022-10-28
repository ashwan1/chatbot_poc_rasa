package com.poc.chatbot.payload;

public class Transaction implements Data {
    String xtraCardNbr;
    String date;
    float amount;
    Store store;

    public Transaction(String xtraCardNbr, String date, float amount, Store store) {
        this.xtraCardNbr = xtraCardNbr;
        this.date = date;
        this.amount = amount;
        this.store = store;
    }

    public String getXtraCardNbr() {
        return xtraCardNbr;
    }

    public String getDate() {
        return date;
    }

    public float getAmount() {
        return amount;
    }

    public Store getStore() {
        return store;
    }
}
