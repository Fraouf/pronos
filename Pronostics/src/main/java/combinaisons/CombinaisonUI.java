/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combinaisons;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import pronostics.Equipe;
import pronostics.NeuralNetwork;
import pronostics.WeightedTeams;

/**
 *
 * @author k1fryouf
 */
public class CombinaisonUI extends javax.swing.JFrame {

    private WeightedTeams wt;
    private ArrayList<Match> listeComplete;
    private ArrayList<Match> listeMatchs;
    private Pari pari;
    private ArrayList<Pari> listeParis;
    private boolean debut;
    private double totalChances;
    private final NumberFormat formatter;
    private ArrayList<String> listTeamsNames;
    private ArrayList<String> parisImprimes;
    
    /**
     * Creates new form combinaisonUI
     * @param nn
     */
    public CombinaisonUI(WeightedTeams wt) {
        
        listeComplete = new ArrayList<>();
        listeMatchs = new ArrayList<>();
        pari = new Pari();
        listeParis = new ArrayList<>();
        this.wt = wt;
        debut = true;
        totalChances = 0;
        parisImprimes = new ArrayList<>();
        formatter = new DecimalFormat("#0.00");
        listTeamsNames = new ArrayList<>();
        for(Equipe e : wt.getListEquipes()){
            listTeamsNames.add(e.getNom());
        }
        
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextCoteDom = new javax.swing.JTextField();
        jTextCoteNull = new javax.swing.JTextField();
        jTextCoteExt = new javax.swing.JTextField();
        jButtonEnregistrer = new javax.swing.JButton();
        jTextNbComb = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextMontant = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButtonCombiner = new javax.swing.JButton();
        jComboBoxEquipeDom = new javax.swing.JComboBox();
        jComboBoxEquipeExt = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Equipe Domicile ");

        jLabel2.setText("Equipe Extérieure");

        jButtonEnregistrer.setText("Enregistrer");
        jButtonEnregistrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnregistrerActionPerformed(evt);
            }
        });

        jTextNbComb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNbCombActionPerformed(evt);
            }
        });

        jLabel3.setText("Nombre de combinaisons :");

        jLabel4.setText("Montant :");

        jButtonCombiner.setText("Combiner");
        jButtonCombiner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCombinerActionPerformed(evt);
            }
        });

        jComboBoxEquipeDom.setModel(new javax.swing.DefaultComboBoxModel(listTeamsNames.toArray(new String[listTeamsNames.size()])));
        jComboBoxEquipeDom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEquipeDomActionPerformed(evt);
            }
        });

        jComboBoxEquipeExt.setModel(new javax.swing.DefaultComboBoxModel(listTeamsNames.toArray(new String[listTeamsNames.size()])));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jTextNbComb, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextCoteDom, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jTextMontant, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonCombiner)
                                .addGap(27, 27, 27)
                                .addComponent(jButtonEnregistrer))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextCoteNull, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(76, 76, 76)
                                .addComponent(jTextCoteExt, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jComboBoxEquipeDom, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxEquipeExt, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextNbComb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxEquipeDom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxEquipeExt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextCoteDom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextCoteExt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextCoteNull, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEnregistrer)
                    .addComponent(jTextMontant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jButtonCombiner))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEnregistrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnregistrerActionPerformed
        // TODO add your handling code here:
        Match m = new Match(jComboBoxEquipeDom.getSelectedItem().toString(),
                            jComboBoxEquipeExt.getSelectedItem().toString(),
                            Double.parseDouble(jTextCoteDom.getText()),
                            Double.parseDouble(jTextCoteExt.getText()),
                            Double.parseDouble(jTextCoteNull.getText()));
        listeComplete.add(m);
        
        jComboBoxEquipeDom.setSelectedIndex(0);
        jComboBoxEquipeExt.setSelectedIndex(0);
        jTextCoteDom.setText("");
        jTextCoteExt.setText("");
        jTextCoteNull.setText("");
    }//GEN-LAST:event_jButtonEnregistrerActionPerformed

    private void jTextNbCombActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNbCombActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNbCombActionPerformed

    private void jButtonCombinerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCombinerActionPerformed
        
        if(!jTextNbComb.getText().equals("")){
            listeMatchs = meilleursMatchs(Integer.parseInt(jTextNbComb.getText()));
        }else{
            listeMatchs = listeComplete;
        }
        
//        Collections.sort(listeMatchs, new Comparator<Match>() {
//        @Override 
//        public int compare(Match m1, Match m2) {
//            if(plusGrandPourcentage(m1) > plusGrandPourcentage(m2)){
//                return 1;
//            }else if (plusGrandPourcentage(m1) < plusGrandPourcentage(m2)){
//                return -1;
//            }else{
//                return 0;
//            }
//        }
//        });
        combiner(listeMatchs);
        combinerW(listeMatchs);
        Set<Pari> hs = new HashSet<>();
        hs.addAll(listeParis);
        listeParis.clear();
        listeParis.addAll(hs);
        
        Collections.sort(listeParis, new Comparator<Pari>() {
        @Override 
        public int compare(Pari p1, Pari p2) {
            if(p2.getChances() > p1.getChances()){
                return 1;
            }else if (p2.getChances() < p1.getChances()){
                return -1;
            }else{
                return 0;
            }
        }
        });
        
        int nbParis = 0;
        double pourcentage = 0;
        for(Pari p : listeParis){
            pourcentage += p.getChances();

            nbParis++;
            //System.out.println(nbParis+" - "+p.toString()+"Montant = "+ formatter.format(Double.parseDouble(jTextMontant.getText())*(p.getChances()/totalChances))+"$");
            //if(pourcentage > 120){
             //   break;
            //}
            if(!parisImprimes.contains(p.getEquipes().toString())){
                System.out.println(nbParis+" - "+p.toString());
                parisImprimes.add(p.getEquipes().toString());
            }
            
        }
    }//GEN-LAST:event_jButtonCombinerActionPerformed

    private void jComboBoxEquipeDomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEquipeDomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxEquipeDomActionPerformed

    
    public void combiner( ArrayList<Match> lm){
        
        if(lm.isEmpty()){

        }else if(lm.size()==1){
            
            pari.getEquipes().add(lm.get(0).getEquipeDom());
            pari.setChances(pari.getChances() * getPercentage(lm.get(0),"dom"));
            totalChances+=pari.getChances() * getPercentage(lm.get(0),"dom");
            if(pari.getEquipes().size()!= listeMatchs.size()){
                System.out.println("Erreur 1" + pari.toString()+" "+listeMatchs.size()+" "+pari.getEquipes().size()+" " +listeParis.size());
                System.exit(0);
            }
            listeParis.add(new Pari(pari));
            pari.setChances(pari.getChances() / getPercentage(lm.get(0),"dom"));
            pari.getEquipes().remove(lm.get(0).getEquipeDom());
            
            pari.getEquipes().add(lm.get(0).getEquipeDom()+" Égalité "+lm.get(0).getEquipeExt());
            pari.setChances(pari.getChances() * getPercentage(lm.get(0),""));
            totalChances+=pari.getChances() * getPercentage(lm.get(0),"dom");
            if(pari.getEquipes().size()!= listeMatchs.size()){
                System.out.println("Erreur 2" + pari.toString()+" "+listeMatchs.size()+" "+pari.getEquipes().size()+" " +listeParis.size());
                System.exit(0);
            }
            listeParis.add(new Pari(pari));
            pari.setChances(pari.getChances() / getPercentage(lm.get(0),""));
            totalChances+=pari.getChances() * getPercentage(lm.get(0),"dom");
            pari.getEquipes().remove(lm.get(0).getEquipeDom()+" Égalité "+lm.get(0).getEquipeExt());
            
            pari.getEquipes().add(lm.get(0).getEquipeExt());
            pari.setChances(pari.getChances() * getPercentage(lm.get(0),"ext"));
            if(pari.getEquipes().size()!= listeMatchs.size()){
                System.out.println("Erreur 3" + pari.toString()+" "+listeMatchs.size()+" "+pari.getEquipes().size()+" " +listeParis.size());
                System.exit(0);
            }
            listeParis.add(new Pari(pari));
            pari.setChances(pari.getChances() / getPercentage(lm.get(0),"ext"));
            pari.getEquipes().remove(lm.get(0).getEquipeExt());
            
        }else{

            pari.getEquipes().add(lm.get(0).getEquipeDom());
            pari.setChances(pari.getChances() * getPercentage(lm.get(0),"dom"));
            combiner(new ArrayList<>(lm.subList(1, lm.size())));
            
            pari.getEquipes().remove(lm.get(0).getEquipeDom());
            pari.setChances(pari.getChances() / getPercentage(lm.get(0),"dom"));
            
            pari.getEquipes().add(lm.get(0).getEquipeDom()+" Égalité "+lm.get(0).getEquipeExt() );
            pari.setChances(pari.getChances() * getPercentage(lm.get(0),""));
            combiner(new ArrayList<>(lm.subList(1, lm.size())));
            
            pari.getEquipes().remove(lm.get(0).getEquipeDom()+" Égalité "+lm.get(0).getEquipeExt() );
            pari.setChances(pari.getChances() / getPercentage(lm.get(0),""));
           
            pari.getEquipes().add(lm.get(0).getEquipeExt());
            pari.setChances(pari.getChances() * getPercentage(lm.get(0),"ext"));
            combiner(new ArrayList<>(lm.subList(1, lm.size())));
            pari.getEquipes().remove(lm.get(0).getEquipeExt());
            pari.setChances(pari.getChances() / getPercentage(lm.get(0),"ext"));
        }
       
    }
    
        public void combinerW( ArrayList<Match> lm){
        
        if(lm.isEmpty()){

        }else if(lm.size()==1){
            
            double[] stats = wt.pronostiquer(lm.get(0).getEquipeDom(), lm.get(0).getEquipeExt());
            
            pari.getEquipes().add(lm.get(0).getEquipeDom());
            pari.setChances(pari.getChances() * stats[0]);
            //totalChances+=pari.getChances() * getPercentage(lm.get(0),"dom");
            if(pari.getEquipes().size()!= listeMatchs.size()){
                System.out.println("Erreur 1" + pari.toString()+" "+listeMatchs.size()+" "+pari.getEquipes().size()+" " +listeParis.size());
                System.exit(0);
            }
            listeParis.add(new Pari(pari));
            pari.setChances(pari.getChances() / stats[0]);
            pari.getEquipes().remove(lm.get(0).getEquipeDom());
            
            pari.getEquipes().add(lm.get(0).getEquipeDom()+" Égalité "+lm.get(0).getEquipeExt());
            pari.setChances(pari.getChances() * stats[1]);
            //totalChances+=pari.getChances() * getPercentage(lm.get(0),"dom");
            if(pari.getEquipes().size()!= listeMatchs.size()){
                System.out.println("Erreur 2" + pari.toString()+" "+listeMatchs.size()+" "+pari.getEquipes().size()+" " +listeParis.size());
                System.exit(0);
            }
            listeParis.add(new Pari(pari));
            pari.setChances(pari.getChances() / stats[1]);
            //totalChances+=pari.getChances() * getPercentage(lm.get(0),"dom");
            pari.getEquipes().remove(lm.get(0).getEquipeDom()+" Égalité "+lm.get(0).getEquipeExt());
            
            pari.getEquipes().add(lm.get(0).getEquipeExt());
            pari.setChances(pari.getChances() * stats[2]);
            if(pari.getEquipes().size()!= listeMatchs.size()){
                System.out.println("Erreur 3" + pari.toString()+" "+listeMatchs.size()+" "+pari.getEquipes().size()+" " +listeParis.size());
                System.exit(0);
            }
            listeParis.add(new Pari(pari));
            pari.setChances(pari.getChances() / stats[2]);
            pari.getEquipes().remove(lm.get(0).getEquipeExt());
            
        }else{

            double[] stats = wt.pronostiquer(lm.get(0).getEquipeDom(), lm.get(0).getEquipeExt());
            pari.getEquipes().add(lm.get(0).getEquipeDom());
            //wt.getListEquipes().get(wt.getTeamPos((lm.get(0).getEquipeDom()))).getHomeWeight()
            pari.setChances(pari.getChances() * stats[0]);
            combiner(new ArrayList<>(lm.subList(1, lm.size())));
            
            pari.getEquipes().remove(lm.get(0).getEquipeDom());
            pari.setChances(pari.getChances() / stats[0]);
            
            pari.getEquipes().add(lm.get(0).getEquipeDom()+" Égalité "+lm.get(0).getEquipeExt() );
            pari.setChances(pari.getChances() * stats[1]);
            combiner(new ArrayList<>(lm.subList(1, lm.size())));
            
            pari.getEquipes().remove(lm.get(0).getEquipeDom()+" Égalité "+lm.get(0).getEquipeExt() );
            pari.setChances(pari.getChances() / stats[1]);
           
            pari.getEquipes().add(lm.get(0).getEquipeExt());
            pari.setChances(pari.getChances() * stats[2]);
            combiner(new ArrayList<>(lm.subList(1, lm.size())));
            pari.getEquipes().remove(lm.get(0).getEquipeExt());
            pari.setChances(pari.getChances() / stats[2]);
        }
       
    }
    
    public double getPercentage(Match m, String s){
        
        double totalCotes = m.getCoteDom() + m.getCoteExt() + m.getCoteNull();
        double chanceDom = (1-(m.getCoteDom()/totalCotes));
        double chanceExt = (1-(m.getCoteExt()/totalCotes));
        double chanceNull = (1-(m.getCoteNull()/totalCotes));
        double total = chanceDom + chanceExt + chanceNull;
        
        if(s.equals("dom")){
            //System.out.println("chance de victoire pour "+m.getEquipeDom()+" est " + chanceDom/total);
                //return chanceDom/total;
            return (totalCotes - m.getCoteDom())/totalCotes;
        }else if(s.equals("ext")){
            //System.out.println("chance de victoire pour "+m.getEquipeExt()+" est " + chanceExt/total);
                //return chanceExt/total;
            return (totalCotes - m.getCoteExt())/totalCotes;
        }else{
            //System.out.println("chance de victoire pour Égalité est " + chanceNull/total);
                //return chanceNull/total;
            return (totalCotes - m.getCoteNull())/totalCotes;
        }
    }
    
    public ArrayList<Match> meilleursMatchs(int n){
        Collections.sort(listeComplete, new Comparator<Match>() {
        @Override 
        public int compare(Match m1, Match m2) {
            if(plusPetiteCote(m1) < plusPetiteCote(m2)){
                return 1;
            }else if (plusPetiteCote(m2) > plusPetiteCote(m1)){
                return -1;
            }else{
                return 0;
            }
        }
        });
        
        return new ArrayList<>(listeComplete.subList(0, n));
    }
    
    public double plusPetiteCote(Match m){
        if(getPercentage(m,"dom") < getPercentage(m,"ext") && getPercentage(m,"dom") < getPercentage(m,"")){
            return getPercentage(m,"dom");
        }else if(getPercentage(m,"ext") < getPercentage(m,"dom") && getPercentage(m,"ext") < getPercentage(m,"")){
            return getPercentage(m,"ext");
        }else{
            return getPercentage(m,"");
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCombiner;
    private javax.swing.JButton jButtonEnregistrer;
    private javax.swing.JComboBox jComboBoxEquipeDom;
    private javax.swing.JComboBox jComboBoxEquipeExt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextCoteDom;
    private javax.swing.JTextField jTextCoteExt;
    private javax.swing.JTextField jTextCoteNull;
    private javax.swing.JTextField jTextMontant;
    private javax.swing.JTextField jTextNbComb;
    // End of variables declaration//GEN-END:variables
}