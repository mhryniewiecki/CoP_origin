package testCases.methodTest;

import org.testng.annotations.Test;
import common.dataService.GlobalMethods;
import org.testng.annotations.DataProvider;
import common.fileService.ConfigFile;
//
import static org.assertj.core.api.Assertions.assertThat;
/**
 *
 * @author Michal.Hryniewiecki
 */
public class TestMethodClass {
    
    @DataProvider
    private  Object[][] staticData() {
    return new Object[][] { 
        { 1, "password"},  
        { 2,  "incorrectPassword" }};
    }
    
    @Test(dataProvider = "staticData")
    /*
    dataProvider = "staticData",
    dataProviderClass = DataToTest.class,
    */
    public void stringRandomMethod(int iterator,String data){
        //start test
        System.out.println("\n@Test");
        System.out.println("TEST no. "+iterator);
        
        //Random Method
        for(int i =0; i<5;i++)
            System.out.println("random: "+GlobalMethods.getRandomString(5)+ " "+GlobalMethods.getRandomPhone()); 
        
        //reed file
        System.out.println("file: "+ConfigFile.get("url"));
        
        //base64
        String p = ConfigFile.get("password");
        System.out.println("password from file: "+p);
        
        String decodeP = GlobalMethods.decodeData(p);
        System.out.println("password from file after decode: "+decodeP);
        
        //asserts
        assertThat(decodeP).as("decode - assert "+iterator).isEqualTo(data);
        
        System.out.println("encode data: "+GlobalMethods.encodeData(decodeP));
        assertThat(p).as("encode - assert").isEqualTo(GlobalMethods.encodeData(decodeP));      
    }
}
