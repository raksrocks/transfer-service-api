/**
 * 
 */
package com.assessment.domain;

import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author raksinga1
 *
 */

@Getter @Setter @NoArgsConstructor
public class Account {
	
	@Id
	private Long id;
	
	private String number;
	
	private Double balance;

	public Account(String number, Double balance) {
		super();
		this.number = number;
		this.balance = balance;
	}

}
