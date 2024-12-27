package com.revature.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

    private WebDriver driver;

    @FindBy(id="usernameInput")
    private WebElement username;

    @FindBy(id="passwordInput")
    private WebElement password;

    @FindBy(xpath = "html/body/div/form/input[3]")
    private WebElement submitButton;

    @FindBy(tagName = "a")
    private WebElement loginHref;

    public RegistrationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToRegistrationPage(){
        driver.get("http://localhost:8080/register");
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

    public void submit(){
        this.submitButton.click();
    }

    public void clickLoginLink(){
        this.loginHref.click();
    }
}
