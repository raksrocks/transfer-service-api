/**
 * 
 */
package com.assessment.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.assessment.domain.Transaction;
import com.assessment.repo.AccountRepository;
import com.assessment.repo.TransactionRepository;
import com.assessment.service.XferService;

/**
 * @author raksinga1
 *
 */
public class TransferControllerTest {
	
	private XferService service;
	private TransferController controller;
	@Autowired
	private AccountRepository accRepo;
	@Autowired
	private TransactionRepository txnRepo;
	
	@BeforeEach
	public void setup() {
		this.service = new XferService( accRepo, txnRepo);
	}
	
	@Test
	public void givenValidAccountDetailsThenTransferSuccessful() {
		
	}
	
	@Test
	public void givenInvalidAccountDetailsThenTransferNotSuccessful() {
		
	}
	
	@Test
	public void givenValidAccountDetailsThenValidateResponse() {
		
	}
	
	@Test
	public void givenInvalidAccountDetailsThenFaileResponse() {
		
	}
	
	
}
