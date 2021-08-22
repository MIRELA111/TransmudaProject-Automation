package com.transmuda.stepdefinitions;

import com.transmuda.pages.DashboardPage;
import com.transmuda.pages.LoginPage;
import com.transmuda.utilities.BrowserUtils;
import com.transmuda.utilities.ConfigurationReader;
import com.transmuda.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LogouFunctionalityStepDefs {

    DashboardPage dashboardPage=new DashboardPage();

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {

        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        BrowserUtils.waitFor(2);
    }


    @And("the user clicks on logout button inside profile info")
    public void theUserClicksOnLogoutButtonInsideProfileInfo() {


        dashboardPage.userName.click();
        dashboardPage.logOutLink.click();

    }


    @Then("the user lands on login page")
    public void theUserLandsOnLoginPage() {
        BrowserUtils.waitFor(5);
        String expectedUrl = "https://qa.transmuda.com/user/login";
        String actualUrl=Driver.get().getCurrentUrl();

        Assert.assertEquals(expectedUrl,actualUrl);
        System.out.println("expectedUrl = " + expectedUrl);
        System.out.println("actualUrl = " + actualUrl);
    }

    @When("When the user logged in as {string}")
    public void whenTheUserLoggedInAs(String userType) {
        String username="";
        String password="";
        LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);
    }

    @And("the {string} logout successfully")
    public void theLogoutSuccessfully(String arg0) {

        dashboardPage.logOut();


    }

    @Then("the user cannot go to homepage again after successful logout")
    public void theUserCannotGoToHomepageAgainAfterSuccessfulLogout() {
        Driver.get().navigate().back();

        String expectedUrl="https://qa.transmuda.com/user/login";
        String actualUrl=Driver.get().getCurrentUrl();

        Assert.assertEquals(expectedUrl,actualUrl);
        System.out.println("expectedUrl = " + expectedUrl);
        System.out.println("actualUrl = " + actualUrl);
    }



}


