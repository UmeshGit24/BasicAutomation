package com.test.makemytrip.pageobject;

import com.test.makemytrip.utilities.WebUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage {

    /*
    WebElement of Menu item on home Page
     */
    @FindBy(xpath ="//li[@data-cy='account']")
    public WebElement login;
    @FindBy(xpath ="//li[@class='menu_Flights']")
    public WebElement flights;
    @FindBy(xpath = "")
    public WebElement hotels;
    @FindBy(xpath = "//span[normalize-space()='Holiday Packages']")
    public WebElement homestays;
    @FindBy(xpath = "//li[@class='menu_Trains']")
    public WebElement trains;
    @FindBy(xpath = "//li[@class='menu_Buses']")
    public WebElement buses;
    @FindBy(xpath ="//li[@class='menu_Cabs']")
    public WebElement cabs;
    @FindBy(xpath = "//li[@class='menu_Visa']")
    public WebElement visa;
    @FindBy(xpath = "//li[@class='menu_Charters']")
    public WebElement charterFlights;
    @FindBy(xpath = "//li[@class='menu_Activities']")
    public  WebElement activities;



    @FindBy(xpath = "//li[@data-cy='roundTrip']")
    public WebElement roundTrip;
    @FindBy(css = "ul.fswTabs.latoBlack.greyText > li")
    public List<WebElement> genericTripType;



    @FindBy(xpath = "//label[@for='fromCity']")
    public WebElement fromCity;
    @FindBy(xpath = "//label[@for='fromCity']/span")
    public WebElement fromCityTittleText;
    @FindBy(xpath ="//label[@for='fromCity']/input")
    public WebElement fromCitySelectedName;
    @FindBy(xpath = "//label[@for='fromCity']/p")
    public WebElement fromCitySelectedLocation;

    @FindBy(xpath = "//input[@placeholder='From']")
    public WebElement fromCitySearchBox;


    @FindBy(xpath = "//label[@for='toCity']")
    public WebElement toCity;
    @FindBy(xpath = "//label[@for='toCity']/span")
    public WebElement toCityTittleText;
    @FindBy(xpath = "//label[@for='toCity']/input")
    public WebElement toCitySelectedName;
    @FindBy(xpath = "//label[@for='toCity']/p")
    public WebElement toCitySelectedLocation;

    @FindBy(xpath = "//input[@placeholder='To']")
    public WebElement toCitySearchBox;

    @FindBy(xpath = "//span[@class='swipCircle']")
    public WebElement location_Swipbutton;

    @FindBy(xpath="//div[@id='react-autowhatever-1']/div/ul/li/div/div[2]")
    public List<WebElement> autosuggestList;

    @FindBy(xpath = "//label[@for='departure']")
    public WebElement departureDateSelection;
    @FindBy(xpath = "//label[@for='departure']/span")
    public WebElement departureDateTittle;
    @FindBy(xpath = "//label[@for='return']")
    public WebElement returnDateSelection;
    @FindBy(xpath ="//label[@for='return']/span")
    public WebElement returnDateTittle;
    @FindBy(xpath = "//label[@for='travellers']")
    public WebElement travellersAndClassSelection;
    @FindBy(xpath = "//label[@for='travellers']/span")
    public WebElement travellersAndClassTittle;
    @FindBy(xpath = "//label[@for='travellers']/p/span/span")
    public WebElement travellersCount;
    @FindBy(xpath = "//label[@for='travellers']/p/following-sibling::p")
    public WebElement travellerClassSelected;

    @FindBy(xpath = "//p[@data-cy='submit']/a")
    public WebElement searchButton;


    public void clickOnLoginButton(){
        login.click();
    }

    public void closeLoginForm(){
      login.click();
    }

    public boolean defaultSelectedTrip(){
        return WebUtility.isSelected(roundTrip);

    }

    public boolean verifyAllMenuOptions_IsDisplayed(){

        if(WebUtility.isDisplayed(flights) && WebUtility.isDisplayed(hotels) && WebUtility.isDisplayed(homestays) && WebUtility.isDisplayed(trains) && WebUtility.isDisplayed(trains) && WebUtility.isDisplayed(buses) && WebUtility.isDisplayed(cabs) && WebUtility.isDisplayed(visa) && WebUtility.isDisplayed(charterFlights) && WebUtility.isDisplayed(activities)){
            return true;
        }
        else{
           return  false;
        }

    }

    public boolean verifyAllTripType_IsDisplayed(){
        if(WebUtility.isDisplayed(oneway) && WebUtility.isDisplayed(roundTrip) && WebUtility.isDisplayed(multiCity)){
            return  true;
        }
        else{
            return false;
        }
    }

    public boolean fromCitySectionIsDisplayed(){
        return WebUtility.isDisplayed(fromCity);

    }

    public boolean toCitySectionIsDisplayed(){
        return WebUtility.isDisplayed(toCity);

    }

    public boolean departureSectionIsDisplayed(){
        return WebUtility.isDisplayed((departureDateSelection));

    }

    public boolean returnSectionIsDisplayed(){
        return WebUtility.isDisplayed(returnDateSelection);
    }

    public boolean travellersAndClassIsDisplayed(){

        return WebUtility.isDisplayed(travellersAndClassSelection);
    }

    public boolean searchButtonIsDisplayed(){
        return WebUtility.isDisplayed(searchButton);
    }

    public boolean switchButtonIsDisplayed(){
        return WebUtility.isDisplayed(location_Swipbutton);

    }

    public void clickOnSearchButton(){
        searchButton.click();

    }

    public void clickOnLocationSwitchButton(){
        location_Swipbutton.click();
    }

    public void SelectTripType(String trip,WebDriver driver){
        genericTripType.stream()
                .filter(tripType->trip.equalsIgnoreCase(tripType.getAttribute("data-cy")))
                .forEach(tripType->tripType.click());


    }
    public void clickOnFromCityLocation() {
        fromCity.click();
    }
    public void clickOnToCityLocation() {
        toCity.click();
    }

    public void enterKeysInFromCity(String fromCityName) {
        WebUtility.sendKeys(fromCitySearchBox,fromCityName);

    }

    public void enterKeysInToCity(String toCityName){
        WebUtility.sendKeys(toCitySearchBox,toCityName);

    }

    public void selectFromAutoSuggestInFromCity(String cityCode){
        selectCityFromAutoSuggest(cityCode);
    }

    public void selectFromAutoSuggestInToCity(String cityCode){
        selectCityFromAutoSuggest(cityCode);
    }

    public String

    public void selectCityFromAutoSuggest(String cityCode) {
        for(int i=0;i<autosuggestList.size();i++) {
        if(cityCode.equals(WebUtility.getText(autosuggestList.get(i)))) {

            autosuggestList.get(i).click();
            break;

        }


        }
    }

    public void switchFromAndToCityWithEachOther(){



    }






    public void selectFromCityLocation() {


    }






}













}
