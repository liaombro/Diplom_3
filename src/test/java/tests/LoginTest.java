package tests;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import pages.MainPage;
import pages.RegistrationPage;
import rules.DriverSetup;
import rules.UserSetup;

public class LoginTest extends TestBase {

    @Rule(order = 1)
    public DriverSetup driverSetup = new DriverSetup();

    @Rule(order = 0)
    public UserSetup userSetup = new UserSetup();

    @Test
    public void guestCanLoginFromMainPage() {
        MainPage page = new MainPage(driver);
        String expectedEmail = userEmail;

        String actualEmail = page.open().
                goToLoginPage()
                .login(userEmail, userPassword)
                .goToPersonalArea()
                .getEmail();

        Assert.assertEquals("После логина со главной страницы в личном кабинете должен отображаться email", expectedEmail, actualEmail);
    }

    @Test
    public void guestCanLoginFromPersonalArea() {
        MainPage page = new MainPage(driver);
        String expectedEmail = userEmail;
        LoginPage loginPage = new LoginPage(driver);

        page.open().
                goToPersonalArea();
        String actualEmail = loginPage.login(userEmail, userPassword)
                .goToPersonalArea()
                .getEmail();

        Assert.assertEquals("После логина из личного кабинета в личном кабинете должен отображаться email", expectedEmail, actualEmail);
    }

    @Test
    public void guestCanLoginFromRegistrationPage() {
        RegistrationPage page = new RegistrationPage(driver);
        String expectedEmail = userEmail;

        String actualEmail = page.open()
                .goToLoginPage()
                .login(userEmail, userPassword)
                .goToPersonalArea()
                .getEmail();

        Assert.assertEquals("После логина со страницы регистрации в личном кабинете должен отображаться email", expectedEmail, actualEmail);
    }

    @Test
    public void guestCanLoginFromForgotPasswordPage() {
        ForgotPasswordPage page = new ForgotPasswordPage(driver);
        String expectedEmail = userEmail;

        String actualEmail = page.open()
                .goToLoginPage()
                .login(userEmail, userPassword)
                .goToPersonalArea()
                .getEmail();

        Assert.assertEquals("После логина со страницы восстановления пароля в личном кабинете должен отображаться email",
                expectedEmail, actualEmail);
    }
}
