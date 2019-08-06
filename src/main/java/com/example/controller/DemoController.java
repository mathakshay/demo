/**
 * 
 */
package com.example.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author amalendramath
 *
 */
@org.springframework.web.bind.annotation.RestController
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
	
	public String mainWithParam(String name,Model model) {
		model.addAttribute("message",name);
		return "welcome";
	}

}
