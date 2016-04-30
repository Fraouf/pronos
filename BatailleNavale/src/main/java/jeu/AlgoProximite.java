/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu;

import java.util.*;

/**
 *
 * @author Gabriel
 */
public class AlgoProximite implements ILogicIA{
    @Override
    public Case jouerCoup(LinkedList<String> coups,Coup dernierCoup)
    {
        Case c=new Case();
        do{
            c=dernierCoup.coupProche();
        }while(coups.contains(c.toString()));

        return c;
    }
}
