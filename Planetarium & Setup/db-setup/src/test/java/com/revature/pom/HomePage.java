package com.revature.pom;

import com.revature.TestRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomePage {
    private WebDriver driver;



    @FindBy(id = "greeting")
    private WebElement greetingHeader;

    @FindBy(id="logoutButton")
    private WebElement logoutButton;

    @FindBy(id="locationSelect")
    private WebElement location;

    @FindBy(id="deleteInput")
    private WebElement deleteNameInput;


    @FindBy(id="deleteButton")
    private WebElement deleteButton;

    @FindBy(id = "moonNameInput")
    private WebElement moonName;

    @FindBy(id="orbitedPlanetInput")
    private WebElement planetId;

    @FindBy(id="moonImageInput")
    private WebElement moonImage;

    @FindBy(xpath="/html/body/div[1]/div[2]/button")
    private WebElement submitButton;

    @FindBy(tagName = "tr")
    private List<WebElement> celestialBodies;

    private WebElement planetNameInput;

    private WebElement planetImageInput;

    public void setDeleteNameInput(String name){
        this.deleteNameInput.sendKeys(name);
    }

    public void clickDeleteButton(){
        this.deleteButton.click();
    }

    public void setMoonImage(String file){
        this.moonImage.sendKeys(file);
    }


    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
//        this.celestialBodies = driver.findElements(By.tagName("tr"));

    }

    public void logUserIn(){
        TestRunner.loginPage.setUpLoggedInUser();
        TestRunner.wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.tagName("tr"), 3));
        this.celestialBodies = driver.findElements(By.tagName("tr"));

    }

    public void logout(){
        logoutButton.click();
    }


    public void unauthorizedAccess(){
        TestRunner.webDriver.get("http://localhost:8080/planetarium");
    }

    public void loadMoonFields(){
        TestRunner.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.tagName("input"), 3));
        moonName = TestRunner.webDriver.findElement(By.id("moonNameInput"));
        planetId = TestRunner.webDriver.findElement(By.id("orbitedPlanetInput"));
        moonImage = TestRunner.webDriver.findElement(By.id("moonImageInput"));
//        TestRunner.wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.tagName("tr"), 3));
        this.celestialBodies = driver.findElements(By.tagName("tr"));
    }

    public void loadPlanetFields(){
        TestRunner.wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.tagName("input"), 4));
        planetNameInput = TestRunner.webDriver.findElement(By.id("planetNameInput"));
        planetImageInput = TestRunner.webDriver.findElement(By.id("planetImageInput"));
//        TestRunner.wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.tagName("tr"), 3));
        this.celestialBodies = driver.findElements(By.tagName("tr"));
    }


    public void loadPage(String value){
        switch(value){
            case "moon":
                selectOptionByValue("moon");
                loadMoonFields();
                break;
            case "planet":
                selectOptionByValue("planet");
                loadPlanetFields();
                break;
            default:
                selectOptionByValue("moon");
                loadMoonFields();
        }

    }


    public void selectOptionByValue(String value){
        Select select = new Select(this.location);
        select.selectByValue(value);
    }

    public int getNumberOfCelestialRows(){
        return celestialBodies.size()-1;
    }

    public String getGreetingHeader(){
        return this.greetingHeader.getText();
    }

    public void setMoonName(String name){
        this.moonName.sendKeys(name);
    }

    public void setPlanetId(int planetId){
        this.planetId.sendKeys(Integer.toString(planetId));
    }

    public void submitCreationInfo(){
        this.submitButton.click();
    }

    public void setPlanetName(String name){
        this.planetNameInput.sendKeys(name);
    }

    public void setPlanetImageInput(String file){
        this.planetImageInput.sendKeys(file);
    }






}
