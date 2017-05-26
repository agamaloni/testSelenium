package selenium.com;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * Created by aloni on 26/05/17.
 */
public class WebDriversImpl {
    WebDriver driver;

    protected WebDriver useSeleniumHtml(){
        driver = new HtmlUnitDriver();
        driver.get("http://google.co.il");
        return driver;
    }

    protected WebDriver useSeleniumFirefox(){
        driver = new FirefoxDriver();
        driver.get("http://google.co.il");
        return driver;
    }
    protected WebDriver useSeleniumChrome(){
        driver = new ChromeDriver();
        driver.get("https://www.skyboxsecurity.com");
        return driver;
    }
}
