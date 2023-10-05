package Pages;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class VacationPage {
    public SelenideElement
            divMinAndMax = $(".category-filter-desk .price-inputs"),
            minPrice = divMinAndMax.$("input[name='minprice']"),
            maxPrice = divMinAndMax.$("input[name='maxprice']"),
            submit = $(".category-filter-desk .submit-button"),
            loader = $(".loader");
    public List<SelenideElement> hotelList = $$(".deal-description");
}
