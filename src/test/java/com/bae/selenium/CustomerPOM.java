package com.bae.selenium;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.selenium.pages.HomePage;
import com.bae.selenium.pages.RentPage;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CustomerPOM {

	
	@LocalServerPort
	private int port;
	private WebDriver driver;

	private List<String> custInfo = new ArrayList<>();
	
	private HomePage homePage = new HomePage(driver);
	private RentPage rentPage = new RentPage(driver);
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		ChromeOptions options = new ChromeOptions();
//		options.setHeadless(true);
		this.driver = new ChromeDriver(options);
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.homePage = new HomePage(driver);
		this.rentPage = new RentPage(driver);
		custInfo.add("Bill");
		custInfo.add("Smith");
		custInfo.add("Sarah");
		custInfo.add("Johnson");
		custInfo.add("07766123456");
		custInfo.add("Friend");
	}

	@After
	public void teardown() {
		driver.quit();
	}

	@Test
	public void seleniumTest() throws InterruptedException {
//		driver.manage().window().maximize();
		this.driver.get("http://3.9.36.142:8181/KayakProject/index.html");
		
	
		
		homePage.createCustomer(custInfo);
		Thread.sleep(2000);
		assertEquals("Customer created.", homePage.readAlertText());
		homePage.alertOK();
		Thread.sleep(2000);
		assertEquals("1/300",  homePage.getCapacity());
		homePage.moveToRentPage();
		
		Thread.sleep(1000);
		rentPage.searchCustomer("Smith");
		rentPage.selectCustomer();
		rentPage.pickAllEquipment();
		assertEquals("Total Price: £125.00", rentPage.getTotalPrice());
		rentPage.saveEquipment();
		Thread.sleep(2000);
		assertEquals("Customer Bill Smith's equipment saved.", rentPage.readAlertText());
		rentPage.alertOK();
		assertEquals("19", rentPage.getKayakStock());
		assertEquals("19", rentPage.getBAStock());
		assertEquals("19", rentPage.getHelmetStock());
		assertEquals("19", rentPage.getPaddleStock());
		rentPage.moveToHomePage();
		
		Thread.sleep(1000);
		homePage.searchCustomer("Smith");
		homePage.selectCustomer();
		homePage.deleteOneCustomer();
		Thread.sleep(2000);
		homePage.alertOK();
		Thread.sleep(500);
		assertEquals("Customer deleted.", homePage.readAlertText());
		homePage.alertOK();
		homePage.createTenCustomers(custInfo);
		homePage.deleteAllCustomers();
		homePage.alertOK();
		Thread.sleep(500);
		assertEquals("All customers deleted.", homePage.readAlertText());
		homePage.alertOK();
		assertEquals("rgba(0, 255, 0, 1)", homePage.getSafetyCircleColour());
		homePage.create150Customers(custInfo);
		homePage.createCustomer(custInfo);
		Thread.sleep(1000);
		homePage.alertOK();
		Thread.sleep(1000);
		assertEquals("rgba(255, 165, 0, 1)", homePage.getSafetyCircleColour());
		homePage.create100Customers(custInfo);
		Thread.sleep(1000);
		assertEquals("rgba(255, 0, 0, 1)", homePage.getSafetyCircleColour());
		homePage.deleteAllCustomers();
		homePage.alertOK();
	}

}
	

