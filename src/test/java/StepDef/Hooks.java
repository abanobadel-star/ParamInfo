package StepDef;

import io.cucumber.java.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Hooks {
    public static WebDriver driver;
    public static Properties prop;
    static String configPath = System.getProperty("user.dir") + "\\src\\test\\java\\configuration\\config.properties";

    public Hooks() throws IOException {
        prop = new Properties();
        FileInputStream file = new FileInputStream(configPath);
        prop.load(file);
    }

    @Before
    public static void startDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.get(prop.getProperty("URL"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @After
    public static void tearDown() {
        driver.quit();
    }
}
