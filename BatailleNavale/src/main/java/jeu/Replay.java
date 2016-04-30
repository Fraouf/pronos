/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu;

import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author k1fryouf
 */
public class Replay {
    
    private Timer timer;
    private double waitSeconds;
    private Reponse reponse;
    private JPanel panel;
    private PartieInterface partieInterface;

    public Replay() {
        
    }

    public Replay(PartieInterface partieInterface, Reponse reponse,JPanel panel, double waitSeconds) {
        this.waitSeconds = waitSeconds;
        this.reponse = reponse;
        this.panel = panel;
        this.partieInterface = partieInterface;
    }

    
    public void starCountDownFromNow(){
        
        timer = new Timer((int)waitSeconds*1000, (ActionEvent e) -> {
            
            partieInterface.afficherCoup(reponse, panel);
            
            timer.stop();
        });
        timer.start();
    }
}
