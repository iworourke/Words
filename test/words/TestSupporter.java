/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package words;

import java.util.ArrayList;

/**
 *
 * @author iworourke
 */
public class TestSupporter {
    
    private Poem poem;
    private String[] gravityLyrics;
    private ArrayList<Word> words;
    private ArrayList<Line> lines;
    
    private PhoneticRepresentation pr1, pr2, pr3, pr4;
    private String busText = "B AH S";
    private String mudText = "M AH D";
    private String dogText = "D AO G";
    private String muttText = "M AH T";
    
    public TestSupporter() {
        poem = new Poem();
        words = new ArrayList<>();
        lines = new ArrayList<>();
        
        gravityLyrics = new String[]{
            "Something always brings me back to you", 
            "It never takes too long",
            "No matter what I say or do",
            "I will still feel you here till the moment I am gone"};
    }
    
    /*public Poem constructGravityPoem() {
        
        for (String s : gravityLyrics) {                                        // for each line in the poem
            String[] wordsFromLine = s.split(" ");
            ArrayList<Word> wordList = new ArrayList<Word>();
            for (String t : wordsFromLine) {                                    // for each word in a line
                Word w = new Word(t, t);                                        // turn the word into a Word object
                wordList.add(w);                                                // add the word to the arrayList
            }
            //turn the wordList into a line
            Line line = new Line(wordList);
            lines.add(line);
            //poem.addLineToPoem(line);                                           // Add the line object to the Poem Object
        }
        poem.addLinesToPoem(lines);
        return poem;
    }
    
    public Line constructFirstLineGravityPoem() {
        String[] wordsFromLine = gravityLyrics[0].split(" ");
        Line firstLine = poem.getLineAtIndex(0);
        return firstLine;
    }
    
    public Poem getGravityPoem() {
        return poem;
    }*/
    
}
