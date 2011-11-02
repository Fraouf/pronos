package user;

import java.lang.Math;
/**
 * Write a description of class ArrondiDouble here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ArrondiDouble{
    
    public static double AroundTwoDecimal(double numberRound){
        numberRound = numberRound * 100;
        long nomberWithTwoDecimal = Math.round(numberRound);
        numberRound = (double)nomberWithTwoDecimal;
        return numberRound/100;
        
    }
    
}