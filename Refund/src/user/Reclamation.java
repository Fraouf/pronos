/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import utils.Montant;

/**
 *
 * @author k1fryouf
 */
public class Reclamation {
    
    private int soin;
    private String date;
    private String montant;
    
    public Reclamation(int soin, String date, String montant){
        
        this.soin = soin;
        this.date = date;
        this.montant = montant;
        
    }
    
    public Reclamation(){
        
        soin = -1;
        date = "";
        montant = "";
    }

    /**
     * @return the soin
     */
    public int getSoin() {
        return soin;
    }

    /**
     * @param soin the soin to set
     */
    public void setSoin(int soin) {
        this.soin = soin;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the montant
     */
    public double getMontant() {
        
        return Montant.lireMontant(montant);
    }

    /**
     * @param montant the montant to set
     */
    public void setMontant(double montant) {
        this.montant = Montant.ecrireMontant(montant);
    }
    
    
    
    
}
