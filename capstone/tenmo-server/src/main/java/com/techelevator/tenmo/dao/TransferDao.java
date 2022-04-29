package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TransferDao {

    List<Transfer> getTransfers(int userid);

   // Transfer createTransfer(Transfer transfer);

    @Transactional
    Transfer createTransfer(Transfer transfer, Account accountFrom, Account accountTo);

    Transfer findbyId(long transfer_id);
}
