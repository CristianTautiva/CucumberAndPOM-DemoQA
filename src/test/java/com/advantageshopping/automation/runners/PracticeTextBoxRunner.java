package com.advantageshopping.automation.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/practiceTextBox.feature",
        glue = "com.advantageshopping.automation.stepdefinitions",
        snippets = SnippetType.CAMELCASE,
        tags = "@regression")
public class PracticeTextBoxRunner {
}
