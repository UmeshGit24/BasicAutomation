package com.test.makemytrip.testScript.TestClass;

import com.test.makemytrip.Constants.Constants;
import com.test.makemytrip.pageobject.FlightSearchPage;
import com.test.makemytrip.pageobject.HomePage;
import com.test.makemytrip.testScript.BaseTest.BaseTest;
import com.test.makemytrip.utilities.ConfigLoader;
import com.test.makemytrip.utilities.HelperUtility;
import com.test.makemytrip.utilities.WebUtility;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FlightTestCases extends BaseTest {
    private FlightSearchPage flightSearchPage;
    private HomePage homePage;
    private String baseURL;

    @BeforeClass(alwaysRun = true)
    public void  beforeClass() {
        baseURL= ConfigLoader.getInstance().getPropertyValue("BASE_URL");
        homePage=new HomePage(driver);
        flightSearchPage=new FlightSearchPage(driver);
        WebUtility.goToUrl(driver,baseURL);
        homePage.closeLoginAccountPopUpIfPresent();


    }
    @Test(description = "verify Flight Search Page URl and Page Tittle",priority = 1)
    public void verifyHomePageUrlAndPageTittle(){
        SoftAssert softAssert=getSoftAssert();
        Assert.assertEquals(WebUtility.getCurrentURL(driver), Constants.HOME_PAGE_URL);
        softAssert.assertEquals(WebUtility.getTittle(driver),Constants.HOME_PAGE_TITTLE);
        softAssert.assertAll();
    }

    @Test(description = "verify all the element on HomePage",priority = 1)
    public void verifyWebElementPresentOnHomePage() {
        SoftAssert softAssert = getSoftAssert();
        softAssert.assertTrue(homePage.verifyLoginButtonOnHomePageIsDisplayed());
        softAssert.assertTrue(homePage.verifyMakeMyTripLogoOnHomePageIsDisplayed());
        softAssert.assertTrue(homePage.verifyMyBizButtonOnHomePageIsDisplayed());
        softAssert.assertTrue(homePage.verifyMyTripButtonOnHomePageIsDisplayed());
        softAssert.assertTrue(homePage.verifyLoginButtonOnHomePageIsDisplayed());
        softAssert.assertTrue(homePage.verifyAllMenuOptions_IsDisplayed());
        softAssert.assertTrue(homePage.verifyAllTripType_IsDisplayed());
        softAssert.assertTrue(homePage.defaultSelectedTrip());
        softAssert.assertTrue(homePage.verifyFromCitySectionIsDisplayed());
        softAssert.assertTrue(homePage.verifyFromCityTitle(Constants.FROM_SECTION_TITTLE_TEXT));
        softAssert.assertTrue(homePage.verifyToCitySectionIsDisplayed());
        softAssert.assertTrue(homePage.verifyToCityTitle(Constants.TO_SECTION_TITTLE_TEXT));
        softAssert.assertTrue(homePage.verifyDepartureSectionIsDisplayed());
        softAssert.assertTrue(homePage.verifyDepartureDateTitle(Constants.DEPARTURE_SECTION_TITTLE_TEXT));
        softAssert.assertTrue(homePage.verifyTravellersAndClassIsDisplayed());
        softAssert.assertTrue(homePage.verifyTravellersAndClassTitle(Constants.PASSENGERS_AND_CLASS_SECTION_TITTLE_TEXT));
        softAssert.assertTrue(homePage.verifySearchButtonIsDisplayed());
        softAssert.assertTrue(homePage.verifySwitchButtonIsDisplayed());
    }

        @Test(description = "verify flights option is selected in menu options",priority = 2)
    public void verifyFlightsIsSelectedInMenuOption(){
        Assert.assertTrue(homePage.verifyDefaultSelectedMenuOptions());

    }

    @Test(description = "Select Trip Type and then verify selected trip type is selected or not",priority = 3)
    public void verifyAndSelectRoundTripType(){
        Assert.assertTrue(homePage.verifyRoundTripIsDisplayed());
        homePage.selectTripType(Constants.TRIP_TYPE,driver);
        Assert.assertTrue(homePage.verifyRoundTripIsSelected());

    }

    @Test(description = "Select Source city and then verify the enter source city",priority = 4)
    public void verifyAndSelectSourceCity(){
        SoftAssert softAssert=getSoftAssert();
        Assert.assertTrue(homePage.verifyFromCitySectionIsDisplayed());
        softAssert.assertTrue(homePage.verifyFromCityTitle(Constants.FROM_SECTION_TITTLE_TEXT));
        homePage.clickOnFromCityLocation();
        homePage.enterKeysInFromCity(Constants.FROM_CITY);
        homePage.selectFromAutoSuggestInFromCity(Constants.FROM_CITY_CODE);
        Assert.assertEquals(homePage.verifyFromCitySelected(),Constants.FROM_CITY);
        softAssert.assertEquals(homePage.verifyFromCityCodeSelected(),Constants.FROM_CITY_CODE);
        softAssert.assertAll();

    }

    @Test(description = "Select Destination city and then verify the enter designation city",priority =5)
    public void verifyAndSelectDestinationCity(){
        SoftAssert softAssert=getSoftAssert();
        Assert.assertTrue(homePage.verifyToCitySectionIsDisplayed());
        softAssert.assertTrue(homePage.verifyToCityTitle(Constants.TO_SECTION_TITTLE_TEXT));
        homePage.clickOnToCityLocation();
        homePage.enterKeysInToCity(Constants.TO_CITY);
        homePage.selectFromAutoSuggestInToCity(Constants.TO_CITY_CODE);
        Assert.assertEquals(homePage.verifyToCitySelected(),Constants.TO_CITY);
        Assert.assertEquals(homePage.verifyToCityCodeSelected(),Constants.TO_CITY_CODE);
        softAssert.assertAll();

    }

    @Test(description = "Select Departure Date and then verify the Departure Date",priority = 6)
    public void verifyAndSelectDepartureDate(){
        SoftAssert softAssert=getSoftAssert();
        Assert.assertTrue(homePage.verifyDepartureSectionIsDisplayed());
        softAssert.assertTrue(homePage.verifyDepartureDateTitle(Constants.DEPARTURE_SECTION_TITTLE_TEXT));
        homePage.clickOnDepartureDate();
        homePage.selectDepartureDate(HelperUtility.getPlusDateFromNow(Constants.DEPARTURE_DAYS_FROM_NOW));
        Assert.assertTrue(compareActualAndExpectedDate(homePage.verifyDepartureDateSelected(),HelperUtility.getPlusDateFromNow(Constants.DEPARTURE_DAYS_FROM_NOW)));
        softAssert.assertAll();
    }

    @Test(description = "select Return Date and then verify the Return Date",priority = 7)
    public void verifyAndSelectReturnDate(){

        SoftAssert softAssert=getSoftAssert();
        Assert.assertTrue(homePage.verifyReturnSectionIsDisplayed());
        softAssert.assertTrue(homePage.verifyReturnDateTitle(Constants.RETURN_SECTION_TITTLE_TEXT));
        homePage.selectReturnDate(HelperUtility.getPlusDateFromNow(Constants.RETURN_DAYS_FROM_NOW));
       Assert.assertTrue(compareActualAndExpectedDate(homePage.verifyReturnDateSelected(),HelperUtility.getPlusDateFromNow(Constants.RETURN_DAYS_FROM_NOW)));
        softAssert.assertAll();
    }

    @Test(description = "Select Travellers Number,Class and then verify the same",priority = 8)
    public void verifyAndSelectTravellersAndClass(){
        SoftAssert softAssert=getSoftAssert();
        Assert.assertTrue(homePage.verifyTravellersAndClassIsDisplayed());
        softAssert.assertTrue(homePage.verifyTravellersAndClassTitle(Constants.PASSENGERS_AND_CLASS_SECTION_TITTLE_TEXT));
        homePage.clickOnTravellersAndClassSection();
        homePage.selectAdultsTravellers(Constants.ADULTS_TRAVELLER_COUNT);
        homePage.selectChildrenTravellers(Constants.CHILDREN_TRAVELLER_COUNT);
        homePage.selectInfantsTravellers(Constants.INFANTS_TRAVELLER_COUNT);
        homePage.selectTravellerClass(Constants.TRAVELLER_CLASS);
        homePage.clickOnApplyButtonOfTravellerSection();
        softAssert.assertEquals(homePage.selectedTravellerClass(),Constants.TRAVELLER_CLASS);
        softAssert.assertEquals(homePage.selectedTravellerCount(),String.valueOf(Constants.ADULTS_TRAVELLER_COUNT+Constants.CHILDREN_TRAVELLER_COUNT+Constants.INFANTS_TRAVELLER_COUNT));
        softAssert.assertAll();

    }

    @Test(description = "verify and click on Search Button",priority = 9)
    public void verifyAndClickOnSearchButton() throws InterruptedException {
    SoftAssert softAssert=getSoftAssert();
    Assert.assertTrue(homePage.verifySearchButtonIsDisplayed());
    homePage.clickOnSearchButton();
    softAssert.assertEquals(WebUtility.getCurrentURL(driver),Constants.FLIGHT_SEARCH_PAGE_URL);

    }
    @Test(description = "verify Flight Search Page URL and Tittle",priority = 10)
    public void verifyFlightSearchPageUrlAndTittle(){
        SoftAssert softAssert=getSoftAssert();
        Assert.assertEquals(WebUtility.getCurrentURL(driver),Constants.FLIGHT_SEARCH_PAGE_URL);
        softAssert.assertEquals(WebUtility.getTittle(driver),Constants.FLIGHT_SEARCH_PAGE_TITTLE);
        softAssert.assertAll();


    }

    @Test(description = "Verify the User Flight Details  on Flight Search Page ",priority = 11)
    public void verifyUserFlightSearchDetailsOnFlightSearchPage(){
        SoftAssert softAssert=getSoftAssert();
        softAssert.assertTrue(flightSearchPage.verifyTripTypeIsDisplayed(),"trip type section is displayed or not");
        softAssert.assertTrue(flightSearchPage.verifyTitleOnTripType(Constants.TRIPTYPE_SECTION_TITTLE),"trip type tittle is correct or not");
        softAssert.assertTrue(flightSearchPage.getTextOfTripType(Constants.TRIP_TYPE_ON_FLIGHT_SEARCH_PAGE),"trip type selected is correct or not");

        softAssert.assertTrue(flightSearchPage.verifyFromCityIsDisplayed(),"from city section is visible or not");
        softAssert.assertTrue(flightSearchPage.verifyTitleOnFromCity(Constants.FROM_SECTION_TITTLE_TEXT),"from city tittle is correct or not");
        softAssert.assertTrue(flightSearchPage.getTextOfFromCity(Constants.FROM_CITY),"from city show is correct or not");

        softAssert.assertTrue(flightSearchPage.verifyToCityIsDisplayed(),"to city section is visble or not");
        softAssert.assertTrue(flightSearchPage.verifyTitleOnToCity(Constants.TO_SECTION_TITTLE_TEXT),"to city tittle is correct or not");
        softAssert.assertTrue(flightSearchPage.getTextOfToCity(Constants.TO_CITY),"to city show is corrent or not");

        softAssert.assertTrue(flightSearchPage.verifyDepartDateIsDisplayed(),"departue section is deisplayed or not");
        softAssert.assertTrue(flightSearchPage.verifyTitleOnDepartDate(Constants.DEPARTURE_SECTION_TITTLE_ON_FLIGHT_SEARCH_PAGE),"daparture title text is correct or not");
        Assert.assertTrue(compareActualAndExpectedDate(flightSearchPage.getDepartDate(),HelperUtility.getPlusDateFromNow(Constants.DEPARTURE_DAYS_FROM_NOW)),"select depart date and dapart date showing on page is correct or not");

        softAssert.assertTrue(flightSearchPage.verifyReturnDateIsDisplayed(),"return date section displayed or not");
        softAssert.assertTrue(flightSearchPage.verifyReturnDateTittle(Constants.RETURN_SECTION_TITTLE_TEXT),"return date tittle show is correct or not");
        Assert.assertTrue(compareActualAndExpectedDate(flightSearchPage.getReturnDate(),HelperUtility.getPlusDateFromNow(Constants.RETURN_DAYS_FROM_NOW)),"selected return date and actual slected on page are equal or not");

        softAssert.assertTrue(flightSearchPage.verifyPassengersAndClassIsDisplayed(),"passengers ans class is desplayed or not");
        softAssert.assertTrue(flightSearchPage.verifyTitleOnPassengerAndClass(Constants.PASSENGERS_AND_CLASS_TITTLE_ON_FLIGHT_SEARCH_PAGE),"passengers tittle displayed corrrect or not");
        softAssert.assertEquals(flightSearchPage.getPassengerAndClass(),String.valueOf(Constants.ADULTS_TRAVELLER_COUNT+Constants.CHILDREN_TRAVELLER_COUNT+Constants.INFANTS_TRAVELLER_COUNT)+" "+Constants.TRAVELLERS_TEXT+","+" "+Constants.TRAVELLER_CLASS,"passenger and class matches");

        softAssert.assertTrue(flightSearchPage.verifySearchButtonIsDisplayed(),"Search button present or not");
        softAssert.assertTrue(flightSearchPage.verifySearchButtonIsDisable(),"Search button disable or not");
        softAssert.assertAll();



    }

    @Test(description = "verify total price amount of flights",priority = 11)
    public void verifyTotalPrice(){
        Assert.assertEquals(flightSearchPage.getDepartureFlightPrice()+flightSearchPage.getReturnFlightPrice(),flightSearchPage.getTotalPrice());
    }

    @Test(description = "verify Fare details on fare details tooltip",priority = 13)
    public void verifyFareDetails(){
        flightSearchPage.clickOnFareDetails();
        Assert.assertTrue(flightSearchPage.verifyFareSummaryToolTipIsDisplayed());
        Assert.assertEquals(flightSearchPage.getBaseFareAmount()+flightSearchPage.getSurChargesAmount(),flightSearchPage.getTotalAmount());
        flightSearchPage.clickOnFareDetails();
    }

    @Test(description = "click on book Now Button",priority = 14)
    public void clickOnBookNowButton(){
        Assert.assertTrue(flightSearchPage.verifyBookNowButtonIsDisplayed());
        flightSearchPage.clickOnBookNowButton();
        flightSearchPage.clickOnContinueButtonMultiFareSelectionIfComes();
        Assert.assertEquals(WebUtility.getCurrentURL(driver),Constants.FLIGHT_REVIEW_DETAILS_PAGE);
    }

    private boolean compareActualAndExpectedDate(String actualDate,String expectedDate ){
        String[] actualDateArray=actualDate.trim().split(" ");
        String[] expectedDateArray=expectedDate.trim().split(" ");
        String expectedDay=expectedDateArray[0];
        expectedDay=expectedDay.charAt(0)=='0'?String.valueOf(expectedDay.charAt(1)):actualDateArray[0];
        if(actualDateArray[0].equals(expectedDay) && actualDateArray[1].equals(expectedDateArray[1]) && actualDateArray[2].equals(expectedDateArray[2])){
            return  true;
        }
        else{
            return  false;
        }

    }




}
