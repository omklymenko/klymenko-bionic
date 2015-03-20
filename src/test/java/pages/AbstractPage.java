package pages;

import webdriver.Browser;

/**
 * Created by Елена on 14.03.2015.
 */
public class AbstractPage {
    protected Browser driver;

    public AbstractPage(Browser driver) {
        this.driver = driver;
    }
}
