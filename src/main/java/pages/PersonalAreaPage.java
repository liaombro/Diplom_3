package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PersonalAreaPage extends BasePage {

    public static final String PERSONAL_AREA_URL = String.format("%s/account/profile", BASE_URL);
    private final By logoutButton = By.cssSelector("li button") ;

    public PersonalAreaPage(WebDriver driver){
        this.driver = driver;
    }

    public PersonalAreaPage open(){
        driver.get(PERSONAL_AREA_URL);
        return this;
    }
    public LoginPage logOut(){
        driver.findElement(logoutButton).click();
        return new LoginPage(driver);
    }
}
