package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


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


        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, userId);

        if (rows.next()) {
            account = mapRowToAccount(rows);
        }

        return account;
    }

    @Override
    public List<Account> findAll() {
        List<Account> accounts = new ArrayList<>();
        String sql = "SELECT account_id, user_id, balance FROM account;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            Account account = mapRowToAccount(results);
            accounts.add(account);
        }
        return accounts;
    }

    @Override
    public Account updateSubstract(Account account) {

            String sql = "UPDATE account " +
                    " SET balance = balance - ? "+
                    " WHERE user_id = ?;";

            // execute the update statement
            // NOTE: the parameter MUST be passed in in the same order
            // that they appear in the sql
          //  jdbcTemplate.update(sql, account.
        }
        return null;
    }


    private Account mapRowToAccount(SqlRowSet rows) {

        Account account;
        long userId = rows.getInt("user_id");

        long accountId = rows.getInt("account_Id");
        BigDecimal balance = rows.getBigDecimal("balance");

        account = new Account(userId, accountId, balance);
        return account;
    }






}









