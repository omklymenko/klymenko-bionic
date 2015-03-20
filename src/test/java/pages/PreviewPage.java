package pages;

import webdriver.Browser;

/**
 * Created by Елена on 15.03.2015.
 */

public class PreviewPage extends AbstractPage{
    public PreviewPage(Browser driver)
    {
        super(driver);
    }
    public boolean isOpened(){
        return (driver.getCurrentUrl().contains("preview")
                && driver.getCurrentUrl().contains("new-adv"));
    }
}
