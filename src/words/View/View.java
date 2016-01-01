/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package words.View;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Observable;
import words.Line;

import words.Poem;

/**
 *
 * @author iworourke
 */
public class View implements java.util.Observer {

    private TextField myTextField;
    private Button button;

    /**
     * 
     */
    public View() {
        System.out.println("View()");
        
        Frame frame = new Frame("simple MVC");
        frame.add("North", new Label("counter"));
        
        myTextField = new TextField();
        frame.add("Center", myTextField);
        
        Panel panel = new Panel();
        button = new Button("PressMe");
        panel.add(button);
        frame.add("South", panel);
        
        frame.addWindowListener(new CloseListener());
        frame.setSize(200,100);
        frame.setLocation(100, 100);
        frame.setVisible(true);
    }
    
    
    /**
     * Once I get the MVC components talking to each other properly, I will
     * worry about making the view completely represent the Model.
     * @param o
     * @param arg 
     */
    @Override
    public void update(Observable o, Object arg) {        
        ArrayList<Line> test = (ArrayList<Line>)arg;
        String conventionalText = test.get(0).getConventionalText();
        myTextField.setText(conventionalText);
    }
    
    /**
     * Not sure this is what I want to do.
     * @param s 
     */
    public void setValue(String s) {
        myTextField.setText(s);
    }
    
    public void addController(ActionListener controller) {
        System.out.println("View: adding controller");
        button.addActionListener(controller);
    }
    
    /**
     * Found this at link: <http://www.austintek.com/mvc/>
     */
    public static class CloseListener extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            e.getWindow().setVisible(false);
            System.exit(0);
        }
    }
    
}
