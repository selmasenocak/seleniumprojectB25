package com.cydeo.tests.day7_webtables_utilities_javafaker;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_WindowHandling {
    public WebDriver driver;
   @BeforeMethod
   public void setupMethod(){
       driver = WebDriverFactory.getDriver("chrome");
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

}
    @Test
    public void window_handling_test(){
        //2. Go to:https://www.amazon.com
        driver.get("https://www.amazon.com");

        //3. Copy-paste the lines from below into your class

        //Lines to be pasted:
         ((JavascriptExecutor) driver).executeScript("window.open('https://google.com','_blank');");
         ((JavascriptExecutor) driver).executeScript("window.open('https://etsy.com','_blank');");
         ((JavascriptExecutor) driver).executeScript("window.open('https://facebook.com','_blank');");

        //4. Create a logic to switch to the tab where Etsy.com is open

        BrowserUtils.switchWindowAndVerify(driver,"etsy","Etsy");


//        Set<String> allWindowsHandles = driver.getWindowHandles();
//        for (String each :allWindowsHandles ) {
//            driver.switchTo().window(each);
//
//            System.out.println("Current URL: "+ driver.getCurrentUrl());
//
//            if(driver.getCurrentUrl().contains("etsy")){
//                break;
//            }
//        }
//
//        //5. Assert:Title contains “Etsy”
//        String actualTitle = driver.getTitle();
//        String expectedInTitle = "Etsy";
//
//       Assert.assertTrue(actualTitle.contains(expectedInTitle));
//        //Assert.assertEquals(actualTitle,expectedInTitle);
    }
}
