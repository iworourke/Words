/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package words.Controller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import words.Dictionary;
import words.Line;
import words.Poem;
import words.View.View;

/**
 *
 * @author iworourke
 */
public class Controller implements java.awt.event.ActionListener {
    
    private Dictionary cmuDict;
    private Poem model;
    private View view;
    
    public Controller(Poem model, View view) {
        this.model = model;
        this.view = view;
    }
    
    /**
     * <http://www.austintek.com/mvc/>
     */
    public Controller() {
        System.out.println("Controller");
    }
    
    /**
     * <http://www.austintek.com/mvc/>
     * Invoked when a button is pressed.
     */
    public void actionPerformed(ActionEvent e) {
        System.out.println("Controller: acting on Model");
        model.rotateLines();
    }
    
    /**
     * <http://www.austintek.com/mvc/>
     * 
     */
    public void addModel(Poem m) {
        System.out.println("Controller: adding model");
        this.model = m;
    }
    
    /**
     * <http://www.austintek.com/mvc/>
     * @param v 
     */
    public void addView(View v) {
        System.out.println("Controller: adding view");
        view = v;
    }
    
    /**
     * <http://www.austintek.com/mvc/>
     * @param x 
     */
    public void initModel(ArrayList<Line> x) {
        model.setValue(x);
    }
}
