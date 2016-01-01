/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package words;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import words.Controller.Controller;
import words.View.View;
import javax.swing.*;

/**
 *
 * @author iworourke
 */
public class Driver implements GlobalPathNames {
    
    public static void main(String[] args)  {
        /*String CmuPath = "support_files/CMU_Dictionary/",
                CmuDict = "CMU_Dict",
                CmuPhones = "CMU_Phones",
                CmuSymbols = "CMU_Symbols";*/
        String[] gravityLyrics = new String[]{
            "Something always brings me back to you", 
            "It never takes too long",
            "No matter what I say or do",
            "I will still feel you here till the moment I am gone"};
        
        Dictionary fullDictionary = new Dictionary(new File(CMU_PATH + CMU_DICT));
        
        ArrayList<Line> gravityLines = new ArrayList<>();
        initGravityLines(gravityLyrics, fullDictionary, gravityLines);
        
        //DO MVC stuff
        Poem model = new Poem();
        constructPoemObject(gravityLyrics, fullDictionary, model);
        printPoemPhonetically(model);
        //View view = new View();
        
        //model.addObserver(view);
        //Controller controller = new Controller();
        //controller.addModel(model);
        //controller.addView(view);
        //controller.initModel(gravityLines);
        //view.addController(controller);
        
    }
    
    private static void initGravityLines(String[] gravityLyrics, Dictionary fullDictionary, ArrayList<Line> lineList) {
        
        
        for (String s : gravityLyrics) {
            
            Scanner wordScanner = new Scanner(s);
            Line line = new Line();
            
            while(wordScanner.hasNext()) {
                
                String wordAsString = wordScanner.next();
                
                try {
                    PhoneticRepresentation phoneticRepresentation = fullDictionary.getPhoneticRepresentationForWord(wordAsString.toUpperCase());
                    Word word = new Word(wordAsString, phoneticRepresentation);
                    line.addWordToLine(word);
                }
                catch (Exception e) {
                    System.out.println("There was a problem");
                }
            }
            
            lineList.add(line);
        }
    }
    
    public static void constructPoemObject(String[] gravityLyrics, Dictionary fullDictionary, Poem poem) {        
        for (String s : gravityLyrics) {
            
            Scanner wordScanner = new Scanner(s);
            Line line = new Line();
            
            while(wordScanner.hasNext()) {
                
                String wordAsString = wordScanner.next();
                
                try {
                    PhoneticRepresentation phoneticRepresentation = fullDictionary.getPhoneticRepresentationForWord(wordAsString.toUpperCase());
                    Word word = new Word(wordAsString, phoneticRepresentation);
                    line.addWordToLine(word);
                }
                catch (Exception e) {
                    System.out.println("There was a problem");
                }
            }
            poem.addLineToPoem(line);
        }
    }

    private static void printPoemPhonetically(Poem poem) {
        for (Line line : poem.getLines()) {
            
            for (Word w : line.getWords()) {
                System.out.print(w.getPhoneticText());
                System.out.print(" ");
            }
            System.out.print("\n");
        }
    }
    
}
