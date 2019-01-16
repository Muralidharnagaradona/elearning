package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.RegisterPOM;
import com.training.pom.studentloginmsgPOM;
import com.training.pom.RecoverpwdPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Recoverpwdtests {
    //private static final String priority 1 = null;
	//RegisterPOM = new RegisterPOM();
	private WebDriver driver;
	private String baseUrl;
	private RecoverpwdPOM recoverpwdPOM; 
	private static Properties properties;
	private ScreenShot screenShot;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		recoverpwdPOM = new RecoverpwdPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validRecoverpwdtests() {
		
		recoverpwdPOM.clickIlostmypassword();
		recoverpwdPOM.sendIlostpassworduser("test1");
		recoverpwdPOM.clickusernamesubmit("Send message"); 
		
		recoverpwdPOM.sendlogin("test1");
		recoverpwdPOM.sendpassword("Fc9aFmG6");
		recoverpwdPOM.clickformLogin_submitAuth1();
		
		//screenShot.captureScreenShot("First");
	}
	
 
   
		//ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
//		driver.switchTo().window(tabs.get(0));
//		driver.get("https://gmail.com");
//		recoverpwdPOM.sendGmailID("muralingd1@gmail.com");
//		recoverpwdPOM.clickGmailNext();
//		recoverpwdPOM.sendGmailPassword("rishith19");
//		recoverpwdPOM.clickGmailNext();
//		
		//driver.findElement(By.id("sendemailid")).sendKeys("muralingd1");
        //driver.findElement(By.id("clicknext1")).click();
        //driver.findElement(By.id("sendpassword")).sendKeys("rishith19");
        //driver.findElement(By.id("clicknext")).click();

		//recoverpwdPOM.sendemailid("muralingd1");
		//recoverpwdPOM.clicknext1("next1");
		//recoverpwdPOM.sendpassword("rishith19");
		//recoverpwdPOM.clicknext("next"); 
		
		//screenShot.captureScreenShot("First");
	 @FindBy(xpath="//*[@id=\"content-section\"]/div/div[2]/div[2]/div/div") 
	 private WebElement finalText;
	 
	 ////The below assert is used to verify the state of the application is same to what we are expecting.
	    //When assert fails, then the test is aborted and will not continue further
	 public void checkCourse() {
			String expectedText = "Your password has been emailed to you.";
			WebElement actual = this.finalText;
			String actualText = actual.getText();
			assertEquals(actualText, expectedText);
		}

}

