/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pronostics;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author k1fryouf
 */
public class WeightedTeams {
    
    ArrayList<Equipe> listEquipes;
    ArrayList<Match> listMatchs;
    private final NumberFormat formatter;
    double drawGap;

    public WeightedTeams() {
        this.formatter = new DecimalFormat("#0.00");
        this.drawGap = 0.1;
    }
    
    public WeightedTeams(ArrayList<Equipe> listEquipes) {
        this.listEquipes = listEquipes;
        this.formatter = new DecimalFormat("#0.00");
        this.drawGap = 0.1;
    }

    public ArrayList<Equipe> getListEquipes() {
        return listEquipes;
    }

    public void setListEquipes(ArrayList<Equipe> listEquipes) {
        this.listEquipes = listEquipes;
    }

    public ArrayList<Match> getListMatchs() {
        return listMatchs;
    }

    public void setListMatchs(ArrayList<Match> listMatchs) {
        this.listMatchs = listMatchs;
    }
    
    public void ponder(){
        for(Match m : listMatchs){
            int id = getTeamPos(m.getEquipeDom());
            int ie = getTeamPos(m.getEquipeExt());
            
            if(m.getButDom() > m.getButExt()){
                
                double n = (((double)(m.getButDom() - m.getButExt()))/12.0) * Math.abs(listEquipes.get(ie).getAwayWeight());
                listEquipes.get(id).setHomeWeight(listEquipes.get(id).getHomeWeight()+n+3);
                
                n = (((double)(m.getButExt() - m.getButDom()))/15.0) * Math.abs(listEquipes.get(id).getHomeWeight());
                listEquipes.get(ie).setAwayWeight(listEquipes.get(ie).getAwayWeight()+n);
                  
            }else if(m.getButDom() < m.getButExt() ){
                
                double n = (((double)(m.getButDom() - m.getButExt()))/5.0) * Math.abs(listEquipes.get(ie).getAwayWeight());
                listEquipes.get(id).setHomeWeight(listEquipes.get(id).getHomeWeight()+n);
                
                n = (((double)(m.getButExt() - m.getButDom()))/8.0) * Math.abs(listEquipes.get(id).getHomeWeight());
                listEquipes.get(ie).setAwayWeight(listEquipes.get(ie).getAwayWeight()+n+3);
                
            }else{
                
                drawGap = (drawGap + ((listEquipes.get(id).getHomeWeight() - listEquipes.get(ie).getAwayWeight())/2))/2;
                
                System.out.println(drawGap);
                
                double n = ((double)(m.getButDom())/8.0) * Math.abs(listEquipes.get(ie).getAwayWeight());
                listEquipes.get(id).setHomeWeight(listEquipes.get(id).getHomeWeight()-n+1);
                
                n = ((double)(m.getButExt())/5.0) * Math.abs(listEquipes.get(id).getHomeWeight());
                listEquipes.get(ie).setAwayWeight(listEquipes.get(ie).getAwayWeight()+n+1);
                
                
            }
        }
    }
    
    public int getTeamPos(String s){
        for(int i=0;i<listEquipes.size();i++){
            if(listEquipes.get(i).getNom().equals(s)){
                return i;
            }
        }
        return -1;
    }

    public void print(){
        
        for(Equipe e: listEquipes){
            System.out.println(e.getNom() + " " + formatter.format(e.getHomeWeight()) + ", " + formatter.format(e.getAwayWeight()) );
        }
    }
    
    public void sort(){
        Collections.sort(listEquipes, new Comparator<Equipe>() {
        @Override 
        public int compare(Equipe e1, Equipe e2) {
            if(((e1.getHomeWeight()+e1.getAwayWeight())/2) < ((e2.getHomeWeight()+e2.getAwayWeight())/2)){
                return 1;
            }else if (((e1.getHomeWeight()+e1.getAwayWeight())/2) > ((e2.getHomeWeight()+e2.getAwayWeight())/2)){
                return -1;
            }else{
                return 0;
            }
        }
        });
    }
    
    public double[] pronostiquer(String equipeDom, String equipeExt){
        
        double[] stats = new double[3];
        
        Equipe ed = listEquipes.get(getTeamPos(equipeDom));
        Equipe ee = listEquipes.get(getTeamPos(equipeExt));
           
        double hw = ed.getHomeWeight() - (drawGap/2);
        double aw = ee.getAwayWeight() - (drawGap/2);
        
        if(hw < 0){
            hw += Math.abs(hw);
            aw += Math.abs(hw);
        }else if(aw < 0){
            aw += Math.abs(aw);
            hw += Math.abs(aw);
        }
        
        double total = aw+hw+drawGap;
        
        stats[0] = hw/total;
        stats[1] = (total - (hw + aw))/total;
        stats[2] = aw/total;
        
        return stats;
    }
    
    
}
