package rules;

import com.sun.jdi.Method;
import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import tests.TestBase;

import java.lang.reflect.Member;

public class LoginSetup implements MethodRule {

    @Override
    public Statement apply(Statement statement, FrameworkMethod frameworkMethod, Object o) {

        TestBase target = (TestBase) o;

        WebDriver driver = target.getDriver();
        LoginPage page = new LoginPage(driver);

        String email = target.getUserEmail();
        String password = target.getUserPassword();
        page.open().login(email, password);

        System.out.println("User logged in");

        return statement;
    }




}
