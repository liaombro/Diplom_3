package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage {

    public static final String REGISTER_URL = String.format("%s/register", BASE_URL);

    private final By nameField = By.xpath("//*[text()='Имя']/parent::*/input");
    private final By emailField = By.xpath("//*[text()='Email']/parent::*/input");
    private final By passwordField = By.xpath("//*[text()='Пароль']/parent::*/input");

    private final By registerButton = By.xpath("//button[text()=\"Зарегистрироваться\"]");

    private final By loginLink = By.xpath("//a[@href=\"/login\"]");

    private final By errorMessage = By.cssSelector("p.input__error");
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public RegistrationPage open(){
        driver.get(REGISTER_URL);
        return this;
    }
    public LoginPage register(String name, String email, String password) {
        setName(name);
        setEmail(email);
        setPassword(password);
        clickRegisterButton();
        return new LoginPage(driver);
    }

    public RegistrationPage setName(String name) {
        driver.findElement(nameField).sendKeys(name);
        return this;

    }

    public RegistrationPage setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public RegistrationPage setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;

    }

    public RegistrationPage clickRegisterButton() {
        driver.findElement(registerButton).click();
        return this;
    }

    public LoginPage goToLoginPage(){
        driver.findElement(loginLink).click();
        return new LoginPage(driver);
    }

    public boolean checkIfPasswordErrorShown(){
        return driver.findElement(errorMessage).isDisplayed();
    }
}
