package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.math.BigDecimal;

public class JdbcAccountDao implements AccountDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcAccountDao(DataSource dataSource)
    {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }



    @Override
    public BigDecimal getBalance(int userId, Account account) {

        String sql = 


        return null;
    }
}
