package Steps;

import Pages.FirstSushiPage;
import io.qameta.allure.Step;

public class FirstSushiPageSteps {
    FirstSushiPage firstSushiPage = new FirstSushiPage();

    @Step("clicking on share button")
    public FirstSushiPageSteps clickOnShare(){
        firstSushiPage.share.click();
        return this;
    }
}
