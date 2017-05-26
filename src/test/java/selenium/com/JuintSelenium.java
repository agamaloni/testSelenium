package selenium.com;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by aloni on 24/05/17.
 */
public class JuintSelenium extends JunitSeleniumHelper {

    @Before
    public void init() throws IOException{
        driver = new ChromeDriver();
        System.out.println("Initializing Selenium chrome data...");

    }

    @After
    public void end() throws IOException {
        try {
            driver.close();
            System.out.println("Initializing Selenium chrome data..."); // <- It works.
        }
        catch (Exception e) {
            System.err.println("Caught IOException: " + e.getMessage());
        }

    }
    @Test
    public void skyBoxNavigateLink() throws InterruptedException {
        driver.get(PagesPath.HOME_PAGE);
        Actions action = new Actions(driver);
        Thread.sleep(6000);
        List<WebElement> solutions = driver.findElements(By.xpath(XpathField.SOLUTIONS));
        Thread.sleep(6000);
        action.moveToElement(solutions.get(0)).build().perform();
        //Go to: Solutions -> Use Cases  and select “Compliance Auditing”
        action.moveToElement(solutions.get(0)).moveToElement(driver.findElements(By.xpath(XpathField.USE_CASE)).get(0)).moveToElement(driver.findElement(By.xpath(XpathField.COMPLIANCE_AUDITING))).click().perform();
        Thread.sleep(6000);
        System.out.println("title = "+ driver.getTitle());
        //Validate that you are in the right page
        assertTrue(driver.getTitle().equals("Compliance Auditing - Skybox Security"));
    }

    @Test
    public void skyBoxPageTime(){
        long start = System.currentTimeMillis();
        driver.get(PagesPath.HOME_PAGE);
        driver.findElement(By.xpath(XpathField.PAGE_HOME_LOADED));
        long totalTime = calcTime(start);
        System.out.println("Total Time for page load in Millis - " + totalTime);
        assertTrue(driver.getTitle().equals("Skybox Security"));
    }

    @Test
    public void skyBoxContectPhones() throws InterruptedException {
        driver.get(PagesPath.CONTACT_PAGE);
        Thread.sleep(6000);
        WebElement pagePhoneUsCanadaFree = driver.findElement(By.xpath(XpathField.PHONE_US_CANADA_FREE));
        //Get Free Phone of US-Canada
        String getPhoneUsCanadaFree = pagePhoneUsCanadaFree.getText();
        System.out.println("Phone Us Canada ="+getPhoneUsCanadaFree);
        WebElement pagePhoneUsCanadaDirect = driver.findElement(By.xpath(XpathField.PHONE_US_CANADA_DIRECT));
        //Get Direct Phone of US-Canada
        String getPhoneUsCanadaDirect = pagePhoneUsCanadaDirect.getText();
        System.out.println("Phone of Us Canada direct =" + getPhoneUsCanadaDirect);
        WebElement pagePhoneAustralia = driver.findElement(By.xpath(XpathField.PHONE_AUSTRALIA));
        String getPhoneAustralia = pagePhoneAustralia.getText().substring(9).trim();
        System.out.println("Phone of Australia direct =" + getPhoneAustralia);

    }
}
