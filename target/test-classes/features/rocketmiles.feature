Feature: Testcases for RockerMiles

Scenario: User should be able to search for hotels
    When   Click on Where do you need a hotel
    And    Type in New York
    And    Click on Select reward program
    Then   Select a program
    Then   Select Date
    And    Select guests
    And    Select rooms
	  And 	 Click on Search properties and earn rewards btn
	  And 	 scroll down and select the Top Offer
	  And 	 Verify miles and $ pre night amount available 
	  And 	 Hotel detail page opens
    Then  Verify that user able to scroll through pictures


Scenario: User able to see and go through account menu
		When  Click on sign in or join menu link
		And   Enter email address "testrocketmiles01@yopmail.com" and Enter password in Password "Test@1234" and Click on Sign In pop-up
		When   Click on Account menu
		And 	 Verify that account page opens
		And 	 Click on Profile from account menu
		And 	 Verify that Apple store and Google Play visible 
		And 	 Click on Account and go to Rewards
		And 	 Verify that user able to refer friends
		And 	 Click on account and Log Out
		Then  Verify that user able to log out


Scenario: User should be able to go to contact us page
		When  Click on Contact Us
		And  Click on Get assistance
		And  Click on in the process of booking
		And  Click on A technical question
		And  Click on Send Conciegre
		And  Verify error message		
		
Scenario: User should be able to login to the account
    When  Click on sign in or join menu link
    And   Enter email address "testrocketmiles01@yopmail.com" and Enter password in Password "Test@1234" and Click on Sign In pop-up
    Then  Check that Account dropdown menu opens
    
Scenario: User should be able to change languages
		When 	 Click on English link
		And 	 Verify Languages in dropdown and select random Langauge
	

