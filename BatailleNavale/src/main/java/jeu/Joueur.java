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
public class Joueur {
    
    protected String nom;
    protected Grille grille;
    protected Coup dernierCoup;
    
    public Joueur(){
    }
    
    public Joueur(String nom, Grille grille){
        this.nom = nom;
        this.grille = grille;
        dernierCoup = new Coup();
    }
    
    public Reponse verifierCoup(Case c){
        dernierCoup.setCase(c);
        return grille.verifierCoup(c);
    }
    
    public void positionnerBateaux(int[] x,int[] y, boolean[] p){
        grille.positionnerBateaux(x, y, p);
    }
    
    public boolean verifierBateaux(){
        return grille.verifierGrille();
    }
    
    public boolean coupDejaJoue(Case c){
        return grille.coupDejaJoue(c);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Grille getGrille() {
        return grille;
    }

    public void setGrille(Grille grille) {
        this.grille = grille;
    }

    public Coup getDernierCoup() {
        return dernierCoup;
    }

    public void setDernierCoup(Coup dernierCoup) {
        this.dernierCoup = dernierCoup;
    }
    
    public Case jouerCoup(){
      return null;  
    } 
}
