package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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


    @GetMapping("/{id}")
    public Account getAccount(@PathVariable long id) {
        return accountDao.getAccount(id);

    }


//    @RequestMapping(path = "/list", method = RequestMethod.GET)
//    public List<Account> listAccounts() {
//
//        return accountDao.findAll();
//    }
//
//    @RequestMapping(path = "/account/", method = RequestMethod.PUT)
//    public Account update(@Valid @RequestBody Account account){
//        return accountDao.update(account);
//    }


}
