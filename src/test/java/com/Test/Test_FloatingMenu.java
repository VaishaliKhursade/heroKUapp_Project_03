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
import com.PageObjects.CheckBoxes;
import com.PageObjects.Floating_Menu;
import com.PageObjects.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_FloatingMenu {
	
	static WebDriver driver;
	static String path = "C:\\Users\\vaishali\\git\\com.heroKU\\src\\test\\resources\\configfiles\\config.properties";
	static Base m = new Base();
	
	@BeforeClass
	public void launch() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Method.ReadPropertyFile(path, "testUrl"));
		driver.findElement(HomePage.FloatingMenu).click();
	}
	
	@AfterClass
	public void close() {
		driver.close();
	}
	

	@Test
	public void TC01() {

		WebElement HomeButton  = driver.findElement(Floating_Menu.HomeButton);
		WebElement NewsButton  = driver.findElement(Floating_Menu.NewsButton);
		WebElement ContactButton  = driver.findElement(Floating_Menu.ContactButton);
		WebElement AboutButton  = driver.findElement(Floating_Menu.AboutButton);
		m.activeValidation(HomeButton );
		m.activeValidation(NewsButton);
		m.activeValidation(ContactButton);
		m.activeValidation(AboutButton);
		
		
		Assert.assertTrue(HomeButton.isDisplayed(),"Test failed, the expected content is not visible");
		Assert.assertTrue(NewsButton.isDisplayed(),"Test failed, the expected content is not visible");
		Assert.assertTrue(ContactButton.isDisplayed(),"Test failed, the expected content is not visible");
		Assert.assertTrue(AboutButton.isDisplayed(),"Test failed, the expected content is not visible");
	}

}
