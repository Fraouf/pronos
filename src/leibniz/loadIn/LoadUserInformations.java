package leibniz.loadIn;

import leibniz.user.UserInformations;
import java.util.StringTokenizer;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Integer;
/**
 *
 * @author Mathieu Green
 */
public class LoadUserInformations {
    
    
    static private String patchUsersFiles = "";
    
    
    
    public static UserInformations[] loadUsers(){

        try{
            //rechercher le nombre fichier Json
            String usersPatch[] = patchJsonFiles();

            //creation des utilisateurs dans la memoire
            UserInformations[] usersInfos = new UserInformations[usersPatch.length];


            for(int i=0;i<usersPatch.length;i++){
                
                String userId = null;
                String userDescription = null;
                int userDuration = 0;
                int userAmount = 0;
                int userFrequencyComposition = 0;
                int userInterestRates = 0;
                int userPaymentFrequency = 0;
                
                
                String test = readUserInfo(usersPatch[i]);

                //retirer les acolades
                test = test.replace("{","");
                test = test.replace("}","");

                //separer les informations
                StringTokenizer token = new StringTokenizer(test,",");

                while(token.hasMoreTokens()){
                    
                    System.out.println(token.nextToken());
                    
                    StringTokenizer dataUser = new StringTokenizer(token.nextToken(),":");
                    
                    String userVariable = dataUser.nextToken();
                    String userVariableValue = dataUser.nextToken();
                    
                    userVariable.replace("\"","");
                    
                    if(userVariable.equals("id")){
                            userId = userVariableValue;
                    }
                    else if(userVariable.equals("description")){
                        
                        userDescription = userVariableValue;
                    }
                    else if(userVariable.equals("montant")){
                        
                        userAmount = Integer.parseInt(userVariableValue);
                        
                    }
                    else if(userVariable.equals("nombreAnnee")){
                        
                        userDuration = Integer.parseInt(userVariableValue);
                        
                    }
                    else if(userVariable.equals("frequenceRemboursement")){
                        
                        userFrequencyComposition = Integer.parseInt(userVariableValue);
                        
                    }
                    else if(userVariable.equals("tauxInteret")){
                        
                        userInterestRates = Integer.parseInt(userVariableValue);
                        
                    }
                    else if(userVariable.equals("frequenceComposition")){
                        
                        userPaymentFrequency = Integer.parseInt(userVariableValue);
                        
                    }
                    else{
                        
                        System.out.println("Erreur lors de la saisie des variable: " + userVariable);
                        
                    }
                    
                }
                
                usersInfos[i] = new UserInformations (userId, userDescription, userAmount, userDuration, userPaymentFrequency, userInterestRates, userFrequencyComposition);
            }

            return usersInfos;
            
        }catch(Exception e){
            
            e.printStackTrace();            
            System.out.println("Aucun fichier trouver dans le repertoire");
            
            return null;
            
        }
        
    }
    
    
    public static void setUserInformationsPatch(){
        File patch = new File("intrant\\");
        patchUsersFiles = patch.getAbsolutePath();
    }
    
    
    
    private static String[] patchJsonFiles(){
        
        File patch = new File(patchUsersFiles);
        System.out.println(patch.getAbsolutePath());
        
        File usersFilePatch[] = patch.listFiles();
        
        String usersPatch[];
        
        usersPatch = new String[usersFilePatch.length];
        
        
        
        for(int i=0;i<usersFilePatch.length;i++){
            
            String patchFileName = usersFilePatch[i].getName();
            
            if(!patchFileName.equals(".." ) || !patchFileName.equals(".") ){
                usersPatch[i] = patchUsersFiles + "\\" + patchFileName;
                System.out.println(patchFileName);
            }
            
            System.out.println("fini");
        }
        
        return usersPatch;
    }
    
    
    
    
    //lecture dans du file
    private static String readUserInfo(String patch){
        String textOut = "";
        String textIn = "";
        try{
            
            BufferedReader in = new BufferedReader(new FileReader(patch));
            
            while ((textIn = in.readLine()) != null)
            {
                textOut = textOut + textIn;
            }
            System.out.println("Le fichier: " + patch + "l'information contenu dans le fichier est: " + textOut);
        }
        catch(IOException e){
            e.printStackTrace();
            System.out.println("Erreur de lecture sur le fichier");
            
        }
        
        return textOut;
         
    }
    
    
    //fin de la classe
}
