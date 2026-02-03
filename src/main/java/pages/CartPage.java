package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CartPage {

    private WebDriver driver;
    private WebDriverWait wait;


    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    private By productTitles = By.xpath("//div[@data-testid='product-title']");
    private By productPrices = By.xpath("//div[@data-testid='product-price']");
    private By removeProductButton = By.cssSelector("[data-testid='quantity-decrease-button']");
    private By cartTitles = By.xpath("//div[@data-testid='product-title'][0]");

    public List<String> getProductTitles() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productTitles));
        List<WebElement> elements = driver.findElements(productTitles);
        List<String> titles = new ArrayList<>();
        for (WebElement element : elements) {
            titles.add(element.getText());
        }
        return titles;
    }

    public List<String> getProductPrices() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productPrices));
        List<WebElement> elements = driver.findElements(productPrices);
        List<String> prices = new ArrayList<>();
        for (WebElement element : elements) {
            prices.add(element.getText());
        }
        return prices;
    }

    public void clickRemoveProduct() {
        wait.until(ExpectedConditions.elementToBeClickable(removeProductButton)).click();
    }


    private By deleteItemTitle = By.cssSelector("span.delete-item-title[data-testid='delete-item-title']");

    public String getDeleteModalTitle() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        return wait.until(ExpectedConditions.visibilityOfElementLocated(deleteItemTitle))
                .getText();
    }

    public void clickConfirmDelete() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button[data-testid='modal-confirm-button']")
        )).click();
    }

    public void waitUntilProductRemoved(String expectedTitle) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(driver -> driver.findElements(cartTitles)
                .stream()
                .map(WebElement::getText)
                .noneMatch(title -> title.contains(expectedTitle)));
    }
}
