package com.techelevator.tenmo.model;

import java.math.BigDecimal;

public class Transfer {

    private long fromUser;
    private long toUser;
    private BigDecimal amount;
    private long transfer_status_id;
    private long transfer_type_id;


    public Transfer(long fromUser, long toUser, BigDecimal amount, long transfer_status_id, long transfer_type_id) {
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.amount = amount;
        this.transfer_status_id = transfer_status_id;
        this.transfer_type_id = transfer_type_id;
    }


    public Transfer(){

    }

    public long getFromUser() {
        return fromUser;
    }

    public void setFromUser(long fromUser) {
        this.fromUser = fromUser;
    }

    public long getToUser() {
        return toUser;
    }

    public void setToUser(long toUser) {
        this.toUser = toUser;
    }

    public long getTransfer_status_id() {
        return transfer_status_id;
    }

    public void setTransfer_status_id(long transfer_status_id) {
        this.transfer_status_id = transfer_status_id;
    }

    public long getTransfer_type_id() {
        return transfer_type_id;
    }

    public void setTransfer_type_id(long transfer_type_id) {
        this.transfer_type_id = transfer_type_id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}



