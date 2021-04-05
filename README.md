# HackerRankAutomationTesting

This repository contains the code for Automation Testing of HackerRank.<br>
Certain parts of the website are tested and corresponding extentreports are generated.<br>
The tools used for testing are Java Selenium and TestNG.


## Modules that are being tested are:

1. [SignUp](SignupTest.java)
2. [Login](LoginTest.java)
3. [Public profile details validation](UserProfileTest.java)

## SignUp
For signup test, we are navigationg to the HackerRank website and then to the signup page.<br>
There we are checking for the presence of seperate signup buttons as provided by the site for developers and companies.<br>
After that we are navigating to the developer sign up page and then we are entering the required details.

## Login
For login test, we are navigating to the HackerRank website and then to the login page.<br>
There we are checking for the presence of two seperate login flows, one for developer and other for companies.<br>
Then we are navigating to the developer login page and the required credentials are entered for successful login.

## User Profile Details
This test deals with the different attributes of the user public pofile being displayed.<br>
We are checking whether the details like username, about section, badges, skills and submissions are displayed or not.

### Note: The locators used here may change so it is suggested to verify the locators at the time of testing if you are using this code as reference.
