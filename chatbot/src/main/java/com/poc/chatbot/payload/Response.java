package com.poc.chatbot.payload;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
    private String status;
    private Data data;
    private String errorMsg;

    public Response(Data data){
        this("success", data, null);
    }
    public Response(String status, Data data, String errorMsg) {
        this.status = status;
        this.data = data;
        this.errorMsg = errorMsg;
    }

    public String getStatus() {
        return status;
    }

    public Data getData() {
        return data;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
