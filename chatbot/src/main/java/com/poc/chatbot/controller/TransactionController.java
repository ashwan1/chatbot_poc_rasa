package com.poc.chatbot.controller;

import com.poc.chatbot.payload.Response;
import com.poc.chatbot.payload.Transaction;
import com.poc.chatbot.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService service;

    @GetMapping("/{xtraCardNbr}/latest")
    public Response getLatestTransaction(@PathVariable("xtraCardNbr") String xtraCardNbr){
        return new Response(service.getLatestTransaction(xtraCardNbr));
    }
}
