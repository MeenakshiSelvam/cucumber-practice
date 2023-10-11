package stepdefinitions;

import PageObjectModels.DashboardPage;
import PageObjectModels.LoginPage;
import io.cucumber.java.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginSteps {

    WebDriver driver;
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @BeforeStep
    public void beforeStep()
    {
        System.out.println("Before Step");
    }


    @AfterStep
    public void afterStep()
    {
        System.out.println("After Step");
    }

    @Before
    public void beforeScenario()
    {
        System.out.println("Before Scenario");
    }
    @After
    public void afterScenario()
    {
        System.out.println("After Scenario");
    }
    @BeforeAll
    public static void beforeFeature()
    {
        System.out.println("Before Feature");
    }
    @AfterAll
    public static void afterFeature()
    {
        System.out.println("After Feature");
    }



    @Given("navigate to OrangeHRM application")
    public void navigate_to_orange_hrm_application() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        System.out.println("Navigated to ORangeHrm");

    }

    @When("enter a valid username {string} and password {string}")
    public void enter_a_valid_username_and_password(String username, String password) {
        loginPage.fillUsername(username);
        loginPage.fillPassword(password);
        System.out.println("Username and password are given");

    }
    @When("click on the {string} button")
    public void click_on_the_button(String string) {
        loginPage.clickLogin();
        System.out.println(string + "Button is clicked");
    }
    @Then("user should be navigated to dashboard")
    public void user_should_be_navigated_to_dashboard() {
        dashboardPage.verifyDashboard();
        System.out.println("User navigated to dashboard");
    }

    @Then("user should not be navigated to dashboard")
    public void user_should_not_be_navigated_to_dashboard() {

       // dashboardPage.verifyDashboard();

        try {
            Thread.sleep(5000);
        } catch (Exception e){}

//        Assert.isTrue(driver.getCurrentUrl().contains("dashboard"),"Url MisMatching");
        System.out.println("User should not be navigated to dashboard");
        org.junit.Assert.assertEquals
                ("url mis matching","https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index",driver.getCurrentUrl());




    }



}




