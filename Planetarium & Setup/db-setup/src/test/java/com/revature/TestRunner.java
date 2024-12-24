package com.revature;

import com.revature.pom.LoginPage;
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
    public static WebDriverWait wait;



    @BeforeClass
    public static void setup(){
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(2));
        loginPage = new LoginPage(webDriver);
    }

    @AfterClass
    public static void tearDown(){
        if(webDriver != null){
            webDriver.quit();
        }
    }
}
