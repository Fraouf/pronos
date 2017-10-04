/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pronostics;

import java.util.Date;

/**
 *
 * @author k1fryouf
 */
class Joueur extends Personne{

    private int numero;

    public Joueur() {

    }

    public Joueur(int numero, String nom, String Prenom, Date dateDeNaissance) {
        super(nom, Prenom, dateDeNaissance);
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    
}
