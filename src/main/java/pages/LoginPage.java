package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class LoginPage extends BasePage {



    public static final String LOGIN_URL = String.format("%s/login", BASE_URL);

    private final By emailField = By.cssSelector(".input_type_text input");
    private final By passwordField = By.cssSelector(".input_type_password  input");
    private final By loginButton = By.cssSelector(".mb-20 > button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage open() {
        driver.get(LOGIN_URL);
        return this;
    }

    public MainPage login(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickLoginButton();
        new WebDriverWait(driver, Duration.of(5, ChronoUnit.SECONDS)).until(ExpectedConditions.urlToBe(BASE_URL+"/"));
        return new MainPage(driver);
    }

    public void setPassword(String password) {
        new WebDriverWait(driver, Duration.of(5, ChronoUnit.SECONDS)).until(ExpectedConditions.elementToBeClickable(passwordField));
        sendKeysTwice(passwordField, password);
    }

    public void setEmail(String email) {
        new WebDriverWait(driver, Duration.of(5, ChronoUnit.SECONDS)).until(ExpectedConditions.elementToBeClickable(emailField));
        sendKeysTwice(emailField, email);
    }

    public void clickLoginButton() {
        clickTwice(loginButton);
    }

}
