package com.test.makemytrip.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

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
    @FindBy(xpath = "//p[@data-cy='error']")
    public WebElement wrongUserNameErrorMessage;
    @FindBy(xpath = "//button[@data-cy='continueBtn']")
    public WebElement continueButton;
    @FindBy(xpath = "//a[text()='Back']")
    public WebElement backButton;
    @FindBy(xpath = "//p[@data-cy='commonModal']")
    public WebElement otpPageTittle;
    @FindBy(xpath = "//input[@id='otp']")
    public WebElement otpField;
    @FindBy(xpath = "//a[text()='Resend OTP']")
    public WebElement otpResend;
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
    

}
