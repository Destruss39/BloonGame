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
        
        this.setLayout(null);
        this.setLocation(50, 50);
        this.setSize(650, 700);
        this.setBackground(Color.WHITE);

        
    }
    
    public boolean Start() {
        boolean istZuende = true;
        
        Bloon bloons[] = new Bloon[5];
        
        for (int i = 0; i < bloons.length; i++) {
            bloons[i] = new Bloon(i+1, Color.orange);
            this.add(bloons[i]);
        }
        
        return istZuende;
    }
    
}
