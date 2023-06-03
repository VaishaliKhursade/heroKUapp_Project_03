package com.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Methods.Base;
import com.Methods.Method;
import com.PageObjects.ABTesting;
import com.PageObjects.Frames;
import com.PageObjects.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_Frames {
	
	static WebDriver driver;
	static String path = "C:\\Users\\vaishali\\git\\com.heroKU\\src\\test\\resources\\configfiles\\config.properties";
	static Base m = new Base();
	static String Framespath = "C:\\Users\\vaishali\\git\\com.heroKU\\src\\test\\resources\\testdata\\Frames.properties";

	@BeforeClass
	public void launch() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Method.ReadPropertyFile(path, "testUrl"));
		driver.findElement(HomePage.NestedFrames).click();
	}

	@AfterClass
	public void close() {
		driver.close();
	}
	
	
	@Test(description = "Link Validation", priority = 1)
	public void TC01() {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		WebElement NestedFramesLink = driver.findElement(Frames.NestedFramesLink); 
		WebElement iFrameLink = driver.findElement(Frames.iFrameLink);
		
		org.testng.Assert.assertTrue(NestedFramesLink.isDisplayed(),"Test failed, the expected Link is not visible");
		org.testng.Assert.assertTrue(iFrameLink.isDisplayed(),"Test failed, the expected Link is not visible");
		
	}
	
	@Test(description = "Link Validation", priority = 2)
	public void TC02() throws Exception {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		String Header = driver.findElement(Frames.heading).getText();
		String expectedHeader = Method.ReadPropertyFile(Framespath, "header");
		m.navigation(Header, expectedHeader);
	}
	
	@Test(description = "Nested Frames", priority = 3)
	public void TC03() {

		int frameCount = driver.findElements(By.tagName("frame")).size();
		System.out.println("Total frames: " + frameCount);

		for (int i = 0; i < frameCount; i++) {

			driver.switchTo().frame(i);
			System.out.println("Switched to frame: " + i);
			int iframeCount = driver.findElements(By.tagName("frame")).size();
			for (int j = 0; j < iframeCount; j++) {
				System.out.println("Switched to iframe: " + j);
				driver.switchTo().defaultContent();
				System.out.println("Switched back to main content");
			}
		}
	}

}
