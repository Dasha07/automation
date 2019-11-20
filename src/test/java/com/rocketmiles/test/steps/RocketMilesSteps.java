package com.rocketmiles.test.steps;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.rocketmiles.test.common.utils.AutomationUtils;
import com.rocketmiles.test.core.Setup;
import com.rocketmiles.test.pages.AccountsPage;
import com.rocketmiles.test.pages.ContactUsPage;
import com.rocketmiles.test.pages.DetailsPage;
import com.rocketmiles.test.pages.HomePage;
import com.rocketmiles.test.pages.LoginPage;
import com.rocketmiles.test.pages.SearchPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RocketMilesSteps {

	LoginPage loginPage = new LoginPage(Setup.driver);
	HomePage homePage = new HomePage(Setup.driver);
	SearchPage searchPage = new SearchPage(Setup.driver);
	DetailsPage detailsPage = new DetailsPage(Setup.driver);
	AccountsPage accountsPage = new AccountsPage(Setup.driver);
	ContactUsPage contactUsPage = new ContactUsPage(Setup.driver);

	@Given("Open browser and navigate to the application  ")
	public void open_browser_and_navigate_to_the_application_https_www_rocketmiles_com() {
		
	}
	
	@When("Click on sign in or join menu link")
    public void click_on_sign_in_or_join_menu_link() throws Throwable {
		loginPage.clickOnLoginLink();
    }

    @Then("Check that Account dropdown menu opens")
    public void check_that_account_dropdown_menu_opens() throws Throwable {
    	List<String> expectedAccountOptions = new ArrayList<String>();
		expectedAccountOptions.add("Home");
		expectedAccountOptions.add("Profile");
		expectedAccountOptions.add("Reservations");
		expectedAccountOptions.add("Credit Cards");
		expectedAccountOptions.add("Rewards");
		expectedAccountOptions.add("Logout");
    	List<String> actualAccountOptions = homePage.getAccountOptions();
    	boolean result = AutomationUtils.compareLists(expectedAccountOptions, actualAccountOptions);
		Assert.assertTrue(result);
    }

    @And("^Enter email address \"([^\"]*)\" and Enter password in Password \"([^\"]*)\" and Click on Sign In pop-up$")
    public void enter_email_address_something_and_enter_password_in_password_something_and_click_on_sign_in_popup(String username, String password) throws Throwable {
    	loginPage.login(username, password);
    }

	@When("Click on Where do you need a hotel")
	public void click_on_Where_do_you_need_a_hotel() {
		homePage.clickWhereDoYouNeedHotel();
	}

	@When("Type in New York")
	public void type_in_New_York() {
		homePage.searchHotelWithLocation("New York");
	}

	@When("Click on Select reward program")
	public void click_on_Select_reward_program() {
		homePage.clickRewardProgram();
	}

	@Then("Select a program")
	public void select_a_program() {
		homePage.selectRandomRewardProgram();
	}

	@Then("Select Date")
	public void select_Date() {
		homePage.selectRandomBookingDate();
		homePage.selectRandomCheckoutDate();
	}

	@Then("Select guests")
	public void select_guests() {
		homePage.selectRandomGuests();
	}

	@Then("Select rooms")
	public void select_rooms() {
		homePage.selectRandomRooms();
	}

	@Then("Click on Search properties and earn rewards btn")
	public void click_on_Search_properties_and_earn_rewards_btn() {
		homePage.clickSearchButton();
	}

	@Then("scroll down and select the Top Offer")
	public void scroll_down_and_select_the_Top_Offer() {
		searchPage.clickOnTopOffer();
	}

	@Then("Verify miles and $ pre night amount available")
	public void verify_miles_and_$_pre_night_amount_available() {
		detailsPage.switchToWindow("Hotel details");
		detailsPage.getMilesEarned();
		detailsPage.getPerNightRoom();
	}

	@Then("Hotel detail page opens")
	public void hotel_detail_page_opens() {
		
	}

	@Then("Verify that user able to scroll through pictures")
	public void verify_that_user_able_to_scroll_through_pictures() {
		detailsPage.scrollImages();
	}

	@When("Verify that account page opens")
	public void verify_that_account_page_opens() {
		
	}

	@When("Click on Account and go to Rewards")
	public void click_on_Account_and_go_to_Rewards() {
		accountsPage.clickRewards();
	}

	@When("Verify that user able to refer friends")
	public void verify_that_user_able_to_refer_friends() {
		accountsPage.clickReferFriend();
	}

	@Then("Verify that user able to log out")
	public void verify_that_user_able_to_log_out() {
		accountsPage.logout();
	}

	@When("Click on English link")
	public void click_on_English_link() {
		homePage.clickLangauge();
	}
	List<String> actualLanguagetOptions = null;
	
	@When("Verify Languages in dropdown and select random Langauge")
	public void verify_Languages_in_dropdown() {
		List<String> expectedLanguageOptions = new ArrayList<String>();
		expectedLanguageOptions.add("English");
		expectedLanguageOptions.add("Norsk");
		expectedLanguageOptions.add("Português");
		expectedLanguageOptions.add("Español");
		expectedLanguageOptions.add("Türkçe");
		
		List<String> actualLanguagetOptions = homePage.getLanguageOptions();
		boolean result = AutomationUtils.compareLists(expectedLanguageOptions, actualLanguagetOptions);
		Assert.assertTrue(result);
	}

	@Then("Select Any Language")
	public void select_Any_Language() {
		homePage.selectRandomLanguage();
		
	}

	@When("Click on {string}")
	public void click_on(String string) {
		
	}

	
	@When("Click on Get assistance")
	public void click_on_Get_assistance() {
		contactUsPage.clickOnGetAssistance();
	}

	@When("Click on in the process of booking")
	public void click_on_in_the_process_of_booking() {
		contactUsPage.clickOnInTheProcessOfBooking();
	}

	@When("Click on A technical question")
	public void click_on_A_technical_question() {
		contactUsPage.clickOnATechnicalQuestion();
	}

	@When("Click on Send Conciegre")
	public void click_on_Send_Conciegre() {
		contactUsPage.clickOnSendToConcierge();
		Assert.assertTrue(contactUsPage.validateErrorMessage());
	}

	@When("Verify error message")
	public void verify_error_message() {
		Assert.assertTrue(contactUsPage.validateErrorMessage());
	}

	@When("Click on Account menu")
	public void click_on_Account_menu() {
		homePage.clickAccountOption("Profile");
	}

	@When("Click on Profile from account menu")
	public void click_on_Profile_from_account_menu() {
		accountsPage.verifyProfileHeading();
	}

	@When("Verify that Apple store and Google Play visible")
	public void verify_that_Apple_store_and_Google_Play_visible() {
		accountsPage.verifyAndroidImage();
		accountsPage.verifyAppleImage();
	}

	@When("Click on account and Log Out")
	public void click_on_account_and_Log_Out() {
		accountsPage.logout();
	}

	@When("Click on Contact Us")
	public void click_on_Contact_Us() {
		homePage.clickContactUs();
	}
	
	@Given("Open browser and navigate to the application")
	public void open_browser_and_navigate_to_the_application() {
		
	}

}
