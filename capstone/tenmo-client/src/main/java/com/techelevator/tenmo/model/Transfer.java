package com.techelevator.tenmo.model;

import java.math.BigDecimal;

public class Transfer {

    private long transfer_id;
    private long fromUserId;
    private long toUserId;
    private BigDecimal amount;
    private long transferStatusId;
    private long transferTypeId;

    @Override
    public String toString() {
        return "Transfer{" +
                "transfer_id=" + transfer_id +
                ", fromUserId=" + fromUserId +
                ", toUserId=" + toUserId +
                ", amount=" + amount +
                ", transferStatusId=" + transferStatusId +
                ", transferTypeId=" + transferTypeId +
                '}';
    }

    public Transfer(long fromUserId, long toUserId, BigDecimal amount, long transferStatusId, long transferTypeId) {
        this.fromUserId = fromUserId;
        this.toUserId = toUserId;
        this.amount = amount;
        this.transferStatusId = transferStatusId;
        this.transferTypeId = transferTypeId;
    }


    public Transfer(long fromUserId, long toUserId, BigDecimal amount) {
        this.fromUserId = fromUserId;
        this.toUserId = toUserId;
        this.amount = amount;

    }


    public Transfer(){

    }

    public long getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(long fromUserId) {
        this.fromUserId = fromUserId;
    }

    public long getToUserId() {
        return toUserId;
    }

    public void setToUserId(long toUserId) {
        this.toUserId = toUserId;
    }

    public long getTransferStatusId() {
        return transferStatusId;
    }

    public void setTransferStatusId(long transferStatusId) {
        this.transferStatusId = transferStatusId;
    }

    public long getTransferTypeId() {
        return transferTypeId;
    }

    public void setTransferTypeId(long transferTypeId) {
        this.transferTypeId = transferTypeId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public long getTransfer_id() {
        return transfer_id;
    }

    public void setTransfer_id(long transfer_id) {
        this.transfer_id = transfer_id;
    }
}



