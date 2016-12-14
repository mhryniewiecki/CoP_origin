package testCases.testDependency;

import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * @author Michal.Hryniewiecki
 */
public class Groups {
      
    @Test()
    public void testMetodA(){
        System.out.println("@Test \n single test; class: Groups");
    }
    
    @Test(groups = "groupA")
    public void testMetodB(){
        System.out.println("@Test \n with group: 'groupA'; class: Groups");
        System.out.println(" test Failed");
        assertThat(true).isFalse();
    }
    
    @Test(groups = {"groupA","groupB"})
    public void testMetodC(){
        System.out.println("@Test \n with groups: 'groupA', 'groupB'; class: Groups");
    }
    
    @Test(groups = "groupC",
          description = "depend on group: 'groupB'")
    public void testMetodD(){
        System.out.println("@Test \n with group: 'groupC'; class: Groups");
    }
    
    @Test(groups = "groupB")
    public void testMetodE(){
        System.out.println("@Test \n with group: 'groupB'; class: Groups");
        System.out.println(" test Failed");
        assertThat(true).isFalse();
    }
    
    @Test(groups = {"groupD"},
          dependsOnGroups = "groupA",
          description = "depend on group: 'groupA'")
    public void testMetodF(){
        System.out.println("@Test \n with group: 'groupD'; class: Groups");
    }
}
