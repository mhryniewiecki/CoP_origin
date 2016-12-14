package testCases.pageObjectPattern.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testCases.pageObjectPattern.UImethods;
import static testCases.pageObjectPattern.UImethods.webDriver;

/**
 *
 * @author Michal.Hryniewiecki
 */
public class PasswordPage {
    private static final By BUTTON_SIGN_IN = By.id("login-btn");
    
    public static By getButtonSignIn(){
        return BUTTON_SIGN_IN;
    }
    
    public static void submitSignIn() {
        //ReportService.log_step("Click 'sign in' button on login page [system should open view with password]");
        WebElement element = webDriver.findElement(BUTTON_SIGN_IN);
        element.click();
        UImethods.waitUntilDisplayed(HomePage.getLinkMyBank());
    }
}
