package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductDetailPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By productPrice = By.cssSelector("div.mantine-Text-root.mantine-1gndjl8");
    private final By productTitle = By.cssSelector("h1.mantine-Text-root.mantine-Title-root");
    private final By addToCartButton = By.cssSelector("button[data-testid='product-detail__add-to-cart-desktop-button']");

    public String getProductTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productTitle)).getText();
    }

    public String getProductPrice() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productPrice)).getText();
    }

    public void addToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }

}