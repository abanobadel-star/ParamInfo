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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;

public class TestBase {

    public static WebDriver driver;
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
        driver.get(prop.getProperty("URL"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
    @AfterMethod
    public void takeScreenShotAfterTestFail(ITestResult testResult) throws IOException {
        if(testResult.getStatus() == ITestResult.FAILURE) {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest=new File("errorScreenShot/"+ testResult.getName()+ ".png");
            FileUtils.copyFile(scrFile, dest);
        }
    }
}
