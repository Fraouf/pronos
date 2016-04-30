/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu;

import java.util.*;

/**
 *
 * @author k1fryouf
 */
public class JoueurHumain implements IJoueur{
    
    private String nom;
    private Grille grille;
    private Coup dernierCoup;
    
    protected LinkedList<String> coups=new LinkedList();
    
    public JoueurHumain(){
    }
    
    public JoueurHumain(String nom, Grille grille){
        this.nom = nom;
        this.grille = grille;
        dernierCoup = new Coup();
    }
    
    @Override
    public Reponse verifierCoup(Case c){
        coups.add(c.toString());
        dernierCoup.setCase(c);
        return grille.verifierCoup(c);
    }
    
    @Override
    public void positionnerBateaux(int[] x,int[] y, boolean[] p){
        grille.positionnerBateaux(x, y, p);
    }
    
    @Override
    public boolean verifierBateaux(){
        return grille.verifierGrille();
    }
    
    @Override
    public boolean coupDejaJoue(Case c){
        return grille.coupDejaJoue(c);
    }
    
    @Override
    public Case jouerCoup(Case c){
      return c;  
    } 

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public Grille getGrille() {
        return grille;
    }

    @Override
    public void setGrille(Grille grille) {
        this.grille = grille;
    }

    @Override
    public Coup getDernierCoup() {
        return dernierCoup;
    }

    @Override
    public void setDernierCoup(Coup dernierCoup) {
        this.dernierCoup = dernierCoup;
    }

    @Override
    public LinkedList<String> getCoups() {
        return coups;
    }

    @Override
    public void setCoups(LinkedList<String> coups) {
        this.coups = coups;
    }

    @Override
    public void setIa(ILogicIA logic) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ILogicIA getIa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
