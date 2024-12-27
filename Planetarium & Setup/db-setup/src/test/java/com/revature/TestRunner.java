package com.revature;

import com.revature.pom.HomePage;
import com.revature.pom.LoginPage;
import com.revature.pom.RegistrationPage;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


@RunWith(Cucumber.class)
@CucumberOptions(
        features="classpath:features",
        glue = "com.revature.steps",
        plugin = {"pretty",
                "html:src/test/resources/reports/html-report.html",
                "json:src/test/resources/reports/json-report.json"}
)
public class TestRunner {

    public static WebDriver webDriver = null;
    public static LoginPage loginPage;
    public static RegistrationPage registrationPage;
    public static HomePage homePage;
    public static WebDriverWait wait;

    public static final String moonValue = "moon";
    public static final String planetValue = "planet";



    @BeforeClass
    public static void setup(){
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(4));
        loginPage = new LoginPage(webDriver);
        registrationPage = new RegistrationPage(webDriver);
        homePage = new HomePage(webDriver);

    }

    @AfterClass
    public static void tearDown(){
        if(webDriver != null){
            webDriver.quit();
        }
    }
}
