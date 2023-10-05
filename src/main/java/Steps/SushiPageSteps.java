package Steps;

import Pages.SushiPage;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.asserts.SoftAssert;


import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SushiPageSteps {
    SushiPage sushiPage = new SushiPage();
   public SoftAssert softAssert = new SoftAssert();


    @Step("clickFavorite step")
    public SushiPageSteps clickFavorite(){
        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
        js.executeScript("window.scrollBy(0, 100);");
       SelenideElement firstSushi = sushiPage.allSushi.get(0);
       SelenideElement favoriteButton = firstSushi.$(".deal-box-wishlist");
       favoriteButton.click();
        return this;

    }

    @Step("loginValidation step")
    public SushiPageSteps loginWindowValidation(){
        softAssert.assertTrue(sushiPage.login.isDisplayed(),"login popup is not displayed");
        return this;

    }

    @Step("vouchersValidation step")
    public SushiPageSteps vouchersValidation(){
       String widthValue = sushiPage.voucherElement.getAttribute("data-width");
        int procentOfSoldVouechers = Integer.parseInt(widthValue);
        softAssert.assertTrue(procentOfSoldVouechers<100);
        return this;
    }

    @Step("click sorting")
    public SushiPageSteps clickSort(){
        sushiPage.sortButton.click();
        return this;
    }

    @Step("click descent")
    public SushiPageSteps clickDescent(){
        sushiPage.descentPrice.click();
        return this;
    }

    @Step("getFirstPrice step")
    public String getFirstPrice(){
        SelenideElement first = sushiPage.allSushi.get(0);
        SelenideElement firstPrice = first.$(".deal-description").$(".voucher-counts").$(".discounted-prices")
                .$(".deal-voucher-price");
        String strFirst = firstPrice.getText();
        return strFirst;
    }

    @Step("getSecondPrice step")
    public String getSecondPrice(){
        SelenideElement second = sushiPage.allSushi.get(1);
        SelenideElement firstPrice = second.$(".deal-description").$(".voucher-counts").$(".discounted-prices")
                .$(".deal-voucher-price");
        String strsSecond = firstPrice.getText();
        return strsSecond;

    }

    @Step("checking step")
    public SushiPageSteps checking(){
        int firstPrice = Integer.parseInt(getFirstPrice().replaceAll("[^0-9]+", ""));
        int secondPrice = Integer.parseInt(getSecondPrice().replaceAll("[^0-9]+", ""));
        softAssert.assertTrue(firstPrice>secondPrice);
        return this;
    }

    @Step("clickFirstSushi step")
    public SushiPageSteps clickFirstSushi(){
        sushiPage.allSushi.get(0).click();
        return this;
    }





}
