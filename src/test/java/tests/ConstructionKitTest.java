package tests;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import pages.MainPage;
import rules.DriverSetup;
import rules.LoginSetup;
import rules.UserSetup;

public class ConstructionKitTest extends TestBase {
    @Rule(order = 2)
    public DriverSetup driverSetup = new DriverSetup();

    @Rule(order = 1)
    public UserSetup userSetup = new UserSetup();

    @Rule(order = 0)
    public LoginSetup loginSetup = new LoginSetup();

    @Test
    public void clickOnFillingsButtonScrollsPageToFillings() {
        MainPage page = new MainPage(driver);

        boolean actual = page.open()
                .viewFillings()
                .checkIfFillingsAreVisible();

        Assert.assertTrue("Начинки должны быть видны после клика на кнопку 'Начинки'", actual);
    }

    @Test
    public void clickOnSaucesButtonScrollsPageToSauces() {
        MainPage page = new MainPage(driver);

        boolean actual = page.open()
                .viewSauces()
                .checkIfSaucesAreVisible();

        Assert.assertTrue("Соусы должны быть видны после клика на кнопку 'Соусы'", actual);
    }

    @Test
    public void clickOnBunsButtonScrollsPageToBuns() {
        MainPage page = new MainPage(driver);

        boolean actual = page.open()
                .viewFillings()
                .viewBuns()
                .checkIfBunsAreVisible();

        Assert.assertTrue("Булки должны быть видны после клика на кнопку 'Булки'", actual);
    }

}
