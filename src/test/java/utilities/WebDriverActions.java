package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebDriverActions extends ExtentReportManager {

    public static WebDriver driver;

    public void clickElement(WebElement element) {
        try {
            element.click();
            stepInfo("Click action performed successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            stepFail("Click action was not successful.");
        }
    }

    public void clickElement(String xpath) {
        try {
            driver.findElement(By.xpath(xpath)).click();
            stepInfo("Click action performed successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            stepFail("Click action was not successful.");
        }
    }

    public void navigateBack() {
        driver.navigate().back();
    }

}
