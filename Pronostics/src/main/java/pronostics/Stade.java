/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pronostics;

/**
 *
 * @author k1fryouf
 */
public class Stade {
    
    private String Ville;
    private String Pays;
    private Equipe equipe;

    public Stade() {
    }

    public Stade(String Ville, String Pays, Equipe equipe) {
        this.Ville = Ville;
        this.Pays = Pays;
        this.equipe = equipe;
    }

    public String getVille() {
        return Ville;
    }

    public void setVille(String Ville) {
        this.Ville = Ville;
    }

    public String getPays() {
        return Pays;
    }

    public void setPays(String Pays) {
        this.Pays = Pays;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }
  
}
