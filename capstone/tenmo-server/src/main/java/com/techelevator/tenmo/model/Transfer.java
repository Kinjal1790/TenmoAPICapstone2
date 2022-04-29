package com.techelevator.tenmo.model;

import java.math.BigDecimal;

public class Transfer {
    private long transfer_id;
    private long transferTypeId;
    private long transferStatusId;
    private long fromUserId;
    private long toUserId;
    private BigDecimal amount;

    public long getAccount_from() {
        return account_from;
    }

    public void setAccount_from(long account_from) {
        this.account_from = account_from;
    }

    public long getAccount_to() {
        return account_to;
    }

    public void setAccount_to(long account_to) {
        this.account_to = account_to;
    }

    private long account_from;
    private long account_to;


    public long getTransfer_id() {
        return transfer_id;
    }

    public void setTransfer_id(long transfer_id) {
        this.transfer_id = transfer_id;
    }

    public long getTransferTypeId() {
        return transferTypeId;
    }

    public void setTransferTypeId(long transferTypeId) {
        this.transferTypeId = transferTypeId;
    }

    public long getTransferStatusId() {
        return transferStatusId;
    }

    public void setTransferStatusId(long transferStatusId) {
        this.transferStatusId = transferStatusId;
    }

    public long getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(long fromUserId) {
        fromUserId = fromUserId;
    }

    public long getToUserId() {
        return toUserId;
    }

    public void setToUserId(long toUserId) {
        toUserId = toUserId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
