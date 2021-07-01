package com.advantageshopping.automation.steps;

import com.advantageshopping.automation.models.DataInjection;
import com.advantageshopping.automation.pageobjects.RegisterPage;
import com.advantageshopping.automation.utils.Times;
import com.advantageshopping.automation.utils.Javascript;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.server.handler.interactions.touch.Scroll;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class RegisterPageSteps {

    RegisterPage registerPage = new RegisterPage();
    DataInjection dataInjection = new DataInjection();


    public RegisterPageSteps() throws AWTException {
    }

    @Step
    public void openBrowser(){
        registerPage.open();
    }

    @Step
    public void registerNewUser() throws InterruptedException {
        Times.implicitWait(1,registerPage.getDriver());
        registerPage.sendName(dataInjection.getName());
        registerPage.sendLastName(dataInjection.getLastName());
        registerPage.sendEmail(dataInjection.getEmail());
        registerPage.clickGenderRadioButton();
        registerPage.sendMobileNumber("3118526374");
        Times.implicitWait(10,registerPage.getDriver());
        registerPage.clickHobbiesCheckbox();
        Javascript.scrollDown(registerPage.getDriver(),"1000");
        Times.implicitWait(3,registerPage.getDriver());
        registerPage.sendBirthday(dataInjection.getBirthday());
        registerPage.sendSubjects(dataInjection.getSubject());
        registerPage.uploadPhoto("C:\\Users\\Dcris\\Pictures\\Camera Roll\\dcris.jpg");
        Times.implicitWait(5,registerPage.getDriver());
        Javascript.clickJS(registerPage.getDriver(), registerPage.submitButton);
        Times.implicitWait(20,registerPage.getDriver());

    }

    @Step
    public void useImplicitWait(int time){
        Times.implicitWait(time,registerPage.getDriver());
    }

    @Step
    public void useExplicitWait(int time, By locator){
        Times.explicitWait(time,locator,registerPage.getDriver());
    }

    @Step
    public void validation(String expected){
        assertEquals(registerPage.getMessageRegisterSuccessfully(),expected);
    }

}
