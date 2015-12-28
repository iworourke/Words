/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package words;

import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author iworourke
 */
public class PhoneticRepresentationTest {
    
    private PhoneticRepresentation pr1, pr2;
    private String dictionaryText = "D IH K SH AH N EH R IY";
    private String dogText = "D AO G";
    
    public PhoneticRepresentationTest() {
    }
    
    @Before
    public void setUp() {
        pr1 = new PhoneticRepresentation(dictionaryText);
        pr2 = new PhoneticRepresentation(dogText);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of equals method, of class PhoneticRepresentation.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object other = new PhoneticRepresentation(pr1);
        PhoneticRepresentation instance = new PhoneticRepresentation(pr1);
        boolean expResult = true;
        boolean result = instance.equals(other);
        assertEquals(expResult, result);
        
        other = new PhoneticRepresentation(pr2);
        expResult = false;
        result = instance.equals(other);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class PhoneticRepresentation.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        PhoneticRepresentation instance = new PhoneticRepresentation(pr1);
        String expResult = dictionaryText;
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of hashCode method, of class PhoneticRepresentation.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        PhoneticRepresentation instance1 = new PhoneticRepresentation(pr1);
        PhoneticRepresentation instance2 = new PhoneticRepresentation(pr1);
        PhoneticRepresentation instance3 = new PhoneticRepresentation(pr2);
        assertTrue(instance1.hashCode() == instance2.hashCode());
        assertFalse(instance1.hashCode() == instance3.hashCode());
    }

 

}
