/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leibniz;

import leibniz.loadIn.LoadUserInformations;
import leibniz.user.UserInformations;
/**
 *
 * @author EmilieGIT
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //recherche du repertoire principal
        LoadUserInformations.setUserInformationsPatch();
        //creation des clients dans la memoire
        UserInformations [] custumer = LoadUserInformations.loadUsers();
        
        
        
    }
}
