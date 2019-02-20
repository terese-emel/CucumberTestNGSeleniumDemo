package managers;


import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.ManagerAccountPage;

public class PageObjectManager {

    private WebDriver driver;
    private HomePage homePage;
    private ManagerAccountPage managerAccountPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage(){

        if(homePage ==null)
        {
            homePage = new HomePage(driver);
        }

        return homePage;

    }

    public ManagerAccountPage getManagerAccountPage() {

        if(managerAccountPage == null)
        {
            managerAccountPage = new ManagerAccountPage(driver);
        }

        return managerAccountPage;
    }

}