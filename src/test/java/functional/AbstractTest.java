package functional;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import utils.PropertyLoader;
import webdriver.Browser;
import webdriver.BrowserFactory;

/**
 * Created by Елена on 14.03.2015.
 */
public class AbstractTest {
    public Browser driver;

    @BeforeClass
    public void initEnv()
    {
        //driver = BrowserFactory.create(PropertyLoader.loadProperty("browser"));
        //driver = new Browser(new FirefoxDriver());
        driver = BrowserFactory.create(PropertyLoader.loadProperty("browser"));
    }

    @AfterClass
    public void shutEnv()
    {
        if (driver != null)
            driver.quit();
    }
}
