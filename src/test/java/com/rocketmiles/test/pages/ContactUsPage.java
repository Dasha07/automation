package com.rocketmiles.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage extends BasePage {

	WebDriver driver;

	public ContactUsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public void clickOnGetAssistance() {
		getElement(By.xpath("//div[text()='Get Assistance']")).click();
		sleep(2);
	}

	public void clickOnInTheProcessOfBooking() {
		getElement(By.xpath("//div[text()='In the process of booking']")).click();
		sleep(2);
	}
	public void clickOnATechnicalQuestion() {
		getElement(By.xpath("//div[text()='A technical question']")).click();
		sleep(2);
	}
	public void clickOnSendToConcierge() {
		getElement(By.xpath("//button[text()='Send to Concierge']")).click();
		sleep(2);
	}
	
	public boolean validateErrorMessage() {
		String message = getElement(By.cssSelector(".rm-error.rm-animate-fade")).getText();
		String expectedMessage = "It appears no message has been entered. Please type a message before submitting.";
		
		return message.contains(expectedMessage);
	}
	
}
