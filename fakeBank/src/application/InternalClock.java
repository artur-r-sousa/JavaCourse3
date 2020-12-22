package application;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;

public class InternalClock {
	
	private DateTime dt;
	private LocalTime time;
	
	public InternalClock() {
		
	}
	
	
	public InternalClock(DateTime dt) {
		this.dt = dt;
	}
	
	public InternalClock(LocalTime time) {
		this.time = time;
	}
	
	public LocalTime getTime() {
		return time;
	}


	public void setTime(LocalTime time) {
		this.time = time;
	}


	public DateTime getDt() {
		return dt;
	}

	public void setDt(DateTime dt) {
		this.dt = dt;
	}
	
	public DateTime startDt() {
		DateTime start = new DateTime();
		return start;
	}

	@Override
	public String toString() {
		return startDt().getHourOfDay()+":"+startDt().getMinuteOfHour()+":"+startDt().getSecondOfMinute();
	}
	
	
	
}
