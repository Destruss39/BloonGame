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
    private JLabel timer = new JLabel();
    
    public Statistik() {
        
        this.setLayout(null);
        this.setLocation(750, 25);
        this.setSize(200, 300);
        this.setBackground(Color.gray);

        punkte.setSize(200, 100);
        punkte.setLocation(0, 0);
        punkte.setVisible(true);
        punkte.setText("Punkte: 0");
        punkte.setFont(new Font("Arial", Font.BOLD, 18));
        
        timer.setSize(200, 100);
        timer.setLocation(0, 25);
        timer.setVisible(true);
        timer.setText("Zeit: 0");
        timer.setFont(new Font("Arial", Font.BOLD, 18));
        
        
        this.add(punkte);
        this.add(timer);
    }
    
    public void refresh(int punkte, int time) {
        this.punkte.setText("Punkte: " + punkte);
        this.timer.setText("Zeit: " + time);
    }
    
}
