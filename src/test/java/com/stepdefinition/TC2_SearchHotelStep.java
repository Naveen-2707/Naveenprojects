package com.stepdefinition;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC2_SearchHotelStep extends BaseClass {
	
	PageObjectManager pom = new PageObjectManager();
	
	@When("User should search hotel {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void user_should_search_hotel_and(String location, String hotels, String roomType, String noOfRoom, String checkInDate, String checkOutDate, String adultsPerRoom, String childPerRoom) throws IOException {
		 pom.getSearchHotelPage().searchHotels(location, hotels, roomType, noOfRoom, checkInDate, checkOutDate, adultsPerRoom, childPerRoom);
	}
	@Then("User should verify after click search success message {string}")
	public void user_should_verify_after_click_search_success_message(String expSearchSuccessMessage) {
		Assert.assertEquals("verify after click search success message", expSearchSuccessMessage, pom.getSelectHotelPage(). getsearchSuccessMessage().getText());           
		}
	@When("User should enter only mandatory fields {string},{string},{string},{string} and {string}")
	public void user_should_enter_only_mandatory_fields_and(String location, String noOfRoom, String checkInDate, String checkOutDate, String adultsPerRoom) {
		 pom.getSearchHotelPage().searchHotels(location, noOfRoom, checkInDate, checkOutDate, adultsPerRoom);
	  
	}
	@Then("User should verify after clicking search button date  error message {string} , {string}")
	public void user_should_verify_after_clicking_search_button_date_error_message(String expCheckInDateErrorMsg, String expCheckOutDateErrorMsg) {
		Assert.assertEquals("verify after clicking search button invalid checkin", expCheckInDateErrorMsg, pom.getSearchHotelPage().getCheckInDateErrorMessage().getText());
		Assert.assertEquals("verify after clicking search button invalid checkout", expCheckOutDateErrorMsg, pom.getSearchHotelPage().getCheckOutDateErrorMessage().getText());
	}
	@When("User should not enter any fields")
	public void user_should_not_enter_any_fields() {
		pom.getSearchHotelPage().searchButton();
	  
	}
	@Then("User should verify after click search error message {string}")
	public void user_should_verify_after_click_search_error_message(String expSearchErrorMessage) {
		 WebElement actSearchErrorMsg = pom.getSearchHotelPage().getSearchErrorMessage();
		 String actSearchErrorMessage = getText( actSearchErrorMsg);
		 boolean contains = actSearchErrorMessage.contains(expSearchErrorMessage);
		Assert.assertTrue("verify after click search error message ",contains);
		
	   
	}

}












	


	
	


	    
	





















