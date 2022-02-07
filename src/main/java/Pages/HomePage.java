package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private final WebDriver webDriver;
    private final WebDriverWait wait;

    @FindBy(xpath = "//*[@id=\"content-column\"]/div/div[2]/div/div/div/div[1]/div/div[2]/div/p[1]")
    private WebElement compteCreationSuccessMsg;

    @FindBy(xpath = "//*[@id=\"content-top\"]/div/div/div[2]/div/div/h1")
    private WebElement welcomeMsg;

    @FindBy(xpath = "//*[@id=\"df-results__embedded\"]/div[1]/a/div/div[2]")
    private WebElement searchResult;
    @FindBy(xpath = "/html/body/div[1]/div/div/div/div[3]/div/div/div/div/div/div[2]/div/div[4]/div/div/p/span")
    private WebElement addToCartSuccess;

    @FindBy(xpath = "//*[@id=\"content-column\"]/div/div[10]/p")
    private WebElement removeFromCartSuccess;

    @FindBy(xpath = "//*[@id=\"content-column\"]/div/div[2]/div[1]/div/div/div/div/div/form/fieldset/div/div[2]/div[1]/button")
    private WebElement loginBtn;



    public HomePage(WebDriver webDriver, WebDriverWait wait) {
        this.webDriver = webDriver;
        this.wait = wait;
        PageFactory.initElements(this.webDriver,this);
    }

    public String getTitle(){
        return this.webDriver.getTitle();
    }

    public boolean isCompteCreationSuccessMsg(){
        this.wait.until(ExpectedConditions.visibilityOf(this.compteCreationSuccessMsg));
        return this.compteCreationSuccessMsg.isEnabled();
    }

    public boolean isWelcomeMsg(){
        this.wait.until(ExpectedConditions.visibilityOf(this.welcomeMsg));
        return this.welcomeMsg.isDisplayed();
    }

    public boolean isHere(){
        this.wait.until(ExpectedConditions.visibilityOf(this.searchResult));
        return this.searchResult.isDisplayed();
    }

    public boolean isAddedToCart(){
        this.wait.until(ExpectedConditions.visibilityOf(this.addToCartSuccess));
        return this.addToCartSuccess.isDisplayed();
    }

    public boolean isRemoved(){
        this.wait.until(ExpectedConditions.visibilityOf(this.removeFromCartSuccess));
        return this.removeFromCartSuccess.isDisplayed();
    }

    public boolean isLogout(){
        this.wait.until(ExpectedConditions.visibilityOf(this.loginBtn));
        return this.loginBtn.isDisplayed();
    }




}
