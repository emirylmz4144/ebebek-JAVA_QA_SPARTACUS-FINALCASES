import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class HomePage extends BasePage
{
    SearchBox searchBox;
    By findCountQuality=By.className("number ng-star-inserted");
    By getToCard=By.className("icon-shopping-cart");


    public HomePage(WebDriver webDriver) {
        super(webDriver);
        searchBox=new SearchBox(webDriver);
    }

    public SearchBox searchbox() {
        return this.searchBox;
    }

    public boolean isProductCountUp() {
       return getCartCount() > 0;
    }

    public void goToCard() {
        click(getToCard);
    }

    public int getCartCount(){
        String countQuality=find(findCountQuality).getText();
        return Integer.parseInt(countQuality);
    }
}
