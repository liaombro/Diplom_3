package rules;

import net.bytebuddy.utility.RandomString;
import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import pages.RegistrationPage;
import tests.TestBase;

public class UserSetup implements MethodRule {

    @Override
    public Statement apply(Statement base, FrameworkMethod method, Object target) {
        //logInfo("Before test", description);

        TestBase testClass = (TestBase) target;
        RegistrationPage page = new RegistrationPage(testClass.getDriver());
        String random = RandomString.make(10).toLowerCase();
        String email = String.format("%s@ya.ru", random);
        String name = random;
        String password = random;

        testClass.setUserEmail(email);
        testClass.setUserPassword(password);

        page.open()
                .register(name, email, password);
        System.out.println("User created");

        try {
            return new Statement() {
                @Override
                public void evaluate() throws Throwable {
                    base.evaluate();
                }
            };
        } finally {

            //logInfo("After test", description);
        }
    }

}


