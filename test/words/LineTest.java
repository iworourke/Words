/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package words;

import java.util.ArrayList;
import static org.hamcrest.CoreMatchers.not;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author iworourke
 */
public class LineTest {
    
    private Word word1, word2, word3, word4;
    private Line line1, line2, line3, matchTestLine, emptyLine;
    private ArrayList<Word> a1, a2, a3;
    private PhoneticRepresentation pr1, pr2, pr3, pr4;
    private String busText = "B AH S";
    private String mudText = "M AH D";
    private String dogText = "D AO G";
    private String muttText = "M AH T";
    
    public LineTest() {
    }
    
    @Before
    public void setUp() {
        System.out.println("Running set up...");
        initializeWords();
        initializeArrayLists();
        initializeLines();
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * 
     */
    private void initializeWords() {
        pr1 = new PhoneticRepresentation(busText);
        pr2 = new PhoneticRepresentation(mudText);
        pr3 = new PhoneticRepresentation(dogText);
        pr4 = new PhoneticRepresentation(muttText);
        word1 = new Word("bus", pr1);
        word2 = new Word("mud", pr2);
        word3 = new Word("dog", pr3);
        word4 = new Word("mutt", pr4);
    }
    
    /**
     * Initializes the instance variables for ArrayLists in this LineTest
     * object.
     * @param a1
     * @param a2
     * @param a3 
     */
    private void initializeArrayLists() {
        a1 = new ArrayList<>();
        a2 = new ArrayList<>();
        a3 = new ArrayList<>();
        
        a1.add(word1);
        a1.add(word2);
        a1.add(word3);
        
        a2.add(word3);
        a2.add(word2);
        a2.add(word1);
        
        a3.add(word1);
        a3.add(word1);
        a3.add(word1);
        a3.add(word1);
    }
    
    /**
     * Initializes the instance variables for lines in this LineTest object.
     * @param a1
     * @param a2
     * @param a3 
     */
    private void initializeLines() {
        line1 = new Line(a1);
        line2 = new Line(a2);
        line3 = new Line(a3);
        emptyLine = new Line();
        matchTestLine = new Line(a1);
    }

    
    
    /**
     * Test of getWordSequence method, of class Line.
     * 
     * getWordSequence returns an ArrayList, so we should be checking whether 
     * the two ArrayLists contain exactly the same elements.
     */
    @Test
    public void testGetWordSequence() {
        System.out.println("getWordSequence");
        Line instance = line1; 
        ArrayList<Word> expResult = new ArrayList<>();
        expResult.add(word1);
        expResult.add(word2);
        expResult.add(word3);
        ArrayList result = instance.getWordSequence();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNumWords method, of class Line.
     */
    @Test
    public void testGetNumWords() {
        System.out.println("getNumWords");
        Line instance = line1;
        int expResult = 3;
        int result = instance.getNumWords();
        assertEquals(expResult, result);
        
        instance = emptyLine;
        expResult = 0;
        result = instance.getNumWords();
        assertEquals(expResult, result);
    }

    /**
     * Test of getWordAtIndex method, of class Line.
     */
    @Test
    public void testGetWordAtIndex() {
        System.out.println("getWordAtIndex");
        int index = 0;
        Line instance = line1;
        Word expResult = word1;
        Word result = instance.getWordAtIndex(index);
        assertEquals(expResult, result);
    }

    /**
     * Test of linesAreSameLength method, of class Line.
     */
    @Test
    public void testLinesAreSameLength() {
        System.out.println("linesAreSameLength");
        Line candidate = line1;
        Line instance = line2;
        boolean expResult = true;
        boolean result = instance.linesAreSameLength(candidate);
        assertEquals(expResult, result);
        
        instance = line3;
        expResult = false;
        result = instance.linesAreSameLength(candidate);
        assertEquals(expResult, result);
    }

    /**
     * Test of isLiteralMatch method, of class Line.
     */
    @Test
    public void testIsLiteralMatch() {
        System.out.println("isLiteralMatch");
        Line candidate = line1;
        Line instance = matchTestLine;
        boolean expResult = true;
        boolean result = instance.isLiteralMatch(candidate);
        assertEquals(expResult, result);
    }

    /**
     * Test of addWordToLine method, of class Line.
     */
    @Test
    public void testAddWordToLine() {
        System.out.println("addWordToLine");
        Word word = null;
        int sizeBeforeAdd, sizeAfterAdd;
        Line instance = new Line(a1);
        
        sizeBeforeAdd = instance.getNumWords();
        instance.addWordToLine(word);
        sizeAfterAdd = instance.getNumWords();
        assertTrue(sizeBeforeAdd + 1 == sizeAfterAdd);
    }

    /**
     * Test of removeWordFromLine method, of class Line.
     */
    @Test
    public void testRemoveWordFromLine() {
        System.out.println("removeWordFromLine");
        int index = 0;
        Line instance = new Line();
        boolean thrown = false;
        
        // empty line
        try {
            instance.removeWordFromLine(index);
        }
        catch (Exception e) {
            thrown = true;
        }
        assertTrue(thrown);
        
        //non-empty line
        instance.addWordToLine(word1);
        thrown = false;
        try {
            instance.removeWordFromLine(index);
        }
        catch (Exception e) {
            thrown = true;
        }
        assertFalse(thrown);
    }

    /**
     * Test of isPhoneticMatch method, of class Line.
     */
    @Test
    public void testIsPhoneticMatch() {
        System.out.println("isPhoneticMatch");
        Line candidate = new Line(line1);
        Line instance = new Line(matchTestLine);
        boolean expResult = true;
        boolean result = instance.isPhoneticMatch(candidate);
        assertEquals(expResult, result);
        
        instance = new Line(line2);
        expResult = false;
        result = instance.isPhoneticMatch(candidate);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Line.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object other = new Line(line1);
        Line instance = new Line(line1);
        boolean expResult = true;
        boolean result = instance.equals(other);
        assertEquals(expResult, result);
        
        other = new Line(line2);
        expResult = false;
        result = instance.equals(other);
        assertEquals(expResult, result);
    }

    /**
     * Test of printLine method, of class Line.
     */
    @Test
    public void testPrintLine() {
        System.out.println("printLine");
        Line instance = new Line(line1);
        boolean thrown = false;
        try {
            instance.printLine();
        }
        catch (Exception e) {
            thrown = true;
        }
        assertFalse(thrown);
    }

    /**
     * Test of hashCode method, of class Line.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Line instance1 = new Line(line1);
        Line instance2 = new Line(line1);
        Line instance3 = new Line(line2);
        int result1 = instance1.hashCode();
        int result2 = instance2.hashCode();
        int result3 = instance3.hashCode();
        assertEquals(result1, result2);
        assertThat(result1, not(equals(result3)));
    }
    
}
