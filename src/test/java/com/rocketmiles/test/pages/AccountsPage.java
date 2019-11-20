package com.rocketmiles.test.pages;

/**
 * @author dasha_daniyalian
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AccountsPage extends BasePage {

	public WebDriver driver;

	public AccountsPage(WebDriver driver) {
		super(driver);
	}

	public void verifyProfileHeading() {
		String actual  = getElement(By.xpath("//h3")).getText().trim();
		String expected = "Profile & Account";
		Assert.assertEquals(actual, expected);
	}
	
	public void verifyAndroidImage() {
		Assert.assertTrue(isElementPresent(By.xpath("//img[contains(@ng-src,'/resources/images/app-badges/android')]")));
	}
	
	public void verifyAppleImage() {
		Assert.assertTrue(isElementPresent(By.xpath("//img[contains(@ng-src,'/resources/images/app-badges/ios')]")));
	}
	
	public void clickRewards() {
		sleep(2);
		getElement(By.xpath("//a[text()='Rewards']")).click();
	}
	public void clickReferFriend() {
		sleep(2);
		getElement(By.xpath("//a[text()='Refer A Friend']")).click();
	}
	
}
