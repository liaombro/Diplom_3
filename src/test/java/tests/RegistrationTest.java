package tests;

import io.qameta.allure.junit4.DisplayName;
import net.bytebuddy.utility.RandomString;
import org.junit.Rule;
import org.junit.Test;
import pages.RegistrationPage;
import rules.DriverSetup;

import static org.junit.Assert.assertEquals;

@DisplayName("Страница регистрации")
public class RegistrationTest extends TestBase {


    @Rule(order = 0)
    public DriverSetup driverSetup = new DriverSetup();

    @Test
    @DisplayName("Проверка создания аккаунта")
    public void guestCanRegisterAccount() {
        RegistrationPage page = new RegistrationPage(driver);
        String random = RandomString.make(10).toLowerCase();
        String email = String.format("%s@ya.ru", random);
        String name = random;
        String password = random;

        String actualEmail = page.open()
                .register(name, email, password)
                .login(email, password)
                .goToPersonalArea()
                .getEmail();

        assertEquals(email, actualEmail);

    }

    @Test
    @DisplayName("Показывается сообщение об ошибке, если пароль слишком короткий")

    public void errorMessageShownIfPasswordIsShorterThan6Symbols() {
        RegistrationPage page = new RegistrationPage(driver);
        String random = RandomString.make(10).toLowerCase();
        String email = String.format("%s@ya.ru", random);
        String name = random;
        String password = RandomString.make(5);
        boolean expected = true;

        boolean actual = page.open()
                .setName(name)
                .setEmail(email)
                .setPassword(password)
                .clickRegisterButton()
                .checkIfPasswordErrorShown();

        assertEquals("Должна быть показана ошибка: пароль слишком короткий", expected, actual);
    }


}
