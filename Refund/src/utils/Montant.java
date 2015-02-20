/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.text.DecimalFormat;

/**
 *
 * @author k1fryouf
 */
public class Montant {

       
     public static Double lireMontant(String montant) {
        
        Double num = Double.parseDouble(montant.substring(0, montant.length() - 1).replace(',','.').replaceAll("[^0-9.]", ""));

        return num;

    }

    public static String ecrireMontant(Double montant) {
        String str = formaterDouble((montant)) + "$";
        str = str.replace(',', '.');
        str = str.replace(' ', '.');
        return str;

    }

    public static String formaterDouble(double unDouble) {

        DecimalFormat df = new DecimalFormat();

        df.setMaximumFractionDigits(2); //arrondi à 2 chiffres apres la virgules
        df.setMinimumFractionDigits(2);
        df.setDecimalSeparatorAlwaysShown(true);

        return df.format(unDouble);
    }

}
