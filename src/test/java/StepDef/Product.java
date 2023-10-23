package StepDef;


import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;

public class Product {

    WebDriver driver;
    String baseurl = "https://www.saucedemo.com";
    @Given("I already Login to the website")
    public void iAlreadyLoginToTheWebsite() {
        driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).isDisplayed();
    }

    @When("I click add to cart button")
    public void iClickAddToCartButton() {
        WebElement addToCartButton = driver.findElement(By.name("add-to-cart-sauce-labs-backpack"));
        addToCartButton.click();
    }

    @And("I click Cart icon on the top right side website")
    public void iClickCartIconOnTheTopRightSideWebsite() {
        WebElement cartIcon = driver.findElement(By.id("shopping_cart_container"));
        cartIcon.click();
    }

    @And("I clik Checkout button")
    public void iClikCheckoutButton() {
        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();
    }

    @And("I fill in customer information")
    public void iFillInCustomerInformation() {
        WebElement firstNameField = driver.findElement(By.id("first-name"));
        firstNameField.sendKeys("Ana");

        WebElement lastNameField = driver.findElement(By.id("last-name"));
        lastNameField.sendKeys("Boe");

        WebElement postalCodeField = driver.findElement(By.id("postal-code"));
        postalCodeField.sendKeys("12345678");

        driver.findElement(By.id("continue")).click();
    }

    @And("I click Finish button")
    public void iClickFinishButton() {
        WebElement finishButton = driver.findElement(By.id("finish"));
        finishButton.click();
    }

    @Then("I successfully order product")
    public void iSuccessfullyOrderProduct() {
        WebElement finishButton = driver.findElement(By.id("back-to-products"));
        finishButton.click();
    }


    @But("I does not fill in customer information")
    public void iDoesNotFillInCustomerInformation() {
        WebElement firstNameField = driver.findElement(By.id("first-name"));
        firstNameField.sendKeys("");

        WebElement lastNameField = driver.findElement(By.id("last-name"));
        lastNameField.sendKeys("");

        WebElement postalCodeField = driver.findElement(By.id("postal-code"));
        postalCodeField.sendKeys("");

        driver.findElement(By.id("continue")).click();
    }

    @Then("System should display error message {string}")
    public void systemShouldDisplayErrorMessage(String errorMessage) {
        WebElement errorElement = driver.findElement(By.cssSelector(".error-message-container.error"));
        assertEquals(errorMessage, errorElement.getText());
        driver.quit();
    }

    @Given("I open the browser")
    public void iOpenTheBrowser() {
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
//        System.setProperty("webdriver.chrome.driver", dir+ "/driver/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", dir+"/driver/geckodriver.exe");
//        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver = new FirefoxDriver();
        driver.get(baseurl);
    }

    @And("I log in")
    public void iLogIn() {
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
    }
}
