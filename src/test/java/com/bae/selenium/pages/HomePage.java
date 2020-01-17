package com.bae.selenium.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties.Lettuce;


public class HomePage extends Page {

	public static final String URL = "http://3.9.36.142:8181/KayakProject/index.html";
		
		//this will be useful for testing own front-end of project, it may be slower and more bulky to create a class for each page, but it is more readable.
		//on this note, a class MUST be created for each page being used.
		
		
		
		@FindBy(id = "newCustFirstName")
		private WebElement custFirstNameField;
		
		@FindBy(id = "newCustSurname")
		private WebElement custSurnameField;
		
		@FindBy(id = "newEmergFirstName")
		private WebElement emergFirstNameField;
		
		@FindBy(id = "newEmergSurname")
		private WebElement emergSurnameField;
		
		@FindBy(id = "newEmergContactNumber")
		private WebElement emergContactNumberField;
		
		@FindBy(id = "newEmergRelation")
		private WebElement emergRelationField;
		
		@FindBy(id = "add-button")
		private WebElement addCustButton;

		@FindBy(id = "capacity")
		private WebElement capacity;
		
		@FindBy(id = "safety-circle")
		private WebElement safetyCircle;
		
		@FindBy(id = "remove-select")
		private WebElement removeOne;
		
		@FindBy(id = "remove-all")
		private WebElement removeAll;
	
		
		
		public HomePage(WebDriver driver) {
			super(driver);
			PageFactory.initElements(driver, this);
		}
		
		public void createCustomer(List<String> custInfo) {
			custFirstNameField.sendKeys(custInfo.get(0));
			custSurnameField.sendKeys(custInfo.get(1));
			emergFirstNameField.sendKeys(custInfo.get(2));
			emergSurnameField.sendKeys(custInfo.get(3));
			emergContactNumberField.sendKeys(custInfo.get(4));
			emergRelationField.sendKeys(custInfo.get(5));
			addCustButton.click();
		}
		
		public void deleteOneCustomer() {
			removeOne.click();
		}
		
		public void deleteAllCustomers() {
			removeAll.click();
		}
		
		public WebElement getCapacity() {
			return capacity;
		}

		public void createTenCustomers(List<String> custInfo) throws InterruptedException {
			for	(int i = 0; i < 10; i++) {
				createCustomer(custInfo);
				Thread.sleep(500);
				alertOK();
			}
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
