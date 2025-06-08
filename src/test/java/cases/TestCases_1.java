package cases;

import org.testng.annotations.Test;
import pages.HomePage;
import utilities.WebDriverUtilities;

public class TestCases_1 extends WebDriverUtilities {

    @Test
    public void TC_1() {
        createTest("Test Case 1");
        HomePage homePage = new HomePage(driver);
        homePage.selectListOption("A/B Testing");
        navigateBack();
    }
}
