package front_end_tests.tests;

import front_end_tests.pages.LandingPage;
import front_end_tests.pages.SignInPage;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class StartUpTests {

    public WebDriver myDriver;
    public WebDriverWait driverWait;

    @BeforeMethod
    void setupBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        System.setProperty("webdriver.chrome.driver", "src/test/browser/mac/chromedriver");
        myDriver = new ChromeDriver(options);
        driverWait = new WebDriverWait(myDriver, 20);
    }

    @Test
    public void gotoTheUrl(){
        myDriver.manage().window().maximize();
        myDriver.get("http://automationpractice.com");
    }

    @Test
    public void gotoTheSignInPage(){
        myDriver.manage().window().maximize();
        myDriver.get("http://automationpractice.com");
        LandingPage landingPageObj = new LandingPage(myDriver);
        driverWait.until(ExpectedConditions.elementToBeClickable(landingPageObj.signInButton));
        landingPageObj.signInButton.click();

        SignInPage signInPageObj = new SignInPage(myDriver);
        driverWait.until((ExpectedConditions.visibilityOf(signInPageObj.registeredEmailAddressInput)));
        signInPageObj.registeredEmailAddressInput.sendKeys("example@domain.xyz");
        signInPageObj.signInButton.click();
    }

    @Test
    public void signInWithoutPassword(){
        myDriver.manage().window().maximize();
        myDriver.get("http://automationpractice.com");
        LandingPage landingPageObj = new LandingPage(myDriver);
        driverWait.until(ExpectedConditions.elementToBeClickable(landingPageObj.signInButton));
        landingPageObj.signInButton.click();

        SignInPage signInPageObj = new SignInPage(myDriver);
        driverWait.until((ExpectedConditions.visibilityOf(signInPageObj.registeredEmailAddressInput)));
        signInPageObj.registeredEmailAddressInput.sendKeys("example@domain.xyz");
        signInPageObj.signInButton.click();
        driverWait.until((ExpectedConditions.visibilityOf(signInPageObj.displayedMessages)));
        signInPageObj.displayedMessages.getText().compareToIgnoreCase("password is required");
    }
    @Test
    public void signInWithoutEmail(){
        myDriver.manage().window().maximize();
        myDriver.get("http://automationpractice.com");
        LandingPage landingPageObj = new LandingPage(myDriver);
        driverWait.until(ExpectedConditions.elementToBeClickable(landingPageObj.signInButton));
        landingPageObj.signInButton.click();

        SignInPage signInPageObj = new SignInPage(myDriver);
        driverWait.until((ExpectedConditions.visibilityOf(signInPageObj.registeredEmailAddressInput)));
        signInPageObj.registeredEmailAddressInput.sendKeys("example");
        signInPageObj.signInButton.click();
        driverWait.until((ExpectedConditions.visibilityOf(signInPageObj.displayedMessages)));
        signInPageObj.displayedMessages.getText().compareToIgnoreCase("invalid email address");
    }
    @Test
    public void falseEmailInput() throws InterruptedException {
        myDriver.manage().window().maximize();
        myDriver.get("http://automationpractice.com");
        LandingPage landingPageObj = new LandingPage(myDriver);
        driverWait.until(ExpectedConditions.elementToBeClickable(landingPageObj.signInButton));
        landingPageObj.signInButton.click();

        SignInPage signInPageObj = new SignInPage(myDriver);
        driverWait.until((ExpectedConditions.visibilityOf(signInPageObj.registeredEmailAddressInput)));
        signInPageObj.registeredEmailAddressInput.sendKeys("example@domain.xyz");
        signInPageObj.passwordInput.sendKeys("examplePassword");
        myDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        signInPageObj.signInButton.click();
        driverWait.until((ExpectedConditions.visibilityOf(signInPageObj.displayedMessages)));
        signInPageObj.displayedMessages.getText().compareToIgnoreCase("authentication failed");
    }

    @Test
    public void falsePasswordInput(){

    }

    @Test
    public void genuineUserLogin(){

    }

    @AfterMethod
    public void tearDown(){
        System.out.println("Ending the Tests ...");
        myDriver.quit();
    }
}
