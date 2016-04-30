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
public class JoueurIntelligent implements IJoueur{

    private Random r;
    private LinkedList<String> coups;
    private boolean touche;
    private boolean coule;
    private String nom;
    private Grille grille;
    private Coup dernierCoup;
    private ILogicIA ia;
    
    public JoueurIntelligent() {
        coups = new LinkedList<>(); 
        touche = false;
        coule = false;
        dernierCoup = new Coup();
        this.ia=null;
    }
    
    public JoueurIntelligent(String nom, Grille grille,ILogicIA ia) {
        this.nom = nom;
        this.grille = grille;
        this.ia=ia;
        coups = new LinkedList<>();
        touche = false;
        coule = false;
        dernierCoup = new Coup();
    }

    @Override
    public Case jouerCoup(Case c){
        
        do{
            c = ia.jouerCoup(coups,dernierCoup);
        }while(coups.contains(c.toString()));
        
        dernierCoup.setCase(c);
        
        coups.add(c.toString());
        
        return dernierCoup.getCase();
    }

    @Override
    public void positionnerBateaux(int[] x, int[] y, boolean[] p){
        grille.positionnerBateauxAleatoire();
    }
    
    @Override
    public boolean coupDejaJoue(Case c)
    {
        return grille.coupDejaJoue(c);
    }
    
    @Override
    public boolean verifierBateaux(){
         return grille.verifierGrille();
    }
    
    @Override
    public Reponse verifierCoup(Case c){
        dernierCoup.setCase(c);
        return grille.verifierCoup(c);
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
    public ILogicIA getIa() {
        return ia;
    }

    @Override
    public void setIa(ILogicIA ia) {
        this.ia = ia;
    }
}

