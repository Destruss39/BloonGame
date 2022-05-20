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
    private JLabel leben = new JLabel();
    
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
        
        leben.setSize(100, 100);
        leben.setLocation(25, 40);
        leben.setVisible(true);
        leben.setText("Leben: 3");
        leben.setFont(new Font("Arial", Font.BOLD, 18));
        
        this.add(punkte);
        this.add(leben);
    }
    
    public void refresh(int punkte, int leben) {
        this.punkte.setText("Punkte: " + punkte);
        this.leben.setText("Leben: " + leben);
    }
    
}
