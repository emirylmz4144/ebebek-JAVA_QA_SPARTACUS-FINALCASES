import org.openqa.selenium.WebDriver;

public class CardPage extends BasePage{
    HomePage homePage;
    public CardPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isProductAdded() {
        return homePage.getCartCount()<2;
    }
}
