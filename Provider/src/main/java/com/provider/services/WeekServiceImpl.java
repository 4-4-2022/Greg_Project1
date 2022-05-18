package com.provider.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.provider.entities.DisplayWeek;
import com.provider.repositories.WeekRepository;

@Service
public class WeekServiceImpl implements WeekService {
	@Autowired
	private WeekRepository weekRepository;
	
	@Override
	public List<DisplayWeek> findAllDisplayWeeks() {
		return weekRepository.findAll();
	}
	
	@Override
	public DisplayWeek saveDisplayWeek(DisplayWeek displayWeek) {
		return weekRepository.save(displayWeek);
	}
	
	@Override
	public DisplayWeek getSingleWeek(Long week) {
		Optional<DisplayWeek> displaySuite = weekRepository.findById(week);
		if(displaySuite.isPresent()) {
			return displaySuite.get();
		} 
		throw new RuntimeException("Week " + week + " does not exist");
	}
	
	@Override
	public void deleteWeek(Long week) {
		weekRepository.deleteById(week);
	}
	
	@Override
	public DisplayWeek updateDisplayWeek(DisplayWeek displayWeek) {
		return weekRepository.save(displayWeek);
	}
	
}