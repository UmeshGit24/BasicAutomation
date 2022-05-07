package com.test.makemytrip.pageobject;

import com.test.makemytrip.testScript.BaseTest.BaseTest;
import com.test.makemytrip.utilities.BrowserSetUp;
import com.test.makemytrip.utilities.WebUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {


    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);


    }

    @FindBy(xpath = "//section[contains(@class,'modalMain')]")
    private WebElement loginSection;
    @FindBy(xpath = "//li[@data-cy='personalLogin']")
    public WebElement personalAccount;
    @FindBy(xpath = "//li[text()='MyBiz Account']" )
    public WebElement myBizAccount;
    @FindBy(xpath = "//p[@data-cy='commonModal']/span")
    public WebElement tittle;
    @FindBy(xpath ="//label[@for='username']")
    public WebElement emailAndMobileHeading;
    @FindBy(xpath = "//input[@id='username']")
    public WebElement userName;
    @FindBy(xpath = "//div[@data-cy='googleLogin']")
    public WebElement loginWithGoogleButton;
    @FindBy(xpath = "//p[@data-cy='error']")
    public WebElement wrongUserNameErrorMessage;
    @FindBy(xpath = "//span[@data-cy='serverError']")
    public WebElement invalidPhoneNumberErrorMessage;
    @FindBy(xpath = "//button[@data-cy='continueBtn']")
    public WebElement continueButton;
    @FindBy(xpath = "//a[text()='Back']")
    public WebElement backButton;
    @FindBy(xpath = "//div[@class='switchLoginFlow']/a")
    public WebElement loginViaPassword;
    @FindBy(xpath = "//p[@data-cy='commonModal']/span")
    public WebElement loginWithPasswordTittle;
    @FindBy(xpath = "//button[@data-cy='login']")
    public WebElement loginButton;
    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordField;
    @FindBy(xpath = "//span[@data-cy='serverError']")
    public WebElement wrongPasswordErrorMessage;
    @FindBy(xpath = "//p[@data-cy='error']")
    public WebElement minimumPasswordLimitErrorMsg;
    @FindBy(xpath ="//a[@data-cy='resetPassword']")
    public WebElement resetPasswordLink;
    @FindBy(xpath = "//p[@data-cy='loggedInUser']")
    public WebElement loggedInUser;


    public boolean verifyloginSectionIsDisplayed(){

        return WebUtility.isDisplayed(loginSection);
    }


    public boolean verifyPersonalAccountIsDisplayed(){

        return WebUtility.isDisplayed(personalAccount);
    }

    public boolean verifyMyBizAccountIsDisplayed(){

        return WebUtility.isDisplayed(myBizAccount);
    }

    public boolean  verifyTitleIsDispalyed(){

        return WebUtility.isDisplayed(tittle);
    }
    public boolean verifyUsernameFieldIsDisplayed(){

        return WebUtility.isDisplayed(userName);
    }

    public boolean verifyContinueButtonIsDisplayed(){

        return WebUtility.isDisplayed(continueButton);
    }
    public boolean verifyLoginWithGoogleIsDisplayed(){

        return WebUtility.isDisplayed(loginWithGoogleButton);
    }

    public boolean verifyContinueButtonIsDisabledWhenUserNameIsNotEntered(){
        return WebUtility.isEnabled(continueButton);
    }


    public String getUserNameFieldPlaceHolderText(){
        return WebUtility.getAttributeValue(userName,"placeholder");
    }

    public void  enterUsernameToLogin(String key){

        WebUtility.sendKeys(userName,key);
    }

    public void clickOnContinueButtonInLoginPage(){
        WebUtility.waitTillElementIsNotVisible(continueButton);
        continueButton.click();
        try{
            Thread.sleep(5000);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public boolean verifyContinueButtonOnLoginPageIsEnabled(){
        return WebUtility.isEnabled(continueButton);
    }

    public boolean verifyPersonalAccountTabIsSelected(){
      String value= WebUtility.getAttributeValue(personalAccount,"class");
        return value.equals("active");
    }

    public boolean verifyLoginSignupTittle(String expectedPageTitle){
        String pagetitle=WebUtility.getText(tittle);
        return expectedPageTitle.equals(pagetitle);


    }

    public boolean verifyInvalidPhoneNumberErrorMessage(){
        return WebUtility.isDisplayed(invalidPhoneNumberErrorMessage);
    }

    public String getInvalidPhoneNumberErrorMessageText(){
        return  WebUtility.getText(invalidPhoneNumberErrorMessage);
    }


    public boolean verifyLoginViaPasswordLinkIsDisplayed(){
        WebUtility.waitTillElementIsNotVisible(loginViaPassword);
        return WebUtility.isDisplayed(loginViaPassword);
    }

    public void clickOnLoginViaPasswordLink(){

        loginViaPassword.click();
    }

    public boolean verifyBackButtonOnLoginViaPasswordPage(){
        return WebUtility.isDisplayed(backButton);

    }

    public boolean verifyTitleOnLoginViaPasswordPage(String titleOnLoginWithPassword) {
        return titleOnLoginWithPassword.equals(WebUtility.getText(loginWithPasswordTittle));

    }
    public boolean verifyPasswordFieldIsDisplayed(){
        return WebUtility.isDisplayed(passwordField);
    }

    public String getPasswordFieldPlaceHolderText(){
       return WebUtility.getAttributeValue(passwordField,"placeholder");

    }

    public boolean verifyResetPasswordLinkIsDisplayed(){
        return WebUtility.isDisplayed(resetPasswordLink);
    }
    public boolean verifyLoginButtonIsDisableTillMinimumCharactersPasswordIsNotEntered(){

        return Boolean.parseBoolean(WebUtility.getAttributeValue(loginButton,"xpath"));

    }
    public void clearPasswordField(){
        WebUtility.clearEnterValue(passwordField);
    }

    public void enterPassword(String password){
    WebUtility.sendKeys(passwordField,password);

    }

    public boolean verifyLoginButtonIsDispalyed(){

        return WebUtility.isDisplayed(loginButton);
     }

     public void clickOnLoginButton(){

        loginButton.click();
     }

     public boolean verifyMinimumLengthCharacterErrorMessage(){
        return WebUtility.isDisplayed(minimumPasswordLimitErrorMsg);


     }

     public String getMinimumLengthCharacterErrorMessageText(){
        return WebUtility.getText(minimumPasswordLimitErrorMsg);
     }

     public boolean verifyWrongPasswordErrorMessage(){
        return WebUtility.isDisplayed(wrongPasswordErrorMessage);

     }




     public String getWrongPasswordErrorMessageText(){
        return WebUtility.getText(wrongPasswordErrorMessage);

     }

     public String getLoggedInUserName(){
        return WebUtility.getText(loggedInUser);
     }













}

