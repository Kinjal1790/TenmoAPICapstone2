package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserService {

    private final String baseUrl;

    private static final RestTemplate restTemplate = new RestTemplate();

    private String authToken  = null;

    public UserService(String url) {
        this.baseUrl = url;
    }


    public void setAuthToken(String authToken)
    {
        this.authToken = authToken;
    }


    public List<User> getAllUser()
    {
        List<User> users = new ArrayList<>();

        try
        {
            String url = baseUrl + "user";
            HttpHeaders headers = new HttpHeaders();
            headers.setBearerAuth(authToken);
            HttpEntity<Void> entity = new HttpEntity<>(headers);

            ResponseEntity<User[]> response = restTemplate.exchange(url, HttpMethod.GET, entity, User[].class);
            users = Arrays.asList(response.getBody());
        }
        catch(RestClientResponseException e)
        {

        }

        return users;
    }
}
