/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package words;

import java.util.ArrayList;

/**
 * The poem class is used to represent a lyrical poem.
 * @author iworourke
 */
public class Poem extends java.util.Observable {
    
    private ArrayList<Line> poemLines;
    
    /**
     * Constructor for making copies of Poem objects.
     * @param p the poem to make a copy of.
     */
    public Poem(Poem p) {
        poemLines = new ArrayList<>(p.getLines());
    }
    
    /**
     * Default constructor for the Poem class.
     */
    public Poem() {
        System.out.println("Model()");
        poemLines = new ArrayList<>();
    }
    
    /**
     * Getter for the poemLines.
     * @return the poemLines instance variable.
     */
    public ArrayList<Line> getLines() {
        return poemLines;
    }
    
    /**
     * Adds a line to the end of the ArrayList "poemLines".
     * @param line the line to be added to the Poem.
     */
    public void addLineToPoem(Line line) {
        poemLines.add(line);
        setChanged();
        notifyObservers(poemLines);
    }
    
    /**
     * Adds a sequence of lines to the end of the poem.
     * @param lines the lines to be added to the Poem.
     */
    public void addLinesToPoem(ArrayList<Line> lines) {
        for (Line l : lines) {
            poemLines.add(l);
        }
    }
    
    /**
     * Removes a line from the ArrayList "poemLines" at the specified index.
     * @param index the index of the Line to be removed.
     * @throws java.lang.Exception if the index does not fall within the bounds
     * of the ArrayList.
     */
    public void removeLineFromPoem(int index) throws Exception {
        poemLines.remove(index);
        notifyObservers(poemLines);
    }
    
    /**
     * Retrieves the Line at the specified index.
     * @param index the index of the desired Line.
     * @return the desired Line object.
     * @throws Exception if the index does not fall within the bounds of the
     * ArrayList.
     */
    public Line getLineAtIndex(int index) throws Exception {
        return poemLines.get(index);
    }
    
    /**
     * Retrieves the number of lines in the Poem.
     * @return the number of lines in the Poem.
     */
    public int getNumLines() {
        return poemLines.size();
    }
    
    /**
     * Prints the text of the poem.
     */
    public void printPoem() {
        for (Line l : poemLines) {
            l.printLine();
        }
    }
    
    /**
     * 
     * @param newValue 
     */
    public void setValue(ArrayList<Line> newValue) {
        this.poemLines = newValue;
        System.out.println("Model init: gravity lines");
        setChanged();
        notifyObservers(poemLines);
    }
    
    public void getConventionalText() {
        String text = "";
        for (Line l : poemLines) {
            text.concat(l.getConventionalText() + "\n");
        }
    }
    
    public void rotateLines() {
        Line l = new Line(poemLines.get(0));
        poemLines.remove(0);
        poemLines.add(l);
    }
}
