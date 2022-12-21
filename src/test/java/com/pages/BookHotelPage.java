package com.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

import io.cucumber.datatable.DataTable;

public class BookHotelPage extends BaseClass {
	
	 public BookHotelPage() {
		 PageFactory.initElements(driver, this);
		 }
	 
        @FindBy(id="first_name")
		private WebElement firstName;
		
		@FindBy(id="last_name")
		private WebElement  lastName;                     
		
		@FindBy(id="address")
		private WebElement billingAddress;
		
		@FindBy(id="cc_num")
		private WebElement cardNum;
		
        @FindBy(id="cc_type")
		private WebElement cardType;
		
		@FindBy(id="cc_exp_month")
		private WebElement  cardMonth;
		
		@FindBy(id="cc_exp_year")
		private WebElement cardYear;
		
		@FindBy(id="cc_cvv")
		private WebElement cvvNum;
		
	

		@FindBy(id="book_now")
		private WebElement bookNow;
		
		@FindBy(xpath="//td[text()='Book A Hotel ']")
		 private WebElement successMsg;
		
		@FindBy(xpath="//td[text()='Booking Confirmation ']")
		 private WebElement bookingConfirmsuccessMsg;
		
	    @FindBy(id="first_name_span")
		private WebElement  firstNameErrorMessage;
			
		@FindBy(id="last_name_span")
			private WebElement  lastNameErrorMessage;
			
		@FindBy(id="address_span")
			private WebElement  addressErrorMessage;
			
		@FindBy(id="cc_num_span")
			private WebElement  cardNumberErrorMessage;
			
		@FindBy(id="cc_type_span")
			private WebElement  cardTypeErrorMessage;
			
		@FindBy(id="cc_expiry_span")
			private WebElement  cardMonthErrorMessage;
			
		@FindBy(id="cc_cvv_span")
			private WebElement  cardCvvErrorMessage;
		
		

		public WebElement getFirstName() {
			return firstName;
		}

		public WebElement getLastName() {
			return lastName;
		}

		public WebElement getBillingAddress() {
			return billingAddress;
		}

		public WebElement getCardNo() {
			return cardNum;
		}

		public WebElement getCardType() {
			return cardType;
		}

		public WebElement getMonth() {
			return cardMonth;
		}

		public WebElement getYear() {
			return cardYear;
		}

		public WebElement getCvv() {
			return cvvNum;
		}
		
		public WebElement getBookNow() {
			return bookNow;
		}
		
		
		public WebElement getSuccessMsg() {
			return successMsg;
		}
		
		public WebElement bookingConfirmsuccessMsg() {
			return bookingConfirmsuccessMsg;
		}

		public WebElement firstNameErrorMessage() {
			return firstNameErrorMessage;
		}

		public WebElement lastNameErrorMessage() {
			return lastNameErrorMessage;
		}

		public WebElement addressErrorMessage() {
			return addressErrorMessage;
		}

		public WebElement cardNumberErrorMessage() {
			return cardNumberErrorMessage;
		}

		public WebElement cardTypeErrorMessage() {
			return cardTypeErrorMessage;
		}

		public WebElement cardMonthErrorMessage() {
			return cardMonthErrorMessage;
		}

		public WebElement cardCvvErrorMessage() {
			return cardCvvErrorMessage;
		}
		
		public void bookHotel(String firstName,String lastName,String billingAddress,DataTable dataTable) {
			sendvalues(getFirstName(), firstName);
			sendvalues(getLastName(), lastName);
			sendvalues(getBillingAddress(), billingAddress);
			
			
			List<Map<String,String>> maps = dataTable.asMaps();
			Map<String, String> map = maps.get(1);
			String cardNum = map.get("cardNum");
			String cardType = map.get("cardType");
			String cardMonth = map.get("cardMonth");
			String cardYear = map.get("cardYear");
			String cvvNum = map.get("cvvNum");
			
			sendvalues(getCardNo(), cardNum);
			sendvalues(getCardType(), cardType);
			sendvalues(getMonth(), cardMonth);
			sendvalues(getYear(), cardYear);
			sendvalues(getCvv(), cvvNum);
			
			
			click(getBookNow());
			
		}
		
		public void bookHotel() {
			click(getBookNow());

		}
			
   }
