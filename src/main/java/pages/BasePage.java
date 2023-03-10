package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;

public class BasePage {

    public static final int WIDTH = 1280;
    public static final int HEIGHT = 1024;
    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site";

    protected WebDriver driver;
    private final By personalArea = By.cssSelector("a[href='/account'] .ml-2");
    private final By combiner = By.cssSelector("a[href='/'] .ml-2");
    private final By logo = By.cssSelector("div[class*='logo'] svg");

    public PersonalAreaPage goToPersonalArea() {
        driver.findElement(personalArea).click();
        return new PersonalAreaPage(driver);
    }

    public MainPage goToMainPageByLink() {
        driver.findElement(combiner).click();
        return new MainPage(driver);
    }

    public MainPage goToMainPageByLogo() {
        driver.findElement(logo).click();
        return new MainPage(driver);
    }


    public void sendKeysTwice(By locator, String text) {
        int attempts = 2;
        for (int i = 0; i < attempts; i++) {
            try {
                driver.findElement(locator).sendKeys(text);
                break;
            } catch (StaleElementReferenceException ignored)
            {
            }
        }
    }
    public void clickTwice(By locator) {
        int attempts = 2;
        for (int i = 0; i < attempts; i++) {
            try {
                driver.findElement(locator).click();
                break;
            } catch (StaleElementReferenceException ignored)
            {
            }
        }
    }

}
