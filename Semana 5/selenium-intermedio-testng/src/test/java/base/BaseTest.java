package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utils.DriverFactory;

public abstract class BaseTest {
    protected WebDriver driver;


    @BeforeClass(alwaysRun = true)
    public void setUp() {
        driver = DriverFactory.createChromeDriver();
    }
    
    @BeforeMethod(alwaysRun = true)
    public void resetPage() {
        //driver = DriverFactory.createChromeDriver();
        //driver.get("https://testautomationpractice.blogspot.com/");
        driver.get("https://www.santander.com.mx/");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
