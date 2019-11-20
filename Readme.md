Selenium Cucumber Framework (BDD)
===========================


Technologies Used:
-------------
1. Java
2. Maven
3. TestNG
4. Cucumber
5. RestAssured
6. Selenium

Prerequisites:
--------------
1. Java and Maven needs to be installed and added to PATH
2.  Credentials that you want to test "www.rocketmiles.com"  here "/automation/src/test/resources/features/rocketmiles.feature"
3.  Facebook developer account "App Access Tokens"

Info:  App access tokens are used to make requests to Facebook APIs on behalf of an app rather than a user. This can be used to modify the parameters of your app, create and manage test users, or read your apps's insights. Go to  https://developers.facebook.com/tools/explorer , create new app with your facebook account. 

Add Permissions >

    public_profile
    email
    user_age_range
    user_birthday
    user_friends
    user_gender
    user_hometown
    user_likes
    user_link
    user_photos
    user_location
    user_posts
    user_status
    user_tagged_places
    user_videos
 
 Copy Access Token and paste it in "automation/src/test/resources/features/facebook_api.feature" file in order to test your api calls
 
 4. If you need to update chromedriver go to  "automation/src/test/resources/drivers"

How to run:
-------------
1. Go to Terminal
2. Go to folder location
3. Run "mvn clean install"
4. Run "mvn clean test"


Reports
-------------

Goto automation\target\cucumber-report and open index.html file.





