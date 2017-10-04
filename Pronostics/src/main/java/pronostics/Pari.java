/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pronostics;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author k1fryouf
 */
public class Pari {
    
    private Match match;
    private String decision;
    private double pourcentage;
    private double montant;
    private final NumberFormat formatter;

    public Pari() {
        this.formatter = new DecimalFormat("#0.00");
    }

    public Pari(Match match, String decision, double pourcentage) {
        this.formatter = new DecimalFormat("#0.00");
        this.match = match;
        this.decision = decision;
        this.pourcentage = pourcentage;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public double getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(double pourcentage) {
        this.pourcentage = pourcentage;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    
    @Override
    public String toString() {
        return "Match : (" + match.toString2() + ")" + " Décision = " + decision + ", pourcentage = " + formatter.format(pourcentage*100) + ", montant = " + formatter.format(montant) + '$';
    }
}
