package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;

import java.math.BigDecimal;
import java.util.List;

public interface AccountDao {

    BigDecimal getBalance(long userId);

    Account getAccount(long userId);

    List<Account> findAll();

    Account update(Account account);

    Account add(Account accountFrom, BigDecimal amountToTransfer);

    Account substract(Account accountTo, BigDecimal AmountToAdd);
}
