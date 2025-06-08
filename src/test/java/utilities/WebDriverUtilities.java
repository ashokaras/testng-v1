package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class WebDriverUtilities extends WebDriverActions {

    @BeforeTest
    public void launchBrowser() {
        WebDriverManager.chromedriver().getWebDriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
    }

    @AfterTest
    public void quitBrowser() {
        driver.quit();
    }


}
