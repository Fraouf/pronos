/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combinaisons;

/**
 *
 * @author k1fryouf
 */
public class Match {
    
    private String equipeDom;
    private String equipeExt;
    private double coteDom;
    private double coteExt;
    private double coteNull;

    
    public Match() {
    }
    
    public Match(String equipeDom, String equipeExt, double coteDom, double coteExt, double coteNull) {
        this.equipeDom = equipeDom;
        this.equipeExt = equipeExt;
        this.coteDom = coteDom;
        this.coteExt = coteExt;
        this.coteNull = coteNull;
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

    public double getCoteDom() {
        return coteDom;
    }

    public void setCoteDom(double coteDom) {
        this.coteDom = coteDom;
    }

    public double getCoteExt() {
        return coteExt;
    }

    public void setCoteExt(double coteExt) {
        this.coteExt = coteExt;
    }

    public double getCoteNull() {
        return coteNull;
    }

    public void setCoteNull(double coteNull) {
        this.coteNull = coteNull;
    }
  
}
