package front_end_tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SignupPage {

    WebDriver wdriver;

    public SignupPage(WebDriver driver){
        this.wdriver = driver;
        PageFactory.initElements(wdriver, this);
    }

    @FindBy(xpath = "")
    public WebElement formTitle;

    @FindBy(xpath = "//input[@name='id_gender' and @id='id_gender1']")
    public WebElement titleMrRdbutton;
    @FindBy(xpath = "//input[@name='id_gender' and @id='id_gender2']")
    public WebElement titleMsRdbutton;
    @FindBy(xpath = "//input[@name='customer_firstname']")
    public WebElement firstNameInput;
    @FindBy(xpath = "//input[@name='customer_lastname']")
    public WebElement lastNameInput;
    @FindBy(xpath = "//input[@name='email' and @id='email']")
    public WebElement emailInput;
    @FindBy(xpath = "//input[@name='passwd' and @id='passwd']")
    public WebElement passwordInput;

    //handling day, month and year selection box
    @FindBy(xpath = "//select[@id='days' and @name='days']")
    public WebElement daySelection;
    @FindBy(xpath = "//select[@id='months' and @name='months']")
    public WebElement monthSelection;
    @FindBy(xpath = "//select[@id='years' and @name='years']")
    public WebElement yearSelection;

    @FindBy(xpath = "//input[@id='firstname' and @name='firstname']")
    public WebElement addressFNameInput;
    @FindBy(xpath = "//input[@id='lastname' and @name='lastname']")
    public WebElement addressLNameInput; //company
    @FindBy(xpath = "//input[@id='company' and @name='company']")
    public WebElement companyNameInput;
    @FindBy(xpath = "//input[@id='address1' and @name='address1']")
    public WebElement addressInput;
    @FindBy(xpath = "//input[@id='address2' and @name='address2']")
    public WebElement addressLine2Input;
    @FindBy(xpath = "//input[@id='city' and @name='city']")
    public WebElement cityNameInput;
    @FindBy(xpath = "//select[@id='id_state' and @name='id_state']")
    public WebElement stateSelection;
    @FindBy(xpath = "//input[@id='postcode' and @name='postcode']")
    public WebElement zipInput;
    @FindBy(xpath = "//select[@id='id_country' and @name='id_country']")
    public WebElement countrySelection;
    @FindBy(xpath = "//textarea[@id='other' and @name='other']")
    public WebElement additionalInfoTextbox;
    @FindBy(xpath = "//input[@id='phone' and @name='phone']")
    public WebElement homePhoneInput;
    @FindBy(xpath = "//input[@id='phone_mobile' and @name='phone_mobile']")
    public WebElement mobilePhoneInput; //alias
    @FindBy(xpath = "//input[@id='alias' and @name='alias']")
    public WebElement aliasAddressInput;

    @FindBy(xpath = "//button[@name='submitAccount' and @id='submitAccount']")
    public WebElement registerButton;

    // form error prompt
    @FindBy(xpath = "")
    public WebElement formActionMessages;


    // pick the title for the user
    public void setTitle(String title){
        if(title.equalsIgnoreCase("mr")){
            titleMrRdbutton.click();
        }
        else if(title.equalsIgnoreCase("mrs")){
            titleMsRdbutton.click();
        }
        else {
            throw new IllegalArgumentException("[Test Input Error] Title given not available for selection.");
        }
    }

    // set state and country
    public void setCountryAndState(String stateName, String countryName){
        Select country = new Select(countrySelection);
        country.selectByVisibleText(countryName);

        Select state = new Select(stateSelection);
        state.selectByVisibleText(stateName);
    }

    // set the date given in a MMDDYYYY format
    public void setDateMMDDYYYY(String dateMMDDYYYY){
        String[] dateSplit = dateMMDDYYYY.split("-");
        Select daySelect = new Select(daySelection);
        Select monthSelect = new Select(monthSelection);
        Select yearSelect = new Select(yearSelection);

        daySelect.selectByIndex(Integer.parseInt(dateSplit[1]));
        monthSelect.selectByIndex(Integer.parseInt(dateSplit[0]));
        yearSelect.selectByIndex(2021-Integer.parseInt(dateSplit[2]));
    }
}
