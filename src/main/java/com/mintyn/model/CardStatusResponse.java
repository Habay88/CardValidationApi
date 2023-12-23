package com.mintyn.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CardStatusResponse {
	private boolean success;
    private int start;
    private int limit;
    private int size;
    private Map<String, String> payload;
}
