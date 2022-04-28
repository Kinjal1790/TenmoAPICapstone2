package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("user")
@PreAuthorize("isAuthenticated()")
public class UserController {

        private AccountDao accountDao;
        private UserDao userDao;

        @Autowired
        public UserController(AccountDao accountDao, UserDao userDao) {
            this.accountDao = accountDao;
            this.userDao = userDao;
        }

        @GetMapping()
        public List<User> getList() {
            return userDao.findAll();
        }


    }
