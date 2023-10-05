package Steps;

import Pages.MainSwoopPage;
import io.qameta.allure.Step;

public class MainSwoopPageSteps {
    MainSwoopPage mainSwoopPage = new MainSwoopPage();

    @Step("clicking on dasveneba")
    public MainSwoopPageSteps clickDasveneba(){
        mainSwoopPage.dasveneba.click();
        return this;

    }

    @Step("clicking on Category button")
    public MainSwoopPageSteps clickOnCategory(){
        mainSwoopPage.categoriesTitleElement.click();
        return this;
    }

    @Step("hover on")
    public MainSwoopPageSteps hoverOn(){
        mainSwoopPage.elementToHover.hover();
        return this;
    }

    @Step("clickOnSushi step")
    public MainSwoopPageSteps clickOnSushi(){
        mainSwoopPage.sushi.click();
        return this;
    }

    @Step("clickOnShesvla step")
    public MainSwoopPageSteps clickOnShesvla(){
        mainSwoopPage.shesvlabutton.click();
        return this;
    }
}
