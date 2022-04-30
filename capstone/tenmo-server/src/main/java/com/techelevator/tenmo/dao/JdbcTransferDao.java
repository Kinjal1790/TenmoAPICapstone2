package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;


@Component
public class JdbcTransferDao implements TransferDao{

    private JdbcTemplate jdbcTemplate;
    private AccountDao accountDao;
    @Autowired
    public JdbcTransferDao(DataSource dataSource, AccountDao accountDao){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.accountDao = accountDao;
    }



    private static int TRANSFER_STATUS_ID = 2;
    private static int TRANSFER_TYPE_ID = 1;




    @Transactional
    @Override
    public Transfer createTransfer(Transfer transfer, Account accountFrom, Account accountTo) {
        Transfer newTransfer = new Transfer();

       String sql = "INSERT INTO transfer (transfer_type_id, transfer_status_id, account_from, account_to, amount) " +
               "VALUES (?,?,?,?,?) RETURNING transfer_id;";


        int transfer_id = jdbcTemplate.queryForObject(sql, Integer.class, TRANSFER_TYPE_ID, TRANSFER_STATUS_ID, accountFrom.getAccountId(), accountTo.getAccountId(), transfer.getAmount());

        accountDao.substract(accountFrom, transfer.getAmount());
        accountDao.add(accountTo, transfer.getAmount());

        return findbyId(transfer_id) ;

    }

    @Override
    public Transfer findbyId(int transfer_id) {
        Transfer transfer = null;
        String sql = "SELECT t.transfer_id\n" +
            ", ts.transfer_status_desc as status\n" +
            ", tt.transfer_type_desc as type\n" +
            ", uf.user_id as from_user_id\n" +
            ", uf.username as from_username\n" +
            ", ut.user_id as to_user_id\n" +
            ", ut.username as to_username\n" +
            ", t.amount\n" +
            "FROM transfer as t\n" +
            "INNER JOIN transfer_status ts\n" +
            "   ON t.transfer_status_id = ts.transfer_status_id\n" +
            "INNER JOIN transfer_type tt\n" +
            "   ON t.transfer_type_id = tt.transfer_type_id\n" +
            "INNER JOIN account af\n" +
            "   ON af.account_id = t.account_from\n" +
                "INNER JOIN tenmo_user uf\n" +
                "   ON uf.user_id = af.user_id\n" +
                "INNER JOIN account at\n" +
                "   ON at.account_id = t.account_to\n" +
                "INNER JOIN tenmo_user ut\n" +
                "   ON ut.user_id = at.user_id\n" +
            "WHERE t.transfer_id = ?;";


        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, transfer_id);
        if(row.next()){
            transfer = mapRowToTransfer(row);
        }

        return transfer;

    }



    @Override
    public List<Transfer> findAll(long id) {

        List<Transfer> transfers = new ArrayList<>();

        String sql = "SELECT t.transfer_id\n" +
                ", ts.transfer_status_desc as status\n" +
                ", tt.transfer_type_desc as type\n" +
                ", uf.user_id as from_user_id\n" +
                ", uf.username as from_username\n" +
                ", ut.user_id as to_user_id\n" +
                ", ut.username as to_username\n" +
                ", t.amount\n" +
                "FROM transfer as t\n" +
                "INNER JOIN transfer_status ts\n" +
                "   ON t.transfer_status_id = ts.transfer_status_id\n" +
                "INNER JOIN transfer_type tt\n" +
                "   ON t.transfer_type_id = tt.transfer_type_id\n" +
                "INNER JOIN account af\n" +
                "   ON af.account_id = t.account_from\n" +
                "INNER JOIN tenmo_user uf\n" +
                "   ON uf.user_id = af.user_id\n" +
                "INNER JOIN account at\n" +
                "   ON at.account_id = t.account_to\n" +
                "INNER JOIN tenmo_user ut\n" +
                "   ON ut.user_id = at.user_id\n" +
                "WHERE uf.user_id= ?\n" +
                " OR ut.user_id = ?;";

        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, id, id);
        while(rows.next())
        {
            Transfer transfer = mapRowToTransfer(rows);
            transfers.add(transfer);
        }

        return transfers;
    }

    private Transfer mapRowToTransfer(SqlRowSet rows) {

        Transfer transfer= new Transfer();
        transfer.setTransfer_id(rows.getLong("transfer_id"));
        transfer.setTransfer_status_desc(rows.getString("status"));
        transfer.setTransfer_type_desc(rows.getString("type"));
        transfer.setFromUserId(rows.getLong("from_user_id"));
        transfer.setUsernameFrom(rows.getString("from_username"));
        transfer.setToUserId(rows.getLong("to_user_id"));
        transfer.setUsernameTo(rows.getString("to_username"));
        transfer.setAmount(rows.getBigDecimal("amount"));



        return transfer;
    }
}
