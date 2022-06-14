package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import page.RegisterConfirmationPage;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class RegisterNewUserSteps {
    private static WebDriver driver;

    @Given("^Browser opened Main Page(.*)$")
    public void browserOpenedTravelFinder(String mainPage) {

        //Sterownik przeglądarki-konfiguracja
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        driver.get(mainPage);
    }

    @When("^User clicked button Profile$")
    public void userClickedButtonProfile() {
        WebElement profileButton = driver.findElement(By.xpath("//img[@alt='Profile']"));
        profileButton.click();

    }

    @And("^User Clicked button Zarejestruj sie in pop-up$")
    public void userClickedButtonZarejestrujSieInPopUp() {

        WebElement registerButtonUp = driver.findElement(By.cssSelector(".dGCRpF"));
        registerButtonUp.click();

    }

    @And("^User filled out valid (.*) and (.*)$")
    public void userFilledOutDetail(String email, String password) {

        WebElement emailInput = driver.findElement(By.cssSelector("#signup-email"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);

        WebElement passwordInput = driver.findElement(By.cssSelector("#signup-password"));
        emailInput.click();
        emailInput.clear();
        passwordInput.sendKeys(password);

        WebElement messageConfirm = driver.findElement(By.cssSelector(".hp__sc-ds2rrp-15"));
        messageConfirm.getText();
        assertEquals("To hasło jest dobre", messageConfirm.getText());
    }
    @And("Screenshot is taken")
    public void screenshotIsTaken() throws Exception {
        RegisterConfirmationPage registerConfirmationPage = new RegisterConfirmationPage(driver);
        RegisterConfirmationPage.takeSnapShot(driver, "C://screenshot//test.png");

    }

//    @And("User confirmed via clicked button Zarejestruj się")
//    public void userShouldLogin() {
//        WebElement registerButtonDown = driver.findElement(By.cssSelector(".VNLwl .hp__sc-ds2rrp-10"));
//        registerButtonDown.click();
//    }
    @Then("^Browser is closed$")
    public void browserIsClosed() {
        driver.close();
    }
}
