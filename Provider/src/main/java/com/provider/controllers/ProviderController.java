package com.provider.controllers;

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

import com.provider.entities.DisplayWeek;
import com.provider.services.WeekService;


@RestController
@RequestMapping("/displayweeks")
public class ProviderController {
	
	// http://localhost:4040/displayweeks/blank
	@Autowired
	private WeekService weekService;
	
	//	http://localhost:4040/displayweeks/weeks
	@GetMapping("/weeks")
	public List <DisplayWeek> getWeeks() {
		return weekService.findAllDisplayWeeks();
	}
//	http://localhost:4040/displayweeks/weeks/number
	@GetMapping("/weeks/{week}")
	public DisplayWeek getDisplayWeek (@PathVariable Long week) {
		return weekService.getSingleWeek(week);
	}
//	http://localhost:4040/displayweeks/postWeeks
	@PostMapping("/postWeeks")
	public DisplayWeek saveDisplayWeek(@RequestBody DisplayWeek weeks) {
		return weekService.saveDisplayWeek(weeks);
	}
//	http://localhost:4040/displayweeks/weeks/number
	@PutMapping("/weeks/{week}")
	public DisplayWeek updateDisplaySuite(@PathVariable Long week, @RequestBody DisplayWeek displayWeek) {
		displayWeek.setWeek(week);
		return weekService.updateDisplayWeek(displayWeek);
	}
//	http://localhost:4040/displayweeks/weeks?id=number
	@DeleteMapping("/weeks")
	public void deleteDisplaySuite (@RequestParam Long week) {
		weekService.deleteWeek(week);
	}
}