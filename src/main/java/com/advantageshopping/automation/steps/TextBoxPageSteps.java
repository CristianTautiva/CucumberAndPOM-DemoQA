package com.advantageshopping.automation.steps;

import com.advantageshopping.automation.models.DataInjection;
import com.advantageshopping.automation.pageobjects.TextBoxPage;
import com.advantageshopping.automation.utils.Javascript;
import com.advantageshopping.automation.utils.Times;
import net.thucydides.core.annotations.Step;

import java.util.concurrent.TimeUnit;

public class TextBoxPageSteps {

    TextBoxPage textBoxPage = new TextBoxPage();
    DataInjection dataInjection = new DataInjection();

    @Step
    public void openBrowser(){
        textBoxPage.open();
    }

    @Step
    public void fillFieldsInTextBoxPage() throws InterruptedException {

        textBoxPage.getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        Times.waitFor(5000);
        textBoxPage.setFullNameInput(dataInjection.getName() + " " + dataInjection.getLastName());
        textBoxPage.setEmailInput(dataInjection.getEmail());
        textBoxPage.setCurrentAddressInput(dataInjection.getCurrentAddress());
        textBoxPage.setPermanentAddressInput(dataInjection.getPermanentAddress());
        Times.waitFor(1000);
        Javascript.clickJS(textBoxPage.getDriver(), textBoxPage.submitButton);

    }

    @Step
    public void validationsOfTextBoxPage() throws InterruptedException {
       // textBoxPage.getDriver().manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        Times.waitFor(10000);
        textBoxPage.validations(dataInjection.getExtensionName()+dataInjection.getName() + " " + dataInjection.getLastName(),
                dataInjection.getExtensionEmail()+dataInjection.getEmail(),
                dataInjection.getExtensionCurrentAddress()+dataInjection.getCurrentAddress(),
                dataInjection.getExtensionPermanentAddress()+dataInjection.getPermanentAddress());
    }
}
