package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;


public class SignUpPage {

    private WebDriver webDriver;
    private WebDriverWait wait;

    By emailInputLoc = By.xpath("//*[@id='rbs-user-create-account-email']");
    By passInputLoc = By.xpath("//*[@id='rbs-user-create-account-password']");
    By confirmPassInputLoc = By.xpath("//*[@id='rbs-user-create-account-confirm-password']");

    public SignUpPage(WebDriver webDriver, WebDriverWait wait) {
        this.webDriver = webDriver;
        this.wait = wait;
    }

    public void goToSignupPage(){
        this.webDriver.get("https://www.glisshop.com/glisshop/creation-de-compte.html");
    }

    public void signUp(String email,String password,String confirmPassword){
        try {
            WebElement emailInput = this.webDriver.findElement(this.emailInputLoc);
            WebElement passwordInput = this.webDriver.findElement(this.passInputLoc);
            WebElement confirmPasswordInput = this.webDriver.findElement(this.confirmPassInputLoc);
            WebElement submit = (WebElement) this.webDriver.findElement(By.xpath("//*[@id=\"content-column\"]/div/div[2]/div/div/div/div[1]/div/form/fieldset[2]/div/button"));
            WebElement cookieBtn = (WebElement) this.webDriver.findElement(By.xpath("//*[@id=\"tarteaucitronPersonalize2\"]"));
            emailInput.sendKeys(email);
            passwordInput.sendKeys(password);
            confirmPasswordInput.sendKeys(confirmPassword);
            this.wait.until(ExpectedConditions.elementToBeClickable(cookieBtn)).sendKeys(Keys.ENTER);
            this.wait.until(ExpectedConditions.elementToBeClickable(submit)).sendKeys(Keys.ENTER);
        }catch (Exception e){
            System.out.println("Erreur lors de l'inscription");
        }

    }


}
