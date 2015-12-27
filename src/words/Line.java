/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package words;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author iworourke
 */
public class Line {
    
    private ArrayList<Word> wordSequence;
    private int numWordsInLine;
    
    /**
     * Non-default constructor which initializes the Line according to the 
     * provided Word-containing ArrayList.
     * @param wordSequence Sequence of words that this line shall contain.
     */
    public Line(ArrayList wordSequence) {
        this.wordSequence = new ArrayList<>(wordSequence);
        numWordsInLine = wordSequence.size();
    }
    
    public Line(Line l) {
        wordSequence = new ArrayList<>(l.getWordSequence());
        numWordsInLine = l.getNumWords();
    }
    
    /**
     * Default constructor.
     */
    public Line() {
        wordSequence = new ArrayList<>();
        numWordsInLine = 0;
    }
    
    /**
     * Takes an array of words and turns it into a Line object, this method
     * also initializes the phonetic spellings to be identical to the literal
     * spellings, which is something that needs to change eventually.
     * @param wordList 
     */
    public Line(String[] wordList) {
        Line l = new Line();
        for (String s : wordList) {
            l.addWordToLine(new Word(s, null));
        }
        numWordsInLine = wordList.length;
    }
    
    
    /**
     * Retrieves the entire sequence of words that make up this Line object.
     * @return the words that make up this line object represented as an 
     *  ArrayList.
     */
    public ArrayList getWordSequence() {
        return wordSequence;
    }
    
    /**
     * Counts and returns the number of words in this Line.
     * @return the number of words in the line.
     */
    public int getNumWords() {
        return numWordsInLine;
    }
    
    /**
     * Retrieves the word at the provided index
     * @param index of the word to be retrieved.
     * @return a word object.
     */
    public Word getWordAtIndex(int index) {
        return wordSequence.get(index);
    }
    
    /**
     * Checks whether this instance of the line class and the provided parameter
     * instance of the line class have the same length.
     * @param candidate an instance of the line class which will be used as 
     *  reference for comparison.
     * @return 
     */
    public boolean linesAreSameLength(Line candidate) {
        return (this.getNumWords() == candidate.getNumWords());
    }
    
    /**
     * Checks whether the literal spelling of two words is the same.
     * @param candidate
     * @return a boolean.
     */
    public boolean isLiteralMatch(Line candidate) {
        boolean result = true;
        if (!linesAreSameLength(candidate)) {
            return false;
        }
        for (int i = 0; i < wordSequence.size() && result == true; i++) {
            Word leftWord = candidate.getWordAtIndex(i);
            Word rightWord = this.getWordAtIndex(i);
            if (!leftWord.isLiteralMatch(rightWord)) {
                result = false;
            }
        }
        return result;
    }
    
    /**
     * Checks whether the literal spelling of two words is the same.
     * @param candidate
     * @return a boolean.
     */
    public boolean isPhoneticMatch(Line candidate) {
        boolean result = true;
        if (!linesAreSameLength(candidate)) {
            return false;
        }
        for (int i = 0; i < wordSequence.size() && result == true; i++) {
            Word leftWord = candidate.getWordAtIndex(i);
            Word rightWord = this.getWordAtIndex(i);
            if (!leftWord.isPhoneticMatch(rightWord)) {
                result = false;
            }
        }
        return result;
    }
    
    /**
     * Adds a word to the end of the ArrayList "wordSequence".
     * @param word 
     */
    public void addWordToLine(Word word) {
        wordSequence.add(word);
        numWordsInLine++;
    }
    
    public void removeWordFromLine(int index) throws Exception {
        wordSequence.remove(index);
        numWordsInLine--;
    }
    
    public void printLine() {
        int i = 0;
        for (Word w : wordSequence) {
            w.printConventionalSpelling();
            
            if (i != wordSequence.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.print("\n");
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.wordSequence);
        hash = 31 * hash + this.numWordsInLine;
        return hash;
    }
    
    @Override public boolean equals(Object other) {
        boolean answer = false;
        if (other instanceof Line) {
            if (this.isLiteralMatch((Line)other) && this.isPhoneticMatch((Line)other)) {
                answer = true;
            }
        }
        return answer;
    }
}
