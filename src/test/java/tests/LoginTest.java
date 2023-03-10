package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import pages.MainPage;
import pages.RegistrationPage;
import rules.DriverSetup;
import rules.UserSetup;

@DisplayName("Страница авторизации")
public class LoginTest extends TestBase {

    @Rule(order = 1)
    public DriverSetup driverSetup = new DriverSetup();

    @Rule(order = 0)
    public UserSetup userSetup = new UserSetup();

    @Test
    @DisplayName("Гость может залогиниться с главной страницы")
    public void guestCanLoginFromMainPage() {
        MainPage page = new MainPage(driver);
        String expectedEmail = userEmail;

        String actualEmail = page.open()
                .goToLoginPage()
                .login(userEmail, userPassword)
                .goToPersonalArea()
                .getEmail();

        Assert.assertEquals("После логина со главной страницы в личном кабинете должен отображаться email", expectedEmail, actualEmail);
    }

    @Test
    @DisplayName("Гость может залогиниться из личного кабинета")
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
    @DisplayName("Гость может залогиниться со страницы регистрации")
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
    @DisplayName("Гость может залогиниться со страницы восстановления пароля")
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
