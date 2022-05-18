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

import com.FrontAPI.model.DisplayWeek;

@RestController
public class DisplayWeekController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private RestTemplate restTemplate;
	//  http://localhost:5050/weekdisplay/new
		
	@GetMapping("/weekdisplay/getall")
	public List<DisplayWeek> getAllDisplayWeek() {
		ResponseEntity<List> displayWeek = restTemplate.getForEntity("http://localhost:4040/displayweeks/weeks/", List.class);
		List<DisplayWeek> displayWeekList = displayWeek.getBody();
		logger.info("All Weeks Here");
		return displayWeekList;
		
	}
	
	/* Use this in Postman 
	 * http://localhost:4040/weekdisplay/1
	 */
	@GetMapping("/weekdisplay/get/{week}")
	public DisplayWeek getDisplayWeekById(@PathVariable Long week) {
		ResponseEntity<DisplayWeek> displayWeek = restTemplate.getForEntity("http://localhost:4040/displayweeks/weeks/" + week, DisplayWeek.class);
		logger.info("Single Week Here");
		return displayWeek.getBody();
		
	}
	
	@PostMapping("/weekdisplay/new")
	public DisplayWeek saveDisplayWeek(@RequestBody DisplayWeek displayWeek) {
		ResponseEntity<DisplayWeek> response = restTemplate.postForEntity("http://localhost:4040/displayweeks/postWeek", displayWeek, DisplayWeek.class);
		return response.getBody();
	}
	
	@PutMapping("weekdisplay/update/{week}")
	public void updateDisplayWeekById(@PathVariable Long week, @RequestBody DisplayWeek displayWeek) {
		restTemplate.put("http://localhost:4040/displayweeks/weeks/" + week, displayWeek);
	}
	
	@DeleteMapping("/weekdisplay/delete")
	public void deleteDisplayWeekById(@RequestParam Long week) {
		restTemplate.delete("http://localhost:4040/displayweeks/weeks?id=" + week);
	}
	
}
