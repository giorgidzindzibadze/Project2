package Pages;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SushiPage {
    public List<SelenideElement> allSushi = $$(".special-offer");
    public SelenideElement login =$(".login-register-outer"),
                            voucherElement = $(".voucher-limit"),
                            sortButton = $("#sort"),
                            descentPrice = $("option[value='1']"),

                            price= $(".deal-description").$(".voucher-counts")
                                    .$(".discounted-prices")
                                    .$(".deal-voucher-price");
}
