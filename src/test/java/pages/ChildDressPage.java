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
    public ChildDressPage(Browser driver) {
        super(driver);
    }

    public void state() {
        driver.findElement(By.xpath(".//*[@id='param_state']/div/a/span[1]")).click();
        driver.findElement(By.cssSelector("label[data-value='new']")).click();
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector(".listOverlay>div"))));
        //driver.findElement(By.id("search-submit")).click();

    }

    public void openOffer() {
        driver.findElement(By.xpath(".//*[@id='offers_table']/tbody/tr[4]/td/table/tbody/tr/td[3]/h3/a/span")).click();
    }

    public boolean newIsChosen() {
        return driver.findElement(By.cssSelector("a[title*='Нові']")).isDisplayed();
    }
//    public void price() {
//        //driver.findElement(By.xpath(".//*[@id='param_price']/div/div[2]/a/span[1]")).click();
//        //driver.findElement(By.xpath(".//*[@id='param_price']/div/div[2]/ul/li[2]/a")).click();
//        driver.findElement(By.xpath(".//*[@id='param_price']/div/div[1]/a/span[1]")).click();
//        driver.findElement(By.cssSelector("a[data-value='100']")).click();
//        driver.findElement(By.id("search-submit")).click();
//    }
    public void price() {
        driver.findElement(By.xpath(".//*[@id='param_price']/div/div[1]/a")).click();
        //driver.findElement(By.xpath(".//*[@id='param_price']/div/div[1]/a")).sendKeys("100 грн.");
        driver.findElement(By.xpath(".//*[@id='param_price']/div/div[1]/ul/li[1]/a")).click();
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector(".listOverlay>div"))));
        driver.findElement(By.xpath(".//*[@id='param_price']/div/div[2]/a")).click();
        driver.findElement(By.xpath(".//*[@id='param_price']/div/div[2]/ul/li[2]/a")).click();
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector(".listOverlay>div"))));
        driver.findElement(By.id("search-submit")).click();
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector(".listOverlay>div"))));
    }

    public boolean checkPrice() {
        //for (int j = 0; j < 44; j++) {

        List<WebElement> elements = driver.findElements(By.className("td-price"));
        Boolean ok = false;
        for (int i = 0; i < elements.size(); i++) {
            String s = (elements.get(i).getText().split("\\s+"))[0];
            if (Integer.parseInt(s) < 500 && Integer.parseInt(s) > 100)
                ok = true;
        }
        //  driver.navigate().back();
        return ok;
    }
}
