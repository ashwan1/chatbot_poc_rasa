package com.poc.chatbot.repository;

import com.poc.chatbot.payload.Store;
import com.poc.chatbot.payload.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;

@Repository
public class TransactionRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Transaction getLatestTransaction(String xtraCardNbr) {
        String sql = "select top 1 xc.encoded_xtra_card_nbr, ptm.date_dt, ptm.amt, s.store_name, s.street_txt, s.city_name, s.state_cd, s.zip_cd " +
                " from poc_chatbot.xtra_card xc " +
                " join poc_chatbot.pos_txn_mstr ptm on xc.xtra_card_nbr=ptm.xtra_card_nbr " +
                " join poc_chatbot.store s on ptm.store_nbr= s.store_nbr " +
                " where " +
                " xc.encoded_xtra_card_nbr=? " +
                " order by date_dt desc ";
        return jdbcTemplate.queryForObject(sql,
                new Object[] {xtraCardNbr},
                new int[]{Types.VARCHAR},
                (rs, rowNum) -> new Transaction(
                        rs.getString("encoded_xtra_card_nbr"),
                        rs.getString("date_dt"),
                        rs.getFloat("amt"),
                        new Store(
                                rs.getString("store_name"),
                                rs.getString("street_txt"),
                                rs.getString("city_name"),
                                rs.getString("state_cd"),
                                rs.getString("zip_cd")
                        )
                ));
    }
}
