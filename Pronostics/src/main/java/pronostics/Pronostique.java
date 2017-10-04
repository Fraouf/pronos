/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pronostics;

import combinaisons.CombinaisonUI;
import gui.PronostiqueUI;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import sql.SQLConnection;

/**
 *
 * @author k1fryouf
 */
public class Pronostique {
    
    private static NeuralNetwork nn;
    
    public static void importJson(String url){
        
    }

    public static void importCSV(String url, String mode){
        String csvFile = url;
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        SQLConnection connMatches = new SQLConnection();
        connMatches.createConnection();
        connMatches.setTableName("APP.MATCHES");
        SQLConnection connEquipes = new SQLConnection();
        connEquipes.createConnection();
        connEquipes.setTableName("APP.EQUIPES");

        try {

            br = new BufferedReader(new FileReader(csvFile));
            DateFormat fromFormat = new SimpleDateFormat("dd/MM/yy");
            fromFormat.setLenient(false);
            DateFormat toFormat = new SimpleDateFormat("yyyy-MM-dd");
            toFormat.setLenient(false);
            br.readLine();
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] country = line.split(cvsSplitBy);
                if(country.length > 0){
                    String dateStr = country[1];
                    Date date = null;
                    try {
                        date = fromFormat.parse(dateStr);
                    } catch (ParseException ex) {
                        Logger.getLogger(Pronostique.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if(mode.equals("update")){
                        if(connEquipes.selectTeams(country[2]).size()>0){
                            connEquipes.editTeam(country[2],"","","",country[0],"","");
                        }
                        if(connEquipes.selectTeams(country[2]).size()>0){
                            connEquipes.editTeam(country[3],"","","",country[0],"","");
                        }
                        String formatedDate = toFormat.format(date);
                        if(connMatches.selectMatchs("("+country[2].substring(0,3)+country[3].substring(0,3)+formatedDate+")").size()>0){
                            connMatches.editMatch("("+country[2].substring(0,3)+country[3].substring(0,3)+formatedDate+")",
                                    country[2],
                                    country[3],
                                    "",
                                    formatedDate,
                                    country[0],
                                    Integer.parseInt(country[4]),
                                    Integer.parseInt(country[5])
                                    );
                        }
                    }else{
                        if(connEquipes.selectTeams(country[2]).isEmpty()){
                            connEquipes.insertTeam(country[2],"","","","","","");
                        }
                        if(connEquipes.selectTeams(country[2]).isEmpty()){
                            connEquipes.insertTeam(country[3],"","","","","","");
                        }
                        String formatedDate = toFormat.format(date);
                        if(!country[4].isEmpty() && !country[5].isEmpty()){
                            if(connMatches.selectMatchs("("+country[2].substring(0,3)+country[3].substring(0,3)+formatedDate+")").isEmpty()){
                                connMatches.insertMatch("("+country[2].substring(0,3)+country[3].substring(0,3)+formatedDate+")",
                                        country[2],
                                        country[3],
                                        "",
                                        formatedDate,
                                        country[0],
                                        Integer.parseInt(country[4]),
                                        Integer.parseInt(country[5])
                                        );
                            }
                        }
                    }
                    
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException, Exception {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PronostiqueUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PronostiqueUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PronostiqueUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PronostiqueUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        for (final File fileEntry : new File("/Users/k1fryouf/NetBeansProjects/Pronostics/src/main/java/csv").listFiles()) {
            if (fileEntry.isDirectory()) {
                //listFilesForFolder(fileEntry);
            } else {
                System.out.println("Importation du fichier " + fileEntry.getName() + "...");
                    importCSV("/Users/k1fryouf/NetBeansProjects/Pronostics/src/main/java/csv/"+fileEntry.getName(),"");
            }
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                try {
                    nn = new NeuralNetwork();
                } catch (Exception ex) {
                    Logger.getLogger(Pronostique.class.getName()).log(Level.SEVERE, null, ex);
                }
                new PronostiqueUI(nn).setVisible(true);
                
                CombinaisonUI cui = new CombinaisonUI(nn.getwTeams());
                cui.setVisible(true);
                
            }
        });
         /*
        try {
            Instances dataset = new Instances (new BufferedReader(new FileReader("/Users/k1fryouf/Desktop/test.arff")));
            System.out.println(dataset.toSummaryString());
            ArffSaver saver = new ArffSaver();
            saver.setInstances(dataset);
            saver.setFile(new File("/Users/k1fryouf/Desktop/testSaved.arff"));
            saver.writeBatch();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Pronostique.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Pronostique.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         
               
            Network net = new Network();
            net.readFile("tutorial_a.xdsl");
            net.updateBeliefs();
            String[] aForecastOutcomeIds = net.getOutcomeIds("Forecast");
            int outcomeIndex;
            for (outcomeIndex = 0; outcomeIndex < aForecastOutcomeIds.length; outcomeIndex++)
            if ("Moderate".equals(aForecastOutcomeIds[outcomeIndex]))
            break;
            double[] aValues = net.getNodeValue("Forecast");
            double P_ForecastIsModerate = aValues[outcomeIndex];
            System.out.println("P(\"Forecast\" = Moderate) = " + P_ForecastIsModerate);
            net.setEvidence("Forecast", "Good");
            net.updateBeliefs();
            // Getting the index of the "Failure" outcome:
            String[] aSuccessOutcomeIds = net.getOutcomeIds("Success");
            for (outcomeIndex = 0; outcomeIndex < aSuccessOutcomeIds.length; outcomeIndex++)
            if ("Failure".equals(aSuccessOutcomeIds[outcomeIndex]))
            break;
            
            
            // Getting the value of the probability:
            aValues = net.getNodeValue("Success");
            double P_SuccIsFailGivenForeIsGood = aValues[outcomeIndex];
            System.out.println("P(\"Success\" = Failure | \"Forecast\" = Good) = " + P_SuccIsFailGivenForeIsGood);
            net.clearEvidence("Forecast");
            net.setEvidence("Forecast", "Poor");
            net.updateBeliefs();
            // Getting the index of the "Failure" outcome:
            aSuccessOutcomeIds = net.getOutcomeIds("Success");
            for (outcomeIndex = 0; outcomeIndex < aSuccessOutcomeIds.length; outcomeIndex++)
            if ("Success".equals(aSuccessOutcomeIds[outcomeIndex]))
            break;
            
            // Getting the value of the probability:
            aValues = net.getNodeValue("Success");
            double P_SuccIsSuccGivenForeIsPoor = aValues[outcomeIndex];
            
            System.out.println("P(\"Success\" = Success | \"Forecast\" = Poor) = " + P_SuccIsSuccGivenForeIsPoor);
            */     
        
    }
}
