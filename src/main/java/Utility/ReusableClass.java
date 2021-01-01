package Utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReusableClass {
	
	public static String getCurrentTimeStamp() {
		
		return new SimpleDateFormat("dd-MM-yyyy-hh:mm:ss").format(new Date());
	}

}
