/**
 * 
 */
package com.assessment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.domain.APIResponse;
import com.assessment.domain.Transaction;
import com.assessment.service.XferService;

/**
 * @author raksinga1
 *
 */
@RestController
@RequestMapping("/xfer")
public class TransferController {
	
	private final XferService xferService;
	
	
	public TransferController(XferService xferService) {
		this.xferService = xferService;
	}


	@PostMapping(path="/send", consumes = {"application/json"})
	public ResponseEntity<APIResponse> sendTransferRequest(@RequestBody Transaction transaction) {
		APIResponse result = xferService.trasnfer(transaction);
		if(result.getCode()==400) 
			return new ResponseEntity<APIResponse>(result,HttpStatus.BAD_REQUEST);	
		else if(result.getCode()==500)
			return new ResponseEntity<APIResponse>(result,HttpStatus.INTERNAL_SERVER_ERROR);
		else
			return new ResponseEntity<APIResponse>(result,HttpStatus.CREATED);
	}
	
	
}
