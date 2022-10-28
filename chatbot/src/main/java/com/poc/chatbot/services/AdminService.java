package com.poc.chatbot.services;

import com.poc.chatbot.payload.XtraCard;
import com.poc.chatbot.repository.XtraCardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private XtraCardRepo xtraCardRepo;

    public XtraCard getXtracareNumberFromEmail(String email) {
        String xtraCardNumber = xtraCardRepo.getXtraCardNumberByEmail(email);
        return new XtraCard(xtraCardNumber);
    }
}
