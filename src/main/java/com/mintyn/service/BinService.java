package com.mintyn.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.mintyn.model.BinResponse;
import com.mintyn.model.CardStatusResponse;
import com.mintyn.model.CardVerificationResponse;

import org.springframework.beans.factory.annotation.Value;
import reactor.core.publisher.Mono;

@Service
public class BinService {

    @Value("${bin.api.url}")
    private String binApiUrl;

    private final WebClient webClient;

    public BinService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(binApiUrl).build();
    }

    public Mono<CardVerificationResponse> verifyCard(String cardNumber) {
        return webClient.get()
                .uri("/card-scheme/verify/{cardNumber}", cardNumber)
                .retrieve()
                .bodyToMono(CardVerificationResponse.class);
    }

    public Mono<CardStatusResponse> getCardStatus(int start, int limit) {
        return webClient.get()
                .uri("/card-scheme/stats?start={start}&limit={limit}", start, limit)
                .retrieve()
                .bodyToMono(CardStatusResponse.class);
    }
}
