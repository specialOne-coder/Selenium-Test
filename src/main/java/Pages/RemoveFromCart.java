package Pages;

import io.cucumber.java8.Th;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RemoveFromCart {
    private WebDriver webDriver;
    private WebDriverWait wait;

    public RemoveFromCart(WebDriver webDriver, WebDriverWait wait) {
        this.webDriver = webDriver;
        this.wait = wait;
    }

    public void goCartPage(){
        this.webDriver.get("https://www.glisshop.com");
    }

    public void goCartPage2(){
        this.webDriver.get("https://www.glisshop.com/glisshop/mon-panier.html");
    }

    public void removeFromCart() throws InterruptedException {
        webDriver.manage().window().maximize();
        //this.wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("//*[@id=\"tarteaucitronPersonalize2\"]")))).sendKeys(Keys.ENTER);
        //webDriver.findElement(By.xpath("/html/body/header/div/div[1]/div/div[4]/div[3]/div/div/div[2]/div/a")).click();
        WebElement element = webDriver.findElement(By.xpath("//button[@class=\'btn_transparent btn p-l_5 p-r_5 font-size_small\']"));
        JavascriptExecutor executor = (JavascriptExecutor)webDriver;
        executor.executeScript("arguments[0].click();", element);
        //webDriver.findElement(By.xpath("//*[@id=\"content-column\"]/div/div[10]/div[1]/div/div[1]/div[3]/div/div[2]/table/tbody/tr[1]/td/div/div/div[4]/div/div[3]/button")).click();
    }


}
