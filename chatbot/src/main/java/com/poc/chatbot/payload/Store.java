package com.poc.chatbot.payload;

public class Store implements Data {
    String name;
    String street;
    String city;
    String stateCode;
    String zipCode;

    public Store(String name, String street, String city, String stateCode, String zipCode) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.stateCode = stateCode;
        this.zipCode = zipCode;
    }

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getStateCode() {
        return stateCode;
    }

    public String getZipCode() {
        return zipCode;
    }
}
