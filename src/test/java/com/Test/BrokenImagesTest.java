package com.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrokenImagesTest {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Sreen\\OneDrive\\Documents\\QA\\Selenium\\chromedriver_win32\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();


		WebDriver driver = new ChromeDriver(options);

		driver.get("http://the-internet.herokuapp.com/broken_images");

		List<WebElement> images = driver.findElements(By.tagName("img"));

		for (WebElement image : images) {
			String imageUrl = image.getAttribute("src");
			
			try {
				URL url = new URL(imageUrl);
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setRequestMethod("GET");
				connection.connect();

				int responseCode = connection.getResponseCode();
				if (responseCode != 200) {
					System.out.println("Broken image found: " + imageUrl);
				}

				connection.disconnect();
			} catch (IOException e) {
				System.out.println("Exception occurred while checking image: " + imageUrl);
				e.printStackTrace();
			}
		}

		driver.quit();
	}

}
