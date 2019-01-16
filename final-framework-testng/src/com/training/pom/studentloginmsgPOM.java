package com.training.pom;
                  
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class studentloginmsgPOM {
	private WebDriver driver; 
	
	public studentloginmsgPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//@FindBy(xpath="//*[@id=\"login_block\"]/div/ul/li[1]/a")
	//private WebElement Signup; 
	
	@FindBy(id="login")
	private WebElement username;
	
	@FindBy(id="password")
	private WebElement password;
	
		
	@FindBy(id="formLogin_submitAuth")
	private WebElement submit;
	
    
	//Below methods are used to send information in all the required fields in the as a student login)
	public void sendusername(String username) {
	this.username.clear();
	this.username.sendKeys(username);
	}
	public void sendpassword(String password) {
	this.password.clear();
	this.password.sendKeys(password);
	}
	
	public void clicksubmit() {
	this.submit.click();
	
	}
	
	
}