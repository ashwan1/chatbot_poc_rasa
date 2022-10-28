package com.poc.chatbot.services;

import com.poc.chatbot.payload.Transaction;
import com.poc.chatbot.repository.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepo repository;

    public Transaction getLatestTransaction(String xtraCardNbr) {
        return repository.getLatestTransaction(xtraCardNbr);
    }
}
