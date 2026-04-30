package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Click the My Account element (best-effort; adjust locator if needed)
    public void clickMyAccount() {
        try {
            WebElement myAccount = driver.findElement(By.xpath("//span[text()='My Account']|//a[@title='My Account']"));
            myAccount.click();
        } catch (Exception e) {
            // Log or ignore; method is a convenience for tests
            System.out.println("Warning: clickMyAccount() could not find/click the element: " + e.getMessage());
        }
    }

    // Navigate to Register page and return the RegistrationPage object
    public RegistrationPage clickRegister() {
        try {
            WebElement registerLink = driver.findElement(By.linkText("Register"));
            registerLink.click();
        } catch (Exception e) {
            // If linkText fails, try alternative locator
            try {
                WebElement registerLink = driver.findElement(By.xpath("//a[text()='Register']"));
                registerLink.click();
            } catch (Exception ex) {
                System.out.println("Warning: clickRegister() could not find/click the Register link: " + ex.getMessage());
            }
        }
        return new RegistrationPage(driver);
    }
}
