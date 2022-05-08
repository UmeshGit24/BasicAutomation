package com.test.makemytrip.testScript.TestClass;

import com.test.makemytrip.Constants.Constants;
import com.test.makemytrip.pageobject.HomePage;
import com.test.makemytrip.testScript.BaseTest.BaseTest;
import com.test.makemytrip.utilities.ConfigLoader;
import com.test.makemytrip.utilities.WebUtility;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageTestCases extends BaseTest {
    private BaseTest baseTest;
    private String baseUrl;
    private HomePage homePage;

    @BeforeClass(alwaysRun = true)
    public void beforeClass(){

        baseUrl= ConfigLoader.getInstance().getPropertyValue("BASE_URL");
        homePage=new HomePage(getDriver());
        WebUtility.goToUrl(getDriver(),baseUrl);
        homePage.closeLoginAccountPopUpIfPresent();
    }


    @Test(description = "verify URL and Page Tittle of Home Page",priority = 0)
    public void verifyPageUrlANDTittleOfPage(){
        SoftAssert softAssert=getSoftAssert();
        Assert.assertEquals(WebUtility.getCurrentURL(driver),Constants.HOME_PAGE_URL);
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

    @Test(description = "verify All Menu URL and Tittle On Home Page",priority = 2)
    public void verifyAvailableMenuUrlAndTittle(){
        SoftAssert softAssert=getSoftAssert();
        homePage.clickOnFlightMenuOption();
        Assert.assertEquals(WebUtility.getCurrentURL(driver),Constants.FLIGHTS_MENU_OPTION_URL);
        softAssert.assertEquals(WebUtility.getTittle(driver),Constants.FLIGHTS_MENU_OPTION_TITTLE);

        homePage.clickOnHotelsMenuOption();
        Assert.assertEquals(WebUtility.getCurrentURL(driver),Constants.HOTELS_MENU_OPTION_URL);
        softAssert.assertEquals(WebUtility.getTittle(driver),Constants.HOTELS_MENU_OPTION_TITTLE);

        homePage.clickOnHomeStaysMenuOption();
        Assert.assertEquals(WebUtility.getCurrentURL(driver),Constants.HOMESTAYS_MENU_OPTION_URL);
        softAssert.assertEquals(WebUtility.getTittle(driver),Constants.HOMESTAYS_MENU_OPTION_TITTLE);

        homePage.clickOnHolidaysPackagesMenuOption();
        Assert.assertEquals(WebUtility.getCurrentURL(driver),Constants.HOLIDAY_PACKAGE_MENU_OPTION_URL);
        softAssert.assertEquals(WebUtility.getTittle(driver),Constants.HOLIDAY_PACKAGE_MENU_OPTION_TITTLE);

        homePage.clickOnTrainsMenuOptions();
        Assert.assertEquals(WebUtility.getCurrentURL(driver),Constants.TRAINS_MENU_OPTION_URL);
        softAssert.assertEquals(WebUtility.getTittle(driver),Constants.TRAINS_MENU_OPTION_TITTLE);

        homePage.clickOnBusesMenuOptions();
        Assert.assertEquals(WebUtility.getCurrentURL(driver),Constants.BUSES_MENU_OPTION_URL);
        softAssert.assertEquals(WebUtility.getTittle(driver),Constants.BUSES_MENU_OPTION_TITTLE);

        homePage.clickOnCabsMenuOptions();
        Assert.assertEquals(WebUtility.getCurrentURL(driver),Constants.CABS_MENU_OPTION_URL);
        softAssert.assertEquals(WebUtility.getTittle(driver),Constants.CABS_MENU_OPTION_TITTLE);

        homePage.clickOnVisaMenuOptions();
        Assert.assertEquals(WebUtility.getCurrentURL(driver),Constants.VISA_MENU_OPTION_URL);
        softAssert.assertEquals(WebUtility.getTittle(driver),Constants.VISA_MENU_OPTION_TITTLE);

        homePage.clickOnCharterFlightsMenuOptions();
        Assert.assertEquals(WebUtility.getCurrentURL(driver),Constants.CHARTER_FLIGHTS_MENU_OPTIONS_URL);
        softAssert.assertEquals(WebUtility.getTittle(driver),Constants.CHARTER_FLIGHTS_MENU_TITTLE);

        homePage.clickOnActivitiesMenuOptions();
        Assert.assertEquals(WebUtility.getCurrentURL(driver),Constants.ACTIVITIES_MENU_OPTIONS_URL);
        softAssert.assertEquals(WebUtility.getTittle(driver),Constants.ACTIVITIES_MENU_OPTIONS_TITTLE);

        homePage.clickOnFlightMenuOption();
        softAssert.assertAll();


    }

    @Test(description = "Verify Source and Designation location cannot be Same",priority = 3)
    public void verifyFromAndToAirportCannotBeSame(){
        SoftAssert softAssert=getSoftAssert();
        Assert.assertTrue(homePage.verifyFromCitySectionIsDisplayed());
        homePage.clickOnFromCityLocation();
        homePage.enterKeysInFromCity(Constants.FROM_CITY);
        homePage.selectFromAutoSuggestInFromCity(Constants.FROM_CITY_CODE);
        Assert.assertTrue(homePage.verifyToCitySectionIsDisplayed());
        homePage.clickOnToCityLocation();
        homePage.enterKeysInToCity(Constants.FROM_CITY);
        homePage.selectFromAutoSuggestInToCity(Constants.FROM_CITY_CODE);
        Assert.assertTrue(homePage.SameCityErrorIsDisplay());
        softAssert.assertEquals(homePage.getSameCityErrorText(),Constants.SAME_CITY_ERROR_TEXT);
        softAssert.assertAll();

    }

    @Test(description = "verify swap button on HomePage to swap Source,Designation location",priority = 4)
    public void verifySwapButtonToSwitchFromCityAndToCity(){
        Assert.assertTrue(homePage.verifyFromCitySectionIsDisplayed());
        homePage.clickOnFromCityLocation();
        homePage.enterKeysInFromCity(Constants.FROM_CITY);
        homePage.selectFromAutoSuggestInFromCity(Constants.FROM_CITY_CODE);
        Assert.assertTrue(homePage.verifyToCitySectionIsDisplayed());
        homePage.clickOnToCityLocation();
        homePage.enterKeysInToCity(Constants.TO_CITY);
        homePage.selectFromAutoSuggestInToCity(Constants.TO_CITY_CODE);
        Assert.assertTrue(homePage.verifySwitchButtonIsDisplayed());
        Assert.assertTrue(homePage.switchFromAndToCityWithEachOther());

    }






}
