package com.test.makemytrip.pageobject;

import com.test.makemytrip.utilities.WebUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightSearchPage {

    public FlightSearchPage(WebDriver driver){
        PageFactory.initElements(driver,this);

    }


    @FindBy(xpath = "//div[@class='multiDropDownVal']")
    private WebElement tripTypeValue;
    @FindBy(xpath = "//label[@for='tripType']")
    private WebElement tripTypeTittle;

    @FindBy(xpath = "//input[@id='fromCity']")
    private WebElement fromCityText;
    @FindBy(xpath = "//span[@for='fromCity']")
    private WebElement fromCityTittle;

    @FindBy(xpath = "//input[@id='toCity']")
    private WebElement toCityText;
    @FindBy(xpath = "//span[@for='toCity']")
    private WebElement toCityTittle;

    @FindBy(xpath = "//input[@id='departure']")
    private WebElement departDateValue;
    @FindBy(xpath = "//span[@for='departure']")
    private WebElement departureDateTittle;

    @FindBy(xpath = "//input[@id='return']")
    private WebElement retrunDateValue;
    @FindBy(xpath = "//span[@for='return']")
    private WebElement returnDateTittle;

    @FindBy(xpath = "//input[@id='travellerAndClass']")
    private WebElement passengersAndClassValue;
    @FindBy(xpath = "//span[@for='travellerAndClass']")
    private WebElement passengersAndClassTitle;

    @FindBy(xpath = "//button[@id='search-button']")
    private WebElement searchButton;


    @FindBy(xpath ="//button[normalize-space()='Book Now']")
    private WebElement bookNowButton;
    @FindBy(xpath = "//div[@class='splitviewStickyOuter ']")
    private WebElement departureAndReturnflightDetailsSection;
    @FindBy(xpath = "//div[@class='splitviewStickyOuter ']/div/div[1]/div/span")
    private WebElement departureFlightPrice;
    @FindBy(xpath = "//div[@class='splitviewStickyOuter ']/div/div[2]/div/span")
    private WebElement returnFlightPrice;
    @FindBy(xpath = "//div[@class='splitviewStickyOuter ']/div/div[3]/div/div/p/span")
    private WebElement totalFlightPrice;
    @FindBy(xpath = "//div[@class='splitviewStickyOuter ']/div/div[3]/div/div/p[2]")
    private WebElement fareDetails;

    @FindBy(xpath = "//div[@class='tooltip-inner']")
    private WebElement fareSummaryTooltip;
    @FindBy(xpath = "//span[contains(text(),'Total base fare')]/following-sibling::span")
    private WebElement totalBaseFare;
    @FindBy(xpath = "//span[contains(text(),'Total Surcharges')]/following-sibling::span")
    private WebElement totalSurCharge;
    @FindBy(xpath = "//span/font[contains(text(),'Total Amount')]/following::span/strong/font")
    private WebElement totalAmount;

    @FindBy(xpath = "//div[@class='multifareWrap']")
    private WebElement multifareSelectionModal;
    @FindBy(xpath = "//button[text()='Continue']")
    private WebElement continueButtonOnMultiFareSelection;

    public boolean verifyTripTypeIsDisplayed(){

        return WebUtility.isDisplayed(tripTypeValue);
    }

    public boolean getTextOfTripType(String expectedTripType){
        return  WebUtility.getText(tripTypeValue).equalsIgnoreCase(expectedTripType);

    }
    public boolean verifyTitleOnTripType(String expectedTitle){
        return WebUtility.getText(tripTypeTittle).contains(expectedTitle);
    }

    public boolean verifyFromCityIsDisplayed(){
        return WebUtility.isDisplayed(fromCityText);
    }
    public boolean verifyTitleOnFromCity(String expectedTitle){
        return WebUtility.getText(fromCityTittle).contains(expectedTitle);
    }

    public boolean getTextOfFromCity(String expectedFromCity){
        String[] actualFromCity= WebUtility.getAttributeValue(fromCityText,"value").split(",");
        return actualFromCity[0].equals(expectedFromCity);
    }

    public boolean verifyToCityIsDisplayed(){
        return WebUtility.isDisplayed(toCityText);
    }
    public boolean verifyTitleOnToCity(String expectedTitle){
        return WebUtility.getText(toCityTittle).contains(expectedTitle);
    }

    public boolean getTextOfToCity(String expectedToCity){
        String[] actualToCity= WebUtility.getAttributeValue(toCityText,"value").split(",");
        return actualToCity[0].equals(expectedToCity);


    }

    public boolean verifyDepartDateIsDisplayed(){
        return WebUtility.isDisplayed(departDateValue);
    }
    public boolean verifyTitleOnDepartDate(String expectedTitle){
        return WebUtility.getText(departureDateTittle).contains(expectedTitle);
    }

    public String getDepartDate(){
        String[] actualDepartDate=WebUtility.getAttributeValue(departDateValue,"value").split(",");
        String[] dayAndMonth=actualDepartDate[1].split(" ");
        if(Integer.parseInt(dayAndMonth[2])<10){
            dayAndMonth[2]=dayAndMonth[2];
        }
        return dayAndMonth[2]+" "+dayAndMonth[1]+" "+actualDepartDate[2].trim();

    }

    public boolean verifyReturnDateIsDisplayed(){
        return WebUtility.isDisplayed(retrunDateValue);
    }
    public boolean verifyReturnDateTittle(String expectedTitle){
        return WebUtility.getText(returnDateTittle).contains(expectedTitle);
    }

    public String getReturnDate(){
        String[] actualReturnDate=WebUtility.getAttributeValue(retrunDateValue,"value").split(",");
        String[] dayAndMonth=actualReturnDate[1].split(" ");
        return  dayAndMonth[2]+" "+dayAndMonth[1]+" "+actualReturnDate[2].trim();

    }

    public boolean verifyPassengersAndClassIsDisplayed(){

        return WebUtility.isDisplayed(passengersAndClassValue);
    }
    public boolean verifyTitleOnPassengerAndClass(String expectedTitle){
        return WebUtility.getText(passengersAndClassTitle).contains(expectedTitle);
    }

    public String getPassengerAndClass(){
        return  WebUtility.getAttributeValue(passengersAndClassValue,"value");

    }

    public boolean verifySearchButtonIsDisplayed(){
        return WebUtility.isDisplayed(searchButton);
    }

    public boolean verifySearchButtonIsDisable(){
        return  WebUtility.getAttributeValue(searchButton,"class").contains("disable-btn");
    }



    public boolean verifyBookNowButtonIsDisplayed(){

        return  WebUtility.isDisplayed(bookNowButton);
    }

    public void clickOnBookNowButton(){
        WebUtility.javaScriptClick(bookNowButton);
    }
    public boolean verifyDepartureAndReturnFlightDetailSectionIsDisplayed(){
        return WebUtility.isDisplayed(departureAndReturnflightDetailsSection);
    }

    public int getDepartureFlightPrice(){
        String price=WebUtility.getText(departureFlightPrice).replace("₹ ","").replace(",","");
        return Integer.parseInt(price);
    }
    public int getReturnFlightPrice(){
        String price=WebUtility.getText(returnFlightPrice).replace("₹ ","").replace(",","");
        return Integer.parseInt(price);

    }

    public int getTotalPrice(){
        String price=WebUtility.getText(totalFlightPrice).replace("₹ ","").replace(",","");
        return Integer.parseInt(price);

    }

    public void clickOnFareDetails(){
        WebUtility.javaScriptClick(fareDetails);

    }
    public boolean verifyFareSummaryToolTipIsDisplayed(){
        return WebUtility.isDisplayed(fareSummaryTooltip);
    }

    public int getBaseFareAmount(){
        String price=WebUtility.getText(totalBaseFare).replace("₹ ","").replace(",","");
        return Integer.parseInt(price);
    }

    public int getSurChargesAmount(){
        String price=WebUtility.getText(totalSurCharge).replace("₹ ","").replace(",","");
        return Integer.parseInt(price);

    }

    public int getTotalAmount(){
        String price=WebUtility.getText(totalAmount).replace("₹ ","").replace(",","");
        return Integer.parseInt(price);

    }

    public void clickOnContinueButtonMultiFareSelectionIfComes(){

        if(WebUtility.isDisplayed(multifareSelectionModal)){
            WebUtility.javaScriptClick(continueButtonOnMultiFareSelection);
            String originalTabId=WebUtility.getCurrentWindowId();
            WebUtility.switchToNewTab(originalTabId);
        }

    }






}
