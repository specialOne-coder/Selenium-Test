package stepDefs;

import Pages.HomePage;
import Pages.SignInPage;
import io.cucumber.java8.En;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class SignInSteps implements En {

    private WebDriver webDriver;
    private SignInPage signInPage;
    private HomePage homePage;

    public SignInSteps() {
        //avant
        Before(() -> {
            String path = "/home/ferdok/Musique/Selenium/chromedriver";
            System.setProperty("webdriver.chrome.driver", path);
            this.webDriver = new ChromeDriver();
            WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(5));
            this.webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            this.signInPage = new SignInPage(this.webDriver, wait);
            this.homePage = new HomePage(this.webDriver,wait);
        });

        //given du scenario
        Given("^user is at the login page$", () -> {
            Thread.sleep(10000);
            this.signInPage.goToSigninPage();
        });

        //quand
        When("^user is logging-in with (.*) (.*)$", (String username, String pass) -> {
            this.signInPage.signIn(username,pass);
        });

        //alors
        Then("^he should(|n't') be at the account page$", (String negation) -> {
            if(negation.isEmpty()){
                assertTrue(this.homePage.isWelcomeMsg());
                return;
            }
            Assert.assertNotEquals(this.homePage.getTitle(), "Identification");
        });
    }

}
