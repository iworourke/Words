/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package words;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author iworourke
 */
public class Dictionary {
    
    private final ArrayList<DictionaryEntry> entries;
    private String outputFileName;
    private String inputFileName;
    private int numEntries;
    
    
    public Dictionary() {
        entries = new ArrayList<>();
        outputFileName = "";
        inputFileName = "";
        numEntries = 0;
    }
    
    public Dictionary(Dictionary d) {
        entries = new ArrayList<>(d.getEntries());
        outputFileName = d.getOutputFileName();
        inputFileName = d.getInputFileName();
        numEntries = d.getNumEntries();
    }
    
    public Dictionary(String inFileName, String outFileName) throws Exception {
        entries = new ArrayList<>();
        inputFileName = inFileName;
        outputFileName = outFileName;
        numEntries = 0;
        addEntriesFromFile(inputFileName);
    }
    
    public ArrayList<DictionaryEntry> getEntries() {
        return entries;
    }
    
    public String getInputFileName() {
        return  inputFileName;
    }
    
    public String getOutputFileName() {
        return outputFileName;
    }
    
    public int getNumEntries() {
        return numEntries;
    }
    
    public DictionaryEntry getEntry(int index) {
        return new DictionaryEntry(entries.get(index));
    }
    
    public void setInputFileName(String newInputFileName) {
        inputFileName = newInputFileName;
    }
    
    public void setOutputFileName(String newOutputFileName) {
        outputFileName = newOutputFileName;
    }
    
    /**
     * Adds a DictionaryEntry to the dictionary. Will not add the entry to the
     * dictionary if the dictionary already contains an identical entry.
     * @param d 
     */
    public void addEntry(DictionaryEntry d) {
        if (entries.contains(d) == false) {
            entries.add(d);
            numEntries++;
        }
    }
    
    /**
     * Removes the DictionaryEntry at the specified index from the Dictionary.
     * @param index
     */
    public void removeEntry(int index) throws IndexOutOfBoundsException {
        entries.remove(index);
        numEntries--;
    }
    
    /**
     * Makes sure the DictionaryEntry objects are sorted in alphabetical order
     * within the dictionary and updates the file where this data is backed up.
     */
    public void RefreshDictionary() {
        sortEntries();
        updateFile();
    }
    
    /**
     * Sorts the ArrayList of DictionaryEntry objects using Selection Sort.
     */
    public void sortEntries() {
        Collections.sort(entries);
    }
    
    /**
     * Adds each entry to the dictionary object from the specified file.
     * @param fileWithEntries
     * @throws java.lang.Exception If there is a problem reading from the file.
     */
    public void addEntriesFromFile(String fileWithEntries) throws Exception {
        ArrayList<String> lines;
        DictionaryEntry dictionaryEntryFromLine;
        String line;
        
        lines = getLinesFromFile(fileWithEntries);
        
        for (String s : lines) {
            dictionaryEntryFromLine = parseDictionaryEntryFromLine(s);
            addEntry(dictionaryEntryFromLine);
        }
        sortEntries();
    }
    
    /**
     * Overridden hashCode method.
     * @return a hashcode.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.entries);
        hash = 53 * hash + Objects.hashCode(this.inputFileName);
        hash = 53 * hash + this.numEntries;
        return hash;
    }
    
    /**
     * The overridden equals method, which will allow us to determine whether
     * two dictionary objects are identical, and while I don't expect this to be
     * useful in the primary application, it might be useful for testing the
     * Dictionary class.
     * @param other An object instance with which we compare "this" instance of
     * a Dictionary object.
     * @return 
     */
    @Override public boolean equals(Object other) {
        boolean answer = true;
        
        if (other instanceof Dictionary) {
            
            ArrayList<DictionaryEntry> list1 = entries;
            ArrayList<DictionaryEntry> list2 = ((Dictionary) other).getEntries();
            if (!list1.equals(list2)) {
                answer = false;
            }
            
            int numEntries1 = numEntries;
            int numEntries2 = ((Dictionary) other).getNumEntries();
            if (numEntries1 != numEntries2) {
                answer = false;
            }
            
            String fileName1 = inputFileName;
            String fileName2 = ((Dictionary) other).getInputFileName();
            if (!fileName1.equals(fileName2)) {
                answer = false;
            }
            
            fileName1 = outputFileName;
            fileName2 = ((Dictionary) other).getOutputFileName();
            if (!fileName1.equals(fileName2)) {
                answer = false;
            }
        }
        return answer;
    }
    
    /**
     * A support method that retrieves all the lines in the file in the form of
     * an ArrayList<String>.
     * @param fileWithEntries The name of the file which will supply the
     * dictionary entries.
     * @return an ArrayList that contains each line in the file.
     * @throws Exception if there is a problem while reading from the file.
     */
    private ArrayList<String> getLinesFromFile(String fileWithEntries) throws Exception {
        String line;
        ArrayList<String> lines = new ArrayList<>();
        FileReader fileReader = new FileReader(fileWithEntries);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        bufferedReader.close();
        return lines;
    }
    
    

    /**
     * A support method that is responsible for converting a single String
     * representation of a dictionary entry into a DictionaryEntry object. It is
     * based upon the structure of the CMU dictionary.
     * @param s
     * @return 
     */
    private DictionaryEntry parseDictionaryEntryFromLine(String s) {
        Word word = parseWordFromLine(s);
        DictionaryEntry dictionaryEntry = new DictionaryEntry(word);
        return dictionaryEntry;
    }
    
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
    
    /**
     * Updates the file to contain the data within the "entries" object.
     */
    private void updateFile() {
        try {
            FileWriter fileWriter = new FileWriter(inputFileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (DictionaryEntry d : entries) {
                bufferedWriter.write(d.getStringRepresentation() + "\n");
            }
            bufferedWriter.close();
        }
        catch (IOException e) {
            System.out.println("An error occurred while trying to write to the"
                    + " file" + inputFileName);
        }
    }

    /**
     * Retrieves the PhoneticRepresentation that corresponds to the provided 
     * spelling.
     * @param wordAsString
     * @return 
     */
    PhoneticRepresentation getPhoneticRepresentationForWord(String wordAsString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
