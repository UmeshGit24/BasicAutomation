package com.test.makemytrip.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class BrowserSetUp {

    private WebDriver driver;

    public WebDriver setupBrowser(String browser){
        ConfigLoader configLoader=ConfigLoader.getInstance();
        String browserExe=configLoader.getPropertyValue(getOsType())+"_"+validateBrowserName(browser);
        String driverExePath=System.getProperty("user.dir")+ File.separator+"Drivers"+File.separator+browserExe;
        if("chrome".equalsIgnoreCase(browser)){
            System.setProperty("webdriver.chrome.driver",driverExePath);
            this.driver=new ChromeDriver();
            driver.manage().window().maximize();
            return driver;
        }

        else if("firefox".equalsIgnoreCase(browser)){
            System.setProperty("webdriver.gecko.driver",driverExePath);
            this.driver=new FirefoxDriver();
            driver.manage().window().maximize();
            return driver;
        }

        else{
            throw new RuntimeException("browser type not supported");
        }

    }

    private String validateBrowserName(String browser){

        if(browser!=null & !browser.isEmpty()){
            if("chrome".equalsIgnoreCase(browser)){
                return "CHROME";
            }
            else if("firefox".equalsIgnoreCase(browser)){
                return "FIREFOX";

            }

            else{
                throw new RuntimeException("browser not supported");
            }
        }
        else{
            throw  new RuntimeException("Browser name cannot be empty or null");
        }



    }

    private String getOsType(){
        String os=System.getProperty("os.name").toLowerCase();

        if(os.equals("linux")){
            return "LINUX";

        }
        else if(os.equals("window")){
            return "WINDOW";
        }
        else{
            throw new RuntimeException("OS type not supported");
        }



    }




}
