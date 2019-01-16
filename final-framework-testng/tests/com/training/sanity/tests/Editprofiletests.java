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
import com.training.pom.EditprofilePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Editprofiletests {
    //RegisterPOM = new RegisterPOM();
	private WebDriver driver;
	private String baseUrl;
	private EditprofilePOM editprofilePOM; 
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
		editprofilePOM = new EditprofilePOM(driver); 
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
	public void validEditprofiletests() {
		
		editprofilePOM.sendusername("test1");
		editprofilePOM.sendpassword("nB2w5oVE");
		editprofilePOM.clicksubmit_Auth(); 
		editprofilePOM.clickprofile_block();
		editprofilePOM.clickEditprofile();
		editprofilePOM.sendpassword1("tesst12345");
		editprofilePOM.sendprofile_password2("test12345");
		editprofilePOM.sendapply_change();
		//screenShot.captureScreenShot("First");
	}
	 @FindBy(xpath="//*[@id=\"content-section\"]/div/div[2]/div/div[1]") 
		private WebElement finalText;
	 

	//The below assert is used to verify the state of the application is same to what we are expecting.
	//When assert fails, then the test is aborted and will not continue further.
	 public void checkCourse() {
			String expectedText = "Your new profile has been saved";
			WebElement actual = this.finalText;
			String actualText = actual.getText();
			assertEquals(actualText, expectedText);
		}
}
