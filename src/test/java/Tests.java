import Steps.*;
import com.codeborne.selenide.testng.SoftAsserts;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import java.sql.SQLException;


@Epic("Swoop Website Tests")
@Listeners({SoftAsserts.class, Config.class})
public class Tests extends ConfigTest{

    MainSwoopPageSteps mainSwoopPageSteps = new MainSwoopPageSteps();

    VacationPageSteps vacationPageSteps = new VacationPageSteps();
    SushiPageSteps sushiPageSteps = new SushiPageSteps();
    FirstSushiPageSteps firstSushiPageSteps = new FirstSushiPageSteps();

    FacebookPopUpPageSteps facebookPopUpPageSteps = new FacebookPopUpPageSteps();
    RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps();
    SQLSteps sqlSteps = new SQLSteps();


    @Test(groups = "Regression1", description = "swoop page test")
    @Feature("Put price in range")
    @Story("Search and Validate that price is in range")
    @Description("this test opens swoop page and clicks on dasveneba, after it, " +
            "test scrolls down and write range of price, then clicks on search then load till the hotels are updated" +
            "and then validate that all hotels price are in the range.Finally there is written assertAll() command")
    public void Test1() {
        mainSwoopPageSteps.clickDasveneba();
        vacationPageSteps.writeMin()
                .writeMax()
                .clickSearch()
                .loader()
                .priceValidation()
                .softAssert.assertAll();
    }

    @Test(groups = "Regression1", description = "testing swoop page")
    @Feature("ADD Sushi in favorite")
    @Story("Select Sushi add in favorite and Validate that the vouchers are not sold out")
    @Description("this test clicks category button, hover on kveba and then it clicks on sushi, then it" +
            "clicks add favorite button and validates if login window is shown," +
            "then it validates if vouchers are sold out, finally there is a command assertAll(")
    public void Test2(){
        mainSwoopPageSteps.clickOnCategory()
                .hoverOn()
                .clickOnSushi();
        sushiPageSteps.clickFavorite()
                .loginWindowValidation()
                .vouchersValidation()
                .softAssert.assertAll();
    }

    @Test(groups = "Regression2", description = "testing swoop page sorting")
    @Feature("Price sorting")
    @Story("Sort and Check Sushi Listings")
    @Description("this test clicks category button, hover on kveba and then it clicks on sushi, then it" +
            "click sort button and sort sushi descent, " +
            "after it test checking if sorting works. finally there is assertAll() command")
    public void Test3(){
        mainSwoopPageSteps.clickOnCategory()
                             .hoverOn()
                                     .clickOnSushi();
        sushiPageSteps.clickSort()
                .clickDescent()
                .checking()
                .softAssert.assertAll();
    }


    @Test(groups = "Regression2", description = "facebook popup window validation")
    @Feature("Sushi Sharing")
    @Story("Try Share Sushi on Facebook")
    @Description("this test clicks category button, hover on kveba and then it clicks on sushi, then it" +
            "clicks first sushi and then clicks share button, after it test checks if facebook popup" +
            "window is shown")
    public void Test4 (){
        mainSwoopPageSteps.clickOnCategory()
                .hoverOn()
                .clickOnSushi();
        sushiPageSteps.clickFirstSushi();
        firstSushiPageSteps.clickOnShare();
        facebookPopUpPageSteps.checkPopUp();

    }


    @Test(groups = "Regression2", description = "testing with database")
    @Feature("User Registration")
    @Story("Register User with SQL Integration")
    @Description("this test opens swoop page than clicks on shesvla button and then registration button," +
            "after it, test execute inserting and selecting steps and then put appropriate arguments in the fields" +
            "then clicks registration button and validate that  გთხოვთ აირჩიოთ სქესი! is shown ")
    public void Test5() throws SQLException{
        mainSwoopPageSteps.clickOnShesvla();
        registrationPageSteps.clickOnRegistrationButton();
        sqlSteps.inserting()
                .selecting()
                .sendName()
                .sendLastName()
                .sendEmail()
                .sendPhoneNumber()
                .sendBirthDate()
                .sendPassword()
                .confirmPassword()
                .deletingLastAddedRow();

        registrationPageSteps.clickRegistration()
                .textValidation();
    }
}
