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
            String expectedURL = PersonalAreaPage.PERSONAL_AREA_URL;

            page.open().goToPersonalArea();
            String actualURL = driver.getCurrentUrl();

            Assert.assertEquals("Пользователь должен находиться в личном кабинете после клика на кнопку 'Личный кабинет' ", expectedURL, actualURL);

        }

        @Test
        public void userCanGoToPersonalAreaFromFeed() {
            FeedPage page = new FeedPage(driver);
            String expectedURL = PersonalAreaPage.PERSONAL_AREA_URL;

            page.open().goToPersonalArea();
            String actualURL = driver.getCurrentUrl();

            Assert.assertEquals("Пользователь должен находиться в личном кабинете после клика на кнопку 'Личный кабинет' ", expectedURL, actualURL);

        }

        @Test
        public void userCanGoFromPersonalAreaToMainPage() {
            MainPage page = new MainPage(driver);
            String expectedURL = MainPage.BASE_URL + "/";

            page.open()
                    .goToPersonalArea()
                    .goToMainPageByLink();
            String actualURL = driver.getCurrentUrl();

            Assert.assertEquals("Пользователь должен находиться на главной странице после клика на кнопку 'Конструктор' ", expectedURL, actualURL);
        }

        @Test
        public void userCanGoFromPersonalAreaToMainPageByClickOnLogo() {
            MainPage page = new MainPage(driver);
            String expectedURL = MainPage.BASE_URL + "/";

            page.open()
                    .goToPersonalArea()
                    .goToMainPageByLogo();
            String actualURL = driver.getCurrentUrl();

            Assert.assertEquals("Пользователь должен находиться на главной странице после клика на логотип", expectedURL, actualURL);
        }

    }

    public static class PersonalAreaGuestTest extends TestBase {
        @Rule(order = 0)
        public DriverSetup driverSetup = new DriverSetup();

        @Test
        public void guestCannotGoToPersonalArea() {
            MainPage page = new MainPage(driver);
            String expectedURL = LoginPage.LOGIN_URL;

            page.open().goToPersonalArea();
            String actualURL = driver.getCurrentUrl();

            Assert.assertEquals("Гость должен находиться на странице входа после клика на кнопку 'Личный кабинет' ", expectedURL, actualURL);


        }

    }


}
