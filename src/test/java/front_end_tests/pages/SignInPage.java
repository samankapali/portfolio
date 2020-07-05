package front_end_tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

    WebDriver wdriver;

    public SignInPage(WebDriver driver){
        this.wdriver = driver;
        PageFactory.initElements(wdriver, this);
    }

    @FindBy(xpath = "//h1[@class='page-heading']")
    public WebElement pageInfoTitle;

    // login to the existing account
    @FindBy(xpath = "//input[@name='email' and @id='email']")
    public WebElement registeredEmailAddressInput;

    @FindBy(xpath = "//input[@name='passwd' and @id='passwd']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@id='SubmitLogin']")
    public WebElement signInButton;

    @FindBy(xpath = "//a[contains(text(),'Forgot your password?')]")
    public WebElement forgotPasswordLink;

    // to create new account
    @FindBy(xpath = "//input[@name='email_create' and @id='email_create']")
    public WebElement newEmailAddressInput;

    @FindBy(xpath = "//button[@id='SubmitCreate']")
    public WebElement createAccountButton;

    // displayed messages
    @FindBy(xpath = "//div[contains(@class,'alert')][1]")
    public WebElement displayedMessages;
}
