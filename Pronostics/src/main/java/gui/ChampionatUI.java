/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import pronostics.Equipe;
import pronostics.Match;
import pronostics.NeuralNetwork;
import sql.SQLConnection;

/**
 *
 * @author k1fryouf
 */
public class ChampionatUI extends javax.swing.JFrame {

    private SQLConnection myConnection;
    private final String championat;
    private NeuralNetwork nn;
    /**
     * Creates new form PronostiqueUI
     * @param championat
     * @param nn
     */
    public ChampionatUI(String championat,NeuralNetwork nn) {
        myConnection = new SQLConnection();
        myConnection.createConnection();
        this.championat = championat;
        this.nn = nn;
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
        jButtonSupprimerEquipe = new javax.swing.JButton();
        jButtonAjouterEquipe = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listeEquipes = new javax.swing.JList();
        jButtonQuitter = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listeMatchs = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        jButtonSupprimerMatche = new javax.swing.JButton();
        jButtonAjouterMatche = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Équipes");

        jButtonSupprimerEquipe.setText("Supprimer");
        jButtonSupprimerEquipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSupprimerEquipeActionPerformed(evt);
            }
        });

        jButtonAjouterEquipe.setText("Ajouter");
        jButtonAjouterEquipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAjouterEquipeActionPerformed(evt);
            }
        });

        myConnection.setTableName("APP.EQUIPES");
        listeEquipes.setModel(new javax.swing.AbstractListModel() {

            ArrayList<Equipe> equipes = myConnection.selectTeamsByComp(championat);

            public int getSize() { return equipes.size(); }
            public String getElementAt(int i) { return equipes.get(i).getNom(); }

        });
        listeEquipes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listeEquipesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listeEquipes);

        jButtonQuitter.setText("Quitter");
        jButtonQuitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuitterActionPerformed(evt);
            }
        });

        myConnection.setTableName("APP.MATCHES");
        listeMatchs.setModel(new javax.swing.AbstractListModel() {
            ArrayList<Match> matchs = myConnection.selectMatchsByComp(championat);
            public int getSize() { return matchs.size(); }
            public String getElementAt(int i) { return matchs.get(i).toString(); }
        });
        listeMatchs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listeMatchsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(listeMatchs);

        jLabel2.setText("Matchs");

        jButtonSupprimerMatche.setText("Supprimer");
        jButtonSupprimerMatche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSupprimerMatcheActionPerformed(evt);
            }
        });

        jButtonAjouterMatche.setText("Ajouter");
        jButtonAjouterMatche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAjouterMatcheActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(233, 233, 233)
                .addComponent(jLabel1)
                .addGap(89, 89, 89))
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jButtonAjouterMatche, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSupprimerMatche))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jButtonQuitter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 9, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jButtonAjouterEquipe, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonSupprimerEquipe))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSupprimerEquipe)
                    .addComponent(jButtonAjouterEquipe)
                    .addComponent(jButtonSupprimerMatche)
                    .addComponent(jButtonAjouterMatche))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jButtonQuitter)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAjouterEquipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAjouterEquipeActionPerformed
        myConnection.setTableName("APP.EQUIPES");
        AddTeam aAddTeam = new AddTeam(myConnection, this);
        aAddTeam.getjTextChampionat().setText(championat);
        if(!championat.equals("")){
            aAddTeam.getjTextChampionat().setEnabled(false);
        }
        aAddTeam.setVisible(true);
    }//GEN-LAST:event_jButtonAjouterEquipeActionPerformed

    private void jButtonSupprimerEquipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSupprimerEquipeActionPerformed
        myConnection.setTableName("APP.EQUIPES");
        List<String> list = listeEquipes.getSelectedValuesList();
        list.stream().forEach((String list1) -> {
            if(myConnection.deleteTeam(list1)){
                
                
                
            }else{
                JOptionPane.showMessageDialog(this, list1 +" n'a pas été supprimé.");
            }
        });
    }//GEN-LAST:event_jButtonSupprimerEquipeActionPerformed

    private void listeEquipesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listeEquipesMouseClicked

            JList list = (JList)evt.getSource();
            if (evt.getClickCount() == 2) {
                // Double-click detected
                editTeam(list.getSelectedValue().toString());
            };
    }//GEN-LAST:event_listeEquipesMouseClicked

    private void jButtonQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuitterActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonQuitterActionPerformed

    private void jButtonAjouterMatcheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAjouterMatcheActionPerformed
        myConnection.setTableName("APP.MATCHES");
        AddMatch aAddMatch = new AddMatch(myConnection, this);
        aAddMatch.getjTextComp().setText(championat);
        if(!championat.equals("")){
            aAddMatch.getjTextComp().setEnabled(false);
        }
        aAddMatch.setVisible(true);
        
    }//GEN-LAST:event_jButtonAjouterMatcheActionPerformed

    private void jButtonSupprimerMatcheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSupprimerMatcheActionPerformed
        myConnection.setTableName("APP.MATCHES");
        List<String> list = listeMatchs.getSelectedValuesList();
        list.stream().forEach((String list1) -> {
            if(myConnection.deleteMatch(list1)){
               refreshListMatchs(championat);
            }else{
                JOptionPane.showMessageDialog(this, list1 +" n'a pas été supprimé.");
            }
        });
    }//GEN-LAST:event_jButtonSupprimerMatcheActionPerformed

    private void listeMatchsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listeMatchsMouseClicked
        JList list = (JList)evt.getSource();
            if (evt.getClickCount() == 2) {
                // Double-click detected
                editMatch(list.getSelectedValue().toString());
            
            };
    }//GEN-LAST:event_listeMatchsMouseClicked

    public void editTeam(String teamName){
        myConnection.setTableName("APP.EQUIPES");
        AddTeam editTeam = new AddTeam(myConnection, this);
        editTeam.getjButtonAjouter().setText("Modifier");
        ArrayList<Equipe> team = myConnection.selectTeams(teamName);
        editTeam.getjTextNom().setText(team.get(0).getNom());
        editTeam.getjTextPresident().setText(team.get(0).getPresident());
        editTeam.getjTextEntraineur().setText(team.get(0).getEntraineur());
        editTeam.getjTextPays().setText(team.get(0).getPays());
        editTeam.getjTextChampionat().setText(team.get(0).getChampionat());
        editTeam.getjTextStade().setText(team.get(0).getStade());
        editTeam.getjTextIcon().setText(team.get(0).getIcon());
        editTeam.setVisible(true);
    }
    
    public void editMatch(String matchId){
        myConnection.setTableName("APP.MATCHES");
        AddMatch editMatch = new AddMatch(myConnection, this);
        editMatch.getjButtonAjouter().setText("Modifier");
        ArrayList<Match> match = myConnection.selectMatchs(matchId);
        editMatch.getjLabelId().setText(matchId);
        editMatch.getjTextEquipeDom().setSelectedItem(match.get(0).getEquipeDom());
        editMatch.getjTextEquipeExt().setSelectedItem(match.get(0).getEquipeExt());
        editMatch.getjTextStade().setText(match.get(0).getStade());
        editMatch.getjTextDate().setText(match.get(0).getDate().toString());
        editMatch.getjTextComp().setText(match.get(0).getCompetition());
        editMatch.setVisible(true);
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JList getListeEquipes() {
        return listeEquipes;
    }

    public void setListeEquipes(JList listeEquipes) {
        this.listeEquipes = listeEquipes;
    }

    public JButton getjButtonAjouterEquipe() {
        return jButtonAjouterEquipe;
    }

    public void setjButtonAjouterEquipe(JButton jButtonAjouterEquipe) {
        this.jButtonAjouterEquipe = jButtonAjouterEquipe;
    }

    public JButton getjButtonAjouterMatche() {
        return jButtonAjouterMatche;
    }

    public void setjButtonAjouterMatche(JButton jButtonAjouterMatche) {
        this.jButtonAjouterMatche = jButtonAjouterMatche;
    }

    public JButton getjButtonQuitter() {
        return jButtonQuitter;
    }

    public void setjButtonQuitter(JButton jButtonQuitter) {
        this.jButtonQuitter = jButtonQuitter;
    }

    public JButton getjButtonSupprimerEquipe() {
        return jButtonSupprimerEquipe;
    }

    public void setjButtonSupprimerEquipe(JButton jButtonSupprimerEquipe) {
        this.jButtonSupprimerEquipe = jButtonSupprimerEquipe;
    }

    public JButton getjButtonSupprimerMatche() {
        return jButtonSupprimerMatche;
    }

    public void setjButtonSupprimerMatche(JButton jButtonSupprimerMatche) {
        this.jButtonSupprimerMatche = jButtonSupprimerMatche;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public void setjScrollPane2(JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }

    public JList getListeMatchs() {
        return listeMatchs;
    }

    public void setListeMatchs(JList listeMatchs) {
        this.listeMatchs = listeMatchs;
    }
    
    public void refreshListMatchs(String s){

        listeMatchs.setModel(new javax.swing.AbstractListModel() {

            ArrayList<Match> matchs = myConnection.selectMatchsByComp(s);

            public int getSize() { return matchs.size(); }
            public String getElementAt(int i) { return matchs.get(i).toString(); }

        });
        jScrollPane2.setViewportView(listeMatchs);
    }
    
    public void refreshListEquipes(String s){
        listeEquipes.setModel(new javax.swing.AbstractListModel() {
                    
            ArrayList<Equipe> equipes = myConnection.selectTeamsByComp(s);

            @Override
            public int getSize() { return equipes.size(); }
            @Override
            public String getElementAt(int i) { return equipes.get(i).getNom(); }

            });
            jScrollPane1.setViewportView(listeEquipes);
    }
    
    public String makeId(Match m){
        return m.getEquipeDom().substring(0, 3)+m.getEquipeExt().substring(0, 3)+m.getDate();
    }
    
    public String getChampionat(){
        return championat;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAjouterEquipe;
    private javax.swing.JButton jButtonAjouterMatche;
    private javax.swing.JButton jButtonQuitter;
    private javax.swing.JButton jButtonSupprimerEquipe;
    private javax.swing.JButton jButtonSupprimerMatche;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList listeEquipes;
    private javax.swing.JList listeMatchs;
    // End of variables declaration//GEN-END:variables
}