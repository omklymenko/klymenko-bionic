package functional;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ChildDressPage;
import pages.ChildPage;
import pages.HomePage;
import pages.SearchPage;
import webdriver.Browser;

import java.util.concurrent.TimeUnit;

/**
 * Created by Елена on 14.03.2015.
 */
public class FilteringTest extends AbstractTest {
    Logger logger = LoggerFactory.getLogger(FilteringTest.class);
    private static final By searchField = By.id("headerSearch");
    private static final By searchButton = By.id("submit-searchmain");
    @Test
    public void searchTest()
    {
        logger.info("Search test");
        HomePage homePage = new HomePage(driver);
        homePage.open();
        driver.findElement(searchField).sendKeys("BMW");
        driver.findElement(searchButton).click();
        SearchPage searchPage = new SearchPage(driver);
        Assert.assertTrue(searchPage.isPresent());
    }
    @Test
    public void stateNew(){
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.openDetskiyMir();
        ChildPage childPage = new ChildPage(driver);
        childPage.openOdezhda();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ChildDressPage childDressPage = new ChildDressPage(driver);
//        WebDriverWait wait = new WebDriverWait(driver,20);
//        wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector(".listOverlay>div"))));
        childDressPage.state();
        //Assert.assertTrue(driver.getCurrentUrl().contains("[filter_enum_state][0]=new"));
//        (new WebDriverWait(driver, 10))
//                .until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector(".listOverlay>div"))));
        childDressPage.openOffer();
        Assert.assertTrue(childDressPage.newIsChosen());

    }
    @Test
    public void priceFilter(){
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.openDetskiyMir();
        ChildPage childPage = new ChildPage(driver);
        childPage.openOdezhda();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ChildDressPage childDressPage = new ChildDressPage(driver);
        childDressPage.price();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        childDressPage.checkPrice();
    }

    public void openDetskiyMir()
    {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.openDetskiyMir();
        ChildPage childPage = new ChildPage(driver);
        Assert.assertTrue(childPage.isOpened());
    }

//    public void openDetskayaOdezhda()
//    {
//        ChildDressPage childDressPage = new ChildDressPage(driver);
//        childDressPage.state();
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        childDressPage.openOffer();
//    }
}
