import com.codeborne.selenide.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;



import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Configuration.downloadsFolder;
import static com.codeborne.selenide.Selenide.open;

public class ConfigTest {
//    public static WebDriver driver;

    @BeforeTest(groups = {"Regression1","Regression2"})
    public void SelenideTests() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        browserCapabilities = options;
        browserSize = null;
        open("https://www.swoop.ge/");

        timeout = 10000;
        holdBrowserOpen = false;
        screenshots = true;
        reopenBrowserOnFail = true;
        downloadsFolder = "src/main/resources/Pictures";
        Configuration.assertionMode = AssertionMode.SOFT;
        fileDownload = FileDownloadMode.HTTPGET;
        downloadsFolder = "src/main/resources/images";

    }

    @AfterTest(groups = {"Regression1", "Regression2"})
    public void closeBrowser() {
        WebDriverRunner.closeWebDriver();
    }
}

