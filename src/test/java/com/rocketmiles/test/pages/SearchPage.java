package com.rocketmiles.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {

	public WebDriver driver;

	public SearchPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void clickOnTopOffer() {
		getElement(By.xpath("//span[@translate='search_page.top.offer']")).click();;
	}
}
