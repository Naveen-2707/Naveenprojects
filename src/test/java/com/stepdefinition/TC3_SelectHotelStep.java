package com.stepdefinition;


import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC3_SelectHotelStep extends BaseClass {
	
	PageObjectManager pom = new PageObjectManager();
	
	@When("User should select a option then click continue button")
	public void user_should_select_a_option_then_click_continue_button() {
		
		pom.getSelectHotelPage().selectHotel();
	 
	}
	@Then("User should verify after clicking continue success message {string}")
	public void user_should_verify_after_clicking_continue_success_message(String selectHotelSuccessMessage) {
	  
	org.junit.Assert.assertEquals("verify after clicking continue success message", selectHotelSuccessMessage, pom.getBookHotelPage().getSuccessMsg().getText());
	}
	@When("User should click continue button without selecting any option")
	public void user_should_click_continue_button_without_selecting_any_option() {
	 
		pom.getSelectHotelPage().clickContinue();
	}
	@Then("User should verify after clicking continue error message {string}")
	public void user_should_verify_after_clicking_continue_error_message(String selectHotelErrorMessage) {
	  
	org.junit.Assert.assertEquals("verify after clicking continue error message", selectHotelErrorMessage, pom.getSelectHotelPage().getErrorMsg().getText());
	}





	
	






	
	
	

	
	}





