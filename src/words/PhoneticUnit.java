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
public class PhoneticUnit {
    
    private String text;
    
    public PhoneticUnit() {
        text = "";
    }
    
    public PhoneticUnit(PhoneticUnit pu) {
        text = pu.getText();
    }
    
    public PhoneticUnit(String text) {
        this.text =  text;
    }
    
    public String getText() {
        return text;
    }
    
    public void setText(String newText) {
        text = newText;
    }

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
     * 
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.text);
        return hash;
    }
    
    public void print() {
        System.out.print(text);
    }
}
