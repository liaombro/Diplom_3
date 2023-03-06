package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalAreaPage extends BasePage {

    public static final String PERSONAL_AREA_URL = String.format("%s/account/profile", BASE_URL);
    private final By logoutButton = By.cssSelector("li button") ;
    private final By email = By.xpath("//label[text()=\"Логин\"]/parent::*/input");
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

    public String getEmail(){
        return driver.findElement(email).getAttribute("value");
    }

    public boolean isPersonalAreaPage(){
        return driver.findElement(logoutButton).isDisplayed();
    }
}
