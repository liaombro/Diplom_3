import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@RunWith(Parameterized.class)
public class TestBase {
    WebDriver driver;
    @Parameterized.Parameter(0)
    public String browser;
    @Parameterized.Parameters
    public static Object[][] getBrowser(){
        return new Object[][]{
                {"chrome"},
                {"bb"}
        };
    }

    @Before
    public void setUp(){
        if (browser.equals("chrome")){
            driver = new ChromeDriver();
        } else {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:\\Users\\kvardekkvar\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
            driver = new ChromeDriver(options);
        }
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
