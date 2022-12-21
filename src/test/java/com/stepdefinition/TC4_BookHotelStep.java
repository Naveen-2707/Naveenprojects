package com.stepdefinition;

import org.junit.Assert;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC4_BookHotelStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	@When("User should book hotel {string},{string} and {string}")
	public void user_should_book_hotel_and(String firstName, String lastName, String billingAddress,
			io.cucumber.datatable.DataTable dataTable) {
		pom.getBookHotelPage().bookHotel(firstName, lastName, billingAddress, dataTable);
	}

	@Then("User should verify after booking hotel success message {string} and save the generated order Id")
	public void user_should_verify_after_booking_hotel_success_message_and_save_the_generated_order_id(
			String bookHotelSuccessMessage) throws InterruptedException {
		impliciWait();
        Assert.assertEquals("verify after booking hotel success message", bookHotelSuccessMessage,
				pom.getBookHotelPage().bookingConfirmsuccessMsg().getText());
		
	}

	@When("User should click book now button without entering any details")
	public void user_should_click_book_now_button_without_entering_any_details() {
		pom.getBookHotelPage().bookHotel();
	}

	@Then("User should verify after clicking book now button error message {string},{string},{string},{string},{string},{string} and {string}")
	public void user_should_verify_after_clicking_book_now_button_error_message_and(String firstNameErrorMessage,
			String lastNameErrorMessage, String addressErrorMessage, String cardNumberErrorMessage,
			String cardTypeErrorMessage, String cardMonthErrorMessage, String cardCvvErrorMessage) {

		org.junit.Assert.assertEquals(" verify after clicking book now button firstNameErrorMessage",
				firstNameErrorMessage, pom.getBookHotelPage().firstNameErrorMessage().getText());
		org.junit.Assert.assertEquals(" verify after clicking book now button lastNameErrorMessage",
				lastNameErrorMessage, pom.getBookHotelPage().lastNameErrorMessage().getText());
		org.junit.Assert.assertEquals(" verify after clicking book now button addressErrorMessage", addressErrorMessage,
				pom.getBookHotelPage().addressErrorMessage().getText());
		org.junit.Assert.assertEquals(" verify after clicking book now button cardNumberErrorMessage",
				cardNumberErrorMessage, pom.getBookHotelPage().cardNumberErrorMessage().getText());
		org.junit.Assert.assertEquals(" verify after clicking book now button cardTypeErrorMessage",
				cardTypeErrorMessage, pom.getBookHotelPage().cardTypeErrorMessage().getText());
		org.junit.Assert.assertEquals(" verify after clicking book now button cardMonthErrorMessage",
				cardMonthErrorMessage, pom.getBookHotelPage().cardMonthErrorMessage().getText());
		org.junit.Assert.assertEquals(" verify after clicking book now button cardCvvErrorMessage", cardCvvErrorMessage,
				pom.getBookHotelPage().cardCvvErrorMessage().getText());

	}

}
