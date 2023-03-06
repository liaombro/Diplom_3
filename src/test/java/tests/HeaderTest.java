package tests;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import pages.*;
import rules.DriverSetup;
import rules.LoginSetup;
import rules.UserSetup;

@RunWith(Enclosed.class)
public class HeaderTest extends TestBase {

    public static class PersonalAreaLoggedInTest extends TestBase {
        @Rule(order = 2)
        public DriverSetup driverSetup = new DriverSetup();

        @Rule(order = 1)
        public UserSetup userSetup = new UserSetup();

        @Rule(order = 0)
        public LoginSetup loginSetup = new LoginSetup();

        @Test
        public void userCanGoToPersonalAreaFromMainPage() {
            MainPage page = new MainPage(driver);

            boolean isPersonalArea = page.open()
                    .goToPersonalArea()
                    .isPersonalAreaPage();

            Assert.assertTrue("Пользователь должен находиться в личном кабинете после клика на кнопку 'Личный кабинет' ", isPersonalArea);

        }

        @Test
        public void userCanGoToPersonalAreaFromFeed() {
            FeedPage page = new FeedPage(driver);

            boolean isPersonalArea = page.open()
                    .goToPersonalArea()
                    .isPersonalAreaPage();

            Assert.assertTrue("Пользователь должен находиться в личном кабинете после клика на кнопку 'Личный кабинет' ", isPersonalArea);

        }

        @Test
        public void userCanGoFromPersonalAreaToMainPage() {
            MainPage page = new MainPage(driver);

            boolean isMainPage = page.open()
                    .goToPersonalArea()
                    .goToMainPageByLink()
                    .isMainPage();

            Assert.assertTrue("Пользователь должен находиться на главной странице после клика на кнопку 'Конструктор' ", isMainPage);
        }

        @Test
        public void userCanGoFromPersonalAreaToMainPageByClickOnLogo() {
            MainPage page = new MainPage(driver);

            boolean isMainPage = page.open()
                    .goToPersonalArea()
                    .goToMainPageByLogo()
                    .isMainPage();

            Assert.assertTrue("Пользователь должен находиться на главной странице после клика на логотип", isMainPage);
        }

    }

    public static class PersonalAreaGuestTest extends TestBase {
        @Rule(order = 0)
        public DriverSetup driverSetup = new DriverSetup();

        @Test
        public void guestCannotGoToPersonalArea() {
            MainPage page = new MainPage(driver);
            LoginPage loginPage = new LoginPage(driver);

            page.open().goToPersonalArea();
            boolean isLoginPage = loginPage.isLoginPage();

            Assert.assertTrue("Гость должен находиться на странице входа после клика на кнопку 'Личный кабинет' ", isLoginPage);


        }

    }


}
