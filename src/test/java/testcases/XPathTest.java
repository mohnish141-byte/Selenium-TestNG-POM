package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XPathTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://mycarhelpline.com/");
    }

    @Test
    public void verifySearchUsingXPath() {

        // Search box ko XPath se locate kar rahe hain
        driver.findElement(By.xpath("//input[@name='q']"))
                .sendKeys("Honda City");

        // Search button ko XPath se locate karke click
        driver.findElement(By.xpath("//input[@name='sa']"))
                .click();

        // Result page ka title
        String title = driver.getTitle();

        System.out.println("Search Page Title: " + title);

        // Verification
        Assert.assertEquals(
                title,
                "Programmable Search Engine",
                "Search page title is incorrect!"
        );
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}