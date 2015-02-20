/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author k1fryouf
 */
public class User {
    
    private String client;
    private char contrat;
    private String mois;
    private List<Reclamation> reclamations;
    private List<Remboursement> remboursements;
    

    public User(String client, char contrat, String mois, List<Reclamation> reclamations, List<Remboursement> remboursements) {

        this.client = client;
        this.contrat = contrat;
        this.mois = mois;
        this.reclamations = reclamations;
        this.remboursements = remboursements;
        

    }

    public User() {

        client = "";
        contrat = 'z';
        mois = "";
        reclamations = new ArrayList<>();
        remboursements = new ArrayList<>();
       
    }

    /**
     * @return the client
     */
    public String getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(String client) {
        this.client = client;
    }

    /**
     * @return the contrat
     */
    public char getContrat() {
        return contrat;
    }

    /**
     * @param contrat the contrat to set
     */
    public void setContrat(char contrat) {
        this.contrat = contrat;
    }

    /**
     * @return the mois
     */
    public String getMois() {
        return mois;
    }

    /**
     * @param mois the mois to set
     */
    public void setMois(String mois) {
        this.mois = mois;
    }

    /**
     * @return the reclamations
     */
    public List<Reclamation> getListReclam() {
        return reclamations;
    }

    /**
     * @param reclamations the reclamations to set
     */
    public void setListReclam(List<Reclamation> reclamations) {
        this.reclamations = reclamations;
    }

    /**
     * @return the remboursements
     */
    public List<Remboursement> getListRemb() {
        return remboursements;
    }

    /**
     * @param remboursements the remboursements to set
     */
    public void setListRemb(List<Remboursement> remboursements) {
        this.remboursements = remboursements;
    }

}
