/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package words;

import java.io.File;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author iworourke
 */
public class DictionaryTest implements GlobalPathNames {
    
    private Dictionary dictionary;
    private String dictionaryFileName;
    private Word word1, word2, word3, unAddedWord;
    private DictionaryEntry d1, d2, d3, unAddedEntry;
    
    
    private PhoneticRepresentation pr1, pr2, pr3, pr4;
    private String busText = "B AH S";
    private String mudText = "M AH D";
    private String dogText = "D AO G";
    private String muttText = "M AH T";
    
    public DictionaryTest() {
    }
    
    @Before
    public void setUp() {
        dictionaryFileName = "testDictionary.txt";
        dictionary = new Dictionary(new File(dictionaryFileName));
        
        pr1 = new PhoneticRepresentation(busText);
        pr2 = new PhoneticRepresentation(mudText);
        pr3 = new PhoneticRepresentation(dogText);
        pr4 = new PhoneticRepresentation(muttText);
        word1 = new Word("bus", pr1);
        word2 = new Word("mud", pr2);
        word3 = new Word("dog", pr3);
        unAddedWord = new Word("mutt", pr4);
        d1 = new DictionaryEntry(word1);
        d2 = new DictionaryEntry(word2);
        d3 = new DictionaryEntry(word3);
        unAddedEntry = new DictionaryEntry(unAddedWord);
        
    }
    
    

    /**
     * Test of getNumEntries method, of class Dictionary.
     */
    @Test
    public void testGetNumEntries() {
        System.out.println("getNumEntries");
        int result, expResult = 3;
        boolean thrown = false;
        
        File file = new File("sortedDictionary.txt");
        Dictionary instance = new Dictionary(file);
        
        try {
            result = instance.getNumEntries();
            assertEquals(result, expResult);
        }
        catch (Exception e) {
            thrown = true;
        }
        assertFalse(thrown);
    }
    
    /**
     * Test of addEntry method, of class Dictionary.
     */
    @Test
    public void testAddEntry() {
        System.out.println("addEntry");
        int numWordsBeforeAdd, numWordsAfterAdd;
        boolean thrown = false;
        
        DictionaryEntry d = new DictionaryEntry(d1);
        Dictionary instance = new Dictionary(dictionary);
        
        try {
            numWordsBeforeAdd = instance.getNumEntries();
            instance.addEntry(d); 
            numWordsAfterAdd = instance.getNumEntries();
            assertTrue(numWordsBeforeAdd == numWordsAfterAdd - 1);
        }
        catch (Exception e) {
            thrown = true;
        }
        assertFalse(thrown);
        
    }

    /**
     * Test of removeEntry method, of class Dictionary.
     */
    /*@Test
    public void testRemoveEntry() {
        System.out.println("removeEntry");
        int numBeforeRemove, numAfterRemove, index;
        boolean thrown = false;
        Dictionary instance = new Dictionary(dictionary);
        
        index = -1;
        try {
            instance.removeEntry(index);
        }
        catch (Exception e) {
            thrown = true;
        }
        assertTrue(thrown);
        
        thrown = false;
        index = 0;
        try {
            instance.removeEntry(index);
        }
        catch (Exception e) {
            thrown = true;
        }
        assertTrue(thrown == false);
    }*/

    /**
     * Test of getEntry method, of class Dictionary.
     */
    /*@Test
    public void testGetEntry() {
        System.out.println("getEntry");
        int index = 0;
        boolean thrown = false;
        Dictionary instance = new Dictionary(dictionary);
        DictionaryEntry expResult = new DictionaryEntry(d1);
        DictionaryEntry result = null;
        
        try {
            result = instance.getEntry(index);
        }
        catch (Exception e) {
            thrown = true;
        }
        assertFalse(thrown);
        assertEquals(expResult, result);
    }*/

    /**
     * Test of getPhoneticRepresentationForWord method, of class Dictionary.
     */
    @Test
    public void testGetPhoneticRepresentationForWord() {
        System.out.println("getPhoneticRepresentationForWord");
        boolean thrown = false;

        File dictFile = new File("sortedDictionary.txt");
        Dictionary instance = new Dictionary(dictFile);
        PhoneticRepresentation expResult = pr1, result;
        
        try {
            assertTrue(instance.getNumEntries() == 3);
            result = instance.getPhoneticRepresentationForWord("BUS");
            assertEquals(expResult, result);
        }
        catch (Exception e) {
            thrown = true;
        }
        assertTrue(!thrown);
    }
    
}
