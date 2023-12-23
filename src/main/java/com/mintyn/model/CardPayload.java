package com.mintyn.model;


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
public class CardPayload {

	  private String scheme;
	    private String type;
	    private String bank;

}
