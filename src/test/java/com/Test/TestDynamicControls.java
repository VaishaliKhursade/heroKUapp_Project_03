package com.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Methods.Base;
import com.Methods.Method;
import com.PageObjects.DynamicContent;
import com.PageObjects.DynamicControls;
import com.PageObjects.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDynamicControls {
	static WebDriver driver;
	static String path = "C:\\Users\\vaishali\\git\\com.heroKU\\src\\test\\resources\\configfiles\\config.properties";
	static Base m = new Base();
	static String dynamicDataPath = "C:\\Users\\vaishali\\git\\com.heroKU\\src\\test\\resources\\testdata\\DynamicControls.properties";

	@BeforeClass
	public void launch() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Method.ReadPropertyFile(path, "testUrl"));
		driver.findElement(HomePage.DynamicControls).click();
	}

	@AfterClass
	public void close() {
		driver.close();
	}

	@Test
	public void TC01() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement chkbox = driver.findElement(DynamicControls.checkbox);
		chkbox.click();
		driver.findElement(DynamicControls.remove).click();
		String message = driver.findElement(DynamicControls.message).getText();
		String expectedmessage = Method.ReadPropertyFile(dynamicDataPath, "removeMessage");
		Assert.assertEquals(message, expectedmessage, "Test failed, check box not removed");
		try {
			Assert.assertFalse(chkbox.isDisplayed(),
					"Test failed, check box still available after clicking on remove button");

		} catch (Exception e) {
			System.out.println("Test Passed, Checkbox deleted");
		}
	}

	@Test
	public void TC02() throws Exception {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(DynamicControls.add).click();
		String message = driver.findElement(DynamicControls.message).getText();
		String expectedmessage = Method.ReadPropertyFile(dynamicDataPath, "addMessage");
		Assert.assertEquals(message, expectedmessage, "Test failed, check box not added");

		try {
			WebElement chkbox = driver.findElement(DynamicControls.checkbox);
			Assert.assertTrue(chkbox.isDisplayed(),
					"Test failed, check box still not available after clicking on add button");

		} catch (Exception e) {
			System.out.println("Test Passed, Checkbox added");
		}
	}

	@Test
	public void TC03() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement input = driver.findElement(DynamicControls.input);
		if (input.isEnabled() == false) {

			driver.findElement(DynamicControls.enable).click();
		}
		Thread.sleep(7000);
		Assert.assertTrue(input.isEnabled(), "Test failed, the input box is not enabled");
		String value = "Test";
		input.sendKeys(value);
		String enteredValue = input.getAttribute("value");
		Assert.assertEquals(value, enteredValue, "Entered values are not equal, input box is not working properly");
	}

	@Test
	public void TC04() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement input = driver.findElement(DynamicControls.input);
		driver.findElement(DynamicControls.disable).click();
		Thread.sleep(7000);
		Assert.assertFalse(input.isEnabled(),
				"Test failed, the expected element is still enable after clicking on disable");

	}

}
