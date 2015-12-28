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
public class WordTest {
    
    private Word word1, word2, word3;
    private PhoneticRepresentation pr1, pr2, pr3;
    private String busText = "B AH S";
    private String mudText = "M AH D";
    private String dogText = "D AO G";
    
    @Before
    public void setUp() {
        pr1 = new PhoneticRepresentation(busText);
        pr2 = new PhoneticRepresentation(mudText);
        pr3 = new PhoneticRepresentation(dogText);
        word1 = new Word("bus", pr1);
        word2 = new Word("mud", pr2);
        word3 = new Word("dog", pr3);
    }
    
    @After
    public void tearDown() {
        System.out.println("Running tear down...");
    }
    
    /**
     * Test of isLiteralMatch method, of class Word.
     */
    @Test
    public void testConventionalSpellingMatches() {
        Word instance, candidate;
        boolean expResult, result;
        
        System.out.println("isLiteralMatch");
        
        instance = new Word(word1);
        candidate = new Word(word1);
        expResult = true;
        result = instance.conventionalSpellingMatches(candidate);
        assertEquals(expResult, result);
        
        candidate = new Word(word3);
        expResult = false;
        result = instance.conventionalSpellingMatches(candidate);
        assertEquals(expResult, result);
    }

    /**
     * Test of isPhoneticMatch method, of class Word.
     */
    @Test
    public void testPhoneticSpellingMatches() {
        Word candidate, instance;
        boolean expResult, result;
        
        System.out.println("isPhoneticMatch");
        
        instance = new Word(word1);
        candidate = new Word(word1);
        expResult = true;
        result = instance.phoneticSpellingMatches(candidate);
        assertEquals(expResult, result);
        
        candidate = new Word(word3);
        expResult = false;
        result = instance.phoneticSpellingMatches(candidate);
        assertEquals(expResult, result);
    }

    

    /**
     * Test of hashCode method, of class Word.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Word instance1 = new Word(word1);
        Word instance2 = new Word(word1);
        int result1 = instance1.hashCode();
        int result2 = instance2.hashCode();
        assertEquals(result1, result2);
    }

    /**
     * Test of equals method, of class Word.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object other = new Word(word1);
        Word instance = new Word(word1);
        boolean expResult = true;
        boolean result = instance.equals(other);
        assertEquals(expResult, result);
        
        other = new Word(word3);
        expResult = false;
        result = instance.equals(other);
        assertEquals(expResult, result);
    }

    /**
     * Test of printWord method, of class Word.
     */
    @Test
    public void testPrintWord() {
        System.out.println("printWord");
        Word instance = new Word(word1);
        boolean thrown = false;
        
        try {
            instance.printConventionalSpelling();
        }
        catch(Exception e) {
            thrown = true;
        }
        assertFalse(thrown);
    }

    /**
     * Test of compareTo method, of class Word.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Word o = new Word(word1);
        Word instance = new Word(word1);
        int expResult = 0;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
    }

    
}
