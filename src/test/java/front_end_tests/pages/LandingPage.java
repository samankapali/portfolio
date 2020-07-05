package front_end_tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

    WebDriver wdriver;

    public LandingPage(WebDriver driver){
        this.wdriver = driver;
        PageFactory.initElements(wdriver, this);
    }
    @FindBy(xpath = "//a[@title='Log in to your customer account']")
    public WebElement pageTitle;

    @FindBy(xpath = "//a[@title='Log in to your customer account']")
    public WebElement signInButton;
}
