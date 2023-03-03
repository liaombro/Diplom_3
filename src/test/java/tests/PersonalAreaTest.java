package tests;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import rules.DriverSetup;
import rules.LoginSetup;
import rules.UserSetup;

public class PersonalAreaTest extends TestBase {

    @Rule(order = 2)
    public DriverSetup driverSetup = new DriverSetup();

    @Rule(order = 1)
    public UserSetup userSetup = new UserSetup();

    @Rule(order = 0)
    public LoginSetup loginSetup = new LoginSetup();

    @Test
    public void userCanLogout() {
        MainPage page = new MainPage(driver);
        String expectedURL = LoginPage.LOGIN_URL;

        page.open()
                .goToPersonalArea()
                .logOut();
        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals("После выхода из аккаунта пользователь должен находиться на странице входа", expectedURL, actualURL);

    }
}
