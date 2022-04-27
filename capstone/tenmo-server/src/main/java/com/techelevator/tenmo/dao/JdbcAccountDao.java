package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.math.BigDecimal;


@Component
public class JdbcAccountDao implements AccountDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcAccountDao(DataSource dataSource)
    {

        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }



    @Override
    public BigDecimal getBalance(long userId) {
        Account account = null;
        String sql = "SELECT user_id, account_id, balance " +
                "FROM account " +
                "Where user_id = ?";

        BigDecimal balance = null;


        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, userId);

        if (rows.next()) {
             account = mapRowToAccount(rows);
        }

        return account.getBalance();

    }

    @Override
    public Account getAccount(long userId) {
        Account account = null;
        String sql = "SELECT user_id, account_id, balance " +
                "FROM account " +
                "Where user_id = ?";

        BigDecimal balance = null;


        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, userId);

        if (rows.next()) {
            account = mapRowToAccount(rows);
        }

        return account;
    }

    private Account mapRowToAccount(SqlRowSet rows) {

        Account account;
        long userId = rows.getInt("user_Id");
        long accountId = rows.getInt("account_Id");
        BigDecimal balance = rows.getBigDecimal("balance");


        account = new Account(userId, accountId, balance);
        return account;
    }




}









