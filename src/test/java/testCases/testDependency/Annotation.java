package testCases.testDependency;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author Michal.Hryniewiecki
 */
public class Annotation {
    private String url;
    
    //class
    @BeforeClass(alwaysRun = true)
    public static void beforeClass(){
        System.out.println("@BeforeClass");
        //declaration global data ex. url
    }
    
    @AfterClass(alwaysRun = true)
    public void afterClass(){
        System.out.println("@AfterClass");
    }
    //test
    @BeforeTest(alwaysRun = true)
    public void beforeTest(){
        System.out.println("@BeforeTest");
    }

    @AfterTest(alwaysRun = true)
    public void afterTest(){
        System.out.println("@AfterTest");
    }
    //method
    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(){
        System.out.println("@BeforeMethod");
        System.out.println("gucio");
    }
    
    @AfterMethod(alwaysRun = true)
    public void afterMethod(){
        System.out.println("@AfterMethod");
    }
    //group
    @BeforeGroups(alwaysRun = true)
    public void beforeGroups(){
        System.out.println("@BeforeGroups");
    }
    
    @AfterGroups(alwaysRun = true)
    public void afterGroups(){
        System.out.println("@AfterGroups");
    }
    //suite
    @AfterSuite(alwaysRun = true)
    public void afterSuite(){
        System.out.println("@AfterSuite");
    }
    
    /////////////
    @Test(groups = "groupA")
    public void testMetodA(){
        System.out.println("@Test1 \n with group: 'groupA'; class: Adnotation");
        System.out.println(method());
    }
    
    @Test(groups = "groupA")
    public void testMetodB(){
        System.out.println("@Test2 \n with group: 'groupA'; class: Adnotation");
    }
    
    String method(){        
        return "Run method";
    }
}
