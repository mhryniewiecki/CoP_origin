package common.dataService;

import org.testng.annotations.BeforeSuite;
import common.fileService.ConfigFile;

/**
 *
 * @author Michal.Hryniewiecki
 */
public class InitializationData {    
    @BeforeSuite(alwaysRun = true)
    public static void beforeSuite() throws Exception {
        System.out.println("@BeforeSuite");
        //initialization external files
        ConfigFile.init();
        //init webdriver
        System.setProperty("webdriver.chrome.driver", ConfigFile.get("pathChromeDriver"));      
    }
}
