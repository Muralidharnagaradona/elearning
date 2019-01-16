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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RegistrationTests {
    //RegisterPOM = new RegisterPOM();
	private WebDriver driver;
	private String baseUrl;
	private RegisterPOM registerPOM; 
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
	//This method is used to get the baseurl and also the driver details.
	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		registerPOM = new RegisterPOM(driver); 
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
	public void validRegistrationTests() {
		registerPOM.clicksignup();
		registerPOM.sendfirstname("murali1");
		registerPOM.sendlastname("test1");
		registerPOM.sendemail("muralingd1@gmail.com");
		registerPOM.sendusername("test1");
		registerPOM.sendpass1("test1234");
		registerPOM.sendpass2("test1234");
		registerPOM.sendphone("9538801033");
		registerPOM.clicksubmit(); 
		//screenShot.captureScreenShot("First");
	}	
		
	
	@FindBy(xpath="//*[@id=\"content-section\"]/div/div[2]/div/p[2]") 
	private WebElement finalText;	
	     
	    //The below assert is used to verify the state of the application is same to what we are expecting.
	    //When assert fails, then the test is aborted and will not continue further.
		public void checkCourse() {
			String expectedText = "An email has been sent to help you remember your login and password.";
			WebElement actual = this.finalText;
			String actualText = actual.getText();
			assertEquals(actualText, expectedText);
		}
	

}

