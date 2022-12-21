package com.stepdefinition;

import org.openqa.selenium.WebElement;


import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.*;

public class TC5_CancelBookingStep extends BaseClass{
	
	PageObjectManager pom = new PageObjectManager();
	
    @When("User should cancel the generated order Id")
	public void user_should_cancel_the_generated_order_id() {
    	WebElement orderId = pom.getBookingConfirmPage().getOrderId();
    	pom.getCancelBookingPage().cancelOrderId(getAttributes(orderId));
	   
	}
	@Then("User should verify after cancelling order Id success message {string}")
	public void user_should_verify_after_cancelling_order_id_success_message(String cancelingBookedId) {
		org.junit.Assert.assertEquals("verify after cancelling order Id success message",cancelingBookedId ,pom.getCancelBookingPage().getbookingCanceledMsg().getText());
	  
	}
	@When("User should cancel the existing order Id {string}")
	public void user_should_cancel_the_existing_order_id(String cancelExistingId) {
	pom.getCancelBookingPage().cancelOrderId(cancelExistingId);
		
		//pom.getCancelBookingPage().cancelOrderId(cancelExistingId);
	  
	}
	





	
	





	







}
