package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PlanetDeletionSteps {

    @Given("the user is logged in to the planetarium")
    public void the_user_is_logged_in_to_the_planetarium() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.loginPage.setUpLoggedInUser();

    }

    @Given("is on the planet page")
    public void is_on_the_planet_page() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.homePage.loadPage(TestRunner.planetValue);

    }

    @When("inputs an valid planet name")
    public void inputs_an_valid_planet_name() {
        // Write code here that turns the phrase above into concrete actions

        TestRunner.homePage.setDeleteNameInput("Earth");
    }

    @When("the user clicks the delete planet button")
    public void the_user_clicks_the_delete_planet_button() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.homePage.clickDeleteButton();
    }

    @Then("the table should refresh and reflect the deleted planet")
    public void the_table_should_refresh_and_reflect_the_deleted_planet() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals("Home",TestRunner.webDriver.getTitle());
//        throw new io.cucumber.java.PendingException();
    }

    @When("inputs an invalid planet name")
    public void inputs_an_invalid_planet_name() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.homePage.setDeleteNameInput("Pangea");

    }

    @Then("the browser should show an alert message for an invalid planet name")
    public void the_browser_should_show_an_alert_message_for_an_invalid_planet_name() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = TestRunner.webDriver.switchTo().alert();
        String text = alert.getText();
        alert.accept();
        Assert.assertEquals("Invalid planet name",text);

    }
}
