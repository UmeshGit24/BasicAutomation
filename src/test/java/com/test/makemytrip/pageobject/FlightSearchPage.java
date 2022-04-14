package com.test.makemytrip.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightSearchPage {

    @FindBy(xpath = "//div[@class='multiDropDownVal']")
    public WebElement tripTypeValue;

    @FindBy(xpath = "//input[@id='fromCity']")
    public WebElement fromCityText;

    @FindBy(xpath = "//input[@id='toCity']")
    public WebElement toCityText;

    @FindBy(xpath = "//input[@id='departure']")
    public WebElement departDateValue;

    @FindBy(xpath = "//input[@id='return']")
    public WebElement retrunDateValue;

    @FindBy(xpath = "//input[@id='travellerAndClass']")
    public WebElement passengersAndClassValue;

    @FindBy(xpath = "//button[@id='search-button']")
    public WebElement searchButton;


    @FindBy(xpath ="//button[normalize-space()='Book Now']")
    public WebElement bookNowButton;


}
