package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WebDriverActions;

import java.util.List;

public class FunctionalitiesPage extends WebDriverActions {

    private WebDriver driver;

    public FunctionalitiesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(text(),'Add Element')]") private WebElement btn_addElement;
    String btn_deleteElement = "//button[contains(text(),'Delete')]";
    @FindBy(xpath = "//button[contains(text(),'Delete')]") private List<WebElement> lst_deleteElements;

    public void validateAddElements(int count) {
        for (int i=0; i<count; i++) {
            clickElementByJS(driver, btn_addElement);
        }
        if (lst_deleteElements.size() == count) {
            stepPass("Delete button count matches");
        } else {
            stepFail("Delete button count doesn't match");
        }
    }

    public void validateRemoveElements() {
        for (WebElement element:lst_deleteElements) {
            clickElementByJS(driver, element);
        }
        if (!isDisplayed(btn_deleteElement)) {
            stepPass("All elements deleted successfully");
        } else {
            stepFail("Elements are not deleted successfully");
        }
    }

}
