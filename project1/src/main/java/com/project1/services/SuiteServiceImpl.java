package com.project1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project1.entities.DisplaySuite;
import com.project1.repositories.SuiteRepository;

@Service
public class SuiteServiceImpl implements SuiteService {
	
	@Autowired
	private SuiteRepository suiteRepository;
	
	@Override
	public List<DisplaySuite> findAllDisplaySuites() {
		return suiteRepository.findAll();
	}
	
	@Override
	public DisplaySuite saveDisplaySuite(DisplaySuite displaySuite) {
		return suiteRepository.save(displaySuite);
	}
	
	@Override
	public DisplaySuite getSingleSuite(Long id) {
		Optional<DisplaySuite> displaySuite = suiteRepository.findById(id);
		if(displaySuite.isPresent()) {
			return displaySuite.get();
		} 
		throw new RuntimeException("Suite " + id + " does not exist");
	}
	
	@Override
	public void deleteSuite(Long id) {
		suiteRepository.deleteById(id);
	}
	
	@Override
	public DisplaySuite updateDisplaySuite(DisplaySuite displaySuite) {
		return suiteRepository.save(displaySuite);
	}

}
