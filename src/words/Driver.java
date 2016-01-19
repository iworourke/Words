/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package words;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import words.Controller.Controller;
import words.View.View;
import javax.swing.*;
import words.Model.Model;
import words.View.UI;

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
        String[] whiteWinterHymnalLyrics = new String[]{
            "I was following the pack all swallowed in their coats", 
            "with scarves of red tied round their throats",
            "to keep their little heads from falling in the snow",
            "And I turn round and there you go"};
        
        Dictionary fullDictionary = new Dictionary(new File(CMU_PATH + CMU_DICT));
        
        ArrayList<Line> gravityLines = new ArrayList<>();
        initGravityLines(whiteWinterHymnalLyrics, fullDictionary, gravityLines);
        
        
        Poem starting_poem = new Poem();
        constructPoemObject(whiteWinterHymnalLyrics, fullDictionary, starting_poem);
        printPoemPhonetically(starting_poem);
        
        //DO MVC stuff
        Model myModel = new Model();
        View myView = new View();
        
        myModel.addObserver(myView);
        
        Controller myController = new Controller();
        myController.addModel(myModel);
        myController.addView(myView);
        myController.initModel(starting_poem);
        
        //myView.addController(myController);
        
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
