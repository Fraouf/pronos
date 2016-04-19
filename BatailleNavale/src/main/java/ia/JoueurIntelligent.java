/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia;

import java.util.LinkedList;
import java.util.Random;
import jeu.Case;
import jeu.Grille;
import jeu.Joueur;
import jeu.Reponse;

/**
 *
 * @author k1fryouf
 */
public class JoueurIntelligent extends Joueur{

    private Random r;
    private LinkedList<String> coups;
    private Case c;
    private boolean touche;
    private boolean coule;
    private boolean strategie;
    
    
    public JoueurIntelligent() {
        super(); 
        r = new Random();
        coups = new LinkedList<>(); 
        touche = false;
        coule = false;
        strategie = false;
    }
    
    public JoueurIntelligent(String nom, Grille grille) {
        super(nom, grille);
        r = new Random();
        coups = new LinkedList<>();
        touche = false;
        coule = false;
        strategie = false;
    }

    @Override
    public Case jouerCoup(){
        if(strategie){
            return coupStrategique();
        }else{
            return coupAleatoire();
        }
    }

    @Override
    public void positionnerBateaux(int[] x, int[] y, boolean[] p){
        grille.positionnerBateauxAleatoire();
    }
    
    private Case coupAleatoire(){
        int x,y;
            do{
                x = r.nextInt(10);
                y = r.nextInt(10);
                dernierCoup.setCase(new Case(x,y));
            }while(coups.contains(dernierCoup.getCase().toString()));
            coups.add(dernierCoup.getCase().toString());
            return dernierCoup.getCase();
    }
    
    private Case coupStrategique(){
        if(touche){
            do{
                dernierCoup.setCase(dernierCoup.coupProche());
            }while(coups.contains(dernierCoup.getCase().toString()));
            coups.add(dernierCoup.getCase().toString());
        }
        return dernierCoup.getCase();
    }      
}

