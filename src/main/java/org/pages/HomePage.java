package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageBase {

    /**
     * constructor
     *
     * @param driver the driver
     */
    public HomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * list Of Country Arrow.
     */
    private By listOfCountryArrow = By.id("arrow");

    /**
     * egypt Country Image.
     */
    private By egyptCountryImage = By.cssSelector("#eg");

    /**
     * UAE Country Image.
     */
    private By uAECountryImage = By.cssSelector("#ae");

    /**
     * jordan Country Image.
     */
    private By jordanCountryImage = By.cssSelector("#jo");

    /**
     * subscription Type.
     */
    private By subscribeType = By.cssSelector("div[class='trial-description'] h4");


    /**
     * price of the subscription.
     */
    private By priceOFSubscription = By.cssSelector("div[class='trial-cost'] b");

    /**
     * currency of the subscription.
     */
    private By currencyOFSubscription = By.cssSelector("div[class='trial-cost']");

    /**
     * get List Of Country Arrow.
     * @return listOfCountryArrow
     */
    public By getListOfCountryArrow() {
        return listOfCountryArrow;
    }

    /**
     * get Egypt Country Image.
     * @return egyptCountryImage
     */
    public By getEgyptCountryImage() {
        return egyptCountryImage;
    }

    /**
     * get UAE Country Image.
     * @return uAECountryImage
     */
    public By getuAECountryImage() {
        return uAECountryImage;
    }

    /**
     * get Jordan Country Image.
     * @return jordanCountryImage
     */
    public By getJordanCountryImage() {
        return jordanCountryImage;
    }

    /**
     * get Subscribe Type.
     * @return subscribeType
     */
    public By getSubscribeType() {
        return subscribeType;
    }

    /**
     * get Price OF Subscription.
     * @return priceOFSubscription
     */
    public By getPriceOFSubscription() {
        return priceOFSubscription;
    }
    /**
     * get currency OF Subscription.
     * @return currencyOFSubscription
     */
    public By getCurrencyOFSubscription() {
        return currencyOFSubscription;
    }
}
