package testCases.pageObjectPattern;

import common.fileService.ConfigFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Michal.Hryniewiecki
 */
public class UImethods {
    public static WebDriver webDriver;
    private static WebDriverWait waiter;
    private static boolean isInitializedWaiter;
    
    public static void waitUntilDisplayed(By selector){
        if(!isInitializedWaiter){
            waiter = new WebDriverWait(webDriver, Integer.parseInt(ConfigFile.get("waiterGlobalTime")));
            isInitializedWaiter = true;
        }   
        waiter.until(ExpectedConditions.presenceOfElementLocated(selector)); 
    }
}
