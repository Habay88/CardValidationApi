package com.mintyn.model;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardStatusResponse {
    private boolean success;
    private int start;
    private int limit;
    private int size;
    private Map<String, String> payload;

    
}