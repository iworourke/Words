/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package words;

import java.util.Objects;

/**
 *
 * @author iworourke
 */
public class Word implements Comparable<Word> {

    private String literalText;
    //private String phoneticText;
    private PhoneticRepresentation phoneticRep;

    /**
     * Constructor (non-default)
     * @param literalText the literal spelling of the word.
     * @param phoneticText the phonetic spelling of the word.
     */
    public Word(String literalText, PhoneticRepresentation phoneticRep) {
        this.literalText = literalText;
        this.phoneticRep = phoneticRep;
    }

    public Word(Word w) {
        literalText = w.getLiteralText();
        phoneticRep = w.getPhoneticRepresentation();
    }
    
    public Word() {
        literalText = "";
        phoneticRep = new PhoneticRepresentation();
    }
    
    /**
     * Retrieves the String representation of the spelling of the word.
     * @return a copy of the instance variable literalText
     */
    public String getLiteralText() {
        return literalText;
    }

    /**
     * Retrieves the String representation of the phonetic spelling of this 
     * word.
     * @return a copy of the instance variable phoneticText
     */
    public PhoneticRepresentation getPhoneticRepresentation() {
        return new PhoneticRepresentation(phoneticRep);
    }

    /**
     * Set the literal spelling of the word to the value specified in the String
     * "text".
     * @param text 
     */
    public void setLiteralText(String text) {
        literalText = text;
    }
    
    /**
     * Set the phonetic text to the value specified in the String "text".
     * @param text 
     */
    public void setPhoneticRepresentation(PhoneticRepresentation pr) {
        phoneticRep = pr;
    }
    
    /**
     * Checks whether the dictionary spelling of the candidate word matches that
     * of 'this' word's instance.
     * @param candidate
     * @return
     */
    public boolean isLiteralMatch(Word candidate) {
        boolean answer;
        String s1, s2;
        s1 = this.literalText;
        s2 = candidate.getLiteralText();
        answer = s1.equals(s2);
        return answer;
    }

    /**
     * Checks whether the phonetic spelling of the candidate word matches that
     * of 'this' word's instance.
     * @param candidate
     * @return a boolean indicating whether the words are phonetically
     * identical.
     */
    public boolean isPhoneticMatch(Word candidate) {
        boolean answer;
        PhoneticRepresentation s1, s2;
        s1 = this.phoneticRep;
        s2 = candidate.getPhoneticRepresentation();
        answer = s1.equals(s2);
        return answer;
    }

    /**
     * Prints the literal text of the Word object to standard out.
     */
    public void printConventionalSpelling() {
        System.out.print(literalText);
    }
    
    public void printPhoneticSpelling() {
        phoneticRep.print();
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.literalText);
        hash = 37 * hash + Objects.hashCode(this.phoneticRep);
        return hash;
    }
    
    /**
     * 
     * @param other
     * @return 
     */
    @Override public boolean equals(Object other) {
        boolean answer = false;
        if (other instanceof Word) {
            if (this.isLiteralMatch((Word)other) && this.isPhoneticMatch((Word)other)) {
                answer = true;
            }
        }
        return answer;
    }

    /**
     * This is necessary to be able to sort things.
     * @param o 
     * @return 
     */
    @Override
    public int compareTo(Word o) {
        return this.getLiteralText().compareTo(o.getLiteralText());
    }
}
