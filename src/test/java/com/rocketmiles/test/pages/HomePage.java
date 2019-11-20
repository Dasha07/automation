package com.rocketmiles.test.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.rocketmiles.test.common.utils.AutomationUtils;

public class HomePage extends BasePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public List<String> getAccountOptions() {
		sleep(5);
		getElement(By.cssSelector("button.btn-black")).click();
		List<WebElement> dropdownOptions = getElements(By.cssSelector(".account-dropdown-menu li .header-link"));
		List<String> options = new ArrayList<String>();
		for (WebElement webElement : dropdownOptions) {
			String option = webElement.getText().trim();
			options.add(option);
			System.out.println(option);
		}
		return options;
	}
	
	public void clickLangauge() {
		getElement(By.xpath("//div[contains(@class,'language-select-container')]//a")).click();
	}
	public List<String> getLanguageOptions(){
		
		
		
		List<WebElement> listElements = getElements(By.xpath("//div[contains(@class,'language-select-container')]//ul/li"));
		List<String> actualLanguageOptions = new ArrayList<String>();
		for (int i = 1; i <= listElements.size(); i++) {
			String lang = getElement(By.xpath("//div[contains(@class,'language-select-container')]//ul/li["+i+"]/a")).getText().trim();
			System.out.println(lang);
			actualLanguageOptions.add(lang);
		}
		int randomNumber = AutomationUtils.getRandomValue(listElements.size());
		System.out.println(randomNumber);
		getElement(By.xpath("//div[contains(@class,'language-select-container')]//ul/li/a[contains(text(),'"+actualLanguageOptions.get(randomNumber-1)+"')]")).click();
		return actualLanguageOptions;
	}

	public void selectRandomLanguage() {
		getElement(By.xpath("//div[contains(@class,'language-select-container')]//ul/li/a[contains(text(),'Português')]")).click();
	}
	public void clickWhereDoYouNeedHotel() {
		getElement(By.xpath("//input[@placeholder='Where do you need a hotel?']")).click();
	}
	
	public void searchHotelWithLocation(String location) {
		getElement(By.xpath("//input[@placeholder='Where do you need a hotel?']")).sendKeys(location);
		sleep(2);
		getElement(By.cssSelector("div.location-search-dropdown ul li a")).click();
	}
	
	public void clickRewardProgram() {
		getElement(By.xpath("//input[@placeholder='Select reward program']")).click();
	}
	
	public void selectRandomRewardProgram() {
		List<String> allProgramsOptions = new ArrayList<String>();
		List<WebElement> rewardAllElements = getElements(By.xpath("//li[@allprograms='All programs']//a"));

		for (WebElement webElement : rewardAllElements) {
			allProgramsOptions.add(webElement.getText().trim());
		}
		String randomRewardProgram = AutomationUtils.getRandomStringFromList(allProgramsOptions);
		getElement(By.xpath("//a[contains(text(),'"+randomRewardProgram+"')]")).click();;
		sleep(2);
	}
	public void searchHotels(String location) {
		getElement(By.xpath("//input[@placeholder='Where do you need a hotel?']")).click();
		getElement(By.xpath("//input[@placeholder='Where do you need a hotel?']")).sendKeys(location);
		sleep(2);
		getElement(By.cssSelector("div.location-search-dropdown ul li a")).click();

		getElement(By.xpath("//input[@placeholder='Select reward program']")).click();
		List<String> allProgramsOptions = new ArrayList<String>();
		List<WebElement> rewardAllElements = getElements(By.xpath("//li[@allprograms='All programs']//a"));

		for (WebElement webElement : rewardAllElements) {
			allProgramsOptions.add(webElement.getText().trim());
		}
		String randomRewardProgram = AutomationUtils.getRandomStringFromList(allProgramsOptions);
		getElement(By.xpath("//a[contains(text(),'"+randomRewardProgram+"')]")).click();;
		sleep(2);
		
		// Type booking date
		selectRandomBookingDate();
		selectRandomCheckoutDate();
		selectRandomGuests();
		selectRandomRooms();
		clickSearchButton();
	}
	
	public void clickSearchButton() {
		getElement(By.cssSelector(".search-submit-btn")).click();
		waitForElement(By.cssSelector(".search-summary-container-transparent"));
	}
	public void selectRandomRooms() {
		getElement(By.cssSelector(".rooms button")).click();
		int totalGuests = getElements(By.cssSelector(".rooms .dropdown-menu li")).size();
		int randomNumber = AutomationUtils.getRandomValue(totalGuests);
		System.out.println(randomNumber);
		if(isElementPresent(By.cssSelector(".rooms .dropdown-menu li:nth-child("+randomNumber+")"))) {
			getElement(By.cssSelector(".rooms .dropdown-menu li:nth-child("+randomNumber+")")).click();
		}else {
			System.out.println("rooms are not available");
		}
	}
	public void selectRandomGuests() {
		getElement(By.cssSelector(".adults button")).click();
		int totalGuests = getElements(By.cssSelector(".adults .dropdown-menu li")).size();
		int randomNumber = AutomationUtils.getRandomValue(totalGuests);
		System.out.println(randomNumber);
		if(isElementPresent(By.cssSelector(".adults .dropdown-menu li:nth-child("+randomNumber+")"))) {
			getElement(By.cssSelector(".adults .dropdown-menu li:nth-child("+randomNumber+")")).click();
		}else {
			System.out.println("guests are not available");
		}
	}
	int nextDay = 0;
	public void selectRandomBookingDate() {
		getElement(By.xpath("//div[@class='checkin booking-date']/input")).click();
		String currentBookingDay = getElement(By.cssSelector(".ui-datepicker-calendar .ui-datepicker-current-day a")).getText();
		nextDay = Integer.parseInt(currentBookingDay)  + 1 ;
		if(isElementPresent(By.xpath("//td[contains(@class,'ui-datepicker-current-day')]/following::a[text()='"+nextDay+"']"))) {
			getElement(By.xpath("//td[contains(@class,'ui-datepicker-current-day')]/following::a[text()='"+nextDay+"']")).click();
		}
	}
	public void selectRandomCheckoutDate() {
		getElement(By.xpath("//div[@class='checkout booking-date']/input")).click();
		int checkoutDate = nextDay  + 2 ;
		System.out.println(checkoutDate);
		sleep(2);
		if(isElementPresent(By.xpath("//td[contains(@class,'ui-datepicker-current-day')]/following::a[text()='"+checkoutDate+"']"))) {
			getElement(By.xpath("//td[contains(@class,'ui-datepicker-current-day')]/following::a[text()='"+checkoutDate+"']")).click();
		}else {
			System.out.println("end date not worked out.");
		}
		
	}

	public void clickContactUs() {
		getElement(By.xpath("//span[text()='Contact Us']")).click();
	}
	
}
