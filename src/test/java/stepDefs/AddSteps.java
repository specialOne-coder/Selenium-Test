package stepDefs;

import Pages.AddToCart;
import Pages.HomePage;
import io.cucumber.java8.En;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class AddSteps implements En {
    private WebDriver webDriver;
    private AddToCart add;
    private HomePage homePage;

    public AddSteps() {
        //avant
       Before(() -> {
            String path = "/home/ferdok/Musique/Selenium/chromedriver";
            System.setProperty("webdriver.chrome.driver", path);
            this.webDriver = new ChromeDriver();
            WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(5));
            this.webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            this.add = new AddToCart(this.webDriver, wait);
            this.homePage = new HomePage(this.webDriver,wait);
        });

        //given du scenario
        Given("^user is search product$", () -> {

            this.add.goProductPage();
        });

        //quand
        When("^user add product to cart (.*)$", (String product) -> {
            this.add.addToCart(product);
        });

        //alors
        Then("^the product is(|n't) added to cart$", (String negation) -> {
            if(negation.isEmpty()){
                assertTrue(this.homePage.isAddedToCart());
                return;
            }
            Assert.assertNotEquals(this.homePage.getTitle(), "Création");
        });
    }
}
