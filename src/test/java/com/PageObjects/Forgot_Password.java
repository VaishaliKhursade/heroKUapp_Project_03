package com.PageObjects;

import org.openqa.selenium.By;

public class Forgot_Password {
	
	public static By ForgotPassword  = By.xpath("//h2[text()='Forgot Password']");
	public static By emailTextkbox = By.xpath("//input[@id='email']");
	public static By RetrievePassButton = By.xpath("//button[@id='form_submit']");
}
