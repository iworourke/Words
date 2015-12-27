/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package words;

import java.util.ArrayList;

/**
 *
 * @author iworourke
 */
public class Poem {
    private ArrayList<Line> poemLines;
    private int numLines;
    
    public Poem(Poem p) {
        poemLines = new ArrayList<>(p.getLines());
        numLines = p.getNumLines();
    }
    
    /**
     * Default constructor for the Poem class.
     */
    public Poem() {
        poemLines = new ArrayList<>();
        numLines = 0;
    }
    
    public ArrayList<Line> getLines() {
        return poemLines;
    }
    
    /**
     * Adds a line to the end of the ArrayList "poemLines".
     * @param line 
     */
    public void addLineToPoem(Line line) {
        poemLines.add(line);
        numLines++;
    }
    
    public void addLinesToPoem(ArrayList<Line> lines) {
        for (Line l : lines) {
            poemLines.add(l);
            numLines++;
        }
    }
    
    /**
     * Removes a line from the ArrayList "poemLines" at the specified index.
     * @param index 
     * @throws java.lang.Exception 
     */
    public void removeLineFromPoem(int index) throws Exception{
        poemLines.remove(index);
        numLines--;
    }
    
    public Line getLineAtIndex(int index) {
        return poemLines.get(index);
    }
    
    public int getNumLines() {
        return numLines;
    }
    
    public void printPoem() {
        for (Line l : poemLines) {
            l.printLine();
        }
    }
}
