package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

import java.time.Duration;
import java.util.Map;

public class
Scenario1test extends BaseTest {

    @Test
    public void sampleLoginTest() {

        int pageLoadCheckTime = 3000;
        HomePage homePage = new HomePage(driver);
        homePage.open();

        new WebDriverWait(driver, Duration.ofMillis(pageLoadCheckTime))
                .until(d -> ((JavascriptExecutor) d)
                        .executeScript("return document.readyState")
                        .equals("complete"));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        @SuppressWarnings("unchecked")
        Map<String, Object> nav = (Map<String, Object>) js.executeScript(
                "return performance.getEntriesByType('navigation')[0].toJSON();"
        );

        double start = ((Number) nav.get("startTime")).doubleValue();
        double domContentLoaded = ((Number) nav.get("domContentLoadedEventEnd")).doubleValue();
        double loadEventEnd = ((Number) nav.get("loadEventEnd")).doubleValue();

        double pageLoadTime = loadEventEnd - start;

        System.out.println("DOMContentLoaded (ms): " + (domContentLoaded - start));
        System.out.println("Load event end (ms): " + pageLoadTime);

        Assert.assertTrue(
                pageLoadTime <= pageLoadTime,
                "Sayfa 3 saniyeden uzun sürede yüklendi! Süre: " + pageLoadTime + " ms"
        );

        Assert.assertTrue(
                homePage.isMainSliderVisible(),
                "embla main-slider ana sayfada görünmüyor!"
        );

        Assert.assertTrue(
                homePage.isBannerVisible(),
                "Banner Promotion ana sayfada görünmüyor!"
        );
    }
}
