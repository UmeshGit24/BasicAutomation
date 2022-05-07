package com.test.makemytrip.testScript.TestClass;

import com.test.makemytrip.pageobject.HomePage;
import com.test.makemytrip.pageobject.LoginPage;
import com.test.makemytrip.testScript.BaseTest.BaseTest;
import com.test.makemytrip.utilities.ConfigLoader;
import com.test.makemytrip.utilities.WebUtility;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTestCases extends BaseTest {

    private String baseurl;

     BaseTest baseTest=new BaseTest();
     LoginPage loginPage;
     HomePage homePage;
    @BeforeClass(alwaysRun = true)
    public void beforeClass(){

        baseurl=ConfigLoader.getInstance().getPropertyValue("BASE_URL");
        loginPage=new LoginPage(getDriver());
        homePage =new HomePage(getDriver());
        WebUtility.goToUrl(driver,baseurl);
        homePage.closeLoginAccountPopUpIfPresent();
    }

    @BeforeMethod
    public void beforeMethod(){
        homePage.clickOnLoginButton();
    }


    @Test(description = "Verify all the element on Login/Signup page",priority = 1)
    public void verifyAllElementOnLoginPopUp(){
        SoftAssert softAssert=getSoftAssert();
        softAssert.assertTrue(loginPage.verifyloginSectionIsDisplayed());
        softAssert.assertTrue(loginPage.verifyPersonalAccountIsDisplayed());
        softAssert.assertTrue(loginPage.verifyMyBizAccountIsDisplayed());
        softAssert.assertTrue(loginPage.verifyTitleIsDispalyed());
        softAssert.assertTrue(loginPage.verifyUsernameFieldIsDisplayed());
        softAssert.assertTrue(loginPage.verifyContinueButtonIsDisplayed());
        softAssert.assertTrue(loginPage.verifyLoginWithGoogleIsDisplayed());
        softAssert.assertFalse(loginPage.verifyContinueButtonOnLoginPageIsEnabled());
        softAssert.assertTrue(loginPage.verifyLoginSignupTittle("Login/Signup"));
        softAssert.assertTrue(loginPage.verifyPersonalAccountTabIsSelected());
        softAssert.assertAll();
    }

    @Test(description = "Verify Login with Correct Username and Password",priority = 2)
    public void loginWithValidCredentials(){
        SoftAssert softAssert=getSoftAssert();
        Assert.assertTrue(loginPage.verifyPersonalAccountTabIsSelected());
        Assert.assertTrue(loginPage.verifyLoginSignupTittle("Login/Signup"));
        Assert.assertTrue(loginPage.verifyUsernameFieldIsDisplayed());
        Assert.assertEquals(loginPage.getUserNameFieldPlaceHolderText(),"Enter email or mobile number");
        Assert.assertFalse(loginPage.verifyContinueButtonOnLoginPageIsEnabled());
        loginPage.enterUsernameToLogin("9536082987");
        Assert.assertTrue(loginPage.verifyContinueButtonOnLoginPageIsEnabled());
        loginPage.clickOnContinueButtonInLoginPage();
        Assert.assertTrue(loginPage.verifyLoginViaPasswordLinkIsDisplayed());
        loginPage.clickOnLoginViaPasswordLink();
        Assert.assertTrue(loginPage.verifyBackButtonOnLoginViaPasswordPage());
        Assert.assertTrue(loginPage.verifyTitleOnLoginViaPasswordPage("Login With Password"));
        Assert.assertTrue(loginPage.verifyPasswordFieldIsDisplayed());
        Assert.assertEquals(loginPage.getPasswordFieldPlaceHolderText(),"Minimum 6 characters.");
        Assert.assertTrue(loginPage.verifyResetPasswordLinkIsDisplayed());
        Assert.assertTrue(loginPage.verifyLoginButtonIsDispalyed());
        Assert.assertTrue(loginPage.verifyLoginButtonIsDisableTillMinimumCharactersPasswordIsNotEntered());
        loginPage.enterPassword("");
        Assert.assertFalse(loginPage.verifyLoginButtonIsDisableTillMinimumCharactersPasswordIsNotEntered());
        loginPage.clickOnLoginButton();
        Assert.assertEquals(loginPage.getLoggedInUserName(),"Hi UserName");
//        softAssert.assertAll();

    }

    @Test(description = "Verify login with invalid username",priority = 3)
    public void loginWithInValidUsername(){
        SoftAssert softAssert=getSoftAssert();
        Assert.assertTrue(loginPage.verifyPersonalAccountTabIsSelected());
        Assert.assertTrue(loginPage.verifyLoginSignupTittle("Login/Signup"));
        Assert.assertTrue(loginPage.verifyUsernameFieldIsDisplayed());
        Assert.assertEquals(loginPage.getUserNameFieldPlaceHolderText(),"Enter email or mobile number");
        Assert.assertFalse(loginPage.verifyContinueButtonOnLoginPageIsEnabled());
        loginPage.enterUsernameToLogin("9536082");
        Assert.assertTrue(loginPage.verifyContinueButtonOnLoginPageIsEnabled());
        loginPage.clickOnContinueButtonInLoginPage();
        Assert.assertTrue(loginPage.verifyInvalidPhoneNumberErrorMessage());
        Assert.assertEquals(loginPage.getInvalidPhoneNumberErrorMessageText(),"Invalid phone number");
        Assert.assertTrue(loginPage.verifyLoginSignupTittle("Login/Signup"));
//        softAssert.assertAll();
    }

    @Test(description = "Verify Login with correct username but wrong password and also verify minimum character length for password",priority = 4)
    public void loginWithCorrectUserNameAndWrongPassword(){
        SoftAssert softAssert=getSoftAssert();
        Assert.assertTrue(loginPage.verifyPersonalAccountTabIsSelected());
        softAssert.assertTrue(loginPage.verifyLoginSignupTittle("Login/Signup"));
        softAssert.assertTrue(loginPage.verifyUsernameFieldIsDisplayed());
        softAssert.assertEquals(loginPage.getUserNameFieldPlaceHolderText(),"Enter email or mobile number");
        softAssert.assertTrue(loginPage.verifyContinueButtonIsDisabledWhenUserNameIsNotEntered());
        loginPage.enterUsernameToLogin("9536082987");
        Assert.assertTrue(loginPage.verifyContinueButtonOnLoginPageIsEnabled());
        loginPage.clickOnContinueButtonInLoginPage();
        softAssert.assertTrue(loginPage.verifyLoginViaPasswordLinkIsDisplayed());
        loginPage.clickOnLoginViaPasswordLink();
        softAssert.assertTrue(loginPage.verifyBackButtonOnLoginViaPasswordPage());
        softAssert.assertTrue(loginPage.verifyTitleOnLoginViaPasswordPage("Login With Password"));
        softAssert.assertTrue(loginPage.verifyPasswordFieldIsDisplayed());
        softAssert.assertEquals(loginPage.getPasswordFieldPlaceHolderText(),"Minimum 6 characters.");
        softAssert.assertTrue(loginPage.verifyResetPasswordLinkIsDisplayed());
        softAssert.assertTrue(loginPage.verifyLoginButtonIsDispalyed());
        softAssert.assertTrue(loginPage.verifyLoginButtonIsDisableTillMinimumCharactersPasswordIsNotEntered());
        loginPage.enterPassword("Wron");
        softAssert.assertTrue(loginPage.verifyLoginButtonIsDisableTillMinimumCharactersPasswordIsNotEntered());
        loginPage.clickOnLoginButton();
        softAssert.assertTrue(loginPage.verifyMinimumLengthCharacterErrorMessage());
        softAssert.assertEquals(loginPage.getMinimumLengthCharacterErrorMessageText(),"Password cannot be less than 6 characters.");
        loginPage.clearPasswordField();
        loginPage.enterPassword("WrongPassword");
        Assert.assertFalse(loginPage.verifyLoginButtonIsDisableTillMinimumCharactersPasswordIsNotEntered());
        loginPage.clickOnLoginButton();
        softAssert.assertTrue(loginPage.verifyWrongPasswordErrorMessage());
        softAssert.assertEquals(loginPage.getWrongPasswordErrorMessageText(),"Looks like we are facing some technical issues, please try again in some time.");
        Assert.assertTrue(loginPage.verifyTitleOnLoginViaPasswordPage("Login With Password"));
        softAssert.assertAll();

    }

    @AfterMethod
    public void afterMethod(){
        homePage.clickOnLoginButton();

    }











}
