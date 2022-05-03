package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.User;
import com.techelevator.util.BasicLogger;
import org.springframework.http.*;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class AccountService {

    private final String baseUrl;

    private static final RestTemplate restTemplate = new RestTemplate();

    private String authToken  = null;

    public AccountService(String url) {
        this.baseUrl = url;
    }


    public void setAuthToken(String authToken)
    {
        this.authToken = authToken;
    }

    public BigDecimal getBalance(long userId){
        Account account = null;
        try
        {
            String url = baseUrl + "account/" + userId;
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setBearerAuth(authToken);
            HttpEntity<Void> entity = new HttpEntity<>(headers);
            ResponseEntity<Account> response = restTemplate.exchange(url, HttpMethod.GET, entity, Account.class);
            account = response.getBody();

        }
        catch(RestClientResponseException e)
        {
            BasicLogger.log(e.getMessage());        }

        return account.getBalance();
    }

//    private HttpEntity<Void> makeAuthEntity()
//    {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setBearerAuth(authToken);
//        return new HttpEntity<>(headers);
//
//    }
//
//    public List<Account> getAccounts()
//    {
//        List<Account> accounts = new ArrayList<>();
//
//        try
//        {
//            String url = baseUrl + "accounts/list";
//            HttpEntity<Void> entity = makeAuthEntity();
//
//            ResponseEntity<Account[]> response = restTemplate.exchange(url, HttpMethod.GET, entity, Account[].class);
//            accounts = Arrays.asList(response.getBody());
//        }
//        catch(RestClientResponseException e)
//        {
//            System.out.println(e.getMessage());
//        }
//
//        return accounts;
//    }


//    public void updateAccount(long currentUserId, long userId, BigDecimal amount){
//        try{
//            long accountIdFrom = getId(currentUserId);
//            Account accountFrom = new Account(accountIdFrom, currentUserId, amount);
//
//            long accountIdTo = getId(userId);
//            Account accountTo = new Account(accountIdTo, currentUserId, amount);
//
//            String url = baseUrl + "account";
//
//            ResponseEntity<Account> resonseAccountFrom = restTemplate.exchange(url, HttpMethod.PUT, makeAccountEntity(accountFrom), Account.class);
//            ResponseEntity<Account> resonseAccountTo = restTemplate.exchange(url, HttpMethod.PUT, makeAccountEntity(accountTo), Account.class);
//
//        }
//        catch(RestClientResponseException e){
//            System.out.println(e.getMessage());
//        }
//    }


//    private HttpEntity<Account> makeAccountEntity(Account account)
//    {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.setBearerAuth(authToken);
//        return new HttpEntity<>(account, headers);
//    }




//    public long getId(long id){
//        long accountId = 0;
//        for(Account account: getAccounts()){
//            if (id == account.getUserId()){
//                accountId = account.getAccountId();
//            }
//        }
//        return accountId;
//    }

}
