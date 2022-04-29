package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
        Transfer newTransfer = new Transfer();


//        String accountId = "SELECT account_id from account where user_id = ?;";
//        Integer accountIdFrom = jdbcTemplate.queryForObject(accountId, Integer.class, transfer.getFromUserId());
//
//        String accountId1 = "SELECT account_id from account where user_id = ?;";
//        Integer accountIdTo = jdbcTemplate.queryForObject(accountId, Integer.class, transfer.getToUserId());



       String sql = "INSERT INTO transfer (transfer_type_id, transfer_status_id, account_from, account_to, amount) " +
               "VALUES (?,?,?,?, ?);";

        String sql1 = "UPDATE account" +
                "SET balance = balance - ? " +
                "WHERE user_id = ?;";

        String sql2 = "UPDATE account" +
                "SET balance = balance + ? " +
                "WHERE user_id = ?;";


        try {
            jdbcTemplate.update(sql, transfer.getTransferTypeId(), transfer.getTransferStatusId(), transfer.getAccount_from(), transfer.getAccount_to(), transfer.getAmount());
        jdbcTemplate.update(sql1, transfer.getAmount(), transfer.getFromUserId());
        jdbcTemplate.update(sql2, transfer.getAmount(), transfer.getToUserId());
        }

        catch (Exception e) {
            e.getMessage();
        }

        return transfer;

    }
}
