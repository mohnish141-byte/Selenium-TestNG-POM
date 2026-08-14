package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomeTest {
    
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // WebDriverManager automatically sets up Chrome driver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Yahan My Car Helpline ka URL daal diya hai
        driver.get("https://mycarhelpline.com/");
    }

    @Test
    public void verifyHomePageTitle() {	
        String actualTitle = driver.getTitle();
        System.out.println("Page Title is: " + actualTitle);
        // Check kar rahe hain ki title khali na aaye
        Assert.assertTrue(actualTitle.length() > 0, "Title does not match!");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}