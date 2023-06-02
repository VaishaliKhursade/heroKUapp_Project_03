package com.Test;

import java.io.File;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Methods.Base;
import com.Methods.Method;
import com.PageObjects.HomePage;
import com.PageObjects.SecureFileDownload;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestSecureFileDownload {

	static WebDriver driver;
	static String path = "C:\\Users\\Sreen\\git\\repository\\herokuapp\\src\\test\\resources\\configfiles\\config.properties";
	static Base m = new Base();

	@BeforeClass
	public void launch() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Method.ReadPropertyFile(path, "testUrl"));
		driver.findElement(HomePage.SecureFileDownload).click();
	}

	@AfterClass
	public void close() {
		driver.close();
	}

	@Test
	public void TC01() {
		
		Alert a = driver.switchTo().alert();
		a.sendKeys("admin");
		a.sendKeys("\t");
		a.sendKeys("admin");
		a.accept();
		
		WebElement downloadButton = driver.findElement(SecureFileDownload.PDFSample);
		downloadButton.click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("downloadedFile")));
		File downloadedFile = new File("path/to/downloaded/file");
		Assert.assertTrue(downloadedFile.exists(), "File is downloaded successfully.");

	}

}
