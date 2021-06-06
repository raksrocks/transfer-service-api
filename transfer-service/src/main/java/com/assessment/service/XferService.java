/**
 * 
 */
package com.assessment.service;

import org.springframework.stereotype.Service;

import com.assessment.domain.Transaction;

/**
 * @author raksinga1
 *
 */
@Service
public class XferService {
	
	private final Transaction transaction;

	public XferService(Transaction transaction) {
		this.transaction = transaction;
	}
	
	public boolean trasnfer() {
		return false;
	}
}
