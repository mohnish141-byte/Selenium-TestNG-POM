package pages;

import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Get page title
    public String getPageTitle() {
        return driver.getTitle();
    }
}