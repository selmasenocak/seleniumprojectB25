package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    /*
    Creating a private constructor, so we are closing
    access to the object of this class from outside the class
     */

    private Driver(){}
/*
    We make WebDriver private, because we want to close access from outside the class.
    We make it static because we will use it in a static method.
 */

        private static WebDriver driver;
        /*
        Create a re-usable utility method which will return same driver instance when we call it.
         */
        public static WebDriver getDriver() {

             if(driver == null){
                 /*
                 We read our browserType from configuration.properties.
                 This way, we cna control which browser is opened from outside our code, form configuration.properties.
                  */

                 String  browserType = ConfigurationReader.getProperty("browser");

                 /*
                 Depending on the browserType that will return from configuration.properties file
                 switch statement will determine the case, and open the matching browser
                  */

                 switch (browserType){
                     case "chrome":
                         WebDriverManager.chromedriver().setup();
                         driver = new ChromeDriver();
                         driver.manage().window().maximize();
                         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                         break;

                     case "firefox":
                         WebDriverManager.firefoxdriver().setup();
                         WebDriverManager.chromedriver().setup();
                         driver = new FirefoxDriver();
                         driver.manage().window().maximize();
                         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                         break;
                 }
             }
            return driver;
        }

//driver.quit()---> nosuchsession
    //drive.close()--->

    //try to create a method named closeDriver
        }

