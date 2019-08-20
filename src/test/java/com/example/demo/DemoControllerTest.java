package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.net.URL;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

/**
 * @author amalendramath
 *
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DemoControllerTest {


	    @LocalServerPort
	    private int port;

	    @Autowired
	    private TestRestTemplate restTemplate;
	    
	    
	    @Disabled
	    @Test
	    public void getHello() throws Exception {

	        ResponseEntity<String> response = restTemplate.getForEntity(
				new URL("http://localhost:" + port + "/").toString(), String.class);
	        assertEquals("welcome", response.getBody());

	    }
	    
   
	    @Test
	    public void getAge() throws Exception {

	        ResponseEntity<Integer> response = restTemplate.getForEntity(
				new URL("http://localhost:" + port + "/age?yearOfBirth=").toString().concat("1994"), Integer.class);
	        assertEquals(26, (int)response.getBody());

	    }

	    @Test
	    public void getHelloNegative() throws Exception {

	        ResponseEntity<String> response = restTemplate.getForEntity(
				new URL("http://localhost:" + port + "/").toString(), String.class);
	        
	        assertNotEquals("Hello Controller", response.getBody());

	    }

	}
