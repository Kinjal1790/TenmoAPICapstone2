package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.User;
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
    public BigDecimal getBalance(int userId) {
        Account account = null;
        String sql = "SELECT balance, user_id, account_id " +
                "FROM account " +
                "Where user_id = ?";

        BigDecimal balance = null;


        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, userId);

        if (rows.next()) {
             account = mapRowToAccount(rows);
        }

        return account.getBalance();

    }

    private Account mapRowToAccount(SqlRowSet rows) {

        Account account;
        int id = rows.getInt("userId");
        int accountId = rows.getInt("account");
        BigDecimal balance = rows.getBigDecimal("balance");


        account = new Account(id, accountId, balance);
        return account;
    }


}









