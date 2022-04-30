package com.techelevator.tenmo.model;

import java.math.BigDecimal;

public class Transfer {

    private long transfer_id;
    private long fromUserId;
    private long toUserId;
    private BigDecimal amount;
    private String transfer_status_desc;
    private String transfer_type_desc;
    private String usernameFrom;
    private String usernameTo;

    public String getTransfer_status_desc() {
        return transfer_status_desc;
    }

    public void setTransfer_status_desc(String transfer_status_desc) {
        this.transfer_status_desc = transfer_status_desc;
    }

    public String getTransfer_type_desc() {
        return transfer_type_desc;
    }

    public void setTransfer_type_desc(String transfer_type_desc) {
        this.transfer_type_desc = transfer_type_desc;
    }

    public String getUsernameFrom() {
        return usernameFrom;
    }

    public void setUsernameFrom(String usernameFrom) {
        this.usernameFrom = usernameFrom;
    }

    public String getUsernameTo() {
        return usernameTo;
    }

    public void setUsernameTo(String usernameTo) {
        this.usernameTo = usernameTo;
    }


    public long getTransfer_id() {
        return transfer_id;
    }

    public void setTransfer_id(long transfer_id) {

        this.transfer_id = transfer_id;
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }


    //    public long getTransferTypeId() {
//        return transferTypeId;
//    }
//
//    public void setTransferTypeId(long transferTypeId) {
//        this.transferTypeId = transferTypeId;
//    }
//
//    public long getTransferStatusId() {
//        return transferStatusId;
//    }
//
//    public void setTransferStatusId(long transferStatusId) {
//        this.transferStatusId = transferStatusId;
//    }

    //    @Override
//    public String toString() {
//        return "Transfer{" +
//                "transfer_id=" + transfer_id +
//                ", transferTypeId=" + transferTypeId +
//                ", transferStatusId=" + transferStatusId +
//                ", fromUserId=" + fromUserId +
//                ", toUserId=" + toUserId +
//                ", amount=" + amount +
//                '}';
//    }
//    public long getAccount_from() {
//        return account_from;
//    }
//
//    public void setAccount_from(long account_from) {
//        this.account_from = account_from;
//    }
//
//    public long getAccount_to() {
//        return account_to;
//    }
//
//    public void setAccount_to(long account_to) {
//        this.account_to = account_to;
//    }

//    private long account_from;
//    private long account_to;

}



