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
public class Combinaison {
    
    private Match m;
    private double p1;
    private double p2;
    private double p3;

    public Combinaison() {
    }

    public Combinaison(Match m, double p1, double p2, double p3) {
        this.m = m;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public Match getM() {
        return m;
    }

    public void setM(Match m) {
        this.m = m;
    }

    public double getP1() {
        return p1;
    }

    public void setP1(double p1) {
        this.p1 = p1;
    }

    public double getP2() {
        return p2;
    }

    public void setP2(double p2) {
        this.p2 = p2;
    }

    public double getP3() {
        return p3;
    }

    public void setP3(double p3) {
        this.p3 = p3;
    }
    
    public double total(){
        return p1+p2+p3;
    }
    
}
