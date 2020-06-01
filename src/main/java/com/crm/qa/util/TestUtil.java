package com.crm.qa.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long page_load_timeut = 20;
	public static long implicit_wait = 10;
	
	public void switchToFrame(){
		
		driver.switchTo().frame("mainpanel");
		
	}
	
	public void takeScreenshot() throws IOException{
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 String filename =  new SimpleDateFormat("yyyyMMddhhmmss'").format(new Date());
		FileUtils.copyFile(srcfile, new File(System.getProperty("user.dir")+ "/screenshots/" + filename +".png"));
	}
	
}
