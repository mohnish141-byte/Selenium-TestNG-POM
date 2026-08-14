package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CarSearchTest {
    
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mycarhelpline.com/");
    }

    @Test
    public void verifySearchOrHeaderSection() {
        // Check karenge ki website ka main header ya logo properly display ho raha hai ya nahi
        boolean isLogoPresent = driver.findElements(By.xpath("//img")).size() > 0;
        System.out.println("Are images/logo present on page: " + isLogoPresent);
        Assert.assertTrue(isLogoPresent, "Logo or images not found on homepage!");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
