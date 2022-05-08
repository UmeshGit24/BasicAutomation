package com.test.makemytrip.testScript.BaseTest;

import com.test.makemytrip.utilities.BrowserSetUp;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    private BrowserSetUp browserSetUp;
    public static WebDriver driver ;



    @BeforeTest
    @Parameters({"browserName"})
    public void beforeTest(String browserName){
        browserSetUp=new BrowserSetUp();
       driver=browserSetUp.setupBrowser(browserName);
       driver.manage().window().maximize();
       driver.manage().deleteAllCookies();
       driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    public static WebDriver getDriver() {

        return driver;
    }

    @AfterTest
    public void afterTest(){
        if(driver!=null){
            driver.quit();
        }

    }

    public SoftAssert getSoftAssert(){
        return new SoftAssert();
    }


}
