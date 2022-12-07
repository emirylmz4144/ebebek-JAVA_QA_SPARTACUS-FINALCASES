import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage{

    By areWeOnProductDetails=By.id("addToCartBtn");


    public ProductDetailsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isOnProductDetailsPage() {
        return isDisplayed(areWeOnProductDetails);
    }

    public void addaToCard() {
        click(areWeOnProductDetails);
    }
}
