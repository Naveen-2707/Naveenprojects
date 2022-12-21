package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class SelectHotelPage extends BaseClass {

	public SelectHotelPage() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(id="radiobutton_0")
	private WebElement radioButton;

	@FindBy(id="continue")
	private WebElement continueButton;

	@FindBy(xpath="//td[text()='Select Hotel ']")
	private WebElement searchSuccessMessage;

	@FindBy(id="radiobutton_span")
	private WebElement errorMsg;

	public WebElement getRadioButton() {
		return radioButton;
	}

	public WebElement getContinueButton() {
		return continueButton;
	}

	public WebElement getsearchSuccessMessage() {
		return searchSuccessMessage;
	}

	public WebElement getErrorMsg() {
		return errorMsg;
	}

	public void selectHotel() {

		click(getRadioButton());
		click(getContinueButton());

	}

	public void clickContinue() {

		click(getContinueButton());

	}


















}