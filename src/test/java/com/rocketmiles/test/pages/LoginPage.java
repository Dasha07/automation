package com.rocketmiles.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void clickOnLoginLink() {
		getElement(By.cssSelector(".homepage-login a")).click();
	}
	public void login(String username, String password) {
		sleep(2);
		getElement(By.xpath("//input[@name='username']")).sendKeys(username);
		getElement(By.xpath("//input[@name='password']")).sendKeys(password);
		getElement(By.xpath("//input[@value='Sign In']")).click();
		sleep(2);
	}
	
	
}
