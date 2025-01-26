package org.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {
    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    public static Properties prop;
    static String configPath = System.getProperty("user.dir") + "\\src\\test\\java\\configuration\\config.properties";

    public TestBase() throws IOException {
        prop = new Properties();
        FileInputStream file = new FileInputStream(configPath);
        prop.load(file);
    }
    @Parameters({"browser"})
    @BeforeMethod
    public void startDriver(@Optional("chrome") String browserName) {
        WebDriver driver = null;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
        }
        else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else if (browserName.equalsIgnoreCase("internetExplorer")) {
            WebDriverManager.edgedriver().setup();
            driver = new InternetExplorerDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(prop.getProperty("URL"));
        driverThreadLocal.set(driver); // Store in ThreadLocal
    }

    @AfterMethod
    public void tearDown(ITestResult testResult) throws IOException {
        WebDriver driver = driverThreadLocal.get();
        if (testResult.getStatus() == ITestResult.FAILURE && driver != null) {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File("errorScreenShot/" + testResult.getName() + ".png");
            FileUtils.copyFile(scrFile, dest);
        }

        if (driver != null) {
            driver.quit();
            driverThreadLocal.remove();
        }
    }
    // Method to get the WebDriver instance for the current thread
    public WebDriver getDriver() {
        return driverThreadLocal.get();
    }
}
