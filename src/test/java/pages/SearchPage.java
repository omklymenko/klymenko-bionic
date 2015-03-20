package pages;

import org.openqa.selenium.By;
import webdriver.Browser;

/**
 * Created by Елена on 14.03.2015.
 */
public class SearchPage extends AbstractPage {
    public SearchPage(Browser driver) {
        super(driver);
    }
    public boolean isPresent()
    {

        return driver.findElement(By.cssSelector("a[href*='bmw']")).isDisplayed();
    }
}
