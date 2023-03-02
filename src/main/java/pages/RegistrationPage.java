package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage extends BasePage {

    public static final String REGISTER_URL = String.format("%s/register", BASE_URL);

    private final By nameFieldLocator = By.xpath("//*[text()='Имя']/parent::*/input");
    private final By emailFieldLocator = By.xpath("//*[text()='Email']/parent::*/input");
    private final By passwordFieldLocator = By.xpath("//*[text()='Пароль']/parent::*/input");

    private final By registerButtonLocator = By.xpath("//button[text()=\"Зарегистрироваться\"]");

    private final By loginLinkLocator = By.xpath("//a[@href=\"/login\"]");

    private final By errorMessageLocator = By.cssSelector("p.input__error");
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

    public void setName(String name) {
        WebElement nameField = driver.findElement(nameFieldLocator);
        nameField.sendKeys(name);
    }

    public void setEmail(String email) {
        WebElement emailField = driver.findElement(emailFieldLocator);
        emailField.sendKeys(email);
    }

    public void setPassword(String password) {
        WebElement passwordField = driver.findElement(passwordFieldLocator);
        passwordField.sendKeys(password);

    }

    public void clickRegisterButton() {
        WebElement registerButton = driver.findElement(registerButtonLocator);
        registerButton.click();
    }

    public LoginPage goToLoginPage(){
        WebElement loginLink = driver.findElement(loginLinkLocator);
        loginLink.click();
        return new LoginPage(driver);
    }
}
