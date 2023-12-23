package com.mintyn.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.mintyn.model.BinResponse;

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

    public Mono<BinResponse> getCardDetails(String cardNumber) {
        return webClient.get()
                .uri("/{cardNumber}", cardNumber)
                .retrieve()
                .bodyToMono(BinResponse.class);
    }
}