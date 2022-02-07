package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Logout {
    private WebDriver webDriver;
    private WebDriverWait wait;


    public Logout(WebDriver webDriver, WebDriverWait wait) {
        this.webDriver = webDriver;
        this.wait = wait;
    }

    public void logout() throws InterruptedException {
        webDriver.manage().window().maximize();
        WebElement logoutBtn = (WebElement) this.webDriver.findElement(By.xpath("//*[@id=\"content-middle\"]/div[2]/div[1]/aside/div/div/nav/a"));
        WebElement cookieBtn = (WebElement) this.webDriver.findElement(By.xpath("//*[@id=\"tarteaucitronPersonalize2\"]"));
        Thread.sleep(2000);
        this.wait.until(ExpectedConditions.elementToBeClickable(logoutBtn)).sendKeys(Keys.ENTER);
    }

}
