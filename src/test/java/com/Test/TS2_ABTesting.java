package com.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Methods.Base;
import com.Methods.Method;
import com.PageObjects.ABTesting;
import com.PageObjects.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TS2_ABTesting {
	static WebDriver driver;
	static String path = "C:\\Users\\Sreen\\git\\repository\\herokuapp\\src\\test\\resources\\configfiles\\config.properties";
	static Base m = new Base();

	@BeforeClass
	public void Launch() throws Exception  {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Method.ReadPropertyFile(path, "testUrl"));
	}
	
	@BeforeMethod
	public void ToABTesting() {
		driver.findElement(HomePage.ABTesting).click();
	}
	
	@AfterMethod
	public void ToHomepage() throws Exception {
		driver.navigate().back();
	}
	
	@AfterClass
	public void terminate() {
		driver.quit();
	}
	
	@Test
	public void TC01() {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		String header = driver.findElement(ABTesting.Header).getText();
		String ExpectedHeader = "A/B Test Variation 1";
		m.navigation(header, ExpectedHeader);
		
	}
	
	@Test
	public void TC02() {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		WebElement content = driver.findElement(ABTesting.Content);
		m.validation(content);
	}
	

}
