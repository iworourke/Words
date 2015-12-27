/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package words;

import java.util.Scanner;

/**
 *
 * @author iworourke
 */
public class Driver {
    
    public static void main(String[] args) {
        String CmuPath = "support_files/CMU_Dictionary",
                CmuDict = "CMU_Dict",
                CmuPhones = "CMU_Phones",
                CmuSymbols = "CMU_Symbols";
        String[] gravityLyrics = new String[]{
            "Something always brings me back to you", 
            "It never takes too long",
            "No matter what I say or do",
            "I will still feel you here till the moment I am gone"};
        String specificDictionaryName = "TEMP_GRAV_POEM";
        
        Dictionary fullDictionary = new Dictionary();
        //Dictionary poemSpecificDictionary = new Dictionary(specificDictionaryName, specificDictionaryName);
        
        for (String s : gravityLyrics) {
            Scanner wordScanner = new Scanner(s);
            String wordAsString;
            Word word;
            PhoneticRepresentation phoneticRepresentation;
            
            while(wordScanner.hasNext()) {
                wordAsString = wordScanner.next();
                phoneticRepresentation = fullDictionary.getPhoneticRepresentationForWord(wordAsString);
                word = new Word(wordAsString, phoneticRepresentation);
                DictionaryEntry d = new DictionaryEntry(word);
                //poemSpecificDictionary.add(d);
            }
            
            
            
            
        }
    }
}
