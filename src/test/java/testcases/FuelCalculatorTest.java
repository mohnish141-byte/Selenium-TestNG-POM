package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FuelCalculatorTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://mycarhelpline.com/");
    }

    // Test Case 1: Verify Page Heading
    @Test
    public void verifyPageHeading() {

        boolean isHeadingPresent =
                driver.findElements(By.tagName("h1")).size() > 0
                || driver.findElements(By.tagName("h2")).size() > 0;

        System.out.println("Main Heading Present: " + isHeadingPresent);

        Assert.assertTrue(
                isHeadingPresent,
                "Main Heading not found on the page!"
        );
    }

    // Test Case 2: Verify Input Fields
    @Test
    public void verifyInputFields() {

        int inputCount =
                driver.findElements(By.tagName("input")).size();

        System.out.println("Total Input Fields: " + inputCount);

        Assert.assertTrue(
                inputCount > 0,
                "Input fields not found!"
        );
    }

    // Test Case 3: Verify Search Button
    @Test
    public void verifyButtons() {

        boolean buttonPresent =
                driver.findElements(By.name("sa")).size() > 0;

        System.out.println("Search Button Present: " + buttonPresent);

        Assert.assertTrue(
                buttonPresent,
                "Search button not found!"
        );
    }

    // Test Case 4: Verify Links
    @Test
    public void verifyLinks() {

        int linkCount =
                driver.findElements(By.tagName("a")).size();

        System.out.println("Total Links: " + linkCount);

        Assert.assertTrue(
                linkCount > 0,
                "Links not found!"
        );
    }

    // Test Case 5: Verify Search Box
    @Test
    public void verifySearchBox() {

        boolean searchBoxPresent =
                driver.findElements(By.name("q")).size() > 0;

        System.out.println("Search Box Present: " + searchBoxPresent);

        Assert.assertTrue(
                searchBoxPresent,
                "Search Box not found!"
        );
    }

    // Test Case 6: Verify Search Functionality
    @Test
    public void verifySearchFunctionality() {

        // Find Search Box
        driver.findElement(By.name("q")).sendKeys("Maruti");

        System.out.println("Text entered in Search Box: Maruti");

        // Click Search Button
        driver.findElement(By.name("sa")).click();

        System.out.println("Search Button clicked");

        // Get current URL
        String currentUrl = driver.getCurrentUrl();

        System.out.println("Current URL: " + currentUrl);

        // Verify search result page
        Assert.assertTrue(
                currentUrl.contains("google"),
                "Search result page was not opened!"
        );
    }

    // Close Browser After Each Test
    @AfterMethod
    public void teardown() {

        if (driver != null) {
            driver.quit();
        }
    }
}
	
	
	
	
	
	
	
