/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package words;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;

/**
 * A class that is used to represent a dictionary of words. For each entry in the
 * dictionary, there is a representation of the word's conventional spelling,
 * as well as a phonetic Spelling of the word. Since the dictionaries will tend
 * to be fairly large text files, this class will refrain from maintaining a
 * List or ArrayList of dictionary entries, and instead it will directly
 * manipulate these text files.
 * @author iworourke
 */
public class Dictionary {
    
    private File dictionaryFile;
    
    /**
     * Default constructor.
     */
    public Dictionary() {
        dictionaryFile = null;
    }
    
    /**
     * Constructor that allows the caller to make copies of a Dictionary 
     * instance.
     * @param d the dictionary to make a copy of.
     */
    public Dictionary(Dictionary d) {
        dictionaryFile = d.getFile();
    }
    
    /**
     * Constructor that initializes the dictionaryFile.
     * @param file value for the dictionaryFile attribute.
     */
    public Dictionary(File file) {
        dictionaryFile = file;
    }
    
    /**
     * Getter for the dictionaryFile object.
     * @return The dictionaryFile attribute.
     */
    public File getFile() {
        return dictionaryFile;
    }
    
    /**
     * Setter for dictionaryFile instance variable.
     * @param file The file the dictionary will use to store its data.
     */
    public void setFile(File file) {
        dictionaryFile = file;
        if (!dictionaryFile.exists()) {
            try {
                dictionaryFile.createNewFile();
            }
            catch (Exception e) {
                System.out.println("Error creating new file...");
            }
        }
    }
    
    /**
     * Checks the dictionaryFile for the number of entries in the dictionary by
     * counting the number of times the readLine() operation can be performed
     * before it returns null, which means that end-of-file has been 
     * encountered; this operation is extremely expensive.
     * @return the number of entries in the dictionary.
     * @throws Exception if the File object is invalid.
     */
    public int getNumEntries() throws Exception {
        int numLines = 0;
        FileReader fileReader = new FileReader(dictionaryFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        
        while (bufferedReader.readLine() != null) {
            numLines++;
        }
        bufferedReader.close();
        
        return numLines;
    }
    
    /**
     * Gets the DictionaryEntry at the specified index.
     * @param index the index of the DictionaryEntry to retrieve.
     * @return The desired DictionaryEntry object.
     * @throws Exception if the provided index is outside the bounds of the 
     * Dictionary.
     */
    public DictionaryEntry getEntry(int index) throws Exception {
        int counter = 0;
        FileReader fileReader = new FileReader(dictionaryFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String s = "";
        DictionaryEntry dAtIndex;
        
        while (counter != index && (s = bufferedReader.readLine()) != null) {
            counter++;
        }
        dAtIndex = parseDictionaryEntryFromLine(s);
        bufferedReader.close();
        return dAtIndex;
    }
    
    
    /**
     * Adds a DictionaryEntry to the dictionary. Will not add the entry to the
     * dictionary if the dictionary already contains an identical entry.
     * @param d DictionaryEntry to be added to the dictionary.
     * @throws java.io.IOException if there is an error reading from the file,
     * which occurs when the method checks whether an entry is already in the 
     * dictionary.
     */
    public void addEntry(DictionaryEntry d) throws IOException {
        String text = d.getStringRepresentation();        
        FileWriter fileWriter = new FileWriter(dictionaryFile, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.append(text + "\n");
        bufferedWriter.close();
    }
    
    
    
    /**
     * Removes the DictionaryEntry at the specified index from the Dictionary.
     * @param index
     */
    public void removeEntry(int index) throws IndexOutOfBoundsException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    /**
     * Sorts the ArrayList of DictionaryEntry objects using Selection Sort.
     */
    public void sortEntries() {
        //Collections.sort(entries);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Retrieves the PhoneticRepresentation that corresponds to the provided 
     * spelling. If the word cannot be found, returns null.
     * @param wordAsString The conventional spelling of a word for which a
     * PhoneticRepresentation is desired.
     * @return A PhoneticRepresentation object for the provided word, 
     * represented by its conventional spelling.
     */
    public PhoneticRepresentation getPhoneticRepresentationForWord(String wordAsString) throws FileNotFoundException, IOException {
        boolean found = false;
        String textFileLine;
        
        BufferedReader bufferedReader = new BufferedReader(new FileReader(dictionaryFile));
        PhoneticRepresentation phoneticRep = null;
        
        while (!found && (textFileLine = bufferedReader.readLine()) != null) {
            
            Word word = parseWordFromLine(textFileLine);
            
            if (word.getConventionalSpelling().equals(wordAsString)) {
                
                found = true;
                phoneticRep = word.getPhoneticRepresentation();
                
            }
            
        }
        
        bufferedReader.close();
        
        return phoneticRep;
    }

    /**
     * Scans the dictionaryFile to determine whether it contains a specific
     * DictionaryEntry object.
     * @param d Dictionary Entry object which we are looking for
     * @return true if the entry is found; false otherwise.
     * @throws FileNotFoundException if the dictionaryFile object has not been 
     * initialized or cannot be found.
     * @throws IOException if there is an error reading from the dictionaryFile.
     */
    private boolean dictionaryFileContains(DictionaryEntry d) throws FileNotFoundException, IOException {
        boolean found = false;
        String textFileLine;
        String wordAsString = d.getWord().getConventionalSpelling();
        
        FileReader fileReader = new FileReader(dictionaryFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        
        while ((textFileLine = bufferedReader.readLine()) != null && !found) {
            Word word = parseWordFromLine(textFileLine);
            DictionaryEntry textFileDictEntry = parseDictionaryEntryFromLine(textFileLine);
            if (d.equals(textFileDictEntry)) {
                found = true;
            }
        }
        bufferedReader.close();
        
        return found;
    }
    
    /**
     * A support method that is responsible for converting a single String
     * representation of a dictionary entry into a DictionaryEntry object. It is
     * based upon the structure of the CMU dictionary.
     * @param s the string that will be parsed into a dictionaryEntry object.
     * @return A DictionaryEntry object based on the provided string.
     */
    private DictionaryEntry parseDictionaryEntryFromLine(String s) {
        Word word = parseWordFromLine(s);
        DictionaryEntry dictionaryEntry = new DictionaryEntry(word);
        return dictionaryEntry;
    }
    
    /**
     * Translates a formatted string (in the style of the CMU Phonetic
     * Dictionary) into a Word object.
     * @param s the string which contains the data to create a Word object.
     * @return the Word object.
     */
    private Word parseWordFromLine(String s) {
        Word w;
        String spelling;
        ArrayList<PhoneticUnit> phoneticUnits = new ArrayList<>();
        PhoneticRepresentation pr;
        
        Scanner scanner = new Scanner(s);
        spelling = scanner.next();
        while(scanner.hasNext()) {
            phoneticUnits.add(new PhoneticUnit(scanner.next()));
        }
        
        pr = new PhoneticRepresentation(phoneticUnits);
        w = new Word(spelling, pr);
        
        return w;
    }
}
