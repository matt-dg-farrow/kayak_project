package com.bae.selenium.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bae.persistence.domain.Customer;

public class RentPage extends Page {

	public static final String URL = "http://3.9.36.142:8181/KayakProject/rent.html";
		
		//this will be useful for testing own front-end of project, it may be slower and more bulky to create a class for each page, but it is more readable.
		//on this note, a class MUST be created for each page being used.
		
		@FindBy(id="kayak")
		private WebElement kayakCheckBox;
		
		@FindBy(id="BA")
		private WebElement BACheckBox;
		
		@FindBy(id="helmet")
		private WebElement helmetCheckBox;
		
		@FindBy(id="paddle")
		private WebElement paddleCheckBox;
		
		@FindBy(id = "save-button")
		private WebElement saveButton;
		
		@FindBy(id = "total-price")
		private WebElement totalPrice;

		@FindBy(id="kayak-stock")
		private WebElement kayakStock;
		
		@FindBy(id="BA-stock")
		private WebElement BAStock;
		
		@FindBy(id="helmet-stock")
		private WebElement helmetStock;
		
		@FindBy(id="paddle-stock")
		private WebElement paddleStock;
		
		
		
		public RentPage(WebDriver driver) {
			super(driver);
			PageFactory.initElements(driver, this);
		}
		
		public WebElement getTotalPrice() {
			return totalPrice;
		}

		public WebElement getKayakStock() {
			return kayakStock;
		}

		public WebElement getBAStock() {
			return BAStock;
		}

		public WebElement getHelmetStock() {
			return helmetStock;
		}

		public WebElement getPaddleStock() {
			return paddleStock;
		}
		
		public void pickAllEquipment() {
			kayakCheckBox.click();
			BACheckBox.click();
			helmetCheckBox.click();
			paddleCheckBox.click();
		}
		
		public void saveEquipment() {
			saveButton.click();
		}
		
		
		
		
		
		
//		public void search(String searchText) {
//			searchbar.sendKeys(searchText);
//			searchbar.submit();
//		}
//		
//		public void pickDress() {
//			dressImage.click();
//		}
//		
//		public void addToCart() {
//			cartButton.click();
//		}
//		
//		public void checkout() {
//			checkoutButton.click();
//		}


}
