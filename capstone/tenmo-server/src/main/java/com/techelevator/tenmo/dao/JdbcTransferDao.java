package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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

    private static int TRANSFER_STATUS_ID = 2;
    private static int TRANSFER_TYPE_ID = 2;


    @Transactional
    @Override
    public Transfer createTransfer(Transfer transfer, Account accountFrom, Account accountTo) {
        Transfer newTransfer = new Transfer();


//        String accountId = "SELECT account_id from account where user_id = ?;";
//        Integer accountIdFrom = jdbcTemplate.queryForObject(accountId, Integer.class, transfer.getFromUserId());
//
//        String accountId1 = "SELECT account_id from account where user_id = ?;";
//        Integer accountIdTo = jdbcTemplate.queryForObject(accountId, Integer.class, transfer.getToUserId());



       String sql = "INSERT INTO transfer (transfer_type_id, transfer_status_id, account_from, account_to, amount) " +
               "VALUES (?,?,?,?,?);";

        String sql1 = "UPDATE account" +
                "SET balance = balance - ? " +
                "WHERE user_id = ?;";

        String sql2 = "UPDATE account" +
                "SET balance = balance + ? " +
                "WHERE user_id = ?;";


        try {
            jdbcTemplate.update(sql, TRANSFER_TYPE_ID, TRANSFER_STATUS_ID, accountFrom.getAccountId(), accountTo.getAccountId(), transfer.getAmount());
        jdbcTemplate.update(sql1, transfer.getAmount(), accountFrom.getUserId());
        jdbcTemplate.update(sql2, transfer.getAmount(), accountTo.getUserId());
        }

        catch (Exception e) {
            e.getMessage();
        }

        return transfer;

    }
}
