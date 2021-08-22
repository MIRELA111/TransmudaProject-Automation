package com.transmuda.pages;

import com.transmuda.utilities.Driver;
import com.transmuda.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id="prependedInput")
    public WebElement userName;

    @FindBy(xpath = "//div[@class='form-signin__footer control-group form-row']/*")
    public WebElement forgotPasswordLink;

    @FindBy(id="prependedInput2")
    public WebElement password;

    @FindBy(name = "_submit")
    public WebElement submit;

    @FindBy(xpath = "//div[@class='alert alert-error']" )
    public WebElement errorMessage;

    @FindBy(xpath = "//label[@for='prependedInput']")
    public WebElement errorMessage_label;

    @FindBy(xpath = "//label[@for='prependedInput2']")
    public WebElement errorMessage_label_password;

    @FindBy(xpath = "//div[@class='alert alert-error']/div")
    public WebElement InvalidUsername;


    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement checkbox;

    @FindBy(xpath ="//span[@class='custom-checkbox__text']")
    public WebElement textCheckbox;

    public void login(String userNameStr, String passwordStr) {
        userName.sendKeys(userNameStr);
        password.sendKeys(passwordStr);
        submit.click();
        // verification that we logged
    }

    public void logIn(String usernameInv,String passwordInv){
        userName.sendKeys(usernameInv);
        password.sendKeys(passwordInv);
        submit.click();
    }


    }



