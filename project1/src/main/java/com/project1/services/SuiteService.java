package com.project1.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project1.entities.DisplaySuite;

@Service
public interface SuiteService {

	public List<DisplaySuite> findAllDisplaySuites();
	public DisplaySuite saveDisplaySuite(DisplaySuite displaySuite);
	public DisplaySuite getSingleSuite(Long id);
	public void deleteSuite(Long id);
	public DisplaySuite updateDisplaySuite(DisplaySuite displaySuite);
}