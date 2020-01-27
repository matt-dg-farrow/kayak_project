//package com.bae.selenium;
//
//import static org.junit.Assert.assertEquals;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.bae.selenium.pages.HomePage;
//import com.bae.selenium.pages.RentPage;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
//public class SeleniumTest {
//
//	
//	@LocalServerPort
//	private int port;
//	
//	@Value("${server.servlet.context-path}")
//	private String context;
//	
//	private WebDriver driver;
//
//	private List<String> custInfo = new ArrayList<>();
//	
//	private HomePage homePage = new HomePage(driver);
//	private RentPage rentPage = new RentPage(driver);
//	
//	@Before
//	public void setup() {
//		System.setProperty("webdriver.chrome.driver", "chromedriver");
//		ChromeOptions options = new ChromeOptions();
//		options.setHeadless(true);
//		this.driver = new ChromeDriver(options);
//		this.driver.manage().window().maximize();
//		this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		this.homePage = new HomePage(driver);
//		this.rentPage = new RentPage(driver);
//		custInfo.add("Bill");
//		custInfo.add("Smith");
//		custInfo.add("Sarah");
//		custInfo.add("Johnson");
//		custInfo.add("07766123456");
//		custInfo.add("Friend");
//	}
//
//	@After
//	public void teardown() {
//		driver.quit();
//	}
//	
//	private String address = "localhost";
////			"3.9.36.142";
//
//	@Test
//	public void seleniumTest() throws InterruptedException {
//		this.driver.get("http://localhost:"+ port + context);
//		
//		WebDriverWait wait = new WebDriverWait(driver,30);
//
//		
//		homePage.createCustomer(custInfo);
//		wait.until(ExpectedConditions.alertIsPresent());
//		assertEquals("Customer created.", homePage.readAlertText());
//		homePage.alertOK();
//		
//		
//		wait.until(ExpectedConditions.textToBe(By.id("capacity"), "1/300"));
//		assertEquals("1/300",  homePage.getCapacity());
//		driver.get("http://localhost:"+ port + context + "/rent.html");
//		
//		
//		rentPage.searchCustomer("Smith");
//		rentPage.selectCustomer();
//		wait.until(ExpectedConditions.elementToBeClickable(By.id("kayak")));
//		rentPage.pickAllEquipment();
//		wait.until(ExpectedConditions.textToBe(By.id("total-price"), "Total Price: £125.00"));
//		assertEquals("Total Price: £125.00", rentPage.getTotalPrice());
//		
//		rentPage.saveEquipment();
//		wait.until(ExpectedConditions.alertIsPresent());
//		assertEquals("Customer Bill Smith's equipment saved.", rentPage.readAlertText());
//		rentPage.alertOK();
//		assertEquals("19", rentPage.getKayakStock());
//		assertEquals("19", rentPage.getBAStock());
//		assertEquals("19", rentPage.getHelmetStock());
//		assertEquals("19", rentPage.getPaddleStock());
//		
//		
//		driver.get("http://localhost:"+ port + context + "/index.html");
//		
//		
//		homePage.searchCustomer("Smith");
//		homePage.selectCustomer();
//		
//		homePage.deleteOneCustomer();
//		wait.until(ExpectedConditions.alertIsPresent());
//		homePage.alertOK();
//		wait.until(ExpectedConditions.alertIsPresent());
//		assertEquals("Customer deleted.", homePage.readAlertText());
//		homePage.alertOK();
//		
//		homePage.createTenCustomers(custInfo);
//		homePage.deleteAllCustomers();
//		wait.until(ExpectedConditions.alertIsPresent());
//		homePage.alertOK();
//		wait.until(ExpectedConditions.alertIsPresent());
//		assertEquals("All customers deleted.", homePage.readAlertText());
//		homePage.alertOK();
//		assertEquals("rgba(0, 255, 0, 1)", homePage.getSafetyCircleColour());
//		
//		homePage.create150Customers(custInfo);
//		assertEquals("rgba(255, 165, 0, 1)", homePage.getSafetyCircleColour());
//		
//		homePage.create100Customers(custInfo);
//		assertEquals("rgba(255, 0, 0, 1)", homePage.getSafetyCircleColour());
//		
//		homePage.deleteAllCustomers();
//		homePage.alertOK();
//	}
//
//}
//	
//
