package stepDefs;

import Pages.HomePage;
import Pages.Search;
import io.cucumber.java8.En;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class SearchSteps implements En {

    private WebDriver webDriver;
    private Search search;
    private HomePage homePage;

    public SearchSteps() {
        //avant
        Before(() -> {
            String path = "/home/ferdok/Musique/Selenium/chromedriver";
            System.setProperty("webdriver.chrome.driver", path);
            this.webDriver = new ChromeDriver();
            WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(5));
            this.webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            this.search = new Search(this.webDriver, wait);
            this.homePage = new HomePage(this.webDriver,wait);
        });

        /*After(()->{
           this.webDriver.quit();
        });*/

        //given du scenario
        Given("^user is on the search bar$", () -> {
            this.search.goToSearchPage();
        });

        //quand
        When("^user look for the product (.*)$", (String product) -> {
            this.search.search(product);
        });

        //alors
        Then("^the products are(|n't') displayed to him$", (String negation) -> {
                assertTrue(this.homePage.isHere());
                //this.webDriver.quit();
        });
    }
}
