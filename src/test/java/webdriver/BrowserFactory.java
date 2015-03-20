package webdriver;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import utils.PropertyLoader;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class BrowserFactory {
    public static final String CHROME = "chrome";
    public static final String FIREFOX = "firefox";
    public static Browser create(String browser)
    {
        Browser driver = null;
        if (browser.equals(FIREFOX))
        {
            driver = new Browser(new FirefoxDriver());
        } else
        if (browser.equals(CHROME))
        {
            String filePath = "/src/main/resources/chromedriver.exe";
            File file = new File(PropertyLoader.loadProperty("project.path")+filePath);
            System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
            driver = new Browser(new ChromeDriver());
        } else
            Assert.fail("No configuration available for driver");
        return new Browser(driver);
    }
}
