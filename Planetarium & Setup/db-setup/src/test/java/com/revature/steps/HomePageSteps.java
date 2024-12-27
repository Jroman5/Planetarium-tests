package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePageSteps {



    @Given("the user is not logged in")
    public void the_user_is_not_logged_in() {
        TestRunner.loginPage.goToLoginPage();
        // Write code here that turns the phrase above into concrete actions
//
    }

    @When("the user tries to access the home page directly")
    public void the_user_tries_to_access_the_home_page_directly() {
        TestRunner.homePage.unauthorizedAccess();
        // Write code here that turns the phrase above into concrete actions
//
    }

    @Then("the user should be denied access")
    public void the_user_should_be_denied_access() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertNotEquals("Home", TestRunner.webDriver.getTitle());
//        throw new io.cucumber.java.PendingException();
    }

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.loginPage.goToLoginPage();
    }

    @When("the user logs in")
    public void the_user_logs_in() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.loginPage.setUpLoggedInUser();
//        TestRunner.wait.until(ExpectedConditions.not(ExpectedConditions.invisibilityOfElementLocated(By.tagName("tbody"))));


    }

    @Then("the user should see their planets")
    public void the_user_should_see_their_planets() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(4,TestRunner.homePage.getNumberOfCelestialRows()-1);

    }

    @Then("the user should see their moons")
    public void the_user_should_see_their_moons() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(4,TestRunner.homePage.getNumberOfCelestialRows());

    }

    @Then("the user should see a greeting on the home page")
    public void the_user_should_see_a_greeting_on_the_home_page() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals("Welcome to the Home Page Batman", TestRunner.homePage.getGreetingHeader());
    }
}
