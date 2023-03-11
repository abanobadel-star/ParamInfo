package org.tests;

import org.openqa.selenium.By;
import org.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class SubscriptionPackages extends TestBase{

    public SubscriptionPackages() throws IOException {
        super();
    }

    /**
     * home page object.
     */
    HomePage homePage;

    /**
     * test cases to verify price for subscription for specific country.
     * @param nameOfCountry name of country
     * @param locatorsOFTheCountry the locator of the country
     * @param typeOfSubscription type of the subscription
     * @param priceOfSubscription price of the subscription
     * @param currencyOfSubscription currency of the subscription
     */
    @Test(priority = 0,dataProvider = "Country-List-Test-Data",
        description = "Verify price of subscription for country")
    public void checkPriceSubscriptionVeryCountry( String nameOfCountry, By locatorsOFTheCountry,
            String typeOfSubscription, String priceOfSubscription, String currencyOfSubscription) {
        homePage = new HomePage(driver);
        driver.findElement(homePage.getListOfCountryArrow()).click();
        driver.findElement(locatorsOFTheCountry).click();
        Assert.assertEquals(driver.findElement(homePage.getPriceOFSubscription()).getText(),priceOfSubscription);
    }

    /**
     * test cases to verify type for subscription for specific country.
     * @param nameOfCountry name of country
     * @param locatorsOFTheCountry the locator of the country
     * @param typeOfSubscription type of the subscription
     * @param priceOfSubscription price of the subscription
     * @param currencyOfSubscription currency of the subscription
     */
    @Test(priority = 1, dataProvider = "Country-List-Test-Data",
        description = "Verify type of subscription for country")
    public void checkTypeOFSubscriptionVeryCountry(
        String nameOfCountry, By locatorsOFTheCountry, String typeOfSubscription,
        String priceOfSubscription, String currencyOfSubscription) {
        homePage = new HomePage(driver);
        driver.findElement(homePage.getListOfCountryArrow()).click();
        driver.findElement(locatorsOFTheCountry).click();
        Assert.assertEquals(driver.findElement(homePage.getSubscribeType()).getText(),typeOfSubscription);
    }

    /**
     * test cases to verify Currency for subscription for specific country.
     * @param nameOfCountry name of country
     * @param locatorsOFTheCountry the locator of the country
     * @param typeOfSubscription type of the subscription
     * @param priceOfSubscription price of the subscription
     * @param currencyOfSubscription currency of the subscription
     */
    @Test(priority = 2, dataProvider = "Country-List-Test-Data",
        description = "Verify currency of subscription for country")
    public void checkCurrencySubscriptionVeryCountry( String nameOfCountry, By locatorsOFTheCountry,
           String typeOfSubscription, String priceOfSubscription, String currencyOfSubscription) {
        homePage = new HomePage(driver);
        driver.findElement(homePage.getListOfCountryArrow()).click();
        driver.findElement(locatorsOFTheCountry).click();
        Assert.assertTrue(
            driver.findElement(homePage.getCurrencyOFSubscription()).getText().contains(currencyOfSubscription));
    }

    /**
     * Gets the test data.
     *
     * @return the test data
     */
    @DataProvider(name = "Country-List-Test-Data")
    public Object[][] countryListTestData() {
        Object[][] data = new Object[][] {
            {"Egypt", By.cssSelector("#eg"),"CLASSIC","10.00"," Egyptian pound"},
            {"UAE", By.cssSelector("#ae"),"CLASSIC","10.00","AED"},
            {"Jordon", By.cssSelector("#jo"),"CLASSIC","0.99","JOD"}
        };
        return data;
    }
}
