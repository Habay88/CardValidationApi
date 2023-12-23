package com.mintyn.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mintyn.service.BinService;

import reactor.core.publisher.Mono;

@RestController
public class CardSchemeController {

    private final BinService binService;

    @Autowired
    public CardSchemeController(BinService binService) {
        this.binService = binService;
    }

    @GetMapping("/card/details/{cardNumber}")
    public Mono<String> getCardDetails(@PathVariable String cardNumber) {
        return binService.getCardDetails(cardNumber)
                .map(response -> "Card is valid\n" +
                        "Scheme: " + response.getScheme() + "\n" +
                        "Bank: " + response.getBank())
                .defaultIfEmpty("Card not found or invalid");
    }
}
