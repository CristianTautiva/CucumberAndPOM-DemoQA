package com.advantageshopping.automation.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import com.advantageshopping.automation.utils.Times;
import org.openqa.selenium.WebElement;

import java.io.File;

@DefaultUrl("https://www.demoqa.com/automation-practice-form")
public class RegisterPage extends PageObject {

    public By nameInput = By.id("firstName");
    public By emailInput = By.id("userEmail");
    public By lastNameInput = By.id("lastName");
    public By mobileNumberInput = By.id("userNumber");
    public By hobbiesCheckbox = By.xpath("//label[@for='hobbies-checkbox-1']");
    public By birthdayInput = By.id("dateOfBirthInput");
    public By genderRadioButton = By.xpath("//label[@for='gender-radio-1']");
    public By subjectInput = By.id("subjectsInput");
    public By addressInput = By.id("currentAddress");
    public By selectDiv = By.id("state");
    public By listDiv = By.xpath("//div[@class='css-1wa3eu0-placeholder']");
    public By selectPicture = By.id("uploadPicture");
    public By submitButton = By.id("submit");
    public By divMessage = By.xpath("//*[@class='modal-title h4']");

    public void sendName(String string){
        getDriver().findElement(nameInput).sendKeys(string);
    }

    public void sendEmail(String string){
        getDriver().findElement(emailInput).sendKeys(string);
    }

    public void sendLastName(String string){
        getDriver().findElement(lastNameInput).sendKeys(string);
    }

    public void clickGenderRadioButton(){
        getDriver().findElement(genderRadioButton).click();
    }

    public void sendMobileNumber(String string){
        getDriver().findElement(mobileNumberInput).sendKeys(string);
    }

    public void sendSubjects(String string){
        getDriver().findElement(subjectInput).sendKeys(string);
    }

    public void sendAddress(String string){
        getDriver().findElement(addressInput).sendKeys(string);
    }

    public void clickSelectListState(){
        getDriver().findElement(selectDiv).click();
        Times.implicitWait(2,getDriver());

    }

    public void uploadPhoto(String route){
        File file = new File(route);
        String path = file.getAbsolutePath();
        getDriver().findElement(selectPicture).sendKeys(path);
    }



    public void clickHobbiesCheckbox(){
        getDriver().findElement(hobbiesCheckbox).click();
    }

    public void sendBirthday(String string){
        getDriver().findElement(birthdayInput).sendKeys(string);
    }

   public String getMessageRegisterSuccessfully(){
       return getDriver().findElement(divMessage).getText();
   }


}
