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
public class HomePage {
    private static final By LINK_MY_BANK = By.linkText("mój bank");
    private static final By LINK_LOG_OUT = By.xpath("//a[contains(text(),'Wyloguj')]");//By.linkText("Wyloguj");
    
    public static By getLinkMyBank(){
        return LINK_MY_BANK;
    }
    
    public static void submitLogOut() {
        //ReportService.log_step("log out afer test");
        WebElement element = webDriver.findElement(LINK_LOG_OUT);
        element.click();
        UImethods.waitUntilDisplayed(By.xpath("//a[contains(text(),'zaloguj ponownie')]"));
        assertThat(webDriver.getCurrentUrl()).as("Attempt to log out from the bank").isEqualTo(ConfigFile.get("url")+"/logout.html");
    }
    
    public static void assert_HomePageStartCorrectly(){
        assertThat(webDriver.getCurrentUrl()).as("Attempt to log on to the bank").isEqualTo(ConfigFile.get("url")+"/home.html");
    }
}
