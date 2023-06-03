package com.PageObjects;

import org.openqa.selenium.By;

public class Form_Authentication {
	
	public static By UsernameTXB  = By.xpath("//input[@id='username']");
	public static By PasswordTXB  = By.xpath("//input[@id='password']");
	public static By Loginbtn  = By.xpath("/html/body/div[2]/div/div/form/button/i");
	public static By Logoutbtn  = By.xpath("/html/body/div[2]/div/div/a/i");
	public static By Header  = By.xpath("/html/body/div[2]/div/div/h2");
	public static By Header1  = By.xpath("//div[@id='flash']");
}
