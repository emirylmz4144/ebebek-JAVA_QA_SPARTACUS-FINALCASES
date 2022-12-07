import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductPage extends BasePage
{
    By areWeOnThePage=By.id("txtBrandFilter");
    By allProducts=By.className("'product-item");

    public ProductPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isOnTheProductPage() {
        return isDisplayed(areWeOnThePage);

    }

    public void selectProduct(int i) {
        getAllProduct().get(i).click();
    }

    public List<WebElement> getAllProduct() {
        return findAll(allProducts);

    }
}
