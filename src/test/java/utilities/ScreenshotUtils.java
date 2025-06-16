package utilities;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ScreenshotUtils {

    public static String captureScreenshot(WebDriver driver) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String random = String.valueOf(new Random().nextInt(1000));
        String fileName = "Screenshot_" + timestamp + "_" + random + ".png";
        String screenshotDir = System.getProperty("user.dir") + "/test-output/screenshots/";
        File dest = new File(screenshotDir + fileName);

        try {
            Files.createDirectories(dest.getParentFile().toPath());
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dest.getAbsolutePath();
    }

    public static Media reportScreenshot(WebDriver driver) {
        try {
            String fullPath = captureScreenshot(driver);
            return MediaEntityBuilder.createScreenCaptureFromPath(fullPath).build();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
