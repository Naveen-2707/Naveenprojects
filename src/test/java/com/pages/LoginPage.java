package com.pages;

import java.awt.AWTException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class LoginPage extends BaseClass {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="username")
	private WebElement username;
	
	@FindBy(id="password")
	private WebElement  password;
	
	@FindBy(id="login")
	private WebElement login;
	

	
	@FindBy(xpath="//b[text()='Invalid Login details or Your Password might have expired. ']")
	private WebElement errorMsg;
	
	public WebElement getUsername() {
		return username;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getLogin() {
		return login;
	}
	
	public WebElement getErrorMsg() {
		return errorMsg;
	}
	
	//Common
	public void commonLoginStep(String username,String Password) {
		sendvalues(getUsername(), username);
		sendvalues(getPassword(), Password);

		
	}
	//valid and invalid login
	public void login(String username,String Password) {
		commonLoginStep(username, Password);
		click(getLogin());
	}
	//login with enter key
	public void loginWithEnterKey(String username,String Password) throws AWTException {
		commonLoginStep(username, Password);
		tab();
		tab();
		enter();
		}
	}

