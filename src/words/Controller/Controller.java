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
import words.Model.Model;
import words.Poem;
import words.View.View;
import words.View.UI;

/**
 *
 * @author iworourke
 */
public class Controller implements java.awt.event.ActionListener {
    
    private Dictionary cmuDict;
    private Model model;
    private View view;
    
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
    public void addModel(Model m) {
        System.out.println("Controller: adding model");
        model = m;
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
     * @param p poem object to initialize the Model with. 
     */
    public void initModel(Poem p) {
        model.setValue(p);
    }
}
