/**
 * 
 */
package com.assessment.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author raksinga1
 *
 */

@Getter @Setter @NoArgsConstructor
public class Transaction {
	
	private Long id;
	
	private String sourceNumber;
	
	private String destNumber;
	
	private Double amount;

	public Transaction(String sourceNumber, String destNumber, Double amount) {
		this.sourceNumber = sourceNumber;
		this.destNumber = destNumber;
		this.amount = amount;
	}

	public Transaction() {
		
	}	
}
