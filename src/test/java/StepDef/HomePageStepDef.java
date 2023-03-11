package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.pages.HomePage;
import org.testng.Assert;

import java.io.IOException;

import static StepDef.Hooks.driver;
import static StepDef.Hooks.startDriver;

public class HomePageStepDef {

    HomePage homePage;
    Hooks hooks ;
    public HomePageStepDef() {
    }

    @Given("user in Home Page")
    public void userInHomePage() throws IOException {
        hooks = new Hooks();
        homePage = new HomePage(driver);
    }

    @When("user open country list")
    public void userOpenCountryList() {
        driver.findElement(homePage.getListOfCountryArrow()).click();
    }

    @And("user select country {string}")
    public void userSelectCountry(String nameOfCountry) {
        driver.findElement(By.cssSelector(nameOfCountry)).click();
    }

    @Then("verify price for subscription is {string}")
    public void verifyPriceForSubscriptionIs(String priceOFSubscription) {
        Assert.assertEquals(
            driver.findElement(homePage.getPriceOFSubscription()).getText(), priceOFSubscription);
    }

    @Then("verify Type for subscription is {string}")
    public void verifyTypeForSubscriptionIs(String typeOFSubscription) {
        Assert.assertEquals(
            driver.findElement(homePage.getSubscribeType()).getText(), typeOFSubscription);
    }
    @Then("verify currency for subscription is {string}")
    public void verifyCurrencyForSubscriptionIs(String currencyOFSubscription) {
        Assert.assertTrue(
            driver.findElement(homePage.getCurrencyOFSubscription()).getText().contains(currencyOFSubscription));
    }
}
