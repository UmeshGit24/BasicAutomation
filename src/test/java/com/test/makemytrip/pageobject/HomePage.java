package com.test.makemytrip.pageobject;

import com.test.makemytrip.testScript.BaseTest.BaseTest;
import com.test.makemytrip.utilities.HelperUtility;
import com.test.makemytrip.utilities.WebUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class HomePage {
    private final WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    /*
    WebElement of Menu item on home Page
     */
    @FindBy(xpath = "//a[@data-cy='mmtLogo']")
    private WebElement makemytripLogo;
    @FindBy(xpath ="//li[@data-cy='account']")
    private WebElement login;
    @FindBy(xpath = "//li[@data-cy='myBiz']")
    private WebElement myBizButton;
    @FindBy(xpath = "//li[@data-cy='myTrips']")
    private WebElement myTripsButton;
    @FindBy(xpath ="//li//a[@href='https://www.makemytrip.com/flights/']")
    private WebElement flights;
    @FindBy(xpath = "//li//a[@href='https://www.makemytrip.com/hotels/']")
    private WebElement hotels;
    @FindBy(xpath = "//li//a[@href='https://www.makemytrip.com/homestays/']")
    private WebElement homestays;
    @FindBy(xpath = "//li//a[@href='https://www.makemytrip.com/holidays-india/']")
    private WebElement holidaysPackages;
    @FindBy(xpath = "//li//a[@href='https://www.makemytrip.com/railways/']")
    private WebElement trains;
    @FindBy(xpath = "//li//a[@href='https://www.makemytrip.com/bus-tickets/']")
    private WebElement buses;
    @FindBy(xpath ="//li//a[@href='https://www.makemytrip.com/cabs/']")
    private WebElement cabs;
    @FindBy(xpath = "//li//a[@href='https://www.makemytrip.com/visa/']")
    private WebElement visa;
    @FindBy(xpath = "//li//a[@href='https://www.makemytrip.com/charter-flights/']")
    private WebElement charterFlights;
    @FindBy(xpath = "//li//a[@href='https://www.makemytrip.com/activities/']")
    private  WebElement activities;
    @FindBy(xpath = "//div[contains(@class,'makeFlex column defaultCursor')]")
    private WebElement loginPopUp;

    @FindBy(xpath = "//li[@data-cy='oneWayTrip']")
    private WebElement onewayTrip;
    @FindBy(xpath = "//li[@data-cy='roundTrip']")
    private WebElement roundTrip;
    @FindBy(xpath = "//li[@data-cy='mulitiCityTrip']")
    private WebElement multiCityTrip;
    @FindBy(css = "ul.fswTabs.latoBlack.greyText > li")
    private List<WebElement> genericTripType;



    @FindBy(xpath = "//label[@for='fromCity']")
    private WebElement fromCity;
    @FindBy(xpath = "//label[@for='fromCity']/span")
    private WebElement fromCityTittleText;
    @FindBy(xpath ="//label[@for='fromCity']/input")
    private WebElement fromCitySelectedName;
    @FindBy(xpath = "//label[@for='fromCity']/p")
    private WebElement fromCitySelectedLocation;

    @FindBy(xpath = "//input[@placeholder='From']")
    private WebElement fromCitySearchBox;


    @FindBy(xpath = "//label[@for='toCity']")
    private WebElement toCity;
    @FindBy(xpath = "//label[@for='toCity']/span")
    private WebElement toCityTittleText;
    @FindBy(xpath = "//label[@for='toCity']/input")
    private WebElement toCitySelectedName;
    @FindBy(xpath = "//label[@for='toCity']/p")
    private WebElement toCitySelectedLocation;

    @FindBy(xpath = "//input[@placeholder='To']")
    private WebElement toCitySearchBox;

    @FindBy(xpath = "//span[@class='swipCircle']")
    private WebElement location_Swipbutton;

    @FindBy(xpath="//div[@id='react-autowhatever-1']/div/ul/li/div/div[2]")
    private List<WebElement> autosuggestList;

    @FindBy(xpath = "//label[@for='departure']")
    private WebElement departureDateSelection;
    @FindBy(xpath = "//label[@for='departure']/span")
    private WebElement departureDateTittle;
    @FindBy(xpath = "//label[@for='departure']/input")
    private WebElement departureDateValue;
    @FindBy(xpath = "//label[@for='return']")
    private WebElement returnDateSelection;
    @FindBy(xpath ="//label[@for='return']/span")
    private WebElement returnDateTittle;
    @FindBy(xpath = "//label[@for='return']/input")
    private WebElement returnDateValue;
    @FindBy(xpath = "//label[@for='travellers']")
    private WebElement travellersAndClassSection;
    @FindBy(xpath = "//label[@for='travellers']/span")
    private WebElement travellersAndClassTittle;
    @FindBy(xpath = "//label[@for='travellers']/p/span/span")
    private WebElement travellersCount;
    @FindBy(xpath = "//label[@for='travellers']/p/following-sibling::p")
    private WebElement travellerClassSelected;

    @FindBy(xpath = "//button[normalize-space()='APPLY']")
    private WebElement applyButtonInTravellersSection;
    @FindBy(xpath = "//p[@data-cy='submit']/a")
    private WebElement searchButton;

    @FindBy(xpath="//div[@class='DayPicker-Caption']/div")
    private List<WebElement> yearMonthInCalender;
    @FindBy(xpath ="//div[@class='DayPicker-Caption']/div")
    private WebElement monthSelected;
    @FindBy(xpath ="//span[@aria-label='Next Month']")
    private WebElement nextMonthButton;
    @FindBy(xpath = "//div[@aria-disabled='false']")
    private List<WebElement> avialableDate;

    @FindBy(xpath = "//span[@data-cy='sameCityError']")
    private WebElement sameCityError;


    public void clickOnFlightMenuOption(){
        flights.click();
    }
    public void clickOnHotelsMenuOption(){
        hotels.click();
    }
    public void clickOnHomeStaysMenuOption(){
        homestays.click();
    }
    public void clickOnHolidaysPackagesMenuOption(){
        holidaysPackages.click();
    }

    public void clickOnTrainsMenuOptions(){
        trains.click();
    }

    public void clickOnBusesMenuOptions(){
        buses.click();
    }

    public void clickOnCabsMenuOptions(){
        cabs.click();
    }

    public void clickOnVisaMenuOptions(){
        visa.click();

    }

    public void clickOnCharterFlightsMenuOptions(){
        charterFlights.click();
    }
    public void clickOnActivitiesMenuOptions(){
        activities.click();
    }

    public boolean verifyLoginButtonOnHomePageIsDisplayed(){
        return WebUtility.isDisplayed(login);

    }

    public boolean verifyMakeMyTripLogoOnHomePageIsDisplayed(){
        return  WebUtility.isDisplayed(makemytripLogo);
    }

    public boolean verifyMyBizButtonOnHomePageIsDisplayed(){

        return WebUtility.isDisplayed(myBizButton);
    }

    public boolean verifyMyTripButtonOnHomePageIsDisplayed(){
        return WebUtility.isDisplayed(myTripsButton);
    }

    public void clickOnLoginButton(){

        WebUtility.javaScriptClick(login);

    }

    public void closeLoginAccountPopUpIfPresent(){
        if(WebUtility.isDisplayed(loginPopUp)){
            login.click();
        }



    }
    public boolean verifyDefaultSelectedMenuOptions(){
        return WebUtility.getAttributeValue(flights,"class").contains("active");

    }

    public boolean defaultSelectedTrip(){
        return WebUtility.isSelected(onewayTrip);

    }





    public boolean verifyAllMenuOptions_IsDisplayed(){

        return WebUtility.isDisplayed(flights) && WebUtility.isDisplayed(hotels) && WebUtility.isDisplayed(homestays) && WebUtility.isDisplayed(trains) && WebUtility.isDisplayed(trains) && WebUtility.isDisplayed(buses) && WebUtility.isDisplayed(cabs) && WebUtility.isDisplayed(visa) && WebUtility.isDisplayed(charterFlights) && WebUtility.isDisplayed(activities);

    }

    public boolean verifyAllTripType_IsDisplayed(){
        return WebUtility.isDisplayed(onewayTrip) && WebUtility.isDisplayed(roundTrip) && WebUtility.isDisplayed(multiCityTrip);
    }

    public boolean verifyRoundTripIsDisplayed(){
        return  WebUtility.isDisplayed(roundTrip);
    }

    public boolean verifyFromCitySectionIsDisplayed(){
        return WebUtility.isDisplayed(fromCity);

    }

    public boolean verifyToCitySectionIsDisplayed(){
        return WebUtility.isDisplayed(toCity);

    }

    public boolean verifyDepartureSectionIsDisplayed(){
        return WebUtility.isDisplayed((departureDateSelection));

    }

    public boolean verifyReturnSectionIsDisplayed(){
        return WebUtility.isDisplayed(returnDateSelection);
    }

    public boolean verifyTravellersAndClassIsDisplayed(){

        return WebUtility.isDisplayed(travellersAndClassSection);
    }

    public boolean verifySearchButtonIsDisplayed(){
        return WebUtility.isDisplayed(searchButton);
    }

    public boolean verifySwitchButtonIsDisplayed(){
        return WebUtility.isDisplayed(location_Swipbutton);

    }
    public void clickOnSearchButton() throws InterruptedException{
        searchButton.click();
        HelperUtility.doWait(5000);


    }

    public void clickOnLocationSwitchButton(){
        location_Swipbutton.click();
    }

    public void selectTripType(String trip,WebDriver driver){
        genericTripType.stream()
                .filter(tripType->trip.equalsIgnoreCase(tripType.getAttribute("data-cy")))
                .forEach(tripType->tripType.click());


    }
    public void clickOnFromCityLocation() {
        WebUtility.waitTillElementIsNotVisible(toCity);
        fromCity.click();
    }
    public void clickOnToCityLocation() {
        WebUtility.waitTillElementIsNotVisible(toCity);
        WebUtility.javaScriptClick(toCity);
    }

    public void clickOnDepartureDate(){
        departureDateSelection.click();
    }
    public  void clickOnReturnDate(){
        returnDateSelection.click();
    }

    public boolean verifyRoundTripIsSelected(){
        return WebUtility.getAttributeValue(roundTrip,"class").contains("selected");
    }
    public void enterKeysInFromCity(String fromCityName) {
        WebUtility.sendKeys(fromCitySearchBox,fromCityName);

    }

    public void enterKeysInToCity(String toCityName){
        WebUtility.sendKeys(toCitySearchBox,toCityName);

    }

    public boolean verifyFromCityTitle(String title) {
        return title.equals(WebUtility.getText(fromCityTittleText));
    }

    public boolean verifyToCityTitle(String title){
        return title.equals(WebUtility.getText(toCityTittleText));

    }

    public boolean verifyDepartureDateTitle(String title){
        return title.equals(WebUtility.getText(departureDateTittle));
    }

    public boolean verifyReturnDateTitle(String title){
        return title.equals(WebUtility.getText(returnDateTittle));
    }

    public boolean verifyTravellersAndClassTitle(String title){
        return title.equalsIgnoreCase(WebUtility.getText(travellersAndClassTittle));
    }

    public void selectFromAutoSuggestInFromCity(String cityCode){
        selectCityFromAutoSuggest(cityCode);
    }

    public void selectFromAutoSuggestInToCity(String cityCode){
        selectCityFromAutoSuggest(cityCode);
    }

    public String verifyFromCitySelected() {
        return WebUtility.getAttributeValue(fromCitySelectedName,"value");



    }

    public String verifyFromCityCodeSelected() {
        String[] cityCode=WebUtility.getAttributeValue(fromCitySelectedLocation,"title").split(",");
        return cityCode[0];


    }
    public String verifyToCitySelected(){
        return  WebUtility.getAttributeValue(toCitySelectedName,"value");


    }

    public String verifyToCityCodeSelected() {
        String[] cityCode=WebUtility.getAttributeValue(toCitySelectedLocation,"title").split(",");
        return cityCode[0];

    }

    public String verifyDepartureDateSelected() {
        String[] departureDate=WebUtility.getAttributeValue(departureDateValue,"value").split(",");
        return departureDate[1].trim();
    }

    public String verifyReturnDateSelected(){
        String[] returnDate=WebUtility.getAttributeValue(returnDateValue,"value").split(",");
        return returnDate[1].trim();

    }




    public void selectCityFromAutoSuggest(String cityCode) {
        for (WebElement element : autosuggestList) {
            if (WebUtility.getText(element).equals(cityCode)) {
                element.click();
                break;

            }


        }
    }

    public boolean switchFromAndToCityWithEachOther(){
        String fromCity=verifyFromCitySelected();
        String toCity=verifyToCitySelected();
        location_Swipbutton.click();
        return fromCity.equals(verifyToCitySelected()) && toCity.equals(verifyFromCitySelected());
    }




    public void selectDepartureDate(String date){
        selectDate(date);


    }

    public void selectReturnDate(String date){
        selectDate(date);
    }



public void clickOnTravellersAndClassSection(){
        travellersAndClassSection.click();

}


public void selectAdultsTravellers(int numberOfAdultstravellers){
        String value=String.valueOf(numberOfAdultstravellers);
        driver.findElement(By.xpath("//ul/li[contains(@data-cy,'adults-"+value+"')]")).click();

}

public void selectChildrenTravellers(int numberOfChildrenTravellers){
        String value=String.valueOf(numberOfChildrenTravellers);
        driver.findElement(By.xpath("//ul/li[contains(@data-cy,'children-"+value+"')]")).click();
}

public void selectInfantsTravellers(int numberOfInFantsTravellers){
        String value=String.valueOf(numberOfInFantsTravellers);
        driver.findElement(By.xpath("//ul/li[contains(@data-cy,'infants-"+value+"')]")).click();
    }



public void selectTravellerClass(String travelClassType){
        WebUtility.javaScriptClick(driver.findElement(By.xpath("//ul/li[text()='"+travelClassType+"']")));

}

public void clickOnApplyButtonOfTravellerSection(){
        WebUtility.javaScriptClick(applyButtonInTravellersSection);

}


public String selectedTravellerClass(){
        return WebUtility.getText(travellerClassSelected);

}

public boolean SameCityErrorIsDisplay(){
        return  WebUtility.isDisplayed(sameCityError);

}

public String getSameCityErrorText(){
        return WebUtility.getText(sameCityError);
}




public String selectedTravellerCount(){
        return  WebUtility.getText(travellersCount).trim();
}



    public void selectDate(String date) {
        Date d=new Date(date);
        SimpleDateFormat formatter=new SimpleDateFormat("dd MMMM yyyy");
        date=formatter.format(d);
        String[] date_arr=date.split(" ");
        String day=date_arr[0];
        String month=date_arr[1];
        String year=date_arr[2];
        selectYearMonth(year,month);
        selectDateAfterMonth(day,month);


    }

    public void selectYearMonth(String year,String month){
        boolean flag=false;
        String yearMonth=month+year;
        while(true) {

            for (WebElement element : yearMonthInCalender) {
                if (yearMonth.equals(element.getText())) {
                    flag = true;
                    break;
                }
            }
            if(flag)
                break;
            nextMonthButton.click();
        }
    }

    public void selectDateAfterMonth(String dayOfMonth,String month){

        for (WebElement element : avialableDate) {
            String date = element.getAttribute("aria-label");
            if (date.toLowerCase().contains(month.toLowerCase() + " " + dayOfMonth)) {
                element.click();
                break;

            }
        }

    }










}














