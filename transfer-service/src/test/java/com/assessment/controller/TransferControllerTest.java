/**
 * 
 */
package com.assessment.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.assessment.domain.APIResponse;
import com.assessment.domain.Transaction;
import com.assessment.repo.AccountRepository;
import com.assessment.repo.TransactionRepository;
import com.assessment.service.XferService;

/**
 * @author raksinga1
 *
 */

public class TransferControllerTest {
	
	//private XferService service;
	private TransferController controller;
	@Autowired
	private AccountRepository accRepo;
	@Autowired
	private TransactionRepository txnRepo;
	
	@BeforeEach
	public void setup() {
		this.controller = new TransferController(new XferService(accRepo, txnRepo));
	}
	
	@Test
	public void givenValidAccountDetailsThenTransferSuccessful() {
		assertThat(controller.sendTransferRequest(new Transaction("1001", "1002", 10.0)).getStatusCode()).isEqualTo(HttpStatus.CREATED);
	}
	
	@Test
	public void givenInvalidAccountDetailsThenTransferNotSuccessful() {
		assertThat(controller.sendTransferRequest(new Transaction("1008", "1002", 10.0)).getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
	}
	
	@Test
	public void givenInvalidDestAccountDetailsThenTransferNotSuccessful() {
		assertThat(controller.sendTransferRequest(new Transaction("1001", "1008", 10.0)).getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
	}
	
	@Test
	public void givenInvalidAmountThenTransferNotSuccessful() {
		assertThat(controller.sendTransferRequest(new Transaction("1001", "1002", -10.0)).getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
	}
	
	@Test
	public void givenInvalidAmountOnAccountThenTransferNotSuccessful() {
		assertThat(controller.sendTransferRequest(new Transaction("1001", "1002", 10000.0)).getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
	}
	
	@Test
	public void givenSameAccountsThenTransferNotSuccessful() {
		assertThat(controller.sendTransferRequest(new Transaction("1001", "1001", 10.0)).getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
	}
	
	@Test
	public void givenValidAccountDetailsThenValidateResponse() {
		Double sourceBalBefore = accRepo.findByNumber("1001").getBalance();
		Double destBalBefore = accRepo.findByNumber("1001").getBalance();
		Double amount = 10.0;
		APIResponse response = controller.sendTransferRequest(new Transaction("1001", "1002", amount)).getBody();
		
		assertEquals(201, response.getCode());
		assertEquals("Transaction successfully created", response.getMessage());
		assertEquals(amount, response.getTxn().getAmount());
		assertEquals(sourceBalBefore-amount, response.getSource().getBalance());
		assertEquals(destBalBefore+amount, response.getDest().getBalance());
		
	}
	
	
}
