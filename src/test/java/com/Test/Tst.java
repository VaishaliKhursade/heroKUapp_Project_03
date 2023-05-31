package com.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.Methods.Method;
import com.PageObjects.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tst {

	static WebDriver driver;
	static String Path = "C:\\Users\\Sreen\\eclipse-workspace\\herokuapp\\src\\test\\resources\\configfiles\\config.properties";
	static Method m = new Method();

	@Test
	public void l1() throws Exception {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(m.ReadPropertyFile(Path, "testUrl"));
		Thread.sleep(2000);
		driver.findElement(HomePage.ABTesting).click();
		Thread.sleep(2000);
		driver.close();
		
		
		
		
		
	}

}
