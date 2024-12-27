package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MoonCreationSteps {
    private int listlength;
    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.loginPage.setUpLoggedInUser();

//
    }

    @When("the user selects Moon creation")
    public void the_user_selects_Moon_creation() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.homePage.loadPage("moon");

    }


    @When("the user inputs Moon name {string}")
    public void the_user_inputs_Moon_name(String name) {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.homePage.setMoonName(name);

    }

    @When("the user inputs planet_id {int}")
    public void the_user_inputs_planet_id(Integer planetId) {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.homePage.setPlanetId(planetId);

    }
    @When("the user provides a file {string}")
    public void the_user_provides_a_file(String file) {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.homePage.setMoonImage(file);
//        throw new io.cucumber.java.PendingException();
    }

    @Then("the table should expect the page to reflect the changes")
    public void the_table_should_expect_the_page_to_reflect_the_changes() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.tagName("tr"),listlength));
        Assert.assertEquals("Home", TestRunner.webDriver.getTitle());
        Assert.assertEquals(listlength+1, TestRunner.homePage.getNumberOfCelestialRows());
//        throw new io.cucumber.java.PendingException();

    }


    @When("the user submits the moon information")
    public void the_user_submits_the_moon_information() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.homePage.submitCreationInfo();

    }

//    Abcdefghi12345678901234567890_-

    @Then("the table should expect message {string}")
    public void the_table_should_expect_message(String response) {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = TestRunner.webDriver.switchTo().alert();
        String text = alert.getText();
        alert.accept();
        TestRunner.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.tagName("tr"),listlength-1));
        Assert.assertEquals(response,text);
        Assert.assertEquals(4,TestRunner.homePage.getNumberOfCelestialRows());
    }




}
