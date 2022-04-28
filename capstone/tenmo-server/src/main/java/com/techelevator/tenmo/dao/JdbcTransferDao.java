package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;


@Component
public class JdbcTransferDao implements TransferDao{

    private JdbcTemplate jdbcTemplate;
    @Autowired
    public JdbcTransferDao(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Transfer> getTransfers(int userid) {
        return null;
    }


    @Transactional
    @Override
    public Transfer createTransfer(Transfer transfer) {

       String sql = "INSERT INTO transfer('account_from', 'account_to', balance) " +
               "VALUES (?,?,?);";

       String sql1 = "UPDATE account" +
                      "SET balance = balance - ? " +
                        "WHERE user_id = ?;";

        String sql2 = "UPDATE account" +
                "SET balance = balance + ? " +
                "WHERE user_id = ?;";


        jdbcTemplate.update(sql, transfer.getFromUserId(), transfer.getToUserId(), transfer.getAmount());
        jdbcTemplate.update(sql1, transfer.getAmount(), transfer.getFromUserId());
        jdbcTemplate.update(sql2, transfer.getAmount(), transfer.getToUserId());


        return null;
    }
}
