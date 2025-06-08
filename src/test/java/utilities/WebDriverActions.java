package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebDriverActions extends ExtentReportManager {

    public static WebDriver driver;

    public void clickElement(WebElement element) {
        try {

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

    public void clickElementByJS(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public Boolean isDisplayed(String xpath) {
        try {
            if (driver.findElements(By.xpath(xpath)).size() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public void navigateToURL(String url) {
        driver.get(url);
    }

}
