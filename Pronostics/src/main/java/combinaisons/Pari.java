/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combinaisons;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author k1fryouf
 */
public class Pari{
    
    private ArrayList<String> equipes;
    private double chances;
    private final NumberFormat formatter;

    public Pari(Pari p) {
        equipes = new ArrayList<>(p.getEquipes());
        chances = p.getChances();
        formatter = new DecimalFormat("#0.00");
    }
    
    public Pari() {
        equipes = new ArrayList<>();
        chances = 1.0;
        formatter = new DecimalFormat("#0.00");
    }

    public Pari(ArrayList<String> equipes, double chances) {
        this.equipes = equipes;
        this.chances = chances;
        formatter = new DecimalFormat("#0.00");
    }

    public ArrayList<String> getEquipes() {
        return equipes;
    }

    public void setEquipes(ArrayList<String> equipes) {
        this.equipes = equipes;
    }

    public double getChances() {
        return chances;
    }

    public void setChances(double chances) {
        this.chances = chances;
    }

    @Override
    public String toString() {
        String s = "Pari{" + "equipes="+ Arrays.toString(equipes.toArray()) +", chances=" + formatter.format(chances*100) +"%"+'}';
        
        return s;
    }
    
}
