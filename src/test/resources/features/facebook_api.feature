Feature: Verify facebook endpoints

Scenario: Veify Fetch photos 
	When  get user details with "XYZ" token 
	And get number of photos with "XYZ" token

Scenario: Veify Fetch posts 
	When  get user details with "XYS" token 
	And get number of posts with "XYZ" token

