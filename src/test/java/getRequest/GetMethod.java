package getRequest;

import org.testng.annotations.Test;

public class GetMethod {
	@Test
	public void get() {
		
		Throwable throwable = new Throwable();
		String methodName = throwable 
                .getStackTrace()[0] 
                .getMethodName();
		
		String classname = throwable.getStackTrace()[0].getClassName();
		
		System.out.println(throwable.getStackTrace());
		System.out.println(methodName);
		System.out.println(classname);
		
	}
	

}
