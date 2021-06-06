/**
 * 
 */
package com.assessment.domain;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author raksinga1
 *
 */
public class APIResponse {
	
	private String message;
	private Integer code;
	private String details;
	
	private Transaction txn;

	@Autowired
	private Account source;
	@Autowired
	private Account dest;
	
	/**
	 * @return the txn
	 */
	public Transaction getTxn() {
		return txn;
	}
	/**
	 * @return the source
	 */
	public Account getSource() {
		return source;
	}
	/**
	 * @return the dest
	 */
	public Account getDest() {
		return dest;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the code
	 */
	public Integer getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(Integer code) {
		this.code = code;
	}
	/**
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}
	/**
	 * @param details the details to set
	 */
	public void setDetails(String details) {
		this.details = details;
	}
	public APIResponse(String message, Integer code, String details) {
		this.message = message;
		this.code = code;
		this.details = details;
		this.txn = new Transaction();
	}
	public APIResponse() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param txn the txn to set
	 */
	public void setTxn(Transaction txn) {
		this.txn = txn;
	}
	/**
	 * @param source the source to set
	 */
	public void setSource(Account source) {
		this.source = source;
	}
	/**
	 * @param dest the dest to set
	 */
	public void setDest(Account dest) {
		this.dest = dest;
	}
	
}
