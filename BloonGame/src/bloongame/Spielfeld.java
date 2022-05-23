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
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Dustin.Rudloff
 */
public class Spielfeld extends JPanel implements MouseListener {
    
    private int punkte;
    private Bloon bloonList[] = new Bloon[1];
    private Timer timer;
    private int maxTime = 60;
    private int time = maxTime;
    
    public Spielfeld() {
        
        this.setLayout(null);
        this.setLocation(50, 50);
        this.setSize(650, 700);
        this.setBackground(Color.WHITE);
        
    } 
    
    public void startBloons() {
        for (int i = 0; i < bloonList.length; i++) {
            bloonList[i] = new Bloon();  
            bloonList[i].addMouseListener(this);
            this.add(bloonList[i]);
            this.bewegeBloons(bloonList[i]);
        }
        this.repaint();
    }
    
    public void bewegeBloons(Bloon bloon) {
        bloon.bewegen();
    }

    public int getPunkte() {
        return punkte;
    }
    
    public void setPunkte(int punkte) {
        this.punkte = punkte;
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
        
        Bloon source = (Bloon)me.getSource();
        source.delete(1736538);
        source.removeMouseListener(this);
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
    
    public void startTimer() {
        timer = new Timer(1000, (ActionEvent ae) -> {
            time -= 1;
        });
        timer.start();
    }
    
    public void stopTimer() {
        time = maxTime;
        punkte = 0;
        if (this.timer instanceof Timer) {
            timer.stop();
        }
    }
    
    public int getTime() {
        return time;
    }
    
    public int getMaxTime() {
        return maxTime;
    }
    
    public void setTime(int time) {
        this.time = time;
    }
    
}
