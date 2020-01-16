package com.bae.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page {
	
	private WebDriver driver;
	
	@FindBy(className = "home-link")
	private WebElement homeLink;
	
	@FindBy(id = "rent-link")
	private WebElement rentLink;
	
	@FindBy(className = "custFirstName")
	private WebElement custFirstNameTableCell;
	
	@FindBy(className = "custSurname")
	private WebElement custSurnameTableCell;
	
	@FindBy(className = "emergFirstName")
	private WebElement emergFirstNameTableCell;
	
	@FindBy(className = "emergSurname")
	private WebElement emergSurnameTableCell;
	
	@FindBy(className = "emergContactNumber")
	private WebElement emergContactNumberTableCell;
	
	@FindBy(className = "emergRelation")
	private WebElement emergRelationTableCell;
	
	@FindBy(className = "search-box")
	private WebElement searchBox;
	
	public Page(WebDriver driver) {
		this.setDriver(driver);
		PageFactory.initElements(driver, this);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	public void moveToRentPage() {
		rentLink.click();
	}
	
	public void moveToHomePage() {
		homeLink.click();
	}
	
	public void alertOK() {
		getDriver().switchTo().alert().accept();
	}
	
	public String readAlertText() {
		return getDriver().switchTo().alert().getText();
	}
		
	public void selectCustomer() {
		custFirstNameTableCell.click();
	}
	
	public void searchCustomer(String surname) {
		searchBox.sendKeys(surname);
	}
	
	
	
}
