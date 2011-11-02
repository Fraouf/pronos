
import com.google.gson.stream.JsonReader;
import java.io.FileReader;
import java.io.IOException;
import loadIn.LoadJsonFile;
import saveIn.SaveJsonFile;
import scanFolder.ScanningFolder;
import user.Calculate;
import user.User;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author k1fryouf
 */
public class Main {
    

    public static void main (String[]args){
            
            try{
                String [] clientFilesJson = ScanningFolder.scanningFolderPatch(args[0]);
                
                
                for(int i=0;i<clientFilesJson.length;i++){
                    
                    //Lecture des fichiers source .json donné par les arguments du main
                    JsonReader  file = new JsonReader( new FileReader(clientFilesJson[i]));
                    
                    //récupération du fichier json de la classe JsonReader
                    User customer  = LoadJsonFile.load(file);
                    
                    //calculé les payements de l'utilisateurs
                    Calculate.calculateTotalPayment(customer);
                    
                    //sauvegarde des fichiés dans le dossier "extrant"
                    SaveJsonFile.save(customer,args[1]);
                }


            }catch (Exception e){
            
                e.printStackTrace();
                //System.out.println (customer.getDescription());
                //System.out.println (customer.getAmount());
                //System.out.println (customer.getDuration());
                //System.out.println (customer.getPaymentFrequency());
                //System.out.println (customer.getInterestRates());
                //System.out.println (customer.getFrequencyComposition());
            }

    }
}


    

