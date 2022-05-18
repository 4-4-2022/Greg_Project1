package com.FrontAPI.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.FrontAPI.model.DisplaySuite;

@RestController
public class DisplaySuiteController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/suitedisplay/getall")
	public List<DisplaySuite> getAllDisplaySuite() {
		ResponseEntity<List> displaySuite = restTemplate.getForEntity("http://localhost:3030/displaysuites/suites/", List.class);
		List<DisplaySuite> displaySuiteList = displaySuite.getBody();
		logger.info("All Suites Here");
		return displaySuiteList;
		
	}
	
	/* Use this in Postman 
	 * http://localhost:5050/suitedisplay/1
	 */
	@GetMapping("/suitedisplay/get/{id}")
	public DisplaySuite getDisplaySuiteById(@PathVariable Long id) {
		ResponseEntity<DisplaySuite> displaySuite = restTemplate.getForEntity("http://localhost:3030/displaysuites/suites/" + id, DisplaySuite.class);
		logger.info("Single Suite Here");
		return displaySuite.getBody();
		
	}
	
	@PostMapping("/suitedisplay/new")
	public DisplaySuite saveDisplaySuite(@RequestBody DisplaySuite displaySuite) {
		ResponseEntity<DisplaySuite> response = restTemplate.postForEntity("http://localhost:3030/displaysuites/postSuite", displaySuite, DisplaySuite.class);
		return response.getBody();
	}
	
	@PutMapping("suitedisplay/update/{id}")
	public void updateDisplaySuiteById(@PathVariable Long id, @RequestBody DisplaySuite displaySuite) {
		restTemplate.put("http://localhost:3030/displaysuites/suites/" + id, displaySuite);
	}
	
	@DeleteMapping("/suitedisplay/delete")
	public void deleteDisplaySuiteById(@RequestParam Long id) {
		restTemplate.delete("http://localhost:3030/displaysuites/suites?id=" + id);
	}
	
}
