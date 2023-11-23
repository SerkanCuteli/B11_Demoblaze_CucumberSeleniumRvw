package com.demoblaze.step_definitions;

import com.demoblaze.pages.HomePage;
import com.demoblaze.pages.LoginPage;
import com.demoblaze.utilities.ConfigurationReader;
import com.demoblaze.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

public class Login_StepDefs {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Given("The user navigates to web site")
    public void the_user_navigates_to_web_site() {
        Driver.get().get(ConfigurationReader.get("url"));
    }
    @When("The user cliks login button and enters valid credentials")
    public void the_user_cliks_login_button_and_enters_valid_credentials() {
        loginPage.login();
    }
    @Then("The user verifies welcome message")
    public void the_user_verifies_welcome_message() {
        homePage.verifyWelcomeMessage();
    }
    @When("The user cliks on login button and enters {string} and {string} credentials")
    public void the_user_cliks_on_login_button_and_enters_and_credentials(String username, String password) {
        loginPage.login(username,password);
    }
    @Then("The user verfies welcome {string} message")
    public void the_user_verfies_welcome_message(String username) {
        homePage.verifyWelcomeMessage(username);
    }
    @When("The user cliks on the login button and enters following credentials")
    public void the_user_cliks_on_the_login_button_and_enters_following_credentials(Map<Object,String> userInfo) {
        loginPage.login(userInfo.get("username"), userInfo.get("password"));
    }
    @Then("The user verifies {string} message")
    public void the_user_verifies_message(String message) {
        homePage.invalidLoginWarningMessage(message);


    }



}
