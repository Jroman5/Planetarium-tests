package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginSteps {


@Given("the user is on the login page.")
public void the_user_is_on_the_login_page() {
    TestRunner.loginPage.goToLoginPage();
    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
}

    @When("the user provides the username {string}.")
    public void the_user_provides_the_username(String username) {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.loginPage.setUsername(username);
//        throw new io.cucumber.java.PendingException();
    }

    @When("the user provides the password {string}.")
    public void the_user_provides_the_password(String password) {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.loginPage.setPassword(password);
//        throw new io.cucumber.java.PendingException();
    }

    @When("the user submits their credentials.")
    public void the_user_submits_their_credentials() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.loginPage.submitCredentials();
//        throw new io.cucumber.java.PendingException();
    }

    @Then("the user should be redirected to {string} page.")
    public void the_user_should_be_redirected_to_page(String pageName) {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("Planetarium Login")));
        Assert.assertEquals(pageName, TestRunner.webDriver.getTitle());
//        throw new io.cucumber.java.PendingException();
    }

    @Then("the user should expect {string} alert.")
    public void the_user_should_expect_alert(String expectedMessage) {
        TestRunner.wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = TestRunner.webDriver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        Assert.assertEquals(expectedMessage, alertText);

        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
    }

    @Then("the user should be redirected to Home page.")
    public void the_user_should_be_redirected_to_Home_page() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("Planetarium Login")));
        Assert.assertEquals("Home", TestRunner.webDriver.getTitle());
//        throw new io.cucumber.java.PendingException();
    }

    @Then("the user should be redirected to login page.")
    public void the_user_should_be_redirected_to_login_page() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals("Planetarium Login", TestRunner.webDriver.getTitle());
//        throw new io.cucumber.java.PendingException();
    }

    @Given("the user is in the logged in")
    public void the_user_is_in_the_logged_in() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.loginPage.setUpLoggedInUser();
//        throw new io.cucumber.java.PendingException();
    }

    @Given("in the home page")
    public void in_the_home_page() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.webDriver.get("http://localhost:8080/planetarium");
//        throw new io.cucumber.java.PendingException();
    }

    @When("the User chooses to log out")
    public void the_User_chooses_to_log_out() {
        // Write code here that turns the phrase above into concrete actions
        // implement home page pom and call here
        TestRunner.homePage.logout();
    }

    @Then("the User should be logged out")
    public void the_User_should_be_logged_out() {
        // Write code here that turns the phrase above into concrete actions

        TestRunner.wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("Home")));

    }

    @Then("the user should be redirected to the log in page")
    public void the_user_should_be_redirected_to_the_log_in_page() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals("Planetarium Login", TestRunner.webDriver.getTitle());

    }


}
