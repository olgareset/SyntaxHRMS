package com.hrms.utils;

public class Constants {
	
	public static final String CONFIGURAION_FILEPATH=System.getProperty("user.dir")
			+"/src/test/resources/configs/configuration.properties";
	
	public static final String TESTDATA_FILEPATH=System.getProperty("user.dir")+"\\src/test\\resouces\\testdata\\HrmsTestData";
	
	public static final String CHROMEDRIVER_PATH=System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\chromedriver.exe";
	
	public static final String GECKODRIVER_PATH=System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\geckodriver.exe";

	public static final int IMPLICIT_WAIT_TIME=10;
	
	public static final int EXPLICIT_WAIT_TIME=20;
	
	public static final String SCREENSHOT_FILEPATH=System.getProperty("user.dir")+"/target/screenshots/";
	
	

}
