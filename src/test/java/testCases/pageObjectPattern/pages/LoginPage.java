package testCases.pageObjectPattern.pages;

import common.fileService.ConfigFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testCases.pageObjectPattern.UImethods;

import static org.assertj.core.api.Assertions.assertThat;
import static testCases.pageObjectPattern.UImethods.webDriver;
/**
 *
 * @author Michal.Hryniewiecki
 */
public class LoginPage {
    //   selectors in HTML
    //names: CHECKBOX, TEXT, LINK, BUTTON, FIELD
    private static final By FIELD_USER_LOGIN = By.id("login-user");
    private static final By BUTTON_NEXT = By.xpath("//button[@type='button']");
    
    //methods: edytowanie - enter...(String text), zatwierdzanie - submit...
    public static void enterUserLogin(String text) {
        //ReportService.log_step("Fill username obligatory field - value: "+text);
        WebElement element = webDriver.findElement(FIELD_USER_LOGIN);
        element.clear();
        element.sendKeys(text);
        assertThat(element.getAttribute("value")).as("try to set username obligatory field on login page").isEqualTo(text);
    }
    
    //start browser
    public static void openLoginPage(){
        //ReportService.log_step("Open the bank login page");
        if(ConfigFile.get("maximizeWindow").equals("yes")) 
            webDriver.manage().window().maximize();
        webDriver.get(ConfigFile.get("url"));
        UImethods.waitUntilDisplayed(BUTTON_NEXT);
        assertThat(webDriver.getCurrentUrl()).as("try to open browser").isEqualTo(ConfigFile.get("url")+"/");
    }
    
    public static void submitSignIn() {
        //ReportService.log_step("Click 'next' button on login page [system should open view with password]");
        WebElement element = webDriver.findElement(BUTTON_NEXT);
        element.click();
        UImethods.waitUntilDisplayed(PasswordPage.getButtonSignIn());
    }
    //asserts
    
}
