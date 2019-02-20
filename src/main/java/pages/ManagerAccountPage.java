package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

@SuppressWarnings("ALL")
public class ManagerAccountPage {

    private WebDriverWait driverWait;
    private String pageTitle;

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }




    @FindBy(how = How.XPATH, using = "/html/body/table/tbody/tr/td/table/tbody/tr[3]/td")
    private WebElement managerID;

    @FindBy(how = How.XPATH, using = "/html/body/table/tbody/tr/td/table/tbody/tr[2]/td/marquee")
    private WebElement greetingText;

    @FindBy(how = How.XPATH, using = "//*[contains(text(), 'Log out')]")
    private WebElement logOutButton;

    public ManagerAccountPage(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
        setPageTitle(driver.getTitle());
    }

    public String getManagerID() {
        return managerID.getText();
    }

    public String getGreeting() {
        return greetingText.getText();
    }

    public void logOut() {
        logOutButton.click();
    }




}
