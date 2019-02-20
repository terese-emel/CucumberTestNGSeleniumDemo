package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

@SuppressWarnings("ALL")
public class HomePage {

    private String pageTitle;
    private WebDriver driver;

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(how = How.NAME, using = "uid")
    private WebElement userName;

    @FindBy(how = How.NAME, using = "password")
    private WebElement password;

    @FindBy(how = How.NAME, using = "btnLogin")
    private WebElement loginButton;

    public void writeText(String usernameText, String passwordText) {
        userName.click();
        userName.sendKeys(usernameText);
        password.click();
        password.sendKeys(passwordText);
    }

    public void login() {
     loginButton.click();
    }


    public void goToPage(String url) {
        driver.get(url);
        setPageTitle(driver.getTitle());
    }
}


