package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage extends BasePage {

    public static final String FORGOT_PASSWORD_URL = String.format("%s/forgot-password", BASE_URL);

    private final By loginLink = By.xpath("//a[@href=\"/login\"]");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public ForgotPasswordPage open() {
        driver.get(FORGOT_PASSWORD_URL);
        return this;
    }

    public LoginPage goToLoginPage() {
        driver.findElement(loginLink).click();
        return new LoginPage(driver);
    }
}
