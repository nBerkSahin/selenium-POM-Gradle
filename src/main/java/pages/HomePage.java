package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(4));
    }

    private By searchInput = By.cssSelector("input[data-test-id='selenium-header-search-input']");
    private By searchIcon = By.cssSelector(".navbar-menu-search-icon");
    private By mainSlider = By.cssSelector(".embla.main-slider");
    private By banner = By.cssSelector("[data-testid=\"navbar-categories-sell-phone\"]");
    private By goToCart = By.cssSelector("[data-testid=\"header-basket-icon-container\"]");

    public void open() {
        driver.get("https://www.getmobil.com");
    }

    public void searchProduct(String text) throws InterruptedException {

        WebElement input = wait.until(
                ExpectedConditions.visibilityOfElementLocated(searchInput)
        );

        input.clear();
        input.sendKeys(text);
        input.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(searchIcon)).click();

    }

    public boolean isMainSliderVisible() {

        WebElement slider = wait.until(
                ExpectedConditions.visibilityOfElementLocated(mainSlider)
        );
        return slider.isDisplayed();
    }

    public boolean isBannerVisible() {

        WebElement bannerPromotion = wait.until(
                ExpectedConditions.visibilityOfElementLocated(banner)
        );
        return bannerPromotion.isDisplayed();
    }

    public void goToCart() {
        WebElement cart = wait.until(
                ExpectedConditions.visibilityOfElementLocated(goToCart)
        );
        cart.click();
    }


}