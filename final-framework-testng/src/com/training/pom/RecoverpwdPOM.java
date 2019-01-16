package com.training.pom;
                  
import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecoverpwdPOM {
	private WebDriver driver; 
	public RecoverpwdPOM(WebDriver driver) {
	this.driver = driver; 
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='http://elearning.hommelle.com/main/auth/lostPassword.php'][text()=' I lost my password ']")       
	private WebElement Ilostmypassword; 
	
	@FindBy(id="lost_password_user")
	private WebElement Ilostpassworduser;
	
	@FindBy(id="lost_password_submit")
	private WebElement usernamesubmit;
	
//	@FindBy(linkText = "https://gmail.com")
//	private WebElement linkText;
//	
//	//@FindBy(xpath="//*[@id=\"view_container\"]/form/div[2]/div/div/div/ul[1]/li[1]/div/div[2]/p[2]")
//	//private WebElement dataemail;
//	
//	@FindBy(id="identifierId")
//	private WebElement clickGmailID;	
//	
//	@FindBy(id="identifierNext")
//	private WebElement clickGmailnext;
//	
//	@FindBy(id="password")
//	private WebElement clickGmailPassword;
//	
//	@FindBy(id="passworNext")
//	private WebElement clickGmailPasswordNext;
//	
		
	@FindBy(id="login")
	private WebElement login;
	
	@FindBy(id="password")
	private WebElement password1;
	
	@FindBy(id="formLogin_submitAuth")
	private WebElement Login;
	
		
	////Below methods are used to send information in all the required fields in the recover password field as well as re-enteringthe new pwd		
	public void clickIlostmypassword() {
		System.out.println(Ilostmypassword);
	this.Ilostmypassword.click();
	}
	public void sendIlostpassworduser(String user) {
	this.Ilostpassworduser.clear();
	this.Ilostpassworduser.sendKeys(user);
	}
	
	public void clickusernamesubmit(String usernamesubmit) {
	this.usernamesubmit.click();
	}                      
	
	//public void linkText1(String linkText) {
		//this.linkText.click();
		//}  
	
//	public void sendGmailID(String sendemailid) {
//		this.clickGmailID.sendKeys();
//		}  
//	
//	public void clickGmailNext() {
//		this.clickGmailnext.click();
//		}  
//	
//	public void sendGmailPassword(String password) {
//		this.clickGmailPassword.sendKeys();
//		}  
//	
//	public void clickGmailPasswordNext(String next) {
//		this.clickGmailPasswordNext.click();
//		}  
	
	
	
//	public void clickformLogin_submitAuth(String Login) {
//		this.Login.click();
//		} 
//	
	public void sendlogin(String login) {
	this.login.clear();
	this.login.sendKeys(login);
	}
	public void sendpassword(String password)  {
	this.password1.sendKeys();	
	}
	
	public void clickformLogin_submitAuth1() {
		this.Login.click();
		}
		
	
	
	
	
}
	
	
		
		

	

