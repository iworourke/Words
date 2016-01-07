/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package words.Model;

import java.util.Observable;
import words.Line;
import words.Poem;

/**
 *
 * @author iworourke
 */
public class Model extends Observable {
    
    private Poem poem;
    
    public Model() {
        System.out.println("Model()");
    }
    
    public void setValue(Poem p) {
        poem = new Poem(p);
        setChanged();
        notifyObservers(poem);
    }
    
    public void rotateLines() {
        
        try {
            Line l = new Line(poem.getLineAtIndex(0));
            poem.removeLineFromPoem(0);
            poem.addLineToPoem(l);
            setChanged();
            notifyObservers(poem);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
