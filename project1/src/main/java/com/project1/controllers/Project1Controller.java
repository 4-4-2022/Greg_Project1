package com.project1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project1.entities.DisplaySuite;
import com.project1.services.SuiteService;


@RestController
@RequestMapping("/displaysuites")
public class Project1Controller {
	
	// http://localhost:3030/displaysuites/blank
	@Autowired
	private SuiteService suiteService;
	
	//	http://localhost:3030/displaysuites/suites
	@GetMapping("/suites")
	public List <DisplaySuite> getSuites() {
		return suiteService.findAllDisplaySuites();
	}
//	http://localhost:3030/displaysuites/suites/number
	@GetMapping("/suites/{id}")
	public DisplaySuite getDisplaySuite (@PathVariable Long id) {
		return suiteService.getSingleSuite(id);
	}
//	http://localhost:3030/displaysuites/postSuites
	@PostMapping("/postSuites")
	public DisplaySuite saveDisplaySuite(@RequestBody DisplaySuite suites) {
		return suiteService.saveDisplaySuite(suites);
	}
//	http://localhost:3030/displaysuites/suites/number
	@PutMapping("/suites/{id}")
	public DisplaySuite updateDisplaySuite(@PathVariable Long id, @RequestBody DisplaySuite displaySuite) {
		displaySuite.setId(id);
		return suiteService.updateDisplaySuite(displaySuite);
	}
//	http://localhost:3030/displaysuites/suites?id=number
	@DeleteMapping("/suites")
	public void deleteDisplaySuite (@RequestParam Long id) {
		suiteService.deleteSuite(id);
	}
}
