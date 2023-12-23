package com.mintyn.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mintyn.model.CardStatusResponse;
import com.mintyn.model.CardVerificationResponse;
import com.mintyn.service.BinService;

import reactor.core.publisher.Mono;

@RestController
public class CardSchemeController {

    private final BinService binService;
    
    @RequestMapping("/hello")
    public String Hello() {
    	return "it is working";
    }
    @GetMapping(value="/testUrl")
    private String getUrl() {
    	String uri = "https://binlist.net/";
    	RestTemplate restTemplate = new RestTemplate();
    	String result = restTemplate.getForObject(uri, String.class);
    	return result ;
    }

    @Autowired
    public CardSchemeController(BinService binService) {
        this.binService = binService;
    }

    @GetMapping("/card-scheme/verify/{cardNumber}")
    public Mono<CardVerificationResponse> verifyCard(@PathVariable String cardNumber) {
        return binService.verifyCard(cardNumber);
    }

    @GetMapping("/card-scheme/status")
    public Mono<CardStatusResponse> getCardStats(@RequestParam int start, @RequestParam int limit) {
        return binService.getCardStatus(start, limit);
    }
}
