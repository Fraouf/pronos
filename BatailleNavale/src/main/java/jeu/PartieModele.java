/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu;

import java.awt.Point;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import javax.swing.JPanel;

/**
 *
 * @author k1fryouf
 */
public class PartieModele {
    
    final IJoueur joueur1;
    final IJoueur joueur2;
    
    private final ILogicIA ia;
    
    PartieModele(){

        ia=new AlgoAleatoire();
        joueur1 = JoueurFactory.addJoueurHumain("Joueur1",new Grille(10,10));
        joueur2 = JoueurFactory.addJoueurIntelligent("Ordinateur",new Grille(10,10),ia);
        
    }
    
    public Reponse verifierCoup(int i,Case c){
        if(i==0)
        {
            return joueur1.verifierCoup(joueur2.jouerCoup(c));
        }
        else
        {
            return joueur2.verifierCoup(joueur1.jouerCoup(c));
        }
        
    }
    
    public void positionnerBateaux(int[] x,int[] y, boolean[] p){
        joueur1.positionnerBateaux(x, y, p);
        joueur2.positionnerBateaux(x, y, p);
        for(int i = 0; i < joueur2.getGrille().bateaux.length;i++){
            System.out.println(joueur2.getGrille().bateaux[i].getType().getNom());
            for(int j = 0; j< joueur2.getGrille().bateaux[i].getCases().length;j++){
                System.out.println(joueur2.getGrille().bateaux[i].getCases()[j]);
            }
        }
    }
    
    public boolean verifierBateaux(){
        return joueur1.verifierBateaux() && joueur2.verifierBateaux();
    }
    
    public boolean coupDejaJoue(int i,Case c){
        if(i==0)
        {
            return joueur1.coupDejaJoue(c);
        }
        else
        {
            return joueur2.coupDejaJoue(c);
        }
        
    }
    
    public Case dernierCoup(){
        return joueur2.getDernierCoup().getCase();
    }
    
    public void revoirPartie(PartieInterface partieInterface){
        
        for(Map.Entry<Reponse,JPanel> entry : partieInterface.getSequence().entrySet()){

            entry.getValue().removeAll();
            entry.getValue().repaint();
            entry.getValue().revalidate();
            
        }
        
        for(Point p : partieInterface.getPoints()){
            partieInterface.getGrille1().remove(partieInterface.getGrille1().getComponentAt(p.x+3,p.y+3));
        }
        
        int i = 0;
        for(Map.Entry<Reponse,JPanel> entry : partieInterface.getSequence().entrySet()){
            i=i+2;
            new Replay(partieInterface,entry.getKey(), entry.getValue(),i).starCountDownFromNow();
        }
    }
}
