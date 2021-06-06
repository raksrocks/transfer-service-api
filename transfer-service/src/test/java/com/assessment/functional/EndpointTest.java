/**
 * 
 */
package com.assessment.functional;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.assessment.app.TransferServiceApplication;
import com.assessment.domain.Transaction;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author raksinga1
 *
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = TransferServiceApplication.class)
public class EndpointTest {
	
	@Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private ObjectMapper mapper;
    
    @Test
    public void testEndpointAvailability() throws JsonProcessingException {
    	Transaction trans = new Transaction("1001", "1002",10.0);
    	HttpEntity<String> entity = getStringHttpEntity(trans);
    	
    	ResponseEntity<String> responseEntity = restTemplate.postForEntity("/xfer/send", entity, String.class);
    	
    	assertThat(responseEntity.getStatusCode()).isNotNull();
    }
    
    @Test
    public void testPostReqWithValidData() throws JsonProcessingException {
    	Transaction trans = new Transaction("1001", "1002",10.0);
    	HttpEntity<String> entity = getStringHttpEntity(trans);
    	
    	ResponseEntity<String> responseEntity = restTemplate.postForEntity("/xfer/send", entity, String.class);
    	
    	assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }
    
    @Test
    public void testPostReqwithInvalidData() throws JsonProcessingException {
    	Transaction trans = new Transaction("1001", "1008",10.0);
    	HttpEntity<String> entity = getStringHttpEntity(trans);
    	
    	ResponseEntity<String> responseEntity = restTemplate.postForEntity("/xfer/send", entity, String.class);
    	
    	assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }
    
    @Test
    public void test5xxError() {
    	//ToDo Mock 5xx error 
    }
    
    private HttpEntity<String> getStringHttpEntity(Object object) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String jsonData = mapper.writeValueAsString(object);
        return (HttpEntity<String>) new HttpEntity(jsonData, headers);
    }
}
