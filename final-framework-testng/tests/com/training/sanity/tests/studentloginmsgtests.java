package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.RegisterPOM;
import com.training.pom.studentloginmsgPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class studentloginmsgtests {
    //RegisterPOM = new RegisterPOM();
	private WebDriver driver;
	private String baseUrl;
	private studentloginmsgPOM nstudentloginmsgPOM; 
	private static Properties properties;
	private ScreenShot screenShot;

	//This class is used to run before the first test method in the current class is invoked.
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	//This annotation will be executed prior to each method in each testcase.  
	//This method is used to get the baseurl and also the driver details
	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		nstudentloginmsgPOM = new studentloginmsgPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	// methods under this, will be executed after each method in each testcase and will comeout of the browser.
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	//This method is used to execute by passing attribute values.
	@Test
	public void validstudentloginmsgTests() {
		
		nstudentloginmsgPOM.sendusername("test1");
		nstudentloginmsgPOM.sendpassword("nB2w5oVE");
		nstudentloginmsgPOM.clicksubmit(); 
		//screenShot.captureScreenShot("First");
	}
	@FindBy(xpath="//*[@id=\"homepage-course\"]/div/p[1]/strong") 
	private WebElement finalText;
	
	
	//The below assert is used to verify the state of the application is same to what we are expecting.
    //When assert fails, then the test is aborted and will not continue further.
	public void checkCourse() {
		String expectedText = "Hello murali1 test1 and welcome,";
		WebElement actual = this.finalText;
		String actualText = actual.getText();
		assertEquals(actualText, expectedText);
	}
	

}

