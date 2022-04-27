package com.techelevator.tenmo.model;

import java.math.BigDecimal;

public class Account {

    private int userId;
    private int accountId;
    private BigDecimal balance;



    public Account() {
    }

    public Account(int id, int accountId, BigDecimal balance) {
    }

    public int getUserId() {
        return userId;
    }

    public void setUser_id(int userId) {
        this.userId = userId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }


}