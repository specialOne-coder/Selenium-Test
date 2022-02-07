package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage {
    private WebDriver webDriver;
    private WebDriverWait wait;

    By emailInputLoc = By.id("block2-login");
    By passInputLoc = By.id("block2-password");


    public SignInPage(WebDriver webDriver, WebDriverWait wait) {
        this.webDriver = webDriver;
        this.wait = wait;
    }

    public void goToSigninPage(){
        this.webDriver.get("https://www.glisshop.com/identification/");
    }

    public void signIn(String email,String password){
        WebElement emailInput = this.webDriver.findElement(this.emailInputLoc);
        WebElement passwordInput = this.webDriver.findElement(this.passInputLoc);
        WebElement submit = (WebElement) this.webDriver.findElement(By.xpath("//*[@id=\"content-column\"]/div/div[2]/div[1]/div/div/div/div/div/form/fieldset/div/div[2]/div[1]/button"));
        WebElement cookieBtn = (WebElement) this.webDriver.findElement(By.xpath("//*[@id=\"tarteaucitronPersonalize2\"]"));
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        this.wait.until(ExpectedConditions.elementToBeClickable(cookieBtn)).sendKeys(Keys.ENTER);
        this.wait.until(ExpectedConditions.elementToBeClickable(submit)).sendKeys(Keys.ENTER);
    }




}
