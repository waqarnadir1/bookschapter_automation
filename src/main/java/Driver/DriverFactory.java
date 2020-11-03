package Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private static WebDriver driver;

    public WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "WebDrivers/chromedriver86.exe");
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        return driver;
    }

    public void closeDriver() {
        driver.close();
    }


}
