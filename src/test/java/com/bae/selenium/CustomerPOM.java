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
//		rentPage.saveEquipment();
//		Thread.sleep(2000);
//		assertEquals("Customer Bill Smith's equipment saved.", rentPage.readAlertText());
//		rentPage.alertOK();
//		assertEquals("19", rentPage.getKayakStock());
//		assertEquals("19", rentPage.getBAStock());
//		assertEquals("19", rentPage.getHelmetStock());
//		assertEquals("19", rentPage.getPaddleStock());
//		rentPage.moveToHomePage();
//		
//		Thread.sleep(1000);
//		homePage.searchCustomer("Smith");
//		homePage.selectCustomer();
//		homePage.deleteOneCustomer();
//		Thread.sleep(2000);
//		homePage.alertOK();
//		assertEquals("Customer deleted.", homePage.readAlertText());
//		homePage.createTenCustomers(custInfo);
//		homePage.deleteAllCustomers();
//		homePage.alertOK();
//		assertEquals("All customers deleted.", homePage.readAlertText());
//		

//		laPage.search("dress");
//		Thread.sleep(3000);
//
//		laPage.pickDress();
//		Thread.sleep(3000);
//
//		itemPage.addToCart();
//		Thread.sleep(3000);
//
//		itemPage.checkout();
//		Thread.sleep(3000);
//		
//		checkPage.proceed();
//		Thread.sleep(3000);
//		
//		checkPage.signIn();
//		Thread.sleep(3000);
//		
//		checkPage.proceedAgain();
//		Thread.sleep(3000);
//		
//		checkPage.checkBox();
//		checkPage.proceedAgainAgain();
//		Thread.sleep(3000);
//		
//		checkPage.payment();
//		Thread.sleep(3000);
//		
//		checkPage.confirm();
//		Thread.sleep(3000);
//		
//		assertEquals("Your order on My Store is complete.", checkPage.confirmMessage());
//		
//		Thread.sleep(12000);
		
		
		
		
//		assertEquals("Printed Summer Dress",
//				this.driver
//						.findElement(
//								By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/h2"))
//						.getText());
		

//		
//		Thread.sleep(6000);
//		
//		SearchPage sePage = new SearchPage(driver);
//		
//		String searched = sePage.searchedText();
//		
//		assertEquals( arg, searched);
//		Thread.sleep(3000);

	}

	private void assertEquals(String expected, Object readAlertText) {
		// TODO Auto-generated method stub
		
	}

}
	

