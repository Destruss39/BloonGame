/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloongame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.JLabel;

/**
 *
 * @author Dustin.Rudloff
 */
public class Bloon extends JLabel {
    
    Random rnd = new Random();
    
    public Bloon() {
        System.out.println("Bloon erschienen.");
        
        this.setText("");
        this.setOpaque(true);
        this.setVisible(true);
        this.setText("");
        
        int größe = rnd.nextInt(3)+1;
        if (größe == 3) {
            smallBloon();
        } else if (größe == 2) {
            mediumBloon();
        } else {
            bigBloon();
        }
        
        int positionX = rnd.nextInt(650)+1;
        int positionY = rnd.nextInt(700)+1;
        
        this.setLocation(positionX, positionY);
        
    }
    
    public void klick() {
        
    }   
    
    public void smallBloon() {
        this.setSize(10, 10);
        this.setBackground(Color.red);
    }
    
    public void mediumBloon() {
        this.setSize(15, 15);
        this.setBackground(Color.orange);
    }
    
    public void bigBloon() {
        this.setSize(20, 20);
        this.setBackground(Color.green);
    }
    
}
