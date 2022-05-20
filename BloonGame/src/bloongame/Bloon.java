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
    private int positionX;
    private int positionY;
    private int größe;
    private int richtung = rnd.nextInt(2)+1;
    private int xRichtung;
    private int yRichtung;
    
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
        
        this.positionX = positionX;
        this.positionY = positionY;
        this.größe = größe;
        
        int random = rnd.nextInt(2)+1;
        if (random == 1) {
            xRichtung = 1;
        } else {
            xRichtung = -1;
        }
        yRichtung = 1;
        
        this.setLocation(positionX, positionY);
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
        
        Timer t = new Timer(10, (ActionEvent ae) -> {
            
            int borderO = 0;
            int borderU = 650;
            int borderL = 0;
            int borderR = 650;
            
            if (this.getX() <= borderL || this.getX() + this.getWidth() >= borderR) {
                xRichtung *= (-1); 
            } else if (this.getY() - this.getHeight() >= borderU) {
                yRichtung *= (-1);
            }
            this.setLocation(this.getX()+xRichtung, this.getY()+yRichtung);
        });
        t.start();
    }    
}
