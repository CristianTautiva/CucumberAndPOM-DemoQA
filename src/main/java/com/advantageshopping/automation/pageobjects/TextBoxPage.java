package com.advantageshopping.automation.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import static org.junit.Assert.*;

@DefaultUrl("https://www.demoqa.com/text-box")
public class TextBoxPage extends PageObject {

    public By fullNameInput = By.id("userName");
    public By emailInput = By.id("userEmail");
    public By currentAddressInput = By.id("currentAddress");
    public By permanentAddressInput = By.id("permanentAddress");
    public By submitButton = By.id("submit");
    public By nameValidation = By.id("name");
    public By emailValidation = By.id("email");
    public By currentAddressValidation = By.xpath("//p[@id='currentAddress']");
    public By permanentAddressValidation = By.xpath("//p[@id='permanentAddress']");


    public void setFullNameInput(String string) {
        getDriver().findElement(fullNameInput).sendKeys(string);
    }

    public void setEmailInput(String string) {
        getDriver().findElement(emailInput).sendKeys(string);
    }

    public void setCurrentAddressInput(String string) {
        getDriver().findElement(currentAddressInput).sendKeys(string);
    }

    public void setPermanentAddressInput(String string) {
        getDriver().findElement(permanentAddressInput).sendKeys(string);
    }

    public void clickSubmitButton(){
        getDriver().findElement(submitButton).submit();
    }

    public void validations(String expectedName, String expectedEmail, String expectedCurrentAddress, String expectedPermanentAddress){
        assertEquals(getDriver().findElement(nameValidation).getText(), expectedName);
        assertEquals(getDriver().findElement(emailValidation).getText(), expectedEmail);
        assertEquals(getDriver().findElement(currentAddressValidation).getText(), expectedCurrentAddress);
        assertEquals(getDriver().findElement(permanentAddressValidation).getText(), expectedPermanentAddress);
    }

}
