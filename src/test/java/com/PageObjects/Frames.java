package com.PageObjects;

import org.openqa.selenium.By;

public class Frames {
	
	public static By heading  = By.xpath("/html/body/div[2]/div/div/h3");
	public static By NestedFramesLink = By.xpath("/html/body/div[2]/div/div/ul/li[1]/a");
	public static By LEFTframe = By.xpath("//frame[@name='frame-left']");
	public static By MiddleFrame = By.xpath("//frame[@name='frame-middle']");
	public static By RigtFrame = By.xpath("//frame[@name='frame-right']");
	public static By BottomFrame = By.xpath("//frame[@name='frame-bottom']");
	
	public static By iFrameLink = By.xpath("//a[text()='iFrame']");
	public static By iFrame = By.xpath("//div[@class='tox tox-tinymce']");

}
