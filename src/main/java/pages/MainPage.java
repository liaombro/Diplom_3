package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class MainPage extends BasePage {


    private final By loginButton = By.cssSelector(".mt-25 button");
    private final By firstBun = By.cssSelector("div[class*=\"BurgerIngredients\"] ul:nth-of-type(1) a:nth-of-type(1)");
    private final By firstSauce =  By.cssSelector("div[class*=\"BurgerIngredients\"] ul:nth-of-type(2) a:nth-of-type(1)");
    private final By firstFilling =  By.cssSelector("div[class*=\"BurgerIngredients\"] ul:nth-of-type(3) a:nth-of-type(1)");

    private final By bunButton = By.cssSelector("div[class*='tab']:nth-of-type(1) .text");
    private final By sauceButton = By.cssSelector("div[class*='tab']:nth-of-type(2) .text");
    private final By fillingButton = By.cssSelector("div[class*='tab']:nth-of-type(3) .text");

    private final By beginningOfIngredientList = By.cssSelector("div[class*=BurgerIngredients]");
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

    public Double getYCoordinateOfElement(By locator){
        WebElement element = driver.findElement(locator);
        String script = "y = window.scrollY + arguments[0].getBoundingClientRect().top; return y;";
        Object y = ((JavascriptExecutor)driver).executeScript(script, element);
        return (Double) y;
    }
    public boolean checkIfScrolledTo(By locator){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Double itemPosition = getYCoordinateOfElement(locator);
        Double startPosition = getYCoordinateOfElement(beginningOfIngredientList);
        return itemPosition > startPosition && itemPosition < HEIGHT ;
    }
    public boolean checkIfBunsAreVisible(){
        return checkIfScrolledTo(firstBun);
    }

    public boolean checkIfSaucesAreVisible(){
        return checkIfScrolledTo(firstSauce);
    }
    public boolean checkIfFillingsAreVisible(){
        return checkIfScrolledTo(firstFilling);
    }

    public boolean isMainPage(){
        return driver.findElement(firstBun).isDisplayed();
    }

}
