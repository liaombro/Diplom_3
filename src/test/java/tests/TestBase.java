package tests;

import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

@RunWith(Parameterized.class)
public class TestBase {

    WebDriver driver;

    String userEmail;
    String userPassword;

    @Parameterized.Parameter(0)
    public String browser;

    @Parameterized.Parameters
    public static Object[][] getBrowser() {
        return new Object[][]{
                {"chrome"},
                {"yandex"}
        };
    }

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
