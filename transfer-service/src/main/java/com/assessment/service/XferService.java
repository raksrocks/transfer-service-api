/**
 * 
 */
package com.assessment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessment.domain.APIResponse;
import com.assessment.domain.Account;
import com.assessment.domain.Transaction;
import com.assessment.repo.AccountRepository;
import com.assessment.repo.TransactionRepository;

/**
 * @author raksinga1
 *
 */
@Service
public class XferService {
	
	@Autowired
	private final AccountRepository accRepo;
	@Autowired
	private final TransactionRepository txnRepo;

	
	  public XferService(AccountRepository accRepo, TransactionRepository txnRepo)
	  { this.accRepo = accRepo; this.txnRepo = txnRepo; }
	 
	
	
	
	public APIResponse trasnfer(Transaction txn) {
		
		APIResponse resp = new APIResponse();
		
		try {		
		
			Account source = accRepo.findByNumber(txn.getSourceNumber());
			if(null == source) {
				resp.setCode(400);
				resp.setMessage("Failed to create transaction");
				resp.setDetails("Source Account number is invalid");
				return resp;
			}else if(source.getBalance() < txn.getAmount()) {
				resp.setCode(400);
				resp.setMessage("Failed to create transaction");
				resp.setDetails("Source Account doesn't have sufficient funds");
				return resp;
			}
			
			Account dest = accRepo.findByNumber(txn.getDestNumber());
			if(null == dest) {
				resp.setCode(400);
				resp.setMessage("Failed to create transaction");
				resp.setDetails("Destination Account number is invalid");
				return resp;
			}
			
			source.setBalance(source.getBalance()+txn.getAmount());
			dest.setBalance(dest.getBalance()-txn.getAmount());
			source = accRepo.save(source);
			dest = accRepo.save(dest);
			
			txn = txnRepo.save(txn);
			
			resp.setCode(201);
			resp.setMessage("Transaction successful");
			resp.setDetails(txn.toString()+"\n"+source.toString()+"\n"+dest.toString());
			
			return resp;
		}catch (Exception e) {
			resp.setCode(500);
			resp.setMessage("Failed to create transaction");
			resp.setDetails("Unexpected error has occured: "+e.getLocalizedMessage());
			return resp;	
		}
	}

	
	
}
