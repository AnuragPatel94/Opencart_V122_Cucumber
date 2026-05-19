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

	public LoginPage clickLogin() {
				try {
			WebElement loginLink = driver.findElement(By.linkText("Login"));
			loginLink.click();
		} catch (Exception e) {
			// If linkText fails, try alternative locator
			try {
				WebElement loginLink = driver.findElement(By.xpath("//a[text()='Login']"));
				loginLink.click();
			} catch (Exception ex) {
				System.out.println("Warning: clickLogin() could not find/click the Login link: " + ex.getMessage());
			}
		}
		return new LoginPage(driver);
		
	}

	public boolean isHomePageExists() {
		 try {
	            // Check for a unique element on the Home page (adjust locator as needed)
	            WebElement homeUniqueElement = driver.findElement(By.xpath("//h1[text()='Your Store']|//div[@id='content']//h1"));
	            return homeUniqueElement.isDisplayed();
	        } catch (Exception e) {
	            System.out.println("Home page unique element not found: " + e.getMessage());
	        }
		return false;
	}

	public void enterProductName(String productName) {
		 try {
	            WebElement searchBox = driver.findElement(By.name("search"));
	            searchBox.clear();
	            searchBox.sendKeys(productName);
	        } catch (Exception e) {
	            System.out.println("Search box not found: " + e.getMessage());
	        }
	}

	public SearchResultsPage clickSearch() {
		 try {
	            WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit' and @class='btn btn-default btn-lg']"));
	            searchButton.click();
	            return new SearchResultsPage(driver);
	        } catch (Exception e) {
	            System.out.println("Search button not found/clickable: " + e.getMessage());
	        }
		return null;
	}
}
