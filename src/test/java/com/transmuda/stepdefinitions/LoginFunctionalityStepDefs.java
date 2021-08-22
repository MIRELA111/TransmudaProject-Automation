package com.transmuda.stepdefinitions;


import com.transmuda.pages.DashboardPage;
import com.transmuda.pages.LoginPage;
import com.transmuda.pages.NavigationPage;
import com.transmuda.utilities.BrowserUtils;
import com.transmuda.utilities.ConfigurationReader;
import com.transmuda.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class LoginFunctionalityStepDefs {


    LoginPage loginPage = new LoginPage();

    DashboardPage dashboardPage = new DashboardPage();


    @Given("the user is on the login page.")
    public void theUserIsOnTheLoginPage() {

        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        BrowserUtils.waitFor(2);

    }


    @When("the user logged in as {string}")
    public void theUserLoggedInAs(String userType) {

        String username="";
        String password="";

        switch (userType) {
            case "driver":
                loginPage.userName.sendKeys(ConfigurationReader.get("driver_username"));
                loginPage.password.sendKeys(ConfigurationReader.get("driver_password"));
                break;
            case "store_manager":
                loginPage.userName.sendKeys(ConfigurationReader.get("store_manager_username"));
                loginPage.password.sendKeys(ConfigurationReader.get("store_manager_password"));
                break;
            case "sales_manager":
                loginPage.userName.sendKeys(ConfigurationReader.get("sales_manager_username"));
                loginPage.password.sendKeys(ConfigurationReader.get("sales_manager_password"));
                break;
            default:
                System.out.println("INVALID user type");
                break;

        }

        loginPage.login(username,password);

    }

    @Then("the page Subtitle contains {string}")
    public void the_page_Subtitle_contains(String expectedSubtitle) {

        System.out.println("expectedSubtitle = " + expectedSubtitle);
        BrowserUtils.waitFor(5);
        Assert.assertEquals(expectedSubtitle, new DashboardPage().pageSubTitle.getText());


    }

    @When("the users logs in using following credentials {string} and {string}")
    public void theUsersLogsInUsingFollowingCredentialsAnd(String username, String password) {


        loginPage.logIn(username, password);
    }

    @Then("the title should contains {string}")
    public void theTitleShouldContains(String expectedMessage) {
        if (Driver.get().equals(expectedMessage)) {
            Assert.assertTrue(Driver.get().getTitle().contains(expectedMessage));

        } else if (Driver.get().equals(expectedMessage)) {
            new LoginPage().password.isDisplayed();

            Assert.assertTrue(Driver.get().getTitle().contains(expectedMessage));


        }


    }

    @When("the users enters {string}")
    public void theUsersEnters(String userType) {

        String username = "";
        String password = "";


        loginPage.login(username, password);


    }

    @And("the users click login button")
    public void theUsersClickLoginButton() {
        loginPage.submit.click();
    }


    @Then("{string} message is displayed")
    public void messageIsDisplayed(String errorMessage_label) {

        String username = "";
        String password = "";

        if (username.isEmpty()) {
            new LoginPage().errorMessage_label.isDisplayed();

        } else if (password.isEmpty()) {
            new LoginPage().errorMessage_label.isDisplayed();

            Assert.assertTrue(Driver.get().getTitle().contains(errorMessage_label));
            System.out.println("errorMessage_label = " + errorMessage_label);
        }


    }


    @When("the user enters valid {string} and invalid {string}")
    public void theUserEntersValidAndInvalid(String username, String password) {

        loginPage.login(username, password);
    }

    @And("the user clicks on Forgot your password link on the login page")
    public void theUserClicksOnForgotYourPasswordLinkOnTheLoginPage() {

        new LoginPage().forgotPasswordLink.click();
    }

    @Then("the users is navigated to {string} page")
    public void theUsersIsNavigatedToPage(String expectedPage) {
        Assert.assertEquals(expectedPage, new NavigationPage().forgotPasswordTab.getText());
        System.out.println("expectedPage = " + expectedPage);

    }


    @When("the users enters {string} in the password box")
    public void theUsersEntersInThePasswordBox(String password) {


        BrowserUtils.waitFor(5);
        new LoginPage().password.sendKeys(password);
    }

    @Then("verify that users can see entered {string} in bullet signs by default")
    public void verifyThatUsersCanSeeEnteredInBulletSignsByDefault(String password) {
        LoginPage loginPage = new LoginPage();


        Assert.assertTrue(loginPage.password.getAttribute("type").equals("password"));

    }


    @When("the user enters {string}")
    public void theUserEnters(String userType) {

        String username = "";
        String password = "";

        loginPage.login(username, password);

        new LoginPage().submit.sendKeys(username);
        new LoginPage().submit.sendKeys(password);

    }

    @And("the user should be able to click on the link")
    public void theUserShouldBeAbleToClickOnTheLink() {

        BrowserUtils.clickWithJS(loginPage.checkbox);

    }

    @Then("the user can see {string} link on login page")
    public void theUserCanSeeLinkOnLoginPage(String checkbox) {

        Assert.assertTrue(loginPage.checkbox.isSelected());
        System.out.println("checkbox = " + checkbox);
    }


    @And("the user clicks Enter button of keyboard")
    public void theUserClicksEnterButtonOfKeyboard() {


        loginPage.submit.sendKeys(Keys.ENTER);


    }



}


   
