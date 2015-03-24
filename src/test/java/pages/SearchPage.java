package pages;

import org.openqa.selenium.By;
import webdriver.Browser;

/**
 * Created by Елена on 14.03.2015.
 */
public class SearchPage extends AbstractPage {
    private static final By hrefText = By.cssSelector("a[href*='bmw']");
    private static final By searchField = By.id("headerSearch");
    private static final By searchButton = By.id("submit-searchmain");
    public SearchPage(Browser driver) {
        super(driver);
    }
    public void itemSearch()
    {
        driver.findElement(searchField).sendKeys("BMW");
        driver.findElement(searchButton).click();
    }
    public boolean isPresent()
    {

        return driver.findElement(hrefText).isDisplayed();
    }
}
