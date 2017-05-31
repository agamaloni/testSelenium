package selenium.com;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by aloni on 24/05/17.
 */
public class JuintSelenium extends JunitSeleniumHelper {
    long start;
    List<WebElement> findElements;
    WebElement enter;
    @Before
    public void init() throws IOException, InterruptedException {
        //init chrome browser set load timeout to 30 sec
        driver = super.useSeleniumChrome();
        System.out.println("Initializing Selenium chrome data...");
        //find search bar
        enter = driver.findElement(By.xpath(XpathField.GOOGLE_SEARCH));
        //enter search text
        enter.sendKeys("Hattrick");
        //enter keyboard
        enter.sendKeys(Keys.ENTER);
        //wait page load with result
        super.loadElementById(driver, "resultStats");
        //find result elements
        findElements = driver.findElements(By.xpath("//*[@id='rso']//h3/a"));
        //Count the result of on the page
        countLines(findElements);
    }

    @After
    public void end() throws IOException {
        try {
            driver.close();
            System.out.println("Initializing Selenium chrome data...");
        }
        catch (Exception e) {
            System.err.println("Caught IOException: " + e.getMessage());
        }

    }
    @Test
    public void navigateLink() throws InterruptedException {
        //enter website from google
        findElements.get(0).sendKeys(Keys.ENTER);
        Actions action = new Actions(driver);
        //find elements for bar
        //List<WebElement> solutions = driver.findElements(By.xpath(XpathField.SOLUTIONS));
        //navigate in bar
        //action.moveToElement(solutions.get(0)).build().perform();
        //Go to: Solutions -> Use Cases  and select “Compliance Auditing”
        //action.moveToElement(solutions.get(0)).moveToElement(driver.findElements(By.xpath(XpathField.USE_CASE)).get(0)).moveToElement(driver.findElement(By.xpath(XpathField.COMPLIANCE_AUDITING))).click().perform();
        System.out.println("title = "+ driver.getTitle());
        //Validate that you are in the right page
        assertTrue(driver.getTitle().startsWith("Hattrick"));
    }

    @Test
    public void pageTime(){
        //start time
        start = System.currentTimeMillis();
        //Enter page from google
        findElements.get(0).sendKeys(Keys.ENTER);
       // super.loadElementByXpath(driver,XpathField.PAGE_HOME_LOADED);
        //calculate the load time of the page millis
        long totalTime = calcTime(start);
        System.out.println("Total Time for page load in Millis - " + totalTime);
        assertTrue(driver.getTitle().startsWith("Hattrick"));
    }

    @Test
    public void contectPhones() throws InterruptedException {
        findElements.get(0).sendKeys(Keys.ENTER);
        //Redirect to Connect page
        //driver.get(PagesPath.CONTACT_PAGE);
        //WebElement pagePhoneUsCanadaFree = driver.findElement(By.xpath(XpathField.PHONE_US_CANADA_FREE));
        //Get Free Phone of US-Canada
        //String getPhoneUsCanadaFree = pagePhoneUsCanadaFree.getText();
        //System.out.println("Phone Us Canada ="+getPhoneUsCanadaFree);
        //WebElement pagePhoneUsCanadaDirect = driver.findElement(By.xpath(XpathField.PHONE_US_CANADA_DIRECT));
        //Get Direct Phone of US-Canada
        //String getPhoneUsCanadaDirect = pagePhoneUsCanadaDirect.getText();
        //System.out.println("Phone of Us Canada direct =" + getPhoneUsCanadaDirect);
       // WebElement pagePhoneAustralia = driver.findElement(By.xpath(XpathField.PHONE_AUSTRALIA));
        //Get Direct Phone of Australia
        //String getPhoneAustralia = pagePhoneAustralia.getText().substring(9).trim();
        //System.out.println("Phone of Australia direct =" + getPhoneAustralia);

    }
}
