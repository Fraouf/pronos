/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu;

/**
 *
 * @author k1fryouf
 */
public class PartieControleur {
    
    PartieModele partieModele;
    
    PartieControleur(){
        partieModele = new PartieModele();
    }
    
    public Reponse verifierCoup(int i, Case c){
        return partieModele.verifierCoup(i, c); 
    }

    
    public boolean verifierBateaux(){
        return partieModele.verifierBateaux();
    }
    
    public void positionnerBateaux(int[] x, int[] y, boolean[] p){
        partieModele.positionnerBateaux(x, y, p);
    }
    
    public boolean coupDejaJoue(int i,Case c){
        return partieModele.coupDejaJoue(i,c);
    }
    
    public Case dernierCoup(){
        return partieModele.dernierCoup();
    }
    
    public void sauvegarderPartie(){
        
    }
}
