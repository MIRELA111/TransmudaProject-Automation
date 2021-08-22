@TRNS-306
Feature: 

	Background:
		#@TRNS-298
		Given the user is on the login page.


	@TRNS-299
	Scenario Outline: All users can log in with valid credentials <userType>
		When the user logged in as "<userType>"
		Then the page Subtitle contains "<subTitle>"
		     Examples:
		
		      |userType           |subTitle      |
		      |driver             |Quick Launchpad|
		      |sales_manager      |Dashboard      |
		      |store_manager      |Dashboard      |	


	@TRNS-300
	Scenario Outline: Users should not be able to log in with invalid credentials
		
		      When the users logs in using following credentials "<username>" and "<password>"
		      Then the title should contains "<errorMessage>"
		      Examples:
		      |username      |password   |
		      |driver        |user       |
		      |store_manager |user       |
		      |sales_manager |user       |
		      |TruckDriver   |UserUser123|
		      |storeManager  |UserUser123|
		      |salesManager  |UserUser123|
		      |DRIVER        |UserUser123|
		      |STORE_MANAGER |UserUser123|
		      |SALES_MANAGER |UserUser123|
		      |driver        |USERUSER123|
		      |store_manager |USERUSER123|
		      |sales_manager |USERUSER123|
		      |DRIVER        |USERUSER123|
		      |STORE_MANAGER |USERUSER123|
		      |SALES_MANAGER |USERUSER123|
		      |              |UserUser123|
		      |driver        |           |
		      |store_manager |           |
		      |sales_manager |            |
		      |              |USERUSER123@|
		      |driver!@?     |            |
		      |              |            |


	@TRNS-301
	Scenario Outline: Verify that error message "Please fill in this field" is displayed
		When the users enters "<userType>"
		        And the users click login button
		        Then "Error" message is displayed
		
		        Examples:
		        |userType             |
		        |driver               |
		        |sales_manager        |
		        |store_manager        |	


	@TRNS-302
	Scenario Outline: Users click on the "Forgot your password?" link 
		
		        
		        When the user enters valid "<username>" and invalid "<password>"
				And the user clicks on Forgot your password link on the login page
				Then the users is navigated to "Forgot Password" page
				Examples:
				|username     |password    |
				|driver       |somepassword|
				|store_manager|somepassword|
				|sales_manager|somepassword|
				|wrongusername |UserUser123 |	


	@TRNS-303
	Scenario Outline: Users can see "Remember Me" link exists
		When the user enters "<userType>"
		And the user should be able to click on the link
		Then the user can see "Remember Me" link on login page


		Examples:
			|userType             |
			|driver               |
			|sales_manager        |
			|store_manager        |



	@TRNS-304
	Scenario Outline: Users should be able to see password in bullet signs 
		When the users enters "<password>" in the password box
		      Then verify that users can see entered "<password>" in bullet signs by default
		      
		      Examples:
		      |password     |
		      |UserUser123  |
		      |UserUser123  |
		      |UserUser123  |


	@TRNS-305 @wip
	Scenario Outline: Login with ENTER key as a different user types
		When the user logged in as "<userType>"
		And the user clicks Enter button of keyboard
		Then the page Subtitle contains "<subTitle>"
		Examples:

			|userType           |subTitle       |
			|driver             |Quick Launchpad|
			|sales_manager      |Dashboard      |
			|store_manager      |Dashboard      |