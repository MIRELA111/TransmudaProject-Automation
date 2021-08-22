package com.transmuda.pages;

import com.transmuda.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationPage {

    public NavigationPage() {

        PageFactory.initElements(Driver.get(), this);

    }

    @FindBy(xpath = "//div[@class='title-box']/*")
    public WebElement forgotPasswordTab;


}
