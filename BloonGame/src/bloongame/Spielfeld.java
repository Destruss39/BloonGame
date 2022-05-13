/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloongame;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author Dustin.Rudloff
 */
public class Spielfeld extends JPanel {
    
    public Spielfeld() {
        
        this.setLocation(50, 50);
        this.setSize(650, 700);
        this.setBackground(Color.WHITE);
        this.setVisible(true);
        
    }
    
    public boolean Start() {
        return false; 
    }
    
}
