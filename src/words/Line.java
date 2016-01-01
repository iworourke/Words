/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package words;

import java.util.ArrayList;
import java.util.Objects;

/**
 * The Line object is used to represent a single line of a poem.
 * @author iworourke
 */
public class Line {
    
    private ArrayList<Word> words;
    
    /**
     * Non-default constructor which initializes the Line according to the 
     * provided Word-containing ArrayList.
     * @param wordSequence Sequence of words that this line shall contain.
     */
    public Line(ArrayList wordSequence) {
        this.words = new ArrayList<>(wordSequence);
    }
    
    /**
     * Constructor that allows us to make copies of a Line without modifying the
     * original object.
     * @param l the line that we are going to clone.
     */
    public Line(Line l) {
        words = new ArrayList<>(l.getWords());
    }
    
    /**
     * Default constructor.
     */
    public Line() {
        words = new ArrayList<>();
    }
    
    /**
     * Constructor that takes an array of words and turns it into a Line object.
     * @param wordList The list of conventional word spellings that will be used
     * to generate a Line object instance.
     */
    public Line(String[] wordList) {
        Line l = new Line();
        for (String s : wordList) {
            l.addWordToLine(new Word(s, null));
        }
    }
    
    
    /**
     * Getter for the words instance variable.
     * @return the words that make up this line object represented as an 
     *  ArrayList.
     */
    public ArrayList<Word> getWords() {
        return words;
    }
    
    /**
     * Returns the number of words in this Line.
     * @return the number of words in the line.
     */
    public int getNumWords() {
        return words.size();
    }
    
    /**
     * Retrieves the word at the provided index.
     * @param index of the word to be retrieved.
     * @return a word object found at the provided instance.
     */
    public Word getWordAtIndex(int index) {
        return words.get(index);
    }
    
    /**
     * Checks whether 'this' instance of the Line class and the candidate
     * instance of the line class have the same length.
     * @param candidate an instance of the line class which will be used as 
     * reference for comparison.
     * @return true if the lines contain the same number of words; false 
     * otherwise.
     */
    public boolean linesAreSameLength(Line candidate) {
        return (this.getNumWords() == candidate.getNumWords());
    }
    
    /**
     * Checks whether the literal spelling of two words is the same.
     * @param candidate a reference Line with which to compare.
     * @return true if the candidate is a match for 'this' Line; false 
     * otherwise.
     */
    public boolean isLiteralMatch(Line candidate) {
        boolean result = true;
        if (!linesAreSameLength(candidate)) {
            return false;
        }
        for (int i = 0; i < words.size() && result == true; i++) {
            Word leftWord = candidate.getWordAtIndex(i);
            Word rightWord = this.getWordAtIndex(i);
            if (!leftWord.conventionalSpellingMatches(rightWord)) {
                result = false;
            }
        }
        return result;
    }
    
    /**
     * Checks whether the literal spelling of two words is the same.
     * @param candidate a reference Line with which to compare.
     * @return true if the candidate is phonetically identical to 'this' Line;
     * false otherwise.
     */
    public boolean isPhoneticMatch(Line candidate) {
        boolean result = true;
        if (!linesAreSameLength(candidate)) {
            return false;
        }
        for (int i = 0; i < words.size() && result == true; i++) {
            Word leftWord = candidate.getWordAtIndex(i);
            Word rightWord = this.getWordAtIndex(i);
            if (!leftWord.phoneticSpellingMatches(rightWord)) {
                result = false;
            }
        }
        return result;
    }
    
    /**
     * Adds a word to the end of the ArrayList "words".
     * @param word to be added to the Line.
     */
    public void addWordToLine(Word word) {
        words.add(word);
    }
    
    /**
     * Removes the word at the specified index from the line.
     * @param index of the word which should be removed.
     * @throws Exception if the index does not fall within the bounds of the 
 ArrayList words.
     */
    public void removeWordFromLine(int index) throws Exception {
        words.remove(index);
    }
    
    /**
     * Prints the entire line to standard out.
     */
    public void printLine() {
        int i = 0;
        for (Word w : words) {
            w.printConventionalSpelling();
            
            if (i != words.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.print("\n");
    }

    /**
     * Returns a hash code value for the Line object.
     * @return A hash code value for this Line object.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.words);
        return hash;
    }
    
    /**
     * Indicates whether some object is equal to 'this' Line object.
     * @param other the reference object with which to compare.
     * @return true if this Line is the same as the 'other' argument; false
     * otherwise.
     */
    @Override public boolean equals(Object other) {
        boolean answer = false;
        if (other instanceof Line) {
            if (this.isLiteralMatch((Line)other) && this.isPhoneticMatch((Line)other)) {
                answer = true;
            }
        }
        return answer;
    }
    
    public String getConventionalText() {
        String text = "";
        
        for (Word w : words) {
            text.concat(w.getConventionalSpelling() + " ");
        }
        return text;
    }
}
