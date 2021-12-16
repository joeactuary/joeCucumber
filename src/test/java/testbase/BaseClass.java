package testbase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.ConfigReader;
import utils.Constants;

import java.util.concurrent.TimeUnit;

//import static utils.Constants.CONFIGURATION_FILEPATH;

public class BaseClass {
    public static WebDriver driver;

    public static void openUrl(String url) {
       // System.setProperty("webdriver.chrome.driver", "drivers/chromedriver94.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
    }

    //**********************************************************************************

    public static void openBrowser() {
        ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH);

        switch (ConfigReader.getPropertyValue("browser")) {

            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setHeadless(true);
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Invalid browser selection");
        }
        driver.get(ConfigReader.getPropertyValue("url"));
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);

    }


    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
