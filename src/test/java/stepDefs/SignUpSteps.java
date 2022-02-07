package stepDefs;

import Pages.HomePage;
import Pages.SignUpPage;
import io.cucumber.java8.En;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class SignUpSteps implements En {

    private WebDriver webDriver;
    private SignUpPage signUpPage;
    private HomePage homePage;

    public SignUpSteps() {
        //avant
        Before(() -> {
            String path = "/home/ferdok/Musique/Selenium/chromedriver";
            System.setProperty("webdriver.chrome.driver", path);
            this.webDriver = new ChromeDriver();
            WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(5));
            this.webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            this.signUpPage = new SignUpPage(this.webDriver, wait);
            this.homePage = new HomePage(this.webDriver,wait);
        });

        After(()->{
            this.webDriver.quit();
        });

        //given du scenario
        Given("^user is at the signup page$", () -> {
            this.signUpPage.goToSignupPage();
        });

        //quand
        When("^user is registered with (.*) (.*) (.*)$", (String username, String pass, String confirm) -> {
            this.signUpPage.signUp(username,pass,confirm);
        });

        //alors
        Then("^he has(|n't) a message confirming his account creation$", (String negation) -> {
            if(negation.isEmpty()){
                assertTrue(this.homePage.isCompteCreationSuccessMsg());
                return;
            }
            //Assert.assertNotEquals(this.homePage.getTitle(), "Création de compte");
        });
    }
}
