package stepDefs;

import Pages.AddToCart;
import Pages.HomePage;
import Pages.RemoveFromCart;
import io.cucumber.java8.En;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class RemoveSteps implements En {
    private WebDriver webDriver;
    private RemoveFromCart remove;
    private AddToCart add;
    private HomePage homePage;

    public RemoveSteps() {
        //avant
        Before(() -> {
            String path = "/home/ferdok/Musique/Selenium/chromedriver";
            System.setProperty("webdriver.chrome.driver", path);
            this.webDriver = new ChromeDriver();
            WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(5));
            this.webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            this.remove = new RemoveFromCart(this.webDriver, wait);
            this.add = new AddToCart(this.webDriver, wait);
            this.homePage = new HomePage(this.webDriver,wait);
        });


        //given du scenario
        Given("^user is at cart(.*)$", (String product) -> {
            this.add.goProductPage();
            this.add.addToCart(product);
            this.add.close();
            this.remove.goCartPage2();
        });

        //quand
        When("^user remove product$", () -> {
            Thread.sleep(2000);
            this.remove.removeFromCart();
        });

        //alors
        Then("^the product is(|n't) removed from the cart$", (String negation) -> {
            if(negation.isEmpty()){
                assertTrue(this.homePage.isRemoved());
                return;
            }
            Assert.assertNotEquals(this.homePage.getTitle(), "Création");
        });
    }
}
