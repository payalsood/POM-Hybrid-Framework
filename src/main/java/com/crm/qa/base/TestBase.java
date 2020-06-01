package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {
 public static WebDriver driver;
 public static Properties prop;
 
	public TestBase(){
		
		try {
				prop = new Properties();
				FileInputStream ip = new FileInputStream("\\Users\\Payal Sood\\workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
				prop.load(ip);
	} catch(FileNotFoundException e){
		e.printStackTrace();
				
	}catch(IOException e){
		e.printStackTrace();
	}
	}
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
			driver = new ChromeDriver();
		}else {
			System.out.println("browser not found");
		}
		
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_timeut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		
	}
	
}

