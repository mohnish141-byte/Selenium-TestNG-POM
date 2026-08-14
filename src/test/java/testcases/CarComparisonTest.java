package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CarComparisonTest {
    
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mycarhelpline.com/");
    }

    @Test
    public void verifyNavigationLinks() {
        // Check karenge ki page par links available hain ya nahi
        boolean areLinksPresent = driver.findElements(By.tagName("a")).size() > 0;
        System.out.println("Are navigation links present: " + areLinksPresent);
        Assert.assertTrue(areLinksPresent, "No links found on the homepage!");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}