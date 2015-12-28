/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package words;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author iworourke
 */
public class PhoneticRepresentation {
    
    private ArrayList<PhoneticUnit> phoneticUnits;
    
    /**
     * Default Constructor.
     */
    public PhoneticRepresentation() {
        phoneticUnits = new ArrayList<>();
    }
    
    /**
     * Constructor that allows the caller to make copies of a 
     * PhoneticRepresentation object.
     * @param p the PhoneticRepresentation object to make a copy of.
     */
    public PhoneticRepresentation(PhoneticRepresentation p) {
        phoneticUnits = new ArrayList<>(p.getPhoneticUnits());
    }
    
    /**
     * Constructor that allows the caller to pass the PhoneticRepresentation
     * object's phoneticUnit(s) as a parameter.
     * @param phoneticUnits The phonetic units that make up this representation.
     */
    public PhoneticRepresentation(ArrayList<PhoneticUnit> phoneticUnits) {
        this.phoneticUnits = phoneticUnits;
    }
    
    /**
     * Constructor that builds a PhoneticRepresentation object from a provided
     * string. It is expected that each PhoneticUnit will be separated by a 
     * space.
     * @param str A string containing ' '-separated spellings for PhoneticUnits.
     */
    public PhoneticRepresentation(String str) {
        Scanner scanner = new Scanner(str);
        phoneticUnits = new ArrayList<>();
        while(scanner.hasNext()) {
            phoneticUnits.add(new PhoneticUnit(scanner.next()));
        }
    }
    
    /**
     * Getter for phoneticUnits.
     * @return the phoneticUnits instance variable.
     */
    public ArrayList<PhoneticUnit> getPhoneticUnits() {
        return phoneticUnits;
    }
    
    /**
     * Setter for phoneticUnits
     * @param phoneticUnits the value to be assigned to the phoneticUnits.
     */
    public void setPhoneticUnits(ArrayList<PhoneticUnit> phoneticUnits) {
        this.phoneticUnits = phoneticUnits;
    }
    
    /**
     * Returns a hash code value for this PhoneticRepresentation object.
     * @return A hash code value for this PhoneticRepresentation object.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.phoneticUnits);
        return hash;
    }
    
    /**
     * Indicates whether some object is equal to 'this' PhoneticRepresentation 
     * object.
     * @param other the reference object with which to compare.
     * @return true if this object is the same as the 'other' argument; false
     * otherwise.
     */
    @Override public boolean equals(Object other) {
        boolean answer = false;
        if (other instanceof PhoneticRepresentation) {
            ArrayList<PhoneticUnit> p1 = this.phoneticUnits;
            ArrayList<PhoneticUnit> p2 = ((PhoneticRepresentation)other).getPhoneticUnits();
            if (p1.equals(p2)) {
                answer = true;
            }
        }
        return answer;
    }
    
    /**
     * Prints the phonetic spelling to standard out.
     */
    public void print() {
        System.out.print(toString());
    }
    
    /**
     * Returns the string of the phonetic spelling for this 
     * PhoneticRepresentation.
     * @return the string of the phonetic spelling for this 
     * PhoneticRepresentation.
     */
    @Override
    public String toString() {
        String stringRep = "";
        int numPhoneticUnits = phoneticUnits.size();
        int index = 0;
        
        for (PhoneticUnit pu : phoneticUnits) {
            stringRep = stringRep.concat(pu.getText());
            if (index++ != numPhoneticUnits-1) {
                stringRep = stringRep.concat(" ");
            }
        }
        return stringRep;
    }
}
