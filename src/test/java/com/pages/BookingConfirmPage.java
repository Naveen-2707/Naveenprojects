package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class BookingConfirmPage  extends BaseClass {
	
	 public BookingConfirmPage() {
		 PageFactory.initElements(driver, this);
		 }
	 @FindBy(id="order_no")
	 private WebElement orderId;
	 
	  @FindBy(xpath="//td[@class='login_title']")
		private WebElement successMsg;

	public WebElement getOrderId() {
		return orderId;
	}
	
	public WebElement getSuccessMsg() {
		return successMsg;
	}

	
	public String orderId() {
		String attributes = getAttributes(getOrderId());
		return attributes;

	}

}
