package com.test.makemytrip.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebUtility {


    public static String getCurrentURL(WebDriver driver){
        String url=driver.getCurrentUrl();
        return url;
    }

    public static String getTittle(WebDriver driver){
        String title=driver.getTitle();
        return title;
    }

    public static String getText(WebElement element){
       return element.getText();
    }

    public static String getAttributeValue(WebElement element,String attribute){
        return element.getAttribute(attribute);
    }

    public static  void sendKeys(WebElement element,String key){
        element.sendKeys(key);
    }
    public static boolean isSelected(WebElement element){

        return  element.isSelected();
    }

    public static  boolean isDisplayed(WebElement element ){

        return element.isDisplayed();
    }






}
