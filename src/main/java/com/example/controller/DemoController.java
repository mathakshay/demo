/**
 * 
 */
package com.example.controller;

import java.util.Arrays;
import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author amalendramath
 *
 */
@Controller
public class DemoController {
	
	@Value("${welcome.message}")
	private String message;
	
	private List<String> tasks = Arrays.asList("a", "b", "c", "d", "e", "f", "g");
	
	@GetMapping("/")
	public String main(Model model) {
		model.addAttribute("message",message);
		model.addAttribute("tasks",tasks);
		return "welcome";
	}
	
   
    @GetMapping("/age")
    ResponseEntity<Integer> age(@RequestParam("yearOfBirth") int yearOfBirth) {
    	int age = 2019 - yearOfBirth;
        return ResponseEntity.status(HttpStatus.OK)
            .body((age));
    }
	
	public String mainWithParam(String name,Model model) {
		model.addAttribute("message",name);
		return "welcome";
	}

}
