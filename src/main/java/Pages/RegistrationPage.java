package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {
    public SelenideElement
            registrationButton = $(By.xpath("//p[@class='register' and text()='რეგისტრაცია']")),
            firstName = $("#pFirstName"),
            lastName = $("#pLastName"),
            Email = $("#pEmail"),
            phone = $("#pPhone"),
            birthDate = $("#pDateBirth"),
            password = $("#pPassword"),
            confirmPassword = $("#pConfirmPassword"),
            regButton = $("input[type='button'][value='რეგისტრაცია']"),
            infoMessage = $("#physicalInfoMassage");;
}
