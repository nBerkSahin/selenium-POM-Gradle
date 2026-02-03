package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductDetailPage;
import java.util.ArrayList;
import java.util.List;

public class Scenario3test extends BaseTest {

    @Test
    public void Scenario3Test() throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        ProductDetailPage productDetailPage = new ProductDetailPage(driver);
        homePage.open();

        Object[][] testData = {
                {"iPhone 14"},
                {"iPhone 15"},
                {"iPhone 16"}
        };

        List<Object[]> PDPData = new ArrayList<>();

        for (int i = 0; i < testData.length; i++) {
            homePage.searchProduct((String) testData[i][0]);
            String PDPlTitle = productDetailPage.getProductTitle();
            String PDPPrice = productDetailPage.getProductPrice();
            PDPData.add(new Object[]{PDPlTitle, PDPPrice});
            productDetailPage.addToCart();
        }

        for (Object[] data : PDPData) {
            System.out.println("Title: " + data[0] + " Price: " + data[1]);
        }

        homePage.goToCart();

        CartPage cartPage = new CartPage(driver);
        List<String> productTitles = cartPage.getProductTitles();
        List<String> productPrices = cartPage.getProductPrices();

        List<Object[]> CartData = new ArrayList<>();

       for (int i = 0; i < productTitles.size(); i++) {
        CartData.add(new Object[]{productTitles.get(i), productPrices.get(i)});
       }

       for (Object[] data : CartData) {
        System.out.println("Title: " + data[0] + " Price: " + data[1]);
       }

        List<String> firstThree = productTitles.subList(0, 3);
        List<String> lastThree = productTitles.subList(productTitles.size() - 3, productTitles.size());

        for (String firstTitle : firstThree) {

            boolean found = lastThree.stream()
                    .anyMatch(lastTitle -> lastTitle.contains(firstTitle)
                            || firstTitle.contains(lastTitle));

            Assert.assertTrue(
                    found,
                    "Eşleşmeyen title bulundu! Title: " + firstTitle
            );
        }

        cartPage.clickRemoveProduct();
        Thread.sleep(3000);

        String expectedTitle = CartData.get(0)[0].toString();
        String actualTitle = cartPage.getDeleteModalTitle();

        Assert.assertTrue(
                actualTitle.contains(expectedTitle),
                "Ürün title eşleşmedi! Expected: " + expectedTitle + " Actual: " + actualTitle
        );

        cartPage.clickConfirmDelete();
        cartPage.waitUntilProductRemoved("iPhone 14");

    }
}
