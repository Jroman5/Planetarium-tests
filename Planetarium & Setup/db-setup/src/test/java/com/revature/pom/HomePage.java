package com.revature.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    private WebDriver driver;

    @FindBy(id="deleteInput")
    private WebElement deleteNameInput;


    @FindBy(id="deleteButton")
    private WebElement deleteButton;

    @FindBy(tagName = "planetNameInput")
    private WebElement planetName;

    @FindBy(tagName = "a")
    private WebElement registrationLink;


}
