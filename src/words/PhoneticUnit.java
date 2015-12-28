/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package words;

import java.util.Objects;

/**
 * Represents a Phonetic Unit, which can be either a consonant or vowel sound.
 * @author iworourke
 */
public class PhoneticUnit {
    
    private String text;
    
    /**
     * Default constructor.
     */
    public PhoneticUnit() {
        text = "";
    }
    
    /**
     * Constructor that allows us to make copies of PhoneticUnit objects.
     * @param pu 
     */
    public PhoneticUnit(PhoneticUnit pu) {
        text = pu.getText();
    }
    
    /**
     * Constructor that allows the caller to specify the textual representation
     * of the PhoneticUnit.
     * @param text a textual representation of the phonetic unit.
     */
    public PhoneticUnit(String text) {
        this.text =  text;
    }
    
    /**
     * Getter for the textual representation of the phonetic unit.
     * @return a String representing the phonetic unit.
     */
    public String getText() {
        return text;
    }
    
    /**
     * Setter for the textual representation of the PhoneticUnit.
     * @param newText the new representation of the PhoneticUnit.
     */
    public void setText(String newText) {
        text = newText;
    }

    /**
     * Indicates whether some object is equal to 'this' PhoneticUnit object.
     * @param other the reference object with which to compare.
     * @return true if this PhoneticUnit is the same as the 'other' object; false
     * otherwise.
     */
    @Override public boolean equals(Object other) {
        boolean answer = false;
        if (other instanceof PhoneticUnit) {
            String t1 = this.text;
            String t2 = ((PhoneticUnit)other).getText();
            if (t1.equals(t2)) {
                answer = true;
            }
        }
        return answer;
    }
    
    /**
     * Returns a hash code value for this PhoneticUnit object.
     * @return A hash code value for this PhoneticUnit object.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.text);
        return hash;
    }
    
    /**
     * Prints the textual representation of the PhoneticUnit to standard out.
     */
    public void print() {
        System.out.print(text);
    }
}
