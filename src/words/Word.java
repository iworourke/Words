/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package words;

import java.util.Objects;

/**
 * The Word class is used to represent a sortable word, and has variables to 
 * represent the literal and phonetic spellings of its instances.
 * @author iworourke
 */
public class Word implements Comparable<Word> {

    private String conventionalSpelling;
    private PhoneticRepresentation phoneticRep;

    /**
     * Constructor (non-default)
     * @param conventionalSpelling the conventional spelling of the word.
     * @param phoneticRep the phonetic representation of the word.
     */
    public Word(String conventionalSpelling, PhoneticRepresentation phoneticRep) {
        this.conventionalSpelling = conventionalSpelling;
        this.phoneticRep = phoneticRep;
    }

    /**
     * This constructor exists so we can make changes to Word object instances
     * without losing a Word object's original data.
     * @param w word object to make a copy of.
     */
    public Word(Word w) {
        conventionalSpelling = w.getConventionalSpelling();
        phoneticRep = w.getPhoneticRepresentation();
    }
    
    /**
     * Default constructor.
     */
    public Word() {
        conventionalSpelling = "";
        phoneticRep = new PhoneticRepresentation();
    }
    
    /**
     * Getter for the spelling of the word instance.
     * @return a copy of the instance variable literalText
     */
    public String getConventionalSpelling() {
        return conventionalSpelling;
    }

    /**
     * Getter for the PhoneticRepresentation of the word instance.
     * @return a copy of the instance variable phoneticText
     */
    public PhoneticRepresentation getPhoneticRepresentation() {
        return new PhoneticRepresentation(phoneticRep);
    }
    
    public String getPhoneticText() {
        return phoneticRep.toString();
    }

    /**
     * Setter for the spelling of the word instance.
     * @param text The spelling of the word.
     */
    public void setConventionalSpelling(String text) {
        conventionalSpelling = text;
    }
    
    /**
     * Setter for the PhoneticRepresentation of the word instance.
     * @param pr the phonetic representation of the word. 
     */
    public void setPhoneticRepresentation(PhoneticRepresentation pr) {
        phoneticRep = pr;
    }
    
    /**
     * Determines whether the conventional spelling of a word matches the 
     * conventional spelling of 'this' word.
     * @param word the reference word object with which to compare.
     * @return a boolean representing whether the candidate is identical to
     * this word instance.
     */
    public boolean conventionalSpellingMatches(Word word) {
        boolean answer;
        String s1, s2;
        s1 = this.conventionalSpelling;
        s2 = word.getConventionalSpelling();
        answer = s1.equals(s2);
        return answer;
    }

    /**
     * Determines whether the phonetic spelling of a word matches that of 'this'
     * word.
     * @param word the reference word object with which to compare.
     * @return a boolean indicating whether the words are phonetically
     * identical.
     */
    public boolean phoneticSpellingMatches(Word word) {
        boolean answer;
        PhoneticRepresentation s1, s2;
        s1 = this.phoneticRep;
        s2 = word.getPhoneticRepresentation();
        answer = s1.equals(s2);
        return answer;
    }

    /**
     * Prints the conventional spelling of the Word object to standard out.
     */
    public void printConventionalSpelling() {
        System.out.print(conventionalSpelling);
    }
    
    /**
     * Prints the phonetic spelling of the Word object to standard out.
     */
    public void printPhoneticSpelling() {
        phoneticRep.print();
    }
    
    /**
     * Returns a hash code value for the Word object.
     * @return A hash code value for this Word object.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.conventionalSpelling);
        hash = 37 * hash + Objects.hashCode(this.phoneticRep);
        return hash;
    }
    
    /**
     * Indicates whether some object is equal to 'this' Word object.
     * @param other the reference object with which to compare.
     * @return true if this object is the same as the 'other' argument; false
     * otherwise.
     */
    @Override public boolean equals(Object other) {
        boolean answer = false;
        if (other instanceof Word) {
            if (this.conventionalSpellingMatches((Word)other) && this.phoneticSpellingMatches((Word)other)) {
                answer = true;
            }
        }
        return answer;
    }
    
    /**
     * Compares this object with the specified object for order, using only the
     * conventional spelling of the word.
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this Word 
     * object is less than, equal to, or greater than 'o'.
     */
    @Override
    public int compareTo(Word o) {
        return this.getConventionalSpelling().compareTo(o.getConventionalSpelling());
    }
}
