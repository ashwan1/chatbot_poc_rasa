package com.poc.chatbot.controller;

import com.poc.chatbot.payload.Data;
import com.poc.chatbot.payload.Response;
import com.poc.chatbot.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/xtracareNumber/{email}")
    public Response getXtracareNumber(@PathVariable("email") String email) {
        Data xtracareNumber = adminService.getXtracareNumberFromEmail(email);
        return new Response(xtracareNumber);
    }

}
