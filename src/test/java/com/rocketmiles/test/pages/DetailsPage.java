package com.rocketmiles.test.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DetailsPage extends BasePage {

	WebDriver driver;

	public DetailsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void clickContinueWithNewReward() {
		if (isElementPresent(By.xpath("//span[text()='Continue with the new reward offer']"))) {
			getElement(By.xpath("//span[text()='Continue with the new reward offer']")).click();
		} else {
			System.out.println("Continue with the new reward offer is not available");
		}
	}

	public void getMilesEarned() {
		String text = getElement(By.xpath("//span[@translate='common.rewards_earned']")).getText();
		System.out.println(text);
		String miles = getElement(By.cssSelector(".rewards div")).getText();
		System.out.println(miles);
	}

	public void getPerNightRoom() {
		System.out.println(getElement(By.cssSelector(".info-summary-item.price")).getText());
	}

	public void scrollImages() {
		List<WebElement> elements = getElements(By.cssSelector(".carousel-indicators li"));
		for (int i = 0; i < elements.size(); i++) {
			getElement(By.cssSelector(".glyphicon-menu-right")).click();
		}
	}
}
