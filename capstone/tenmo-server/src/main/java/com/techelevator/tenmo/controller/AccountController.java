package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;


@RestController
@RequestMapping("account")
@PreAuthorize("isAuthenticated()")
public class AccountController {

    private AccountDao accountDao;
    private UserDao userDao;

    @Autowired
    public AccountController(AccountDao accountDao, UserDao userDao) {
        this.accountDao = accountDao;
        this.userDao = userDao;
    }


//    @GetMapping("/{id}/balance")
//    @PreAuthorize("permitAll()")
//    public BigDecimal getBalance(@PathVariable long userId){
//        return accountDao.getBalance(userId);
//    }


    @GetMapping("/{id}")
    public Account getAccount(@PathVariable long id) {
        return accountDao.getAccount(id);

    }


}
