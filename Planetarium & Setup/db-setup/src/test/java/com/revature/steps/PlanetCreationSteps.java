package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PlanetCreationSteps {

    @Given("the user is logged in the planetarium")
    public void the_user_is_logged_in_the_planetarium() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.loginPage.goToLoginPage();
        TestRunner.loginPage.setUpLoggedInUser();

    }

    @When("the user selects planet creation")
    public void the_user_selects_planet_creation() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.homePage.loadPage(TestRunner.planetValue);
    }

    @When("the user inputs planet name {string}")
    public void the_user_inputs_planet_name(String name) {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.homePage.setPlanetName(name);

    }

    @When("the user inputs fileType {string}")
    public void the_user_inputs_fileType(String fileType) {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.homePage.setPlanetImageInput(fileType);
    }

    @When("the user submits the planet data")
    public void the_user_submits_the_planet_data() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.homePage.submitCreationInfo();

    }

    @Then("the homepage should reflect the change on the list")
    public void the_homepage_should_reflect_the_change_on_the_list() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals("Home", TestRunner.webDriver.getTitle());
//        throw new io.cucumber.java.PendingException();

    }

    @Then("the user should expect and alert {string}")
    public void the_user_should_expect_and_alert(String alertMessage) {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = TestRunner.webDriver.switchTo().alert();
        String text = alert.getText();
        alert.accept();
        Assert.assertEquals(alertMessage,text);

//        throw new io.cucumber.java.PendingException();
    }

}
