package testCases.testDependency;

import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * @author Michal.Hryniewiecki
 */
public class TestsDependencies {
    @Test(groups = "groupC",
          description = "depend on group: 'groupB'")
    public void testMetodA(){
        System.out.println("@Test \n with group: 'groupC' II; class: TestsDependencies");
        System.out.println(" test Failed");
        assertThat(true).isFalse();
    }
    
    @Test(groups = "groupD")
    public void testMetodB(){
        System.out.println("@Test \n with group: 'groupD'; class: TestsDependencies");
    }
    
    @Test(groups = "groupA")
    public void testMetodC(){
        System.out.println("@Test \n with group: 'groupA'; class: TestsDependencies");
        System.out.println(" test Failed");
        assertThat(true).isFalse();
    }
    
    @Test(groups = "groupA",
          dependsOnMethods = "testMetodC",
          description = "depend on methods: 'testMetodC'")
    public void testMetodD(){
        System.out.println("@Test \n with group: 'groupA'; class: TestsDependencies");
    }
}
