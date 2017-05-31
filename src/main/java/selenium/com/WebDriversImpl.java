package selenium.com;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by aloni on 26/05/17.
 */
public class WebDriversImpl {
    WebDriver driver;

    public WebDriver useSeleniumHtml(){
        driver = new HtmlUnitDriver();
        driver.get(PagesPath.GOOGLE);
        setPageLoadTime(driver,30);
        return driver;
    }

    public WebDriver useSeleniumFirefox(){
        driver = new FirefoxDriver();
        driver.get(PagesPath.GOOGLE);
        setPageLoadTime(driver,30);
        return driver;
    }
    public WebDriver useSeleniumChrome(){
        driver = new ChromeDriver();
        driver.get(PagesPath.GOOGLE);
        setPageLoadTime(driver,30);
        return driver;
    }
    public WebDriver setPageLoadTime(WebDriver driver,int sec){
        driver.manage().timeouts().pageLoadTimeout(sec, TimeUnit.SECONDS);
        return driver;
    }
    public void countLines(List<WebElement> urls){
        int count = 0;
        for (WebElement url : urls) {
            System.out.println(url.getAttribute("href"));
            String filtering=url.getText();
            if(filtering.startsWith("nana"))
                count++;
        }
        System.out.println("Total count : "+count);
    }
    public WebDriver loadElementById(WebDriver driver, String id){
        new WebDriverWait(driver, 6000).until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
        return driver ;
    }
    public WebDriver loadElementByXpath(WebDriver driver, String xpath){
        new WebDriverWait(driver, 6000).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        return driver ;
    }

}
