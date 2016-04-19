/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu;

import ia.JoueurIntelligent;

/**
 *
 * @author k1fryouf
 */
public class PartieModele {
    
    private final Joueur[] joueurs = new Joueur[2];
    
    PartieModele(){

        joueurs[0] = new Joueur("Joueur1",new Grille(10,10));
        joueurs[1] = new JoueurIntelligent("Ordinateur",new Grille(10,10));
    }
    
    public Reponse verifierCoup(int i,Case c){
        
        if(joueurs[i] instanceof JoueurIntelligent){
            return joueurs[i].verifierCoup(c);
        }
        return joueurs[i].verifierCoup(joueurs[1].jouerCoup());
    }
    
    public void positionnerBateaux(int[] x,int[] y, boolean[] p){
        for(Joueur joueur : joueurs){
            joueur.positionnerBateaux(x, y, p);
        }
    }
    
    public boolean verifierBateaux(){
        return joueurs[0].verifierBateaux() && joueurs[1].verifierBateaux();
    }
    
    public boolean coupDejaJoue(int i,Case c){
        return joueurs[i].coupDejaJoue(c);
    }
    
    public Case dernierCoup(){
        return joueurs[1].getDernierCoup().getCase();
    }
}
