//package StepDef;
//
//import io.cucumber.java.*;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.time.Duration;
//import java.util.Properties;
//
//public class Hooks {
//
//    public static WebDriver driver; // Instance level driver
//    public static Properties prop = new Properties();
//    static String configPath = System.getProperty("user.dir") + "\\src\\test\\java\\configuration\\config.properties";
//
//    @Before
//    public void startDriver() {
//        // Load properties before using them
//        try {
//            FileInputStream file = new FileInputStream(configPath);
//            prop.load(file);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        WebDriverManager.firefoxdriver().setup();
//        System.out.println("firefoxdriver is set up.");
//        driver = new FirefoxDriver();  // Initialize the WebDriver instance
//        String url = prop.getProperty("URL");
//        System.out.println("url ::" + url);
//        if (url != null && !url.isEmpty()) {
//            driver.get(url);
//        } else {
//            System.out.println("URL is not defined in config.properties");
//        }
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
//    }
//
//    @After
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//
//    // Getter method for driver if needed in other steps
//    public WebDriver getDriver() {
//        return driver;
//    }
//}
