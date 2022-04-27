package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.Account;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
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

    public BigDecimal getbalance(){
        BigDecimal balance = null;
        try
        {
            String url = baseUrl + "account";
            HttpHeaders headers = new HttpHeaders();
            headers.setBearerAuth(authToken);
            HttpEntity<Void> entity = new HttpEntity<>(headers);

            ResponseEntity<Account> response = restTemplate.exchange(url, HttpMethod.GET, entity, Account.class);
            balance = response.getBody().getBalance();

        }
        catch(RestClientResponseException e)
        {
            e.getRawStatusCode();
        }

        return balance;
    }
}
