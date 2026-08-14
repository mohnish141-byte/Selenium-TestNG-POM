package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://mycarhelpline.com/");

        // Explicit Wait create
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void verifySearchUsingWait() {

        // Search box visible hone ka wait
        By searchBox = By.name("q");

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(searchBox)
        );

        // Search box me text enter
        driver.findElement(searchBox).sendKeys("Honda City");

        // Search button
        By searchButton = By.name("sa");

        wait.until(
                ExpectedConditions.elementToBeClickable(searchButton)
        );

        driver.findElement(searchButton).click();

        // Result page ka title
        String title = driver.getTitle();

        System.out.println("Search Page Title: " + title);

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
