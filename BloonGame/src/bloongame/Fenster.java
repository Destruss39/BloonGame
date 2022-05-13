/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloongame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author Dustin.Rudloff
 */
public class Fenster extends JFrame {
    
    private Spielfeld spielfeld = new Spielfeld();
    private Statistik stats = new Statistik();
    private JButton btnStart = new JButton();
    private Timer t;
    
    public Fenster() {
        
        this.setLayout(null);
        this.getContentPane().setPreferredSize(new Dimension(1000, 800));
        this.getContentPane().setBackground(Color.gray);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Bloon Game");
        
        this.add(spielfeld);
        
        btnStart.setText("Start");
        btnStart.setLocation(750, 700);
        btnStart.setBackground(Color.green);
        btnStart.setSize(200, 50);
        btnStart.addActionListener((ActionEvent ae) -> {
            btnStart.setText("Spiel läuft...");
            btnStart.setBackground(Color.orange);
            this.StarteSpiel();
        });
        this.add(btnStart);
        this.pack();
        this.setVisible(true);
    }
    
    public void StarteSpiel() {
        t = new Timer(50, (ActionEvent ae) -> {
            this.GameLoop();
        });
        t.start();
    }
    
    public void GameLoop() {    
        if (spielfeld.Start()) {
            t.stop();
            btnStart.setText("Fertig");
            btnStart.setBackground(Color.green);
        }
        System.out.println("HUHU");
    }
    
}
