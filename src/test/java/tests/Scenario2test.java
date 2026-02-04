package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailPage;

public class Scenario2test extends BaseTest {

    @Test
    public void Scenario2Test() throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        ProductDetailPage productDetailPage = new ProductDetailPage(driver);

        homePage.open();

        Object[][] testData = {
                {"iPhone 14", "₺50.399"},
                {"iPhone 15", "₺58.799"},
                {"iPhone 16", "₺67.999"}
        };

        for (int i = 0; i < testData.length; i++) {
            String expectedTitle = (String) testData[i][0];
            String expectedPrice = (String) testData[i][1];

            searchAndAssert(homePage, productDetailPage, expectedTitle, expectedPrice, i + 1);
        }
    }

    private void searchAndAssert(HomePage homePage,
                                 ProductDetailPage productDetailPage,
                                 String expectedTitle,
                                 String expectedPrice,
                                 int index) throws InterruptedException {

        homePage.searchProduct(expectedTitle);
        String actualTitle = productDetailPage.getProductTitle();
        String actualPrice = productDetailPage.getProductPrice();

        Assert.assertTrue(
                actualTitle.contains(expectedTitle),
                index + ". ürün title bekleneni içermiyor. Beklenen: " + expectedTitle + " | Gelen: " + actualTitle
        );

        Assert.assertTrue(
                actualPrice.contains(expectedPrice),
                index + ". ürün fiyat bekleneni içermiyor. Beklenen: " + expectedPrice + " | Gelen: " + actualPrice
        );
    }
}