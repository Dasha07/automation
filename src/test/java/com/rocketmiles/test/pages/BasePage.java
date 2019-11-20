package com.rocketmiles.test.pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
	WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isElementPresent(By by) {
		if (driver.findElements(by).size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isElementPresent1(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void sleep(int sec) {
		try {
			Thread.sleep(1000 * sec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public WebElement getElement(By by) {
		List<WebElement> elements = driver.findElements(by);
		if (elements.size() > 0) {
			return elements.get(0);
		} else {
			throw new NoSuchElementException(by.toString() + "element not found");
		}
	}

	public List<WebElement> getElements(By by) {
		List<WebElement> elements = driver.findElements(by);
		return elements;
	}

	public void acceptCookies() {
		getElement(By.cssSelector(".cookie-banner-button")).click();
	}

	public void waitForElement(By by) {
		if (driver.findElements(by).size() > 0) {

		}
	}

	public void switchToWindow(String partOfTitle) {
		String mainTitle = driver.getWindowHandle();
		Set<String> windowTitles = driver.getWindowHandles();

		for (String windowTitle : windowTitles) {
			if (!mainTitle.contains(windowTitle)) {
				driver.switchTo().window(windowTitle);
				break;
			}
		}

	}
	
	public void clickAccountOption(String account) {
		sleep(2);
		String value = getElement(By.xpath("//div[@class='account-dropdown']//button[@data-toggle='dropdown']")).getAttribute("aria-expanded");
		if(value==null || !value.equals("true")) {
			getElement(By.xpath("//div[@class='account-dropdown']//button[@data-toggle='dropdown']")).click();
		}
		
		getElement(By.xpath("//a[contains(text(),'"+account+"')]")).click();
		
	}
	
	public void logout() {
		getElement(By.xpath("//div[@class='account-options']")).click();
		getElement(By.xpath("//a[contains(text(),'Logout')]")).click();
	}
}
