package com.stepdefinition;

import java.awt.AWTException;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.*;

public class TC1_LoginStep extends BaseClass{

	PageObjectManager pom = new PageObjectManager();

	@Given("User is on the adactin page")
	public void user_is_on_the_adactin_page() throws IOException {
		browser(getPropertyFileValue("url"));
		maximize();

	}
	@When("user should login {string},{string}")
	public void user_should_login(String userName, String password) {
		pom.getLoginpage().login(userName, password);


	}
	@When("user should login {string},{string} with Enter key")
	public void user_should_login_with_enter_key(String userName, String password) throws AWTException {
		pom.getLoginpage().loginWithEnterKey(userName, password);

	}
	@Then("User should verify after login with invalid credentials error message contains {string}")
	public void user_should_verify_after_login_with_invalid_credentials_error_message_contains(String expLoginErrorMessage) {
		WebElement actErrorMsg = pom.getLoginpage().getErrorMsg();
		String elementGetText = elementGetText(actErrorMsg);
		boolean b = elementGetText.contains(expLoginErrorMessage);
		Assert.assertTrue("User should verify after login with invalid credentials error message contains" , b);

	}









}
