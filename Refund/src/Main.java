
import com.google.gson.stream.JsonReader;
import java.io.FileReader;
import user.Calculate;
import user.Erreur;
import user.Message;
import userFileManagement.LoadJsonFile;
import userFileManagement.SaveJsonFile;
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

    private static final String PATH = "/Users/k1fryouf/NetBeansProjects/Refund/src/intrant/";

    public static void main(String[] args) {

        try {
            
            String clientFilesJson = PATH + args[0];

            //Lecture des fichiers source .json donn� par les arguments du main
            JsonReader file = new JsonReader(new FileReader(clientFilesJson));

            //r�cup�ration du fichier json de la classe JsonReader
            User customer = LoadJsonFile.load(file);

            //calcul� les payements de l'utilisateurs
            if(customer == null){
                Erreur.messageErreur(new Message("Données invalides"), args[1]);
            }
            Calculate.calculateTotalRefunds(customer);

            //sauvegarde des fichi�s dans le dossier "extrant"
            SaveJsonFile.save(customer, args[1]);

        } catch (Exception e) {

            e.printStackTrace();
        }

    }
}
