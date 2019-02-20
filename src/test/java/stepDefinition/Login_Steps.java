package stepDefinition;


import base.TestContext;
import cucumber.api.Scenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import managers.Constant;
import managers.PageObjectManager;
import managers.WebDriverManager;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.ManagerAccountPage;

import static org.testng.Assert.assertEquals;

@SuppressWarnings("ALL")
public class Login_Steps {

    private TestContext testContext;
    private WebDriverManager webDriverManager;
    private PageObjectManager pageObjectManager;
    private HomePage homePage;
    private ManagerAccountPage managerAccountPage;
    private String expectedPageTitle;
    private String actualPageTitle;
    private Scenario scenario;
    private WebDriver driver;


    public Login_Steps(TestContext testContext) {
        this.testContext = testContext;
        pageObjectManager = new PageObjectManager(driver);
    }


    @Given("I am on the home page")
    public void iAmOnTheHomePage() {
        // Write code here that turns the phrase above into concrete actions
//        testContext.getScenarioContext().setContext(Context.SCENARIO_NAME,scenario.getName());
        homePage = testContext.getPageObjectManager().getHomePage();
        homePage.goToPage(Constant.APP_URL);
        testContext.getWebDriverManager().maximizeWindow();
        testContext.getWebDriverManager().pageLoad(15);
        expectedPageTitle = "Guru99 Bank Home Page";
        assertEquals(homePage.getPageTitle(), expectedPageTitle);
    }

    @Then("I fill UserID with {string} and Password with {string}")
    public void iFillUserIDWithAndPasswordWith(String UserID, String Password) {
        homePage.writeText(UserID, Password);
    }

    @And("I click Login")
    public void iClick() {
        homePage.login();
    }

    @Then("I should see {string} heading")
    public void iShouldSeeHeading(String heading) {


        try {
            //System.out.println("heading : " + heading);
            managerAccountPage = testContext.getPageObjectManager().getManagerAccountPage();
            testContext.getWebDriverManager().dismissAlert();
            expectedPageTitle = heading;
            actualPageTitle = managerAccountPage.getPageTitle();
            assertEquals(actualPageTitle, expectedPageTitle);
        } catch (NoAlertPresentException exception) {
            managerAccountPage.logOut();
        } catch (UnhandledAlertException alertPresent) {
            testContext.getWebDriverManager().dismissAlert();
            expectedPageTitle = heading;
            actualPageTitle = testContext.getWebDriverManager().getDriver().getTitle();
            assertEquals(actualPageTitle, expectedPageTitle);
        }
        testContext.getWebDriverManager().quitDriver();
    }

}

