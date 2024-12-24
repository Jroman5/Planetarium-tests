package com.revature.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    @FindBy(id="usernameInput")
    private WebElement username;


    @FindBy(id="passwordInput")
    private WebElement password;

    @FindBy(tagName = "input")
    private WebElement loginButton;

    @FindBy(tagName = "a")
    private WebElement registrationLink;


    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToLoginPage(){
        driver.get("http://localhost:8080/");
    }

    public void setUsername(String username){
        this.username.sendKeys(username);
    }

    public void setPassword(String password){
        this.password.sendKeys(password);
    }
    public void submitCredentials(){
        this.loginButton.submit();
    }

    public void setUpLoggedInUser(){
        goToLoginPage();
        setUsername("Batman");
        setPassword("Iamthenight1939");
        submitCredentials();
    }

    public void clickRegistrationLink(){
        this.registrationLink.click();
    }


}
