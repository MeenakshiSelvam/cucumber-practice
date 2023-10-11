package PageObjectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver ld;
    private static final By USERNAME = By.xpath("//input[@name='username']");

    private static final By PASSWORD = By.xpath("//input[@name='password']");
    private static final By LOGIN_BUTTON = By.xpath("//button[normalize-space()='Login']");

    public LoginPage(WebDriver rdriver) {
        ld = rdriver;
    }
    public void fillUsername(String username) {
        ld.findElement(USERNAME).clear();
        ld.findElement(USERNAME).sendKeys(username);
    }
    public void fillPassword(String password) {
        ld.findElement(PASSWORD).clear();
        ld.findElement(PASSWORD).sendKeys(password);
    }
    public void clickLogin() {
        ld.findElement(LOGIN_BUTTON).click();
    }



}







