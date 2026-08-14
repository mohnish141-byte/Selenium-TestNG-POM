package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://mycarhelpline.com/");
    }

    @Test
    public void verifySearch() {

        // Search box locate karo
        driver.findElement(By.name("q")).sendKeys("Honda City");

        // Search button click karo
        driver.findElement(By.name("sa")).click();

        // Search ke baad title print karo
        String title = driver.getTitle();

        System.out.println("Search Page Title: " + title);

        // Verify karo ki search ke baad page open hua
        Assert.assertTrue(title.length() > 0,
                "Search page title is empty!");
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}