package genericUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	//Generate Random number
	
	public int getRandomNumber() {
		Random random= new Random();
		int r= random.nextInt(5000);
		return r;
	}
	
	// Capture the System date
	
	public String getSystemDateyyyMMdd() {
		Date dateObj= new Date();
		SimpleDateFormat sim= new SimpleDateFormat("yyyy-MM-dd");
		String date = sim.format(dateObj);
		return date;
	}
	
	//Get Required Data
	
	public String getRequiredDateyyyMMdd(int days) {
		Date dateObj= new Date();
		SimpleDateFormat sim= new SimpleDateFormat("yyyy-MM-dd");
		sim.format(dateObj);
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,days);
		String reqDate = sim.format(cal.getTime());
		return reqDate;
	}
	
	//ToCapture Current Date and Time to Attach to the screenshot
	public String getCurrentDateAndTimeForSS() {
		
		String date = new Date().toString().replace(" ", "_").replace(":", "_");
		return date;
	}

}
