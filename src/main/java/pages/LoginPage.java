package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        return new MainPage(driver);
    }

    public void setPassword(String password) {
        driver.findElement(this.passwordField).sendKeys(password);
    }

    public void setEmail(String email) {
       driver.findElement(this.emailField).sendKeys(email);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

}
