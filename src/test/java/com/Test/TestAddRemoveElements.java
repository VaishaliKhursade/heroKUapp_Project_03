package com.Test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Methods.Base;
import com.Methods.Method;
import com.PageObjects.AddRemoveElements;
import com.PageObjects.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestAddRemoveElements {
	static WebDriver driver;
	static String path = "C:\\Users\\vaishali\\git\\com.heroKU\\src\\test\\resources\\configfiles\\config.properties";
	static Base m = new Base();

	@BeforeClass
	public void launch() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Method.ReadPropertyFile(path, "testUrl"));
		driver.findElement(HomePage.AddRemoveElements).click();
	}

	@AfterClass
	public void close() {
		driver.close();
	}

	@Test
	public void TC01() {
		driver.findElement(AddRemoveElements.AddElementButton).click();
		WebElement elements = driver.findElement(AddRemoveElements.Elements);
		m.validation(elements);
		System.out.println("Element added successfully");
	}

	@Test
	public void TC02() {

		driver.findElement(AddRemoveElements.Delete).click();
		try {
			WebElement elements = driver.findElement(AddRemoveElements.Elements);
			Assert.assertFalse(elements.isDisplayed(), "Test failed, deletion of element is not done");
		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("Test Passed, Element deleted successfully");
			e.printStackTrace();
		}
	}

}
