package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TransferDao {


    @Transactional
    Transfer createTransfer(Transfer transfer, Account accountFrom, Account accountTo);

    Transfer findbyId(int transfer_id);

    List<Transfer> findAll(long id);
}
