/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pronostics;

import java.sql.Date;

/**
 *
 * @author k1fryouf
 */
public class Match {
    
    private String equipeDom;
    private String equipeExt;
    private int butDom;
    private int butExt;
    private String stade;
    private Date date;
    private String competition;
    private double quoteDom;
    private double quoteEgalite;
    private double quoteExt;

    public Match() {
    }

    public Match(String equipeDom, String equipeExt, String stade, Date date, String competition, int butDom, int butExt) {
        this.equipeDom = equipeDom;
        this.equipeExt = equipeExt;
        this.stade = stade;
        this.date = date;
        this.competition = competition;
        this.butDom = butDom;
        this.butExt = butExt;
    }

    public String getEquipeDom() {
        return equipeDom;
    }

    public void setEquipeDom(String equipeDom) {
        this.equipeDom = equipeDom;
    }

    public String getEquipeExt() {
        return equipeExt;
    }

    public void setEquipeExt(String equipeExt) {
        this.equipeExt = equipeExt;
    }

    public String getStade() {
        return stade;
    }

    public void setStade(String stade) {
        this.stade = stade;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCompetition() {
        return competition;
    }

    public void setCompetition(String competition) {
        this.competition = competition;
    }

    public double getQuoteDom() {
        return quoteDom;
    }

    public void setQuoteDom(double quoteDom) {
        this.quoteDom = quoteDom;
    }

    public double getQuoteEgalite() {
        return quoteEgalite;
    }

    public void setQuoteEgalite(double quoteEgalite) {
        this.quoteEgalite = quoteEgalite;
    }

    public double getQuoteExt() {
        return quoteExt;
    }

    public void setQuoteExt(double quoteExt) {
        this.quoteExt = quoteExt;
    }

    public int getButDom() {
        return butDom;
    }

    public void setButDom(int butDom) {
        this.butDom = butDom;
    }

    public int getButExt() {
        return butExt;
    }

    public void setButExt(int butExt) {
        this.butExt = butExt;
    }
    
    public String getId(){
        return "("+equipeDom.substring(0, 3)+equipeExt.substring(0, 3)+date+")";
    }

    public String toString(){
        return equipeDom + " " + butDom + " - " +  butExt + " " + equipeExt + " (" + date + ")";
    }
    
    public String toString2(){
        return equipeDom + " - " + equipeExt;
    }
    
}
