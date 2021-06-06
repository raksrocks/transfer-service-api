/**
 * 
 */
package com.assessment.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.assessment.domain.Transaction;

/**
 * @author raksinga1
 *
 */
public class XferServiceTest {
	
	private XferService service;
	
	@BeforeEach
	public void setUp() {
		this.service = new XferService(new Transaction());
	}
	
	@Test
	public void givenValidTransactionBeanShouldReturnSuccessfulResponse() {
		
	}

	@Test
	public void givenInvalidTransactionBeanShouldReturnFailureResponse() {
		
	}
}
