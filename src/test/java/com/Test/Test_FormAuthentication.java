package com.Test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Methods.Base;
import com.Methods.Method;
import com.PageObjects.Forgot_Password;
import com.PageObjects.Form_Authentication;
import com.PageObjects.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_FormAuthentication {
	
	static WebDriver driver;
	static String path = "C:\\Users\\vaishali\\git\\com.heroKU\\src\\test\\resources\\configfiles\\config.properties";
	static Base m = new Base();
	static String FormAuthenticationPath ="C:\\Users\\vaishali\\git\\com.heroKU\\src\\test\\resources\\testdata\\FormAuthentication.properties";
	
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

		WebElement UsernameTextkbox = driver.findElement(Form_Authentication.UsernameTXB);
		WebElement Password = driver.findElement(Form_Authentication.PasswordTXB);
		WebElement LoginButton = driver.findElement(Form_Authentication.Loginbtn);
		m.activeValidation(UsernameTextkbox);
		m.activeValidation(Password);
		m.activeValidation(LoginButton);
		
		UsernameTextkbox.sendKeys("Username");
		Password.sendKeys("password");
		LoginButton.click();
		
		org.testng.Assert.assertTrue(UsernameTextkbox.isEnabled(),"Test failed, the "+ UsernameTextkbox+" is not enabled");
		org.testng.Assert.assertTrue(Password.isEnabled(),"Test failed, the "+ Password+" is not enabled");
		org.testng.Assert.assertTrue(LoginButton.isEnabled(),"Test failed, the "+ LoginButton+" is not enabled");
}
	
	
	@Test
	public void TC02() throws Exception {

		WebElement UsernameTextkbox = driver.findElement(Form_Authentication.UsernameTXB);
		WebElement Password = driver.findElement(Form_Authentication.PasswordTXB);
		WebElement LoginButton = driver.findElement(Form_Authentication.Loginbtn);
		
		UsernameTextkbox.sendKeys("Username");
		Password.sendKeys("password");
		LoginButton.click();
		
		String header = driver.findElement(Form_Authentication.Header).getText();
		String expectedHeader = Method.ReadPropertyFile(FormAuthenticationPath, "header");
		m.navigation(header, expectedHeader);
}
	
	@Test
	public void TC03() throws Exception {

		WebElement UsernameTextkbox = driver.findElement(Form_Authentication.UsernameTXB);
		WebElement Password = driver.findElement(Form_Authentication.PasswordTXB);
		WebElement LoginButton = driver.findElement(Form_Authentication.Loginbtn);
		WebElement LogoutButton = driver.findElement(Form_Authentication.Loginbtn);
		
		UsernameTextkbox.sendKeys("Username");
		Password.sendKeys("password");
		LoginButton.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		LogoutButton.click();
		
		String header = driver.findElement(Form_Authentication.Header1).getText();
		String expectedHeader = Method.ReadPropertyFile(FormAuthenticationPath, "header1");
		m.navigation(header, expectedHeader);
}
}