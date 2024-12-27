package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationSteps {

    @Given("the new user is on the login page")
    public void the_new_user_is_on_the_login_page() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.registrationPage.goToLoginPage();
    }

    @When("the user clicks the register link")
    public void the_user_clicks_the_register_link() {
        // Write code here that turns the phrase above into concrete actions

        TestRunner.loginPage.clickRegistrationLink();
    }

    @When("the user provides a username {string}")
    public void the_user_provides_a_username(String username) {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.registrationPage.setUsername(username);

    }

    @When("the user provides a password {string}")
    public void the_user_provides_a_password(String password) {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.registrationPage.setPassword(password);

    }

    @When("the user submits the credentials")
    public void the_user_submits_the_credentials() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.registrationPage.submit();

    }



    @Then("the user should get a browser alert {string}")
    public void the_user_should_get_a_browser_alert(String response) {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = TestRunner.webDriver.switchTo().alert();
        String text = alert.getText();
        alert.accept();
        Assert.assertEquals(response, text);


    }

    @Then("should be redirected to the login page.")
    public void should_be_redirected_to_the_login_page() {
        // Write code here that turns the phrase above into concrete actions

        TestRunner.wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("Account Creation")));
        Assert.assertEquals("Planetarium Login", TestRunner.webDriver.getTitle());
    }

    @Given("the user is on the registration page")
    public void the_user_is_on_the_registration_page() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.registrationPage.goToRegistrationPage();
    }

    @When("the user clicks on the login link")
    public void the_user_clicks_on_the_login_link() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.registrationPage.clickLoginLink();

    }



}
