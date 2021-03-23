package com.example.demo.controller;

import com.example.demo.Campaign;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class Hitter {
    @Autowired
    RestTemplate restTemplate;

    public void uriHitting(Campaign body){
        //HttpHeaders headers=new HttpHeaders();
        //headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        ResponseEntity<String> response=restTemplate.postForEntity("https://ezetap.verloop.io/api/v1/Campaign/SendMessage",body,String.class);
        //System.out.println(restTemplate.postForObject("https://ezetap.verloop.io/api/v1/Campaign/SendMessage", entity,String.class));
        System.out.println(response.getBody());
    }

}
