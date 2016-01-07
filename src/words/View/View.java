/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package words.View;

import javax.swing.*;
import java.awt.event.*;
import java.util.Observable;


/**
 *
 * @author iworourke
 */
public class View implements java.util.Observer {

    private JTextField myTextField;
    private JButton button;
    private final WordsUI ui;

    /**
     * 
     */
    public View() {
        System.out.println("View()");
        ui = new WordsUI();
        ui.addWindowListener(new CloseListener());
        ui.setLocation(100,100);
        ui.setVisible(true);
    }
    
    
    /**
     * Once I get the MVC components talking to each other properly, I will
     * worry about making the view completely represent the Model.
     * @param o
     * @param arg 
     */
    @Override
    public void update(Observable o, Object arg) {        
        ui.update(o, arg);
    }
    
    /**
     * Not sure this is what I want to do.
     * @param s 
     */
    public void setValue(String s) {
        ui.setValue(s);
    }
    
    public void addController(ActionListener controller) {
        System.out.println("View: adding controller");
        ui.addControllerToButton(controller);
    }
    
    /**
     * Found this at link: <http://www.austintek.com/mvc/>
     */
    public static class CloseListener extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            e.getWindow().setVisible(false);
            System.exit(0);
        }
    }
    
}
