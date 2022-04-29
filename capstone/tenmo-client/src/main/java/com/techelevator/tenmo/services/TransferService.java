package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.util.BasicLogger;
import org.springframework.http.*;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

public class TransferService {

    private final String baseUrl;
    private final RestTemplate restTemplate = new RestTemplate();
    private String authToken  = null;

    public TransferService(String url) {
        this.baseUrl = url;
    }
    public void setAuthToken(String authToken)
    {
        this.authToken = authToken;
    }


    public Transfer initiateTransfer(Transfer transfer){
            Transfer transfer1 = null;
            String url = baseUrl + "transfer";

        System.out.println("DEBUG ANDY");
        System.out.println(transfer);

            try
            {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                headers.setBearerAuth(authToken);
                HttpEntity<Transfer> entity = new HttpEntity<>(transfer, headers);
                transfer1 = restTemplate.postForObject(url, entity, Transfer.class);

            }
            catch(RestClientResponseException e)
            {
                BasicLogger.log(e.getMessage());
            }

            return transfer1;
        }
}

