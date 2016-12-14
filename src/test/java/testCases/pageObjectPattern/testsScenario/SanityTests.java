package testCases.pageObjectPattern.testsScenario;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testCases.pageObjectPattern.pages.LoginPage;

import static testCases.pageObjectPattern.UImethods.webDriver;
import testCases.pageObjectPattern.pages.HomePage;
import testCases.pageObjectPattern.pages.PasswordPage;
/**
 *
 * @author Michal.Hryniewiecki
 */
public class SanityTests {
    @BeforeMethod(alwaysRun = true)
    public void setWebDriver(){
        webDriver = new ChromeDriver();
        //ReportService.setScenario("");
        //UImethods.isInitializedWaiter = false;
    }
    
//    @AfterTest(alwaysRun = true)
//    public void logoff(){
//        webDriver.quit(); 
//    }
    
    //possibility to test scenario
    //User give incorrect password. The system not allowed to log on and was displayed correct error
    
    //1 
    @Test(groups = {"sanityTestUI"})  
    public void given_correct_login_credentials_when_press_login_button_then_system_open_home_page(){
        //ReportService.createTestInReport("...");        
        //given      
        LoginPage.openLoginPage();
        LoginPage.enterUserLogin("Jasinek K");
        LoginPage.submitSignIn();
        //when
        PasswordPage.submitSignIn();
        //then 
        HomePage.assert_HomePageStartCorrectly();
        //
        HomePage.submitLogOut();
    }
}
