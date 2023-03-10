package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import pages.*;
import rules.DriverSetup;

@DisplayName("Заголовок страницы для незалогиненного пользователя")
public class HeaderNotLoggedInTest extends TestBase {

    @Rule(order = 0)
    public DriverSetup driverSetup = new DriverSetup();

    @Test
    @DisplayName("Гость не может зайти в личный кабинет")
    public void guestCannotGoToPersonalArea() {
        MainPage page = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        page.open().goToPersonalArea();
        boolean isLoginPage = loginPage.isLoginPage();

        Assert.assertTrue("Гость должен находиться на странице входа после клика на кнопку 'Личный кабинет' ", isLoginPage);


    }

}


