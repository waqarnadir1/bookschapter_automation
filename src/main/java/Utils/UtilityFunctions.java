package Utils;

import Driver.Config;
import Driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilityFunctions extends DriverFactory {

    public WebDriver driver;

    public UtilityFunctions() {
        driver = getDriver();
    }

    public boolean openPage(String url) {
        try {
            driver.get(url);
            waitForPageLoad();
            return true;
        } catch (Exception e) {
            System.out.println("URL is not in correct format" + e);
        }
        return false;
    }

    public boolean openPageJS(String url) {
        try {
            String openPageScript = "window.location='" + url + "'";
            ((JavascriptExecutor) driver).executeScript(openPageScript);
            waitForPageLoad();
            return true;
        } catch (Exception e) {
            System.out.println("URL is not in correct format" + e);
        }
        return false;
    }

    public boolean click(By elementLocator) {
        WebElement element = checkElementVisibility(elementLocator, Config.defaultWaitTimeInSec);
        if (element == null) {
            return false;  // element not visible
        }
        element.click();
        return true;
    }

    public String getText(By elementLocator) {
        WebElement element = checkElementVisibility(elementLocator, Config.defaultWaitTimeInSec);
        if (element == null) {
            return null;  // element not visible
        }
        return element.getText();
    }

    public WebElement checkElementVisibility(By elementLocator, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        return wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));

    }

    public void waitForPageLoad() {
        new WebDriverWait(driver, Config.defaultPageLoadTimeInSec).until(
                ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";"));
    }


    public void closeDriver() {

        driver.close();
    }
}
