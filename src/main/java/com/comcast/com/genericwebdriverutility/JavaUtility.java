package com.comcast.com.genericwebdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getrandomnumber()
	{
		Random random=new Random();
	  int randomnumber =random.nextInt(5000);
	  return randomnumber;
		
	}
	public String getSystemDateYYYYDDMM() {
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String date=sdf.format(d);
		return date;
		
	}
	
	public String getRequiredDataYYYYMMDD(int days) {
		Date d=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
	//	String date=sim.format(d);
		Calendar cal=sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String reqDate = sim.format(cal.getTime());
		return reqDate;
	}
	


}

