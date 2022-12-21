package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class CancelBookingPage  extends BaseClass {
	
	 public CancelBookingPage() {
		 PageFactory.initElements(driver, this);
		 }

        @FindBy(xpath="//a[text()='Booked Itinerary']")
		private WebElement clickBooked;
        
    	@FindBy(id="order_id_text")
		private WebElement searchOrderId;
    	
    	@FindBy(id="search_hotel_id")
		private WebElement btnGo;
		
		@FindBy(xpath="//input[@type='button']")
		private WebElement btnCancel;
		
		@FindBy(id="search_result_error")
		private WebElement bookingCanceledMsg;
		
	
		
		public WebElement getClickBooked() {
			return clickBooked;
		}

		public WebElement getSearchOrderId() {
			return searchOrderId;
		}
		
		public WebElement getBtnGo() {
			return btnGo;
		}

		public WebElement getBtnCancel() {
			return btnCancel;
		}

		public WebElement getbookingCanceledMsg() {
			return bookingCanceledMsg;
		}

		
		
		public void cancelOrderId(String orderId) {
			click(getClickBooked());
			sendvalues(getSearchOrderId(), orderId);
			click(getBtnGo());
			click(getBtnCancel());
			ActionsMouseOverAccept();
			
		}

		

}
