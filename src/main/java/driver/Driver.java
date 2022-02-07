package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class Driver {

    private final WebDriver driver;

    public Driver() {
        System.setProperty("webdriver.chrome.driver", "/home/ferdok/Musique/Selenium/chromedriver");
        this.driver = new ChromeDriver(this.getChromeOptions());
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public void closeDriver() {
        this.driver.close();
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = (ChromeOptions) new ChromeOptions()
                .setAcceptInsecureCerts(true);
        chromeOptions.addArguments("--enable-automation");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-browser-side-navigation");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        return chromeOptions;
    }

}