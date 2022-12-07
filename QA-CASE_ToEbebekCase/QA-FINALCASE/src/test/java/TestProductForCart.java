import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class TestProductForCart extends BaseTest
{
    HomePage homePage;
    ProductPage productPage;
    ProductDetailsPage productDetailsPage;
    CardPage cardPage;

    @Test
    @Order(1)
    public void searchProduct()
    {
        homePage=new HomePage(webDriver);
        productPage=new ProductPage(webDriver);
        homePage.searchbox().search("Kaşık maması");
        Assertions.assertTrue(productPage.isOnTheProductPage(),"Listelenen ürünler sayfasında değilsiniz");

    }
    @Test
    @Order(2)
    public void selectAProduct()
    {
        productDetailsPage=new ProductDetailsPage(webDriver);
        productPage.selectProduct((productPage.getAllProduct().size()-1));
        Assertions.assertTrue(productDetailsPage.isOnProductDetailsPage(),"Tıklanan ürün sayfasında değilsiniz..");
    }

    @Test
    @Order(3)
    public void sendProductToCard()
    {
        productDetailsPage.addaToCard();
        Assertions.assertTrue(homePage.isProductCountUp(),"Bilinmeyen sebepten veya limit dolduğundan ürün sepete eklenemedi");
    }
    @Test
    @Order(4)
    public void goToCard()
    {
        cardPage=new CardPage(webDriver);
        homePage.goToCard();
        Assertions.assertTrue(cardPage.isProductAdded(),"Ürün sepete eklenemedi");
    }
}
