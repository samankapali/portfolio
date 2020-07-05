package front_end_tests.tests;

import front_end_tests.pages.LandingPage;
import front_end_tests.pages.SignInPage;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class StartUpTests {

    public WebDriver myDriver;
    public WebDriverWait driverWait;

    @BeforeTest
    void setupBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        System.setProperty("webdriver.chrome.driver", "src/test/browser/chromedriver");
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
//        myDriver.manage()
        LandingPage landingPageObj = new LandingPage(myDriver);
        driverWait.until(ExpectedConditions.elementToBeClickable(landingPageObj.signInButton));
        landingPageObj.signInButton.click();

        SignInPage signInPageObj = new SignInPage(myDriver);
        driverWait.until((ExpectedConditions.visibilityOf(signInPageObj.registeredEmailAddressInput)));
        signInPageObj.registeredEmailAddressInput.sendKeys("example@domain.xyz");
        signInPageObj.signInButton.click();
    }
}
