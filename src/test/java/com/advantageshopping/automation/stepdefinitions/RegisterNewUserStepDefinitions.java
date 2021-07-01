package com.advantageshopping.automation.stepdefinitions;

import com.advantageshopping.automation.pageobjects.RegisterPage;
import com.advantageshopping.automation.steps.RegisterPageSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import com.advantageshopping.automation.utils.Times;

import java.util.concurrent.TimeUnit;

public class RegisterNewUserStepDefinitions {

    @Steps
    RegisterPageSteps registerPageSteps;

    @Given("^that a web user wants to register in advantage shopping online$")
    public void thatAWebUserWantsToRegisterInAdvantageShoppingOnline(){
        registerPageSteps.openBrowser();
    }


    @When("^he fills all the requested fields$")
    public void heFillsAllTheRequestedFields() throws InterruptedException {
        registerPageSteps.registerNewUser();
    }

    @Then("^he should see him username in the homepage$")
    public void heShouldSeeHimUsernameInTheHomepage() throws InterruptedException {

        registerPageSteps.validation("Thanks for submitting the form");

    }

}
