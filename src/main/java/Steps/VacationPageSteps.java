package Steps;

import Pages.VacationPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.asserts.SoftAssert;




import static com.codeborne.selenide.WebDriverRunner.getWebDriver;





public class VacationPageSteps {

    VacationPage vacationPage = new VacationPage();
    public SoftAssert softAssert = new SoftAssert();

    @Step("writMinPrice step")
    public VacationPageSteps writeMin(){
        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
        js.executeScript("window.scrollBy(0, 600);");
        vacationPage.minPrice.scrollIntoView(false).setValue("200");
        return this;
    }

    @Step("writeMaxPrice step")
    public VacationPageSteps writeMax(){
        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
        vacationPage.maxPrice.scrollIntoView(false).setValue("230");
        js.executeScript("window.scrollBy(0, 200);");
        return this;
    }

    @Step("clickSearch step")
    public VacationPageSteps  clickSearch(){
        vacationPage.submit.click();
        return this;
    }

    @Step("loader step")
    public VacationPageSteps loader(){
        vacationPage.loader.shouldNot(Condition.appear);
        return this;
    }

    @Step("priceValidation Step")
    public VacationPageSteps priceValidation(){
        vacationPage.hotelList.forEach(element->{
            SelenideElement elementClass = element.$(".outs-and-shorts");
            SelenideElement actualPrice = elementClass.$("p.deal-voucher-price");
            String text = actualPrice.getText();
            int price ;
            try {
                price = Integer.parseInt(text.replaceAll("[^0-9]+", ""));
                softAssert.assertTrue(price>200 && price <230, "Value is not within the range 200-230: " + price);
            } catch (NumberFormatException ex) {
                            }
        });
        return this;
    }

}
