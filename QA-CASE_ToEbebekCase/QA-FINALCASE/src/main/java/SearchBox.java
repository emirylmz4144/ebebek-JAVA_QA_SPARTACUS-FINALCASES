import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SearchBox extends  BasePage{
    By searchBoxLocator=By.id("txtSearchBox");

    public SearchBox(WebDriver webDriver)
    {
        super(webDriver);
    }

    public void search(String text) {
        type(searchBoxLocator,text);
        super.webDriver.findElement(By.id("txtSearchBox")).sendKeys(Keys.ENTER);
    }
}
