package com.revature.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResgistrationPage {

    private WebDriver driver;

    @FindBy(id="usernameInput")
    private WebElement username;

    @FindBy(id="passwordInput")
    private WebElement password;

    @FindBy(tagName = "input")
    private WebElement submitButton;
}
