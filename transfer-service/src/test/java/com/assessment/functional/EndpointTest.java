/**
 * 
 */
package com.assessment.functional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.assessment.app.TransferServiceApplication;
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
    public void testEndpointAvailability() {
    	
    }
    
    @Test
    public void testPostReqWithValidData() {
    	
    }
    
    @Test
    public void testPostReqwithInvalidData() {
    	
    }
    
    @Test
    public void test5xxError() {
    	
    }
}
