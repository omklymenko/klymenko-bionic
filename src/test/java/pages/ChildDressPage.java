package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.Browser;

import java.util.List;

/**
 * Created by Елена on 14.03.2015.
 */
public class ChildDressPage extends AbstractPage {
    private static final By paramState = By.xpath(".//*[@id='param_state']/div/a/span[1]");
    private static final By stateNew = By.cssSelector("label[data-value='new']");
    private static final By offer = By.xpath(".//*[@id='offers_table']/tbody/tr[4]/td/table/tbody/tr/td[3]/h3/a/span");
    private static final By newChosen = By.cssSelector("a[title*='Нові']");
    private static final By lowerPricelist = By.xpath(".//*[@id='param_price']/div/div[1]/a");
    private static final By lowerPrice = By.xpath(".//*[@id='param_price']/div/div[1]/ul/li[1]/a");
    private static final By upperPricelist = By.xpath(".//*[@id='param_price']/div/div[2]/a");
    private static final By upperPrice = By.xpath(".//*[@id='param_price']/div/div[2]/ul/li[2]/a");
    private static final By waitElement = By.cssSelector(".listOverlay>div");
    private static final By submitB = By.id("search-submit");
    private static final By findPrice = By.className("td-price");

    public ChildDressPage(Browser driver) {
        super(driver);
    }

    public void state() {
        driver.findElement(paramState).click();
        driver.findElement(stateNew).click();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        WebDriverWait wait = new WebDriverWait(driver,20);
//        wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector(".listOverlay>div"))));
    }

    public void openOffer() {
        driver.findElement(offer).click();
    }

    public boolean newIsChosen() {
        return driver.findElement(newChosen).isDisplayed();
    }

    public void price() {
        driver.findElement(lowerPricelist).click();
        driver.findElement(lowerPrice).click();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        (new WebDriverWait(driver, 10))
//                .until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector(".listOverlay>div"))));
        driver.findElement(upperPricelist).click();
        driver.findElement(upperPrice).click();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        (new WebDriverWait(driver, 10))
//                .until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector(".listOverlay>div"))));
        driver.findElement(submitB).click();
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.stalenessOf(driver.findElement(waitElement)));
    }

    public boolean checkPrice() {
        List<WebElement> elements = driver.findElements(findPrice);
        Boolean ok = false;
        for (int i = 0; i < elements.size(); i++) {
            String s = (elements.get(i).getText().split("\\s+"))[0];
            if (Integer.parseInt(s) < 500 && Integer.parseInt(s) > 100)
                ok = true;
        }
        return ok;
    }
}
