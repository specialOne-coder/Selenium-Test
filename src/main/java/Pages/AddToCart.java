package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCart {
    private WebDriver webDriver;
    private WebDriverWait wait;

    private String art;

    public AddToCart(WebDriver webDriver, WebDriverWait wait) {
        this.webDriver = webDriver;
        this.wait = wait;
    }

    public void goProductPage(){
        this.webDriver.get("https://www.glisshop.com");
    }


    public void addToCart(String product) throws InterruptedException {
        webDriver.manage().window().maximize();
        webDriver.findElement(By.name("searchText")).click();
        webDriver.findElement(By.id("df-searchbox__dffullscreen")).sendKeys(product);
        webDriver.findElement(By.id("df-searchbox__dffullscreen")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        webDriver.findElement(By.id("tarteaucitronAllDenied2")).click();
        webDriver.findElement(By.cssSelector(".df-card:nth-child(1) img")).click();
        webDriver.findElement(By.xpath("//*[@id=\"cartBox\"]/div/div[1]/div/div/div[2]/button")).click();
    }

    public void close(){
        this.webDriver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[3]/div/div/div/div/div/div[1]/button")).click();
    }

}
