package pages;

import org.openqa.selenium.WebDriver;

public class FeedPage extends BasePage {

    public static final String FEED_URL = String.format("%s/feed", BASE_URL);

    public FeedPage(WebDriver driver){
        this.driver = driver;
    }
    public FeedPage open(){
        driver.get(FEED_URL);
        return this;
    }
}
