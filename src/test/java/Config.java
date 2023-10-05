import com.codeborne.selenide.Screenshots;
import io.qameta.allure.Attachment;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.nio.file.Files;

public class Config  implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        takeScreenshot();
        saveLogs(result.getThrowable().toString());
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] takeScreenshot() {
        try {
            return Files.readAllBytes(Screenshots.takeScreenShotAsFile().toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    @Attachment(value = "Stacktrace", type = "text/plain")
    public String saveLogs(String message) {
        return message;
    }
}
