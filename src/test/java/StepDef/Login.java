package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class Login {

    WebDriver driver;

    String baseurl = "https://www.saucedemo.com";

    @Given("I open browser")
    public void iOpenBrowser() {
//        WebDriverManager.chromedriver().setup();
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
//        System.setProperty("webdriver.chrome.driver", dir+ "/driver/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", dir+"/driver/geckodriver.exe");
//        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver = new FirefoxDriver();


    }

    @And("Open website saucedemo")
    public void openWebsiteSaucedemo() throws InterruptedException {
        driver.get(baseurl);
        Thread.sleep(1000);
    }


    @When("I input wrong username")
    public void iInputWrongUsername() {
        driver.findElement(By.name("user-name")).sendKeys("standard_use");

    }

    @And("I input valid password")
    public void iInputValidPassword() {
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
    }

    @And("Click Login button")
    public void clickLoginButton() {
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
    }

    @Then("I should see an error message {string}")
    public void iShouldSeeAnErrorMessage(String errorMessage) {
//        WebElement errorElement = driver.findElement(By.cssSelector(".error-button"));
//        assert (errorElement.getText().contains(errorMessage));
//        driver.close();
//        driver.quit();
        WebElement errorElement = driver.findElement(By.cssSelector(".error-message-container.error"));
        assertEquals(errorMessage, errorElement.getText());
        driver.quit();
    }

    @When("I input valid username")
    public void iInputValidUsername() {
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
    }

    @Then("I go to homepage")
    public void iGoToHomepage() {
        driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).isDisplayed();
//        driver.close();
        driver.quit();
    }
}
