package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageBase {

    protected WebDriver driver;
    /**
     * constructor
     * @param driver the driver
     */
    public PageBase (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
