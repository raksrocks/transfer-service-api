/**
 * 
 */
package com.assessment.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.assessment.domain.Transaction;
import com.assessment.service.XferService;

/**
 * @author raksinga1
 *
 */
public class TransferControllerTest {
	
	private XferService service;
	private TransferController controller;
	
	@BeforeEach
	public void setup() {
		this.service = new XferService(new Transaction());
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
