package managers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebDriverManager {
    private WebDriver driver;
    private String handle;


    public WebDriver getDriver() {

        if(driver==null){
            System.setProperty(Constant.CHROME_DRIVER_PROPERTY,Constant.CHROME_DRIVER_PATH);
            driver = new ChromeDriver();
        }
        return driver;
    }

    public void closeDriver() {
        driver.close();

    }
    public void setWindow() {
        this.handle = driver.getWindowHandle();
    }
    public String getWindow() {
        return handle;
    }

    public void quitDriver() {
        driver.quit();
    }
    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public void acceptAlert() {
       Alert alert= driver.switchTo().alert();
       alert.accept();
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }
    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }

    public void sendTextToAlert(String key) {
        driver.switchTo().alert().sendKeys(key);
    }

    public void implicitWait(int time) {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    public void explicitWait(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 3000);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void pageLoad(int time) {
        driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
    }

    public void deleteAllCookies() {
        driver.manage().deleteAllCookies();
    }

}
