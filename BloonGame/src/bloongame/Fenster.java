/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloongame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.Timer;

/**
 *
 * @author Dustin.Rudloff
 */
public class Fenster extends JFrame {
    
    private Spielfeld spielfeld = new Spielfeld();
    private Statistik stats = new Statistik();
    private JButton btnStart = new JButton();
    private JTextArea lastStats = new JTextArea();
    private Timer t;
    
    public Fenster() {
        
        this.setLayout(null);
        this.getContentPane().setPreferredSize(new Dimension(1000, 800));
        this.getContentPane().setBackground(Color.gray);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Bloon Game");
        
        this.add(spielfeld);
        this.add(stats);
        
        btnStart.setText("Start");
        btnStart.setLocation(750, 700);
        btnStart.setBackground(Color.green);
        btnStart.setSize(200, 50);
        btnStart.addActionListener((ActionEvent ae) -> {
            btnStart.setText("Spiel läuft...");
            btnStart.setBackground(Color.orange);
            this.StarteSpiel();
            btnStart.setEnabled(false);
        });
        
        lastStats.setText("");
        lastStats.setLocation(750, 150);
        lastStats.setBackground(Color.gray);
        lastStats.setSize(200, 70);
        lastStats.setEditable(false);
        lastStats.setFont(new Font("Arial", Font.BOLD, 18));
        
        this.add(lastStats);
        this.add(btnStart);
        this.pack();
        this.setVisible(true);
        this.repaint();
    }
    
    public void StarteSpiel() {
        t = new Timer(1000, (ActionEvent ae) -> {
            this.GameLoop();
        });
        t.start();
        spielfeld.stopTimer();
        spielfeld.startTimer();
        System.out.println("Spiel gestartet");
    }
    
    public void GameLoop() {   
        if (spielfeld.getTime() <= 0) {
            t.stop();
            lastStats.setText("Letztes Ergebnis" + "\n" + "Punkte: " + spielfeld.getPunkte() + "\n" + "Zeit: " + spielfeld.getMaxTime());
            btnStart.setEnabled(true);
            spielfeld.setTime(0);
            spielfeld.setPunkte(0);
            btnStart.setText("Neustart");
            btnStart.setBackground(Color.red);
        }
        spielfeld.startBloons();
        stats.refresh(spielfeld.getPunkte(), spielfeld.getTime());
    }
    
}
