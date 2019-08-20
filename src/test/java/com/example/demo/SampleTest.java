/**
 * 
 */
package com.example.demo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
/**
 * @author amalendramath
 *
 */
@DisplayName("DisplayName Demo")
public class SampleTest {
	
    @BeforeAll
    static void init() {
        System.out.println("Only run once before all tests");
    }
	
    @BeforeEach
    void init(TestInfo testInfo) {
        String callingTest = testInfo.getTestMethod().get().getName();
        System.out.println(callingTest);
    }


	    @DisplayName("Test Junit")
	    @Test
	    void testGet() {
	        assertEquals("Hello JUnit 5", "Hello");
	    }
	    
	    @ParameterizedTest
	    @ValueSource(strings = { "cal", "bali", "dani" })
	    void endsWithI(String str) {
	        assertTrue(str.endsWith("i"));
	    }
	    
	    @RepeatedTest(value = 5, name = "{displayName} {currentRepetition}/{totalRepetitions}")
	    @DisplayName("RepeatingTest")
	    void customDisplayName(RepetitionInfo repInfo, TestInfo testInfo) {
	        int i = 3;
	        System.out.println(testInfo.getDisplayName() + 
	            "-->" + repInfo.getCurrentRepetition()
	        );
	        
	        assertEquals(repInfo.getCurrentRepetition(), i);
	    }
	    
	    @Test
	    @DisplayName("Custom test name")
	    @Disabled
	    void testWithDisplayName() {
	    }

	    @Test
	    @DisplayName("Print test name")
	    void printDisplayName(TestInfo testInfo) {
	        System.out.println(testInfo.getDisplayName());
	    }
	    
	    @AfterAll
	    static void after() {
	        System.out.println("Only run once after all tests");
	    }
	    
	}

