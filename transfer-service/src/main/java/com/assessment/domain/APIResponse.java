/**
 * 
 */
package com.assessment.domain;

/**
 * @author raksinga1
 *
 */
public class APIResponse {
	
	private String message;
	private Integer code;
	private String details;
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
	}
	public APIResponse() {
		// TODO Auto-generated constructor stub
	}

}
