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
public class PoemTest {
    
    TestSupporter ts;
    Poem gravityPoem;
    Line firstLineGravityPoem;
    String[] gravityLyrics;
    
    private Word word1, word2, word3, word4;
    private Line line1, line2, line3, matchTestLine, emptyLine;
    private Poem poem1;
    private ArrayList<Word> a1, a2, a3;
    private PhoneticRepresentation pr1, pr2, pr3, pr4;
    private String busText = "B AH S";
    private String mudText = "M AH D";
    private String dogText = "D AO G";
    private String muttText = "M AH T";
    
    public PoemTest() {
    }
    
    @Before
    public void setUp() {
        ts = new TestSupporter();
        /*gravityPoem = ts.constructGravityPoem();
        firstLineGravityPoem = ts.constructFirstLineGravityPoem();
        gravityLyrics = new String[]{
            "Something always brings me back to you", 
            "It never takes too long",
            "No matter what I say or do",
            "I will still feel you here till the moment I am gone"};*/
        initializeWords();
        initializeArrayLists();
        initializeLines();
        initializePoem();
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
    
    private void initializePoem() {
        poem1 = new Poem();
        poem1.addLineToPoem(line1);
        poem1.addLineToPoem(line2);
        poem1.addLineToPoem(line3);
    }
    
    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of addLineToPoem method, of class Poem.
     */
    @Test
    public void testAddLineToPoem() {
        System.out.println("addLineToPoem");
        int numLinesBeforeAdd, numLinesAfterAdd;
        Line line = new Line(line1);
        Poem instance = new Poem();
        
        numLinesBeforeAdd = instance.getNumLines();
        instance.addLineToPoem(line);
        numLinesAfterAdd = instance.getNumLines();
        
        assertTrue(numLinesAfterAdd - 1 == numLinesBeforeAdd);
    }

    /**
     * Test of removeLineFromPoem method, of class Poem. Should test behavior
     * for two situations: first, when the Poem has one or more lines in it, and
     * second, when the poem has no lines in it.
     */
    @Test
    public void testRemoveLineFromPoem() {
        System.out.println("removeLineFromPoem");
        
        boolean thrown = false;
        int numLinesBeforeRemove, 
                numLinesAfterRemove,
                index = 0;
        Line line = new Line(line1); 
        Poem instance = new Poem();
        
        //empty poem
        try {
            instance.removeLineFromPoem(index);
        }
        catch (Exception e) {
            thrown = true;
        }
        assertTrue(thrown);
        
        //non-empty poem
        thrown = false;
        instance.addLineToPoem(line1);
        try {
            numLinesBeforeRemove = instance.getNumLines();
            instance.removeLineFromPoem(index);
            numLinesAfterRemove = instance.getNumLines();
            assertTrue(numLinesBeforeRemove == numLinesAfterRemove + 1);
        }
        catch (Exception e) {
            thrown = true;
        }
        assertFalse(thrown);
    }

    /**
     * Test of getLineAtIndex method, of class Poem.
     */
    @Test
    public void testGetLineAtIndex() {
        System.out.println("getLineAtIndex");
        int index = 0;
        Poem instance = new Poem(poem1);
        Line expResult = line1;
        Line result = instance.getLineAtIndex(index);
        assertEquals(expResult, result);
    }

    /**
     * Test of getNumLines method, of class Poem.
     */
    @Test
    public void testGetNumLines() {
        System.out.println("getNumLines");
        Poem instance = poem1;
        int expResult = 3;
        int result = instance.getNumLines();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLines method, of class Poem. Needs to be able to handle the
     * situation in which the Poem has no lines.
     */
    @Test
    public void testGetLines() {
        System.out.println("getLines");
        boolean thrown = false;
        Poem instance = new Poem();
        ArrayList<Line> expResult = new ArrayList<>();
        ArrayList<Line> result = instance.getLines();
        assertEquals(expResult, result);
        
        try {
            instance = new Poem(poem1);
            instance.getLines();
        }
        catch (Exception e) {
            thrown = true;
        }
        assertFalse(thrown);
    }

    /**
     * Test of addLinesToPoem method, of class Poem.
     */
    @Test
    public void testAddLinesToPoem() {
        System.out.println("addLinesToPoem");
        int numBeforeAdd, numAfterAdd;
        Poem instance1 = new Poem(poem1);
        Poem instance2 = new Poem(poem1);
        ArrayList<Line> lines = instance2.getLines();
        
        numBeforeAdd = instance1.getNumLines();
        instance1.addLinesToPoem(lines);
        numAfterAdd = instance1.getNumLines();
        assertTrue(numAfterAdd - 3 == numBeforeAdd);
    }

    /**
     * Test of printPoem method, of class Poem.
     */
    @Test
    public void testPrintPoem() {
        System.out.println("printPoem");
        Poem instance = new Poem(poem1);
        boolean thrown = false;
        
        try {
            instance.printPoem();
        }
        catch (Exception e) {
            thrown = true;
        }
        assertFalse(thrown);
    }
    
}
