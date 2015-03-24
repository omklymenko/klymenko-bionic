package negative;

import entities.Advertisement;
import functional.AbstractTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AdvertisementPage;
import pages.HomePage;
import pages.PreviewPage;

/**
 * Created by Елена on 15.03.2015.
 */
public class NegativeAdvTest extends AbstractTest {
    @DataProvider
    public Object[][] negativeAdv() {
        return new Object[][] {
                new Object[] {"new", " ", "Неимоверно нежное изысканное выпускное)", "Е", "ttt"},
        };
    }
    @Test(dataProvider = "negativeAdv")
    public void createAdv(String title, String price, String desc, String user, String email)
    {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        AdvertisementPage advertisementPage = new AdvertisementPage(driver);
        advertisementPage.createAdvertisement();
        Advertisement adv = new Advertisement();
        adv.title = title;
        adv.desc = desc;
        adv.price = price;
        adv.user = user;
        adv.email = email;
        AdvertisementPage advPage = new AdvertisementPage(driver);
        advertisementPage.setAdv(adv);
        advertisementPage.preview();
        Assert.assertTrue(advPage.isError(), "negativeAdvTest FAILED");
    }
}
