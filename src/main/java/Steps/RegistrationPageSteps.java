package Steps;

import Pages.RegistrationPage;
import io.qameta.allure.Step;
import Data.Dates;
import org.testng.Assert;


public class RegistrationPageSteps {
    RegistrationPage registrationPage = new RegistrationPage();
    Dates dates = new Dates();

    @Step("registrationButton step")
    public RegistrationPageSteps clickOnRegistrationButton(){
        registrationPage.registrationButton.click();
        return this;
    }

    @Step("clickRegistration step")
    public RegistrationPageSteps clickRegistration(){
        registrationPage.regButton.click();
        return this;
    }

    @Step("textValidation step")
    public RegistrationPageSteps textValidation(){
        Assert.assertEquals(registrationPage.infoMessage.getText(),dates.exceptedText);
        return this;

    }

}
