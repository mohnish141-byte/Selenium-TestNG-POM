package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Yahan My Car Helpline ka URL set kar diya hai
        driver.get("https://mycarhelpline.com/");
    }

    @Test
    public void verifyHomePage() {
        String actualTitle = driver.getTitle();
        System.out.println("Page Title is: " + actualTitle);
        // Basic check ki website khul rahi hai ya nahi
        Assert.assertTrue(actualTitle.length() > 0, "Title is empty!");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}