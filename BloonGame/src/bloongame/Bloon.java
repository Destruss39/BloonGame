/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloongame;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
    private Timer timer;
    private int praller = 0;
    
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
        
        int positionX = rnd.nextInt(500)+100;
        int positionY = rnd.nextInt(600)+100;
        
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
    } 
    
    public void smallBloon() {
        this.setSize(15, 15);
        this.setBackground(Color.red);
    }
    
    public void mediumBloon() {
        this.setSize(22, 22);
        this.setBackground(Color.orange);
    }
    
    public void bigBloon() {
        this.setSize(30, 30);
        this.setBackground(Color.green);
    }
    
    public void bewegen() {
        
        timer = new Timer(5, (ActionEvent ae) -> {
            
            int borderO = 0;
            int borderU = 700;
            int borderL = 0;
            int borderR = 650;
            
            if (this.getX() <= borderL || this.getX() + this.getWidth() >= borderR) {
                xRichtung *= (-1); 
                praller += 1;
            } else if (this.getY() <= borderO || this.getY() + this.getHeight() >= borderU) {
                yRichtung *= (-1);
                praller += 1;
            }
            this.setLocation(this.getX() + xRichtung, this.getY() + yRichtung);
            
            if (praller >= 2) {
                delete(1736538);
            }
            
        });
        timer.start();
    }    
    
    public boolean delete(int delay) {
        if (delay == 1736538) {
            timer.stop();
            this.setVisible(false);
            return true;
        } else {
            return false;
        }
    }
    
    public int getPraller() {
        return praller;
    }
}
