package rules;

import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.BasePage;
import tests.TestBase;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class DriverSetup implements MethodRule {

    @Override
    public Statement apply(Statement base, FrameworkMethod method, Object target) {

        TestBase testClass = (TestBase) target;
        WebDriver driver;

        String browser = System.getProperty("browser");

        if (browser == null || browser.equals("chrome")){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-single-click-autofill");
            options.addArguments("--headless");
            driver = new ChromeDriver(options);

        } else {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--disable-single-click-autofill");
            options.setBinary("src/main/resources/yandex_browser/browser.exe");
            driver = new ChromeDriver(options);
        }


        driver.manage().timeouts().implicitlyWait( Duration.of(10, ChronoUnit.SECONDS));
        testClass.setDriver(driver);
        System.out.println("Driver set");


        try {
            return new Statement() {
                @Override
                public void evaluate() throws Throwable {
                    base.evaluate();
                }
            };
        } finally {
            System.out.println("Finally block executed - driver");
        }
    }

}
