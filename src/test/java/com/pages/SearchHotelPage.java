package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class SearchHotelPage extends BaseClass {

	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "location")
	private WebElement location;

	@FindBy(id = "hotels")
	private WebElement hotels;

	@FindBy(id = "room_type")
	private WebElement roomType;

	@FindBy(id = "room_nos")
	private WebElement noOfRoom;

	@FindBy(id = "datepick_in")
	private WebElement checkInDate;

	@FindBy(id = "datepick_out")
	private WebElement checkOutDate;

	@FindBy(id = "adult_room")
	private WebElement adultsPerRoom;

	@FindBy(id = "child_room")
	private WebElement childPerRoom;

	@FindBy(id = "Submit")
	private WebElement search;

	@FindBy(id = "username_show")
	private WebElement searchSuccessMessage;

	@FindBy(id = "checkin_span")
	private WebElement checkInDateErrorMessage;

	@FindBy(id = "checkout_span")
	private WebElement checkOutDateErrorMessage;

	@FindBy(id = "location_span")
	private WebElement searchErrorMessage;

	public WebElement getLocation() {
		return location;
	}

	public WebElement getHotels() {
		return hotels;
	}

	public WebElement getRoomType() {
		return roomType;
	}

	public WebElement getNoOfRoom() {
		return noOfRoom;
	}

	public WebElement getCheckInDate() {
		return checkInDate;
	}

	public WebElement getCheckOutDate() {
		return checkOutDate;
	}

	public WebElement getAdultsPerRoom() {
		return adultsPerRoom;
	}

	public WebElement getChildPerRoom() {
		return childPerRoom;
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getSearchSuccessMessage() {
		return searchSuccessMessage;
	}

	public WebElement getCheckInDateErrorMessage() {
		return checkInDateErrorMessage;
	}

	public WebElement getCheckOutDateErrorMessage() {
		return checkOutDateErrorMessage;
	}

	public WebElement getSearchErrorMessage() {
		return searchErrorMessage;
	}

	// common
	public void searchHotelsCommonSteps(String location, String noOfRoom, String checkInDate, String checkOutDate,
			String adultsPerRoom) {
		selectByVisibleText(getLocation(), location);
		selectByVisibleText(getNoOfRoom(), noOfRoom);
		clear(getCheckInDate());
		sendvalues(getCheckInDate(), checkInDate);
		clear(getCheckOutDate());
		sendvalues(getCheckOutDate(), checkOutDate);
		selectByVisibleText(getAdultsPerRoom(), adultsPerRoom);
	}

	public void searchHotels(String location, String hotels, String roomType, String noOfRoom, String checkInDate,
			String checkOutDate, String adultsPerRoom, String childPerRoom) {

		searchHotelsCommonSteps(location, noOfRoom, checkInDate, checkOutDate, adultsPerRoom);
		selectByVisibleText(getHotels(), hotels);
		selectByVisibleText(getRoomType(), roomType);
		selectByVisibleText(getChildPerRoom(), childPerRoom);
		searchButton();

	}

	// mandatory
	public void searchHotels(String location, String noOfRoom, String checkInDate, String checkOutDate,
			String adultsPerRoom) {
		searchHotelsCommonSteps(location, noOfRoom, checkInDate, checkOutDate, adultsPerRoom);
		searchButton();
	}

	public void searchHotels() {
		searchButton();

	}

	public void searchButton() {
		click(getSearch());

	}

}
