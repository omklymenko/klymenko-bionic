package functional;

import entities.Advertisement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AdvertisementPage;
import pages.HomePage;
import pages.PreviewPage;

/**
 * Created by Елена on 15.03.2015.
 */
public class PositiveAdvTest extends AbstractTest{
    @DataProvider
    public Object[][] positiveAdv() {
        return new Object[][] {
                new Object[] {"new-adv", "500", "Неимоверно нежное изысканное выпускное платье Tony Bowls, удачное сочетание силуэта, отделки и оптимального объема пышной струящейся юбки создает некую таинственность и очарование.\n" +
                        "Размер 6\n" +
                        "\n" +
                        "Смотрите другие мои объявления,есть много интересного)", "Елена", "ttt.rrr@gmail.com"},
        };
    }
    @Test(dataProvider = "positiveAdv")
    public void createAdv(String title, String price, String desc, String user, String email)
    {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        AdvertisementPage advertisementPage = new AdvertisementPage(driver);
        advertisementPage.createAdvertisement();
        Advertisement adv = new Advertisement();
        adv.title = title;
        adv.price = price;
        adv.desc = desc;
        adv.user = user;
        adv.email = email;
        advertisementPage.TestFileUpload();
        AdvertisementPage advPage = new AdvertisementPage(driver);
        advPage.setAdv(adv);
        advertisementPage.preview();
        PreviewPage previewPage = new PreviewPage(driver);
        Assert.assertTrue(previewPage.isOpened(), "positiveAdvTest FAILED");
    }
}

