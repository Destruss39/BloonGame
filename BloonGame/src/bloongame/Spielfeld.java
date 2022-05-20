/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloongame;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 *
 * @author Dustin.Rudloff
 */
public class Spielfeld extends JPanel implements MouseListener {
    
    private int punkte;
    private int leben = 3;
    
    public Spielfeld() {
        
        this.setLayout(null);
        this.setLocation(50, 50);
        this.setSize(650, 700);
        this.setBackground(Color.WHITE);
        
    } 
    
    public void startBloons() {
        
        Bloon bloons[] = new Bloon[1];
        
        for (int i = 0; i < bloons.length; i++) {
            bloons[i] = new Bloon();
            bloons[i].addMouseListener(this);
            this.add(bloons[i]);
            this.bewegeBloons(bloons[i]);
        }
        this.repaint();
        
    }
    
    public void bewegeBloons(Bloon bloon) {
        bloon.bewegen();
    }

    public int getPunkte() {
        return punkte;
    }
    
    public int getLeben() {
        return leben;
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
        Bloon source = (Bloon)me.getSource();
        this.remove(source);
        if (source.getBackground() == Color.green) {
            this.punkte += 1;
        } else if (source.getBackground() == Color.orange) {
            this.punkte += 2;
        } else {
            this.punkte += 3;
        }
        this.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent me) {
       
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }
    
    
}
