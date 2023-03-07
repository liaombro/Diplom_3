package tests;

import org.junit.After;
import org.openqa.selenium.WebDriver;

public class TestBase {

    WebDriver driver;

    String userEmail;
    String userPassword;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }


    @After
    public void tearDown() {
       driver.quit();
    }


}
