/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import pronostics.NeuralNetwork;
import sql.SQLConnection;

/**
 *
 * @author k1fryouf
 */
public class PronostiqueUI extends javax.swing.JFrame {

    private NeuralNetwork nn;
    /**
     * Creates new form PronostiqueUI
     * @param nn
     */
    public PronostiqueUI(NeuralNetwork nn) {
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

        jButtonLiga = new javax.swing.JButton();
        jButtonQuitter = new javax.swing.JButton();
        jButtonPronostiquer = new javax.swing.JButton();
        jButtonPL = new javax.swing.JButton();
        jButtonLiga2 = new javax.swing.JButton();
        jButtonAutres = new javax.swing.JButton();
        jButtonAfrique = new javax.swing.JButton();
        jButtonEurope = new javax.swing.JButton();
        jButtonAmeriqueSud = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonLiga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/liga_BBVA.jpg"))); // NOI18N
        jButtonLiga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLigaActionPerformed(evt);
            }
        });

        jButtonQuitter.setText("Quitter");
        jButtonQuitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuitterActionPerformed(evt);
            }
        });

        jButtonPronostiquer.setText("Pronostiquer");
        jButtonPronostiquer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPronostiquerActionPerformed(evt);
            }
        });

        jButtonPL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/premier_league.png"))); // NOI18N
        jButtonPL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPLActionPerformed(evt);
            }
        });

        jButtonLiga2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spain-segunda-division.png"))); // NOI18N
        jButtonLiga2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLiga2ActionPerformed(evt);
            }
        });

        jButtonAutres.setText("Autres");
        jButtonAutres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAutresActionPerformed(evt);
            }
        });

        jButtonAfrique.setIcon(new javax.swing.ImageIcon(getClass().getResource("/afrique_logo.jpg"))); // NOI18N
        jButtonAfrique.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAfriqueActionPerformed(evt);
            }
        });

        jButtonEurope.setIcon(new javax.swing.ImageIcon(getClass().getResource("/europe_logo.png"))); // NOI18N
        jButtonEurope.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEuropeActionPerformed(evt);
            }
        });

        jButtonAmeriqueSud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/amerique_sud_logo.jpg"))); // NOI18N
        jButtonAmeriqueSud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAmeriqueSudActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonPronostiquer)
                        .addGap(39, 39, 39))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonAmeriqueSud, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonAfrique, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jButtonAutres, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonPL, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonLiga2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButtonQuitter, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                        .addComponent(jButtonLiga, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jButtonEurope, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButtonPL, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonAutres, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButtonLiga, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonLiga2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonAfrique, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonEurope, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButtonAmeriqueSud, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonQuitter)
                    .addComponent(jButtonPronostiquer))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLigaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLigaActionPerformed


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ChampionatUI("SP1",nn).setVisible(true);
        });
    }//GEN-LAST:event_jButtonLigaActionPerformed

    private void jButtonQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuitterActionPerformed
        System.exit(0x0);
    }//GEN-LAST:event_jButtonQuitterActionPerformed

    private void jButtonPronostiquerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPronostiquerActionPerformed
        java.awt.EventQueue.invokeLater(() -> {
            SQLConnection myConnection = new SQLConnection();
            myConnection.createConnection();
            new PronostiqueurUI(myConnection,nn).setVisible(true);
        });
    }//GEN-LAST:event_jButtonPronostiquerActionPerformed

    private void jButtonPLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPLActionPerformed

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ChampionatUI("E0",nn).setVisible(true);
        });
    }//GEN-LAST:event_jButtonPLActionPerformed

    private void jButtonLiga2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLiga2ActionPerformed


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ChampionatUI("SP2",nn).setVisible(true);
        });
    }//GEN-LAST:event_jButtonLiga2ActionPerformed

    private void jButtonAutresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAutresActionPerformed

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ChampionatUI("",nn).setVisible(true);
        });
    }//GEN-LAST:event_jButtonAutresActionPerformed

    private void jButtonAfriqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAfriqueActionPerformed
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ChampionatUI("Afrique",nn).setVisible(true);
        });
    }//GEN-LAST:event_jButtonAfriqueActionPerformed

    private void jButtonEuropeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEuropeActionPerformed
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ChampionatUI("Europe",nn).setVisible(true);
        });
    }//GEN-LAST:event_jButtonEuropeActionPerformed

    private void jButtonAmeriqueSudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAmeriqueSudActionPerformed
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ChampionatUI("Amérique du sud",nn).setVisible(true);
        });
    }//GEN-LAST:event_jButtonAmeriqueSudActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAfrique;
    private javax.swing.JButton jButtonAmeriqueSud;
    private javax.swing.JButton jButtonAutres;
    private javax.swing.JButton jButtonEurope;
    private javax.swing.JButton jButtonLiga;
    private javax.swing.JButton jButtonLiga2;
    private javax.swing.JButton jButtonPL;
    private javax.swing.JButton jButtonPronostiquer;
    private javax.swing.JButton jButtonQuitter;
    // End of variables declaration//GEN-END:variables
}
