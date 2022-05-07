package com.test.makemytrip.utilities;

import com.test.makemytrip.testScript.BaseTest.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class WebUtility extends BaseTest {


    public static String getCurrentURL(WebDriver driver){
        String[] url=driver.getCurrentUrl().split("=");
        return url[0];
    }

    public static String getTittle(WebDriver driver){
        String title=driver.getTitle();
        return title;
    }

    public static void goToUrl(WebDriver driver,String url){
        driver.get(url);
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
        waitTillElementIsNotVisible(element);
        return element.isDisplayed();
    }

    public static boolean isEnabled(WebElement element){
        return  element.isEnabled();
    }

    public static void clearEnterValue(WebElement element){
        element.clear();
    }


    public static  void waitTillElementIsNotVisible(WebElement element){
        FluentWait<WebDriver> wait= new FluentWait<>(driver).withTimeout(60, TimeUnit.SECONDS).pollingEvery(5,TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
        wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver){
                return  element;

            }

        });

    }

    public static void javaScriptClick(WebElement element){
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",element);

    }

    public static String getCurrentWindowId(){
        return  driver.getWindowHandle();
    }
    public static void  switchToNewTab(String originalTabId){
        Set<String> windowHandles=driver.getWindowHandles();
        for(String window:windowHandles){
            if(!window.equals(originalTabId)){
                driver.switchTo().window(window);
            }

        }
    }


}
