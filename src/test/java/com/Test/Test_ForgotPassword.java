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
import com.PageObjects.Forgot_Password;
import com.PageObjects.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_ForgotPassword {
	
	static WebDriver driver;
	static String path = "C:\\Users\\vaishali\\git\\com.heroKU\\src\\test\\resources\\configfiles\\config.properties";
	static Base m = new Base();
	static String ForgotPasswordpath = "C:\\Users\\vaishali\\git\\com.heroKU\\src\\test\\resources\\testdata\\ForgotPassword.properties";
	
	@BeforeClass
	public void launch() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Method.ReadPropertyFile(path, "testUrl"));
		driver.findElement(HomePage.ForgotPassword ).click();
	}
	
	@AfterClass
	public void close() {
		driver.close();
	}
	
	
	@Test
	public void TC01() {

		WebElement emailTextkbox = driver.findElement(Forgot_Password.emailTextkbox);
		WebElement RetrievePassButton = driver.findElement(Forgot_Password.RetrievePassButton);
		m.activeValidation(emailTextkbox);
		m.activeValidation(RetrievePassButton);
		
		emailTextkbox.sendKeys(ForgotPasswordpath);
		RetrievePassButton.click();
		
		org.testng.Assert.assertTrue(emailTextkbox.isEnabled(),"Test failed, the "+ emailTextkbox+" is not enabled");
		org.testng.Assert.assertTrue(RetrievePassButton.isEnabled(),"Test failed, the "+ RetrievePassButton+" is not enabled");
		

}
}
