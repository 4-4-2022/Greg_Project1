package com.provider.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.provider.entities.DisplayWeek;

@Service
public interface WeekService {

	public List<DisplayWeek> findAllDisplayWeeks();
	public DisplayWeek saveDisplayWeek(DisplayWeek displayWeek);
	public DisplayWeek getSingleWeek(Long week);
	public void deleteWeek(Long week);
	public DisplayWeek updateDisplayWeek(DisplayWeek displayWeek);
}
