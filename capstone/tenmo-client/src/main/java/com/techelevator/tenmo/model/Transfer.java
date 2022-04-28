package com.techelevator.tenmo.model;

import java.math.BigDecimal;

public class Transfer {

    private User fromUser;
    private User toUser;
    private BigDecimal amount;


    public Transfer(User fromUser, User toUser, BigDecimal amount) {
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.amount = amount;
    }


    public User getFromUser() {
        return fromUser;
    }

    public void setFromUser(User fromUser) {
        this.fromUser = fromUser;
    }

    public User getToUser() {
        return toUser;
    }

    public void setToUser(User toUser) {
        this.toUser = toUser;
    }


    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}



