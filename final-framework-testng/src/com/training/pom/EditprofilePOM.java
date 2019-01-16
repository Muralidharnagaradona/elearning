package com.training.pom;
                  
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditprofilePOM {
	private WebDriver driver; 
	
	public EditprofilePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="login")
	private WebElement username;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(xpath="//*[@id=\"formLogin_submitAuth\"]")
	private WebElement Login;
	
	@FindBy(xpath="//*[@id=\"profile_block\"]/div[1]/h4")
	private WebElement profileblock;
	
	@FindBy(xpath="//*[@id=\"profileCollapse\"]/div/ul/li[4]/a")
	private WebElement Editprofile;
	
	@FindBy(id="password1")
	private WebElement password1;
	
	@FindBy(id="profile_password2")
	private WebElement profile_password2;
	
	@FindBy(id="profile_apply_change")
	private WebElement apply_change;
	   	
  //Below methods are used to send information in all the required fields in Edit profile page 
	public void sendusername(String username) {
	this.username.clear();
	this.username.sendKeys(username);
	}
	public void sendpassword(String password) {
	this.password.clear();
	this.password.sendKeys(password);
	}
	
	public void clicksubmit_Auth() {
	this.Login.click();
	}
	public void clickprofile_block() {
	this.profileblock.click();	
	
	}
	
	public void clickEditprofile() {
	this.Editprofile.click();	
	}
	
	public void sendpassword1(String password1) {
	this.password1.clear();
	this.password1.sendKeys(password1);
	}
 
	public void sendprofile_password2(String profile_password2) {
	this.profile_password2.clear();
	this.profile_password2.sendKeys(profile_password2);
	}
	public void sendapply_change() {
	this.apply_change.click();
	
	}
		
}