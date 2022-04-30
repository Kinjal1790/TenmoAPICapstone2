package com.techelevator.tenmo.controller;


import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.dao.TransferDao;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("transfer")
@PreAuthorize("isAuthenticated()")
public class TransferController {


    private TransferDao transferDao;
    private UserDao userDao;
    private AccountDao accountDao;

    @Autowired
    public TransferController(TransferDao transferDao, UserDao userDao, AccountDao accountDao) {
        this.transferDao = transferDao;
        this.userDao = userDao;
        this.accountDao = accountDao;
    }

    @PostMapping()
    public Transfer doTransfer(@RequestBody Transfer transfer, Principal principal) {

//        System.out.println("DEBUG ANDY");
//        System.out.println(transfer);
//        return null;

        Account accountFrom = accountDao.getAccount(transfer.getFromUserId());
        Account accountTo = accountDao.getAccount(transfer.getToUserId());


        return transferDao.createTransfer(transfer, accountFrom, accountTo);

    }

    @GetMapping("{userId}")
    public List<Transfer> getAllTransfer(@PathVariable long userId) {
        return transferDao.findAll(userId);
    }

}
