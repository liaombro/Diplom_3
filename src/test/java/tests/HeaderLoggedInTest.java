package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import pages.FeedPage;
import pages.MainPage;
import rules.DriverSetup;
import rules.LoginSetup;
import rules.UserSetup;

@DisplayName("Заголовок страницы для залогиненого пользователя")

public class HeaderLoggedInTest extends TestBase {

    @Rule(order = 2)
    public DriverSetup driverSetup = new DriverSetup();

    @Rule(order = 1)
    public UserSetup userSetup = new UserSetup();

    @Rule(order = 0)
    public LoginSetup loginSetup = new LoginSetup();


    @Test
    @DisplayName("Проверка перехода в личный кабинет с главной страницы")
    public void userCanGoToPersonalAreaFromMainPage() {
        MainPage page = new MainPage(driver);

        boolean isPersonalArea = page.open()
                .goToPersonalArea()
                .isPersonalAreaPage();

        Assert.assertTrue("Пользователь должен находиться в личном кабинете после клика на кнопку 'Личный кабинет' ", isPersonalArea);

    }

    @Test
    @DisplayName("Проверка перехода в личный кабинет с ленты заказов")
    public void userCanGoToPersonalAreaFromFeed() {
        FeedPage page = new FeedPage(driver);

        boolean isPersonalArea = page.open()
                .goToPersonalArea()
                .isPersonalAreaPage();

        Assert.assertTrue("Пользователь должен находиться в личном кабинете после клика на кнопку 'Личный кабинет' ", isPersonalArea);

    }

    @Test
    @DisplayName("Проверка перехода на главную страницу с личного кабинета по клику на кнопку")
    public void userCanGoFromPersonalAreaToMainPage() {
        MainPage page = new MainPage(driver);

        boolean isMainPage = page.open()
                .goToPersonalArea()
                .goToMainPageByLink()
                .isMainPage();

        Assert.assertTrue("Пользователь должен находиться на главной странице после клика на кнопку 'Конструктор' ", isMainPage);
    }

    @Test
    @DisplayName("Проверка перехода на главную страницу с личного кабинета по клику на логотип")
    public void userCanGoFromPersonalAreaToMainPageByClickOnLogo() {
        MainPage page = new MainPage(driver);

        boolean isMainPage = page.open()
                .goToPersonalArea()
                .goToMainPageByLogo()
                .isMainPage();

        Assert.assertTrue("Пользователь должен находиться на главной странице после клика на логотип", isMainPage);
    }

}
