package com.mintyn.model;

import com.mintyn.entity.CardPayLoad;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardVerificationResponse {

	 private boolean success;
	    private CardPayLoad payload;
}
