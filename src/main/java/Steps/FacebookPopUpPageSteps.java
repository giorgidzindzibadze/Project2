package Steps;

import Pages.FacebookPopUpPage;
import io.qameta.allure.Step;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.switchTo;

public class FacebookPopUpPageSteps {
    FacebookPopUpPage facebookPopUpPage = new FacebookPopUpPage();

    @Step("check popup")
    public FacebookPopUpPageSteps checkPopUp(){
        switchTo().window(1);
        Assert.assertTrue(facebookPopUpPage.fb.isDisplayed());
        return this;
    }
}
