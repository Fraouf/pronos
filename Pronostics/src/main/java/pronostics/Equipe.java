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
public class Equipe{
    private String nom;
    private String entraineur;
    private String president;
    private String pays;
    private String championat;
    private String stade;
    private String icon;
    private double homeWeight;
    private double awayWeight;

    
    public Equipe() {
    }

    public Equipe(String nom, String entraineur, String president, String pays, String championat, String stade, String icon) {
        this.nom = nom;
        this.entraineur = entraineur;
        this.president = president;
        this.pays = pays;
        this.championat = championat;
        this.stade = stade;
        this.icon = icon;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPresident() {
        return president;
    }

    public void setPresident(String president) {
        this.president = president;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getChampionat() {
        return championat;
    }

    public void setChampionat(String championat) {
        this.championat = championat;
    }

    public String getStade() {
        return stade;
    }

    public void setStade(String stade) {
        this.stade = stade;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
    
    

    public String getEntraineur() {
        return entraineur;
    }

    public void setEntraineur(String Entraineur) {
        this.entraineur = Entraineur;
    }

    public double getHomeWeight() {
        return homeWeight;
    }

    public void setHomeWeight(double homeWeight) {
        this.homeWeight = homeWeight;
    }

    public double getAwayWeight() {
        return awayWeight;
    }

    public void setAwayWeight(double awayWeight) {
        this.awayWeight = awayWeight;
    }
}
