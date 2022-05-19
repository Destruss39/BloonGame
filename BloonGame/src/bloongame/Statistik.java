/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloongame;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Dustin.Rudloff
 */
public class Statistik extends JPanel {
    
    private JLabel punkte = new JLabel();
    
    public Statistik() {
        
        this.setLayout(null);
        this.setLocation(750, 50);
        this.setSize(200, 600);
        this.setBackground(Color.WHITE);

        punkte.setSize(100, 100);
        punkte.setLocation(25, 10);
        punkte.setVisible(true);
        punkte.setText("Punkte: 0");
        punkte.setFont(new Font("Arial", Font.BOLD, 18));
        
        this.add(punkte);
    }
    
    public void refresh(int punkte) {
        this.punkte.setText("Punkte: " + punkte);
    }
    
}
