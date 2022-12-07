import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BaseTest
{
    WebDriver webDriver;

    @BeforeAll
    public void setUp()
    {
       webDriver=new ChromeDriver();
       webDriver.get("https://www.e-bebek.com/");
       webDriver.manage().window().maximize();
    }
    @AfterAll
    public void Quit()
    {
        webDriver.quit();
    }

}
