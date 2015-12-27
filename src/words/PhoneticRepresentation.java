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
    
    public PhoneticRepresentation() {
        phoneticUnits = new ArrayList<>();
    }
    
    public PhoneticRepresentation(PhoneticRepresentation p) {
        phoneticUnits = new ArrayList<>(p.getPhoneticUnits());
    }
    
    public PhoneticRepresentation(ArrayList<PhoneticUnit> phoneticUnits) {
        this.phoneticUnits = phoneticUnits;
    }
    
    public PhoneticRepresentation(String str) {
        Scanner scanner = new Scanner(str);
        phoneticUnits = new ArrayList<>();
        while(scanner.hasNext()) {
            phoneticUnits.add(new PhoneticUnit(scanner.next()));
        }
    }
    
    public ArrayList<PhoneticUnit> getPhoneticUnits() {
        return phoneticUnits;
    }
    
    public void setPhoneticUnits(ArrayList<PhoneticUnit> phoneticUnits) {
        this.phoneticUnits = phoneticUnits;
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.phoneticUnits);
        return hash;
    }
    
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
    
    public void print() {
        System.out.print(toString());
    }
    
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
