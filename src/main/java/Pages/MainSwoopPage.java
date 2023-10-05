package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MainSwoopPage {

    public SelenideElement dasveneba = $(By.linkText("დასვენება")),
                           categoriesTitleElement = $("p.categoriesTitle"),
                           elementToHover = $("a.mainCategories[href='/category/15/restornebi-da-barebi']"),
                           sushi = $(byAttribute("href", "/category/235/restornebi-da-barebi/sushi")),
                           shesvlabutton = $(byText("შესვლა"));;
    ;



}
