package com.training.pom;
                  
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPOM {
	private WebDriver driver; 
	
	public RegisterPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"login_block\"]/div/ul/li[1]/a")
	private WebElement Signup; 
	
	@FindBy(id="registration_firstname")
	private WebElement firstname;
	
	@FindBy(id="registration_lastname")
	private WebElement lastname;
	
	@FindBy(id="registration_email")
	private WebElement email;
	
	@FindBy(id="username")
	private WebElement username;
	
	@FindBy(id="pass1")
	private WebElement pass1;
	
	@FindBy(id="pass2")
	private WebElement pass2;
	
	@FindBy(id="registration_phone")
	private WebElement phone;
	
	@FindBy(xpath="//*[@id=\"registration\"]/fieldset/div[10]/div[1]/div/button/span[1]")
	private WebElement Language;
	
	@FindBy(xpath="//*[@id=\"registration\"]/fieldset/div[11]/div[1]/div/label")
	private WebElement Porfile;
	
	@FindBy(id="registration_submit")
	private WebElement submit;
    	
	//Below methods are used to send information in all the required fields in the registration page
	public void sendfirstname(String firstname) {
	this.firstname.clear();
	this.firstname.sendKeys(firstname);
	}
	
	public void sendlastname(String lastname) {
	this.lastname.clear();
	this.lastname.sendKeys(lastname);
	}
	
	public void sendemail(String email) {
	this.email.clear();
	this.email.sendKeys(email);
	
}
	public void sendusername(String username) {
	this.username.clear();
	this.username.sendKeys(username);
	}	
	public void sendpass1(String pass1) {
	this.pass1.clear();
	this.pass1.sendKeys(pass1);
	}
	public void sendpass2(String pass2) {
	this.pass2.clear();
	this.pass2.sendKeys(pass2);
	}
	public void sendphone(String phone) {
	this.phone.clear();
	this.phone.sendKeys(phone);
    }
	
	public void clicksubmit() {
	this.submit.click();
	}
	
	public void clicksignup() {
	this.Signup.click();	
		
	}
}
