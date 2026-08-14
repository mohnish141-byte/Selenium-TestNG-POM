package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {

    WebDriver driver;

    // Locators
    By searchBox = By.name("q");
    By searchButton = By.name("sa");

    // Constructor
    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    // Search Box
    public WebElement getSearchBox() {
        return driver.findElement(searchBox);
    }

    // Enter Search Text
    public void enterSearchText(String text) {
        driver.findElement(searchBox).sendKeys(text);
    }

    // Click Search Button
    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }
}