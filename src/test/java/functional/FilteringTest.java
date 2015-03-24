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
    @Test
    public void searchTest()
    {
        logger.info("Search test");
        HomePage homePage = new HomePage(driver);
        homePage.open();
        SearchPage searchPage = new SearchPage(driver);
        searchPage.itemSearch();
        Assert.assertTrue(searchPage.isPresent(), "searchTest FAILED");
    }
    @Test
    public void stateNew(){
        logger.info("State test");
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.openDetskiyMir();
        ChildPage childPage = new ChildPage(driver);
        childPage.openOdezhda();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ChildDressPage childDressPage = new ChildDressPage(driver);
        childDressPage.state();
        childDressPage.openOffer();
        Assert.assertTrue(childDressPage.newIsChosen(), "stateTest FAILED");
    }
    @Test
    public void priceFilter(){
        logger.info("Price test");
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.openDetskiyMir();
        ChildPage childPage = new ChildPage(driver);
        childPage.openOdezhda();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ChildDressPage childDressPage = new ChildDressPage(driver);
        childDressPage.price();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        childDressPage.checkPrice();
    }
}
