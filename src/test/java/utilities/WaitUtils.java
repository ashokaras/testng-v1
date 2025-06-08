package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utilities.WebDriverActions.driver;

public class WaitUtils {

    public static void waitUntilElementDisplayed(WebElement element, int waitTime) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
