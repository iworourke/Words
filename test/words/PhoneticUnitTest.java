/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package words;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author iworourke
 */
public class PhoneticUnitTest {
    
    PhoneticUnit p1, p2;
    
    public PhoneticUnitTest() {
    }
    
    @Before
    public void setUp() {
        p1 = new PhoneticUnit("IY");
        p2 = new PhoneticUnit("EH");
        
    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test of equals method, of class PhoneticUnit.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object other = new PhoneticUnit(p1);
        PhoneticUnit instance = new PhoneticUnit(p1);
        boolean expResult = true;
        boolean result = instance.equals(other);
        assertEquals(expResult, result);
        
        other = new PhoneticUnit(p2);
        expResult = false;
        result = instance.equals(other);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class PhoneticUnit.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        PhoneticUnit instance1 = new PhoneticUnit(p1);
        PhoneticUnit instance2 = new PhoneticUnit(p1);
        PhoneticUnit instance3 = new PhoneticUnit(p2);
        assertTrue(instance1.hashCode() == instance2.hashCode());
        assertFalse(instance1.hashCode() == instance3.hashCode());
    }

}
