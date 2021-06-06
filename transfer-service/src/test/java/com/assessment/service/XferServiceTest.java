/**
 * 
 */
package com.assessment.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.assessment.domain.Transaction;
import com.assessment.repo.AccountRepository;
import com.assessment.repo.TransactionRepository;

/**
 * @author raksinga1
 *
 */
public class XferServiceTest {
	
	private XferService service;
	@Autowired
	private AccountRepository accRepo;
	@Autowired
	private TransactionRepository txnRepo;
	
	@BeforeEach
	public void setUp() {
		this.service = new XferService(accRepo,txnRepo);
	}
	
	@Test
	public void givenValidTransactionBeanShouldReturnSuccessfulResponse() {
		
	}

	@Test
	public void givenInvalidTransactionBeanShouldReturnFailureResponse() {
		
	}
}
