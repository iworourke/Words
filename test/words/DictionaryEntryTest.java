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
public class DictionaryEntryTest {
    
    private Word word1, word2, word3;
    private DictionaryEntry d1, d2, d3;
    private PhoneticRepresentation pr1, pr2, pr3;
    private String busText = "B AH S";
    private String mudText = "M AH D";
    private String dogText = "D AO G";
    
    public DictionaryEntryTest() {
    }
    
    @Before
    public void setUp() {
        pr1 = new PhoneticRepresentation(busText);
        pr2 = new PhoneticRepresentation(mudText);
        pr3 = new PhoneticRepresentation(dogText);
        word1 = new Word("bus", pr1);
        word2 = new Word("mud", pr2);
        word3 = new Word("dog", pr3);
        d1 = new DictionaryEntry(word1);
        d2 = new DictionaryEntry(word2);
        d3 = new DictionaryEntry(word3);
        
    }

    /**
     * Test of getWord method, of class DictionaryEntry.
     */
    @Test
    public void testGetWord() {
        System.out.println("getWord");
        DictionaryEntry instance = d1;
        Word expResult = word1;
        Word result = instance.getWord();
        assertEquals(expResult, result);
    }

    /**
     * Test of setWord method, of class DictionaryEntry.
     */
    @Test
    public void testSetWord() {
        System.out.println("setWord");
        Word w = new Word(word1);
        DictionaryEntry instance = new DictionaryEntry();
        instance.setWord(w);
        Word expectedResult = word1;
        Word result = instance.getWord();
        assertEquals(expectedResult, result);
    }

    /**
     * Test of getStringRepresentation method, of class DictionaryEntry.
     */
    @Test
    public void testGetStringRepresentation() {
        System.out.println("getStringRepresentation");
        DictionaryEntry instance = d1;
        String expResult = new String("BUS " + busText);
        String result = instance.getStringRepresentation();
        assertEquals(expResult, result);
    }

    

    /**
     * Test of compareTo method, of class DictionaryEntry.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        DictionaryEntry o = new DictionaryEntry(d1);
        DictionaryEntry instance = new DictionaryEntry(d1);
        int expResult = 0;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class DictionaryEntry.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        DictionaryEntry instance = new DictionaryEntry(d1);
        DictionaryEntry sameInstance = new DictionaryEntry(d1);
        DictionaryEntry diffInstance = new DictionaryEntry(d2);
        
        Object other = diffInstance;
        boolean expResult = false;
        boolean result = instance.equals(other);
        assertEquals(expResult, result);
        
        other = sameInstance;
        expResult = true;
        result = instance.equals(other);
        assertEquals(expResult, result);
    }
    
}
