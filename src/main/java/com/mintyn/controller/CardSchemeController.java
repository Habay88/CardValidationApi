package com.mintyn.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.mintyn.model.CardVerificationResponse;

@RestController
public class CardSchemeController {

    private final WebClient webClient;

    public CardSchemeController(WebClient.Builder webClientBuilder,
                                @Value("${binlist.api.url}") String binListApiUrl) {
        this.webClient = webClientBuilder.baseUrl(binListApiUrl).build();
    }

    @GetMapping("/card-scheme/verify/{cardNumber}")
    @ResponseBody
    public CardVerificationResponse verifyCard(@PathVariable String cardNumber) {
        // Use WebClient to make a GET request to the external API
        BinListResponse binListResponse = webClient.get()
                .uri("/{cardNumber}", cardNumber)
                .retrieve()
                .bodyToMono(BinListResponse.class)
                .block(); // blocking for simplicity, consider using reactive programming for non-blocking

        // Map the external API response to your custom response
        return new CardVerificationResponse(
                true,
                new CardPayload(
                        binListResponse.getScheme(),
                        binListResponse.getType(),
                        binListResponse.getBank()
                )
        );
    }

    // ... (other methods)

}