package pages;

import entities.Advertisement;
import org.openqa.selenium.By;
import webdriver.Browser;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class AdvertisementPage extends AbstractPage {
    private static final By createAdvertisementLink = By.id("post-new-ad");
    private static final By advTitle = By.id("add-title");
    private static final By advCategory = By.cssSelector("#targetrenderSelect1-0>dt>a");
    private static final By category = By.id("cat-36");
    private static final By childrenWorld = By.cssSelector("a[data-category = '69']");
    private static final By price = By.className("paramPriceInput");
    private static final By state = By.xpath(".//*[@id='targetparam13']/dt/a");
    private static final By chooseState = By.xpath(".//*[@id='targetparam13']/dd/ul/li[3]/a");
    private static final By ownerField = By.cssSelector("#targetid_private_business>dt>a");
    private static final By owner = By.xpath(".//*[@id='targetid_private_business']/dd/ul/li[2]/a");
    private static final By email = By.id("add-email");
    private static final By desc = By.id("add-description");
    private static final By user = By.id("add-person");
    private static final By regionList = By.cssSelector("#targetregion-id-select>dt>a");
    private static final By region = By.xpath(".//*[@id='targetregion-id-select']/dd/ul/li[2]/a");
    private static final By cityList = By.cssSelector("#targetsubregion-id-select>dt>a");
    private static final By city = By.xpath(".//*[@id='targetsubregion-id-select']/dd/ul/li[8]/a");
    private static final By agreement = By.cssSelector("label[for='agreement']");
    private static final By preview = By.id("preview-link");
    private static final By addFile = By.xpath(".//*[@id='add-file-1']/div/a");
    private static final By titleError = By.xpath(".//*[@id='title']/div[2]/div/div/p[2]");
    private static final By descriptionError = By.xpath(".//*[@id='description']/div[2]/div/div/p/label");


    public AdvertisementPage(Browser driver) {
        super(driver);
    }
    public void createAdvertisement() {
        Advertisement adv = new Advertisement();
        driver.findElement(createAdvertisementLink).click();
        driver.findElement(advTitle).sendKeys(adv.title);
        driver.findElement(advCategory).click();
        driver.findElement(category).click();
        driver.findElement(childrenWorld).click();
        driver.findElement(price).sendKeys(adv.price);
        driver.findElement(state).click();
        driver.findElement(chooseState).click();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.findElement(ownerField).click();
        driver.findElement(owner).click();
        driver.findElement(desc).sendKeys(adv.desc);
        driver.findElement(regionList).click();
        driver.findElement(region).click();
        driver.findElement(cityList).click();
        driver.findElement(city).click();
        driver.findElement(user).sendKeys(adv.user);
        driver.findElement(email).sendKeys(adv.email);
        driver.findElement(agreement).click();

    }
    public static void setClipboardData(String string) {
        StringSelection stringSelection = new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    }

    public void TestFileUpload() {
        {
            driver.findElement(addFile).click();
            Advertisement adv = new Advertisement();
            setClipboardData(adv.photoFilePath);

            Robot robot = null;
            try {
                robot = new Robot();
            } catch (AWTException e) {
                e.printStackTrace();
            }
            robot.setAutoDelay(900);

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);

            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        }
    }
    public void setAdv(Advertisement adv)
    {
        driver.findElement(advTitle).sendKeys(adv.title);
        driver.findElement(desc).sendKeys(adv.desc);
        driver.findElement(price).sendKeys(adv.price);
        driver.findElement(user).sendKeys(adv.user);
        driver.findElement(email).sendKeys(adv.email);

    }
    public void preview(){
        driver.findElement(preview).click();
    }
    public boolean isError()
    {
        return(driver.findElement(titleError).isDisplayed()&&driver.findElement(descriptionError).isDisplayed());
    }
}
