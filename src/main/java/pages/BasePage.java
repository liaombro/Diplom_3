package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site";

    protected WebDriver driver;
    private final By personalArea = By.cssSelector("a[href='/account'] .ml-2");
    private final By combiner = By.cssSelector("a[href='/'] .ml-2");
    private final By logo = By.cssSelector("div[class*='logo'] svg");
    public PersonalAreaPage goToPersonalArea(){
        driver.findElement(personalArea).click();
        return new PersonalAreaPage(driver);
    }

    public MainPage goToMainPageByLink(){
        driver.findElement(combiner).click();
        return new MainPage(driver);
    }

    public MainPage goToMainPageByLogo(){
        driver.findElement(logo).click();
        return new MainPage(driver);
    }
}
