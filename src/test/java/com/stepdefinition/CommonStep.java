package com.stepdefinition;

import org.openqa.selenium.WebElement;


import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;

public class CommonStep extends BaseClass {
	
	PageObjectManager pom = new PageObjectManager();
	
	@Then("User should verify after login success message {string}")
	public void user_should_verify_after_login_success_message(String expLoginSuccessMessage) {
		
		WebElement actLoginSuccessMessage =pom.getSearchHotelPage().getSearchSuccessMessage();
	    String loginSuccess = getAttributes(actLoginSuccessMessage);
	   org.junit.Assert.assertEquals("verify after login success message", expLoginSuccessMessage,loginSuccess);
		
		
	}

}
