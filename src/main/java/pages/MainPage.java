package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.log.Log;

public class MainPage extends BasePage {



    private final By loginButton = By.cssSelector(".mt-25 button");
    private final By firstBun = By.cssSelector("div[class*=\"BurgerIngredients\"] ul:nth-of-type(1) a:nth-of-type(1)");
    private final By firstSauce =  By.cssSelector("div[class*=\"BurgerIngredients\"] ul:nth-of-type(2) a:nth-of-type(1)");
    private final By firstFilling =  By.cssSelector("div[class*=\"BurgerIngredients\"] ul:nth-of-type(3) a:nth-of-type(1)");

    private final By bunButton = By.cssSelector("span.text:nth-of-type(1)");
    private final By sauceButton = By.cssSelector("span.text:nth-of-type(2)");
    private final By fillingButton = By.cssSelector("span.text:nth-of-type(3)");
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage open(){
        driver.get(BASE_URL);
        return this;
    }

    public LoginPage goToLoginPage(){
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }
    public MainPage viewBuns(){
        driver.findElement(bunButton).click();
        return this;
    }
    public MainPage viewSauces(){
        driver.findElement(sauceButton).click();
        return this;
    }
    public MainPage viewFillings(){
        driver.findElement(fillingButton).click();
        return this;
    }

    public boolean checkIfBunsAreVisible(){
        return driver.findElement(firstBun).isDisplayed();
    }

    public boolean checkIfSaucesAreVisible(){
        return driver.findElement(firstSauce).isDisplayed();
    }
    public boolean checkIfFillingsAreVisible(){
        return driver.findElement(firstFilling).isDisplayed();
    }

}
