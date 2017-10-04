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
public class Arbitre extends Personne {
    
    private Pays origine;

    public Arbitre() {
    }

    
    public Arbitre(Pays origine) {
        this.origine = origine;
    }

    public Arbitre(Pays origine, String nom, String Prenom, Date dateDeNaissance) {
        super(nom, Prenom, dateDeNaissance);
        this.origine = origine;
    }

    public Pays getOrigine() {
        return origine;
    }

    public void setOrigine(Pays origine) {
        this.origine = origine;
    }
    
    
}
