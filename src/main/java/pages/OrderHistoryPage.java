package pages;

import org.openqa.selenium.WebDriver;

public class OrderHistoryPage extends BasePage {

    public static final String HISTORY_URL = String.format("%s/account/order-history", BASE_URL);

    public OrderHistoryPage(WebDriver driver){
        this.driver = driver;
    }

    public OrderHistoryPage open(){
        driver.get(HISTORY_URL);
        return this;
    }

}
