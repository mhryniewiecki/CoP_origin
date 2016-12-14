package common.dataService;

import org.testng.annotations.AfterSuite;
import static testCases.pageObjectPattern.UImethods.webDriver;

/**
 *
 * @author Michal.Hryniewiecki
 */
public class CloseData {
    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        System.out.println("@AfterSuite");
        webDriver.quit(); 
    }
}
