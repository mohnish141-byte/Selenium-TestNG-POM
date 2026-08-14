package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    // Locators
    By searchBox = By.name("q");
    By searchButton = By.name("sa");

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Verify Search Box
    public boolean isSearchBoxDisplayed() {
        return driver.findElement(searchBox).isDisplayed();
    }

    // Enter Search Text
    public void enterSearch(String text) {
        driver.findElement(searchBox).sendKeys(text);
    }

    // Get Search Text
    public String getSearchText() {
        return driver.findElement(searchBox).getAttribute("value");
    }

    // Click Search Button
    public void clickSearch() {
        driver.findElement(searchButton).click();
    }
}