package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Search {
    private WebDriver webDriver;
    private WebDriverWait wait;

    private String art;

    public Search(WebDriver webDriver, WebDriverWait wait) {
        this.webDriver = webDriver;
        this.wait = wait;
    }

    public void goToSearchPage(){
        this.webDriver.get("https://www.glisshop.com/");
    }

    public void search(String article) throws InterruptedException {
        WebElement searchInput = this.webDriver.findElement(By.xpath("//*[@id=\"df-searchbox__dffullscreen\"]"));
        WebElement searchBtn = (WebElement) this.webDriver.findElement(By.xpath("/html/body/header/div/div[1]/div/div[3]/div/form/div/span/button"));
        WebElement cookieBtn = (WebElement) this.webDriver.findElement(By.xpath("//*[@id=\"tarteaucitronPersonalize2\"]"));
        this.wait.until(ExpectedConditions.elementToBeClickable(cookieBtn)).sendKeys(Keys.ENTER);
        this.webDriver.findElement(By.name("searchText")).click();
        searchInput.sendKeys(article);
        this.wait.until(ExpectedConditions.elementToBeClickable(searchInput)).sendKeys(Keys.ENTER);
    }

}
