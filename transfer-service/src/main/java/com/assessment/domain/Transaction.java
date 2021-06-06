/**
 * 
 */
package com.assessment.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author raksinga1
 *
 */

@Getter @Setter 
@Entity
@Table(name = "transaction")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	private String sourceNumber;
	
	private String destNumber;
	
	private Double amount;

	public String getSourceNumber() {
		return sourceNumber;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", sourceNumber=" + sourceNumber + ", destNumber=" + destNumber + ", amount="
				+ amount + "]";
	}

	public String getDestNumber() {
		return destNumber;
	}

	public Double getAmount() {
		return amount;
	}

	public Transaction(String sourceNumber, String destNumber, Double amount) {
		this.sourceNumber = sourceNumber;
		this.destNumber = destNumber;
		this.amount = amount;
	}

	public Transaction() {
		
	}	
}
