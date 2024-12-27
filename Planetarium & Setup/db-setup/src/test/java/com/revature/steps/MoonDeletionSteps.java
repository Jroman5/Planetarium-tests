package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MoonDeletionSteps {

    @Given("the User is logged in")
    public void the_User_is_logged_in() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.loginPage.setUpLoggedInUser();

    }

    @Given("is on the moon page")
    public void is_on_the_moon_page() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.homePage.loadPage(TestRunner.moonValue);

    }

    @When("inputs a valid name")
    public void inputs_a_valid_name() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.homePage.setDeleteNameInput("Luna");

    }

    @When("the user clicks the delete button")
    public void the_user_clicks_the_delete_button() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.homePage.clickDeleteButton();

    }

    @Then("the table should refresh and reflect the changes")
    public void the_table_should_refresh_and_reflect_the_changes() {
        // Write code here that turns the phrase above into concrete actions
        //assert the change in the size of the List
        Assert.assertEquals("Home", TestRunner.webDriver.getTitle());
        Assert.assertEquals(3, TestRunner.homePage.getNumberOfCelestialRows()-1);
    }

    @When("inputs an invalid name")
    public void inputs_an_invalid_name() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.homePage.setDeleteNameInput("ThisMoonDoesnotExist");

    }

    @Then("the browser should show an alert message for an invalid name")
    public void the_browser_should_show_an_alert_message_for_an_invalid_name() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = TestRunner.webDriver.switchTo().alert();
        String text = alert.getText();
        alert.accept();
        Assert.assertEquals("Invalid moon name", text);

    }

    @Then("should return to the home page")
    public void should_return_to_the_home_page() {
        Assert.assertEquals("Home", TestRunner.webDriver.getTitle());
    }

}
