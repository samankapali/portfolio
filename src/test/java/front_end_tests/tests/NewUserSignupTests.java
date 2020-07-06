package front_end_tests.tests;

import front_end_tests.pages.LandingPage;
import front_end_tests.pages.SignInPage;
import front_end_tests.pages.SignupPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class NewUserSignupTests extends StartUpTests{

    @Test
    void signUpNewUser(){
        myDriver.manage().window().maximize();
        myDriver.get("http://automationpractice.com");

        myDriver.manage().window().maximize();
        myDriver.get("http://automationpractice.com");
        LandingPage landingPageObj = new LandingPage(myDriver);
        driverWait.until(ExpectedConditions.elementToBeClickable(landingPageObj.signInButton));
        landingPageObj.signInButton.click();

        SignInPage signInPageObj = new SignInPage(myDriver);
        driverWait.until(ExpectedConditions.elementToBeClickable(signInPageObj.newEmailAddressInput));
        signInPageObj.newEmailAddressInput.sendKeys("example@domain.xyz");
        signInPageObj.createAccountButton.click();

        SignupPage signUpPageObj = new SignupPage(myDriver);
        myDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        signUpPageObj.titleMrRdbutton.click();
        signUpPageObj.firstNameInput.sendKeys("Saman");
        signUpPageObj.lastNameInput.sendKeys("Kapali");
        signUpPageObj.emailInput.clear();
        signUpPageObj.emailInput.sendKeys("demouser@domain.xyz");
        signUpPageObj.passwordInput.sendKeys("qwerty123");

        signUpPageObj.setDateMMDDYYYY("07-21-1990");

        signUpPageObj.addressFNameInput.sendKeys("Saman");
        signUpPageObj.addressLNameInput.sendKeys("Kapali");
        signUpPageObj.companyNameInput.sendKeys("STUDENT");
        signUpPageObj.addressInput.sendKeys("NSW, Australia");
        signUpPageObj.addressLine2Input.sendKeys("NSW, Australia");
        signUpPageObj.cityNameInput.sendKeys("Shitty");
        signUpPageObj.zipInput.sendKeys("22160");
        signUpPageObj.homePhoneInput.sendKeys("0420710000");
        signUpPageObj.mobilePhoneInput.sendKeys("0420710000");
        signUpPageObj.registerButton.click();

        myDriver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

    }

    @Test (dataProvider = "newUserData", dataProviderClass = NewUserData.class)
    void signUpNewUsers(String inputData){
        myDriver.manage().window().maximize();
        myDriver.get("http://automationpractice.com");

        // landing page where the url directs us
        LandingPage landingPageObj = new LandingPage(myDriver);
        driverWait.until(ExpectedConditions.elementToBeClickable(landingPageObj.signInButton));
        landingPageObj.signInButton.click();

        // we reach the sign-in page
        SignInPage signInPageObj = new SignInPage(myDriver);
        driverWait.until(ExpectedConditions.elementToBeClickable(signInPageObj.newEmailAddressInput));
        signInPageObj.newEmailAddressInput.sendKeys("example@domain.xyz");
        signInPageObj.createAccountButton.click();

        // sign-up option is available in the sign-in page itself
        SignupPage signUpPageObj = new SignupPage(myDriver);
        myDriver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

        // filling up the form
        String[] userData = inputData.split("\\|");
        // setting the title first
        signUpPageObj.setTitle("Mr");
        signUpPageObj.firstNameInput.sendKeys(userData[0]);
        signUpPageObj.lastNameInput.sendKeys(userData[1]);
        signUpPageObj.emailInput.clear();
        signUpPageObj.emailInput.sendKeys(userData[2]);
        signUpPageObj.passwordInput.sendKeys(userData[3]);

        // setting the date
        signUpPageObj.setDateMMDDYYYY(userData[4]);

        // These inputs are pre-filled (Supposition that it is the requirement.)
//        signUpPageObj.addressFNameInput.sendKeys("Saman");
//        signUpPageObj.addressLNameInput.sendKeys("Kapali");
        
        signUpPageObj.companyNameInput.sendKeys(userData[5]);
        signUpPageObj.addressInput.sendKeys(userData[6]);
        signUpPageObj.addressLine2Input.sendKeys(userData[7]);
        signUpPageObj.cityNameInput.sendKeys(userData[8]);
        signUpPageObj.setCountryAndState(userData[9], userData[11]);
        signUpPageObj.zipInput.sendKeys(userData[10]);
        signUpPageObj.additionalInfoTextbox.sendKeys(userData[12]);
        signUpPageObj.homePhoneInput.sendKeys(userData[13]);
        signUpPageObj.mobilePhoneInput.sendKeys(userData[14]);
        signUpPageObj.registerButton.click();

        myDriver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    }


}
