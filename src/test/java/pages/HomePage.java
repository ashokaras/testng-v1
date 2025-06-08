package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.WebDriverUtilities;

import java.util.List;

public class HomePage extends WebDriverUtilities {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    String lst_listElement = "(//div[@id='content']//li/a)[%s]";

    public void selectListOption(String optionName) {
        try {
            List<WebElement> lst_listElements = driver.findElements(By.xpath("//div[@id='content']//li/a"));
            for (WebElement element : lst_listElements) {
                if (element.getText().equalsIgnoreCase(optionName)) {
                    clickElementByJS(driver, element);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
