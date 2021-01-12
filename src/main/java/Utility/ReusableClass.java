package Utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReusableClass {
	
	public static String getCurrentTimeStamp() {
		
		return new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
	}

}
