package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageBase {

    /**
     * constructor
     * @param driver the driver
     */
    public PageBase (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
