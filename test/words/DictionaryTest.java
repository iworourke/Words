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
public class DictionaryTest {
    
    Dictionary dictionary;
    private Word word1, word2, word3, unAddedWord;
    private DictionaryEntry d1, d2, d3, unAddedEntry;
    private String dictionaryFileName;
    
    private PhoneticRepresentation pr1, pr2, pr3, pr4;
    private String busText = "B AH S";
    private String mudText = "M AH D";
    private String dogText = "D AO G";
    private String muttText = "M AH T";
    
    public DictionaryTest() {
    }
    
    @Before
    public void setUp() {
        dictionary = new Dictionary();
        dictionaryFileName = "testDictionary.txt";
        
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
        dictionary.setInputFileName(dictionaryFileName);
        dictionary.addEntry(d1);
        dictionary.addEntry(d2);
        dictionary.addEntry(d3);
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of RefreshDictionary method, of class Dictionary.
     */
    @Test
    public void testRefreshDictionary() {
        System.out.println("RefreshDictionary");
        Dictionary instance = new Dictionary();
        String fileName = "refreshTestFile.txt";
        instance.setInputFileName(fileName);
        boolean thrown = false;
        
        try {
            instance.RefreshDictionary();
        }
        catch (Exception e) {
            thrown = true;
        }
        assertFalse(thrown);
        
        thrown = false;
        instance = new Dictionary(dictionary);
        try {
            instance.RefreshDictionary();
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
        DictionaryEntry d = new DictionaryEntry(d1);
        Dictionary instance = new Dictionary(dictionary);
        
        numWordsBeforeAdd = instance.getNumEntries();
        instance.addEntry(d);
        numWordsAfterAdd = instance.getNumEntries();
        assertTrue(numWordsBeforeAdd == 3);
        assertTrue(numWordsAfterAdd == 3);
        
        DictionaryEntry unAddedD = new DictionaryEntry(unAddedEntry);
        numWordsBeforeAdd = instance.getNumEntries();
        instance.addEntry(unAddedD);
        numWordsAfterAdd = instance.getNumEntries();
        assertTrue(numWordsBeforeAdd == 3);
        assertTrue(numWordsAfterAdd == 4);
    }

    /**
     * Test of removeEntry method, of class Dictionary.
     */
    @Test
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
        assertTrue(instance.getNumEntries() == 3);
        
        thrown = false;
        index = 0;
        numBeforeRemove = instance.getNumEntries();
        try {
            instance.removeEntry(index);
        }
        catch (Exception e) {
            thrown = true;
        }
        numAfterRemove = instance.getNumEntries();
        assertTrue(numBeforeRemove == 3);
        assertTrue(numAfterRemove == 2);
        assertTrue(thrown == false);
    }

    /**
     * Test of getEntry method, of class Dictionary.
     */
    @Test
    public void testGetEntry() {
        System.out.println("getEntry");
        int index = 0;
        Dictionary instance = new Dictionary(dictionary);
        DictionaryEntry expResult = new DictionaryEntry(d1);
        DictionaryEntry result = instance.getEntry(index);
        assertEquals(expResult, result);
    }

    /**
     * Test of getEntries method, of class Dictionary.
     */
    @Test
    public void testGetEntries() {
        System.out.println("getEntries");
        Dictionary instance = new Dictionary(dictionary);
        ArrayList<DictionaryEntry> expResult = new ArrayList<DictionaryEntry>();
        expResult.add(d1);
        expResult.add(d2);
        expResult.add(d3);
        ArrayList<DictionaryEntry> result = instance.getEntries();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFileName method, of class Dictionary.
     */
    @Test
    public void testGetFileName() {
        System.out.println("getFileName");
        Dictionary instance = new Dictionary(dictionary);
        String expResult = dictionaryFileName;
        String result = instance.getInputFileName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNumEntries method, of class Dictionary.
     */
    @Test
    public void testGetNumEntries() {
        System.out.println("getNumEntries");
        Dictionary instance = new Dictionary();
        int expResult = 0;
        int result = instance.getNumEntries();
        assertEquals(expResult, result);
        
        instance = new Dictionary(dictionary);
        expResult = 3;
        result = instance.getNumEntries();
        assertEquals(expResult, result);
    }

    /**
     * Test of addEntriesFromFile method, of class Dictionary.
     */
    @Test
    public void testAddEntriesFromFile() {
        System.out.println("addEntriesFromFile");
        boolean thrown = false;
        String fileWithEntries = "testDictionary.txt";
        Dictionary instance = new Dictionary();
        Dictionary instanceCompare = new Dictionary(dictionary);
        
        try {
            instance.addEntriesFromFile(fileWithEntries);
            instance.setInputFileName(fileWithEntries);
        }
        catch (Exception e) {
            thrown = true;
        }
        assertFalse(thrown);
        instanceCompare.sortEntries();
        instance.sortEntries();
        assertEquals(instance, instanceCompare);
        
        fileWithEntries = "fakeFileName.txt";
        try {
            instance.addEntriesFromFile(fileWithEntries);
        }
        catch (Exception e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    /**
     * Test of equals method, of class Dictionary.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object other = new Dictionary(dictionary);
        Dictionary instance = new Dictionary(dictionary);
        boolean expResult = true;
        boolean result = instance.equals(other);
        assertEquals(expResult, result);
    }

    /**
     * Test of setFileName method, of class Dictionary.
     */
    @Test
    public void testSetFileName() {
        System.out.println("setFileName");
        String newFileName = "newFileName";
        Dictionary instance = new Dictionary();
        
        instance.setInputFileName(newFileName);
        String expectedResult = newFileName;
        String result = instance.getInputFileName();
        assertEquals(expectedResult, result);
    }

    /**
     * Test of sortEntries method, of class Dictionary.
     */
    @Test
    public void testSortEntries() {
        System.out.println("sortEntries");
        boolean thrown = false;
        try {
            Dictionary unsortedInstance = new Dictionary("unsortedDictionary.txt", "unsortedDictionary.txt");
            Dictionary sortedInstance = new Dictionary("sortedDictionary.txt", "sortedDictionary.txt"); 
            assertFalse(unsortedInstance.equals(sortedInstance));
            unsortedInstance.sortEntries();
            assertFalse(unsortedInstance.equals(sortedInstance));
            unsortedInstance.setInputFileName("sortedDictionary.txt");
            assertTrue(unsortedInstance.equals(sortedInstance));
        }
        catch (Exception e) {
            thrown = true;
        }
        assertFalse(thrown);
        
    }

    /**
     * Test of hashCode method, of class Dictionary.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Dictionary instance1 = new Dictionary(dictionary);
        Dictionary instance2 = new Dictionary(dictionary);
        int result1 = instance1.hashCode();
        int result2 = instance2.hashCode();
        assertEquals(result1, result2);
    }
    
}
