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
public class Personne {
    String nom;
    String Prenom;
    Date dateDeNaissance;

    public Personne() {
    }

    public Personne(String nom, String Prenom, Date dateDeNaissance) {
        this.nom = nom;
        this.Prenom = Prenom;
        this.dateDeNaissance = dateDeNaissance;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(Date dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }
    
    
}
