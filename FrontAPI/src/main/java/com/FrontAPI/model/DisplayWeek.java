package com.FrontAPI.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DisplayWeek {
	private long week;
	private String date;
	private String opponent;
	public DisplayWeek(long week, String date, String opponent) {
		super();
		this.week = week;
		this.date = date;
		this.opponent = opponent;
	}
	public long getWeek() {
		return week;
	}
	public void setWeek(long week) {
		this.week = week;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getOpponent() {
		return opponent;
	}
	public void setOpponent(String opponent) {
		this.opponent = opponent;
	}
	@Override
	public int hashCode() {
		return Objects.hash(date, opponent, week);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DisplayWeek other = (DisplayWeek) obj;
		return Objects.equals(date, other.date) && Objects.equals(opponent, other.opponent) && week == other.week;
	}
	@Override
	public String toString() {
		return "DisplayWeek [week=" + week + ", date=" + date + ", opponent=" + opponent + "]";
	}
	
	
}
