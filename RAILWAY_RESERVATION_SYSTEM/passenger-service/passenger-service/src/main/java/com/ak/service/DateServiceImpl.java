package com.ak.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class DateServiceImpl implements DateService{
	
	
	
	
	@Override
	public String getDayFromDate(String dateString) throws Exception {
		int day=0;
		String dateParsed=dateString.replace("-", "/");
		
		Date date=new SimpleDateFormat("dd/MM/yyyy").parse(dateParsed);
		
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);
		day=calendar.get(Calendar.DAY_OF_WEEK);
		switch (day) {
		case 0:
			return "SUNDAY";
		case 1:
			return "MONDAY";
		case 2:
			return "TUESDAY";
		case 3:
			return "WEDNESDAY";
		case 4:
			return "THURSDAY";
		case 5:
			return "FRIDAY";
		case 6:
			return "SATURDAY";
     	}
		
		return "SUNDAY";
	}

}
