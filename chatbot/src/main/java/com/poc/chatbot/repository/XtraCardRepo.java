package com.poc.chatbot.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class XtraCardRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public String getXtraCardNumberByEmail(String email){
        String sql = "select xc.encoded_xtra_card_nbr " +
                "from poc_chatbot.customer_email ce join poc_chatbot.xtra_card xc on ce.cust_id=xc.cust_id " +
                "where ce.email=?";
        return jdbcTemplate.queryForObject(sql, String.class, email);
    }
}
