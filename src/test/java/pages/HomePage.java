package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.WebDriverUtilities;

import java.util.List;

public class HomePage extends WebDriverUtilities {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    String lst_listElement = "(//div[@id='content']//li/a)[%s]";

    public void selectListOption(String optionName) {
        List<WebElement> lst_listElements = driver.findElements(By.xpath("//div[@id='content']//li/a"));
        for (int i=1; i<=lst_listElements.size(); i++) {
            if (driver.findElement(By.xpath(String.format(lst_listElement, 1))).getText().equalsIgnoreCase(optionName)) {
                clickElement(String.format(lst_listElement, i));
                break;
            }
        }
    }

}
