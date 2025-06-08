package cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FunctionalitiesPage;
import pages.HomePage;
import utilities.WebDriverUtilities;

import static utilities.WaitUtils.waitUntilElementDisplayed;

public class TestCases_1 extends WebDriverUtilities {

    WebDriver localDriver;

    HomePage homePage;
    FunctionalitiesPage functionalitiesPage;

    @FindBy(xpath = "//h1[@class='heading']") private WebElement lbl_homePageTitle;

    @BeforeMethod
    public void setup() {
        localDriver = driver; // 'driver' from WebDriverUtilities (initialized in @BeforeTest)
        PageFactory.initElements(localDriver, this);
        homePage = new HomePage(localDriver);
        functionalitiesPage = new FunctionalitiesPage(localDriver);
    }

//    @Test
//    public void TC_1() {
//        createTest("Test Case 1");
//        homePage.selectListOption("A/B Testing");
//        navigateToURL("https://the-internet.herokuapp.com/");
//        waitUntilElementDisplayed(lbl_homePageTitle, 5);
//    }

    @Test
    public void TC_2() {
        createTest("Test Case 2");
        homePage.selectListOption("Add/Remove Elements");
        functionalitiesPage.validateAddElements(3);
        functionalitiesPage.validateRemoveElements();
        navigateBack();
    }

}
