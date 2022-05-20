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
import javax.swing.Timer;

/**
 *
 * @author Dustin.Rudloff
 */
public class Bloon extends JLabel {
    
    Random rnd = new Random();
    private int xRichtung;
    private int yRichtung;
    private int zeit;
    private Timer timer1;
    private Timer timer2;
    
    public Bloon() {
        System.out.println("Bloon erschienen.");
        
        this.setText("");
        this.setOpaque(true);
        this.setVisible(true);
        this.setText("");
        
        int größe = rnd.nextInt(10)+1;
        if (größe == 1 || größe == 2 || größe == 3 || größe == 4 || größe == 5) {
            bigBloon();
        } else if (größe == 6 || größe == 7 || größe == 8) {
            mediumBloon();
        } else {
            smallBloon();
        }
        
        int positionX = rnd.nextInt(630)+10;
        int positionY = rnd.nextInt(680)+10;
        
        int randomX = rnd.nextInt(2)+1;
        if (randomX == 1) {
            xRichtung = 1;
        } else {
            xRichtung = -1;
        }
        
        int randomY = rnd.nextInt(2)+1;
        if (randomY == 1) {
            yRichtung = 1;
        } else {
            yRichtung = -1;
        }
        
        this.setLocation(positionX, positionY);
        
        timer1 = new Timer(1000, (ActionEvent ae) -> {
            zeit += 1;
            this.timeLeft();
        });
        timer1.start();
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
    
    public void bewegen() {
        
        timer2 = new Timer(10, (ActionEvent ae) -> {
            
            int borderO = 0;
            int borderU = 700;
            int borderL = 0;
            int borderR = 650;
            
            if (this.getX() <= borderL || this.getX() + this.getWidth() >= borderR) {
                xRichtung *= (-1); 
            } else if (this.getY() <= borderO || this.getY() + this.getHeight() >= borderU) {
                yRichtung *= (-1);
            }
            this.setLocation(this.getX() + xRichtung, this.getY() + yRichtung);
        });
        timer2.start();
    }    
    
    public boolean delete(int delay) {
        if (delay == 1736538) {
            timer1.stop();
            timer2.stop();
            return true;
        } else {
            return false;
        }
    }
    
    public boolean timeLeft() {
        if (zeit == 10) {
            this.delete(1736538);
            return true;
        }
        return false;
    }
    
}
