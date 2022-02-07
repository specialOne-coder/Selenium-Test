package stepDefs;

import Pages.HomePage;
import Pages.Logout;
import Pages.SignInPage;
import io.cucumber.java8.En;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class LogoutSteps implements En {
    private WebDriver webDriver;
    private Logout logout;
    private HomePage homePage;
    private SignInPage signIn;
    public LogoutSteps() {
        //avant
        Before(() -> {
            String path = "/home/ferdok/Musique/Selenium/chromedriver";
            System.setProperty("webdriver.chrome.driver", path);
            this.webDriver = new ChromeDriver();
            WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(5));
            this.webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            this.signIn = new SignInPage(this.webDriver,wait);
            this.logout = new Logout(this.webDriver, wait);
            this.homePage = new HomePage(this.webDriver,wait);
        });

        //given du scenario
        Given("^user is logged in(.*) (.*)$", (String email, String pass) -> {
            this.signIn.goToSigninPage();
            this.signIn.signIn(email,pass);
        });

        //quand
        When("^user is logout$", () -> {
            Thread.sleep(2000);
            this.logout.logout();
        });

        //alors
        Then("^he should(|n't') be at the home page$", (String negation) -> {
            assertTrue(this.homePage.isLogout());
            //this.webDriver.quit();
        });
    }

}
