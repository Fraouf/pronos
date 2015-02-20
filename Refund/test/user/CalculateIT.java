/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author k1fryouf
 */
public class CalculateIT {
    
    public CalculateIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {

    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of calculateTotalRefunds method, of class Calculate.
     */
    @Test
    public void testCalculateTotalRefunds() {
        
        Reclamation reclam1 = new Reclamation(600,"12-05-2014","3785.75$");
        Reclamation reclam2 = new Reclamation(345,"12-05-2014","4873.03$");
        Reclamation reclam3 = new Reclamation(700,"12-05-2014","67938.24$");
        
        Remboursement remb1 = new Remboursement(600,"12-05-2014","-1$");
        Remboursement remb2 = new Remboursement(345,"12-05-2014","-1$");
        Remboursement remb3 = new Remboursement(700,"12-05-2014","-1$");
        
        List<Reclamation> listRecl = new ArrayList<>();
        
        listRecl.add(reclam1);
        listRecl.add(reclam2);
        listRecl.add(reclam3);
        
        List<Remboursement> listRemb = new ArrayList<>();
        
        listRemb.add(remb1);
        listRemb.add(remb2);
        listRemb.add(remb3);
       
        User client = new User("789345",'D',"05-2014", listRecl, listRemb);
        Calculate.calculateTotalRefunds(client);
        
        Reclamation reclam4 = new Reclamation(300,"15-05-2314","500.88$");
        Reclamation reclam5 = new Reclamation(700,"19-05-1914","988.03$");
        Reclamation reclam6 = new Reclamation(0,"13-05-2002","5362.24$");
        
        Remboursement remb4 = new Remboursement(300,"15-05-2314","-1$");
        Remboursement remb5 = new Remboursement(700,"19-05-1914","-1$");
        Remboursement remb6 = new Remboursement(0,"13-05-2002","-1$");
        
        List<Reclamation> listRecl2 = new ArrayList<>();
        
        listRecl2.add(reclam4);
        listRecl2.add(reclam5);
        listRecl2.add(reclam6);
        
        List<Remboursement> listRemb2 = new ArrayList<>();
        
        listRemb2.add(remb4);
        listRemb2.add(remb5);
        listRemb2.add(remb6);
        User client2 = new User("789035",'A',"02-2062", listRecl2, listRemb2);
        Calculate.calculateTotalRefunds(client2);
        
        assertEquals(client.getListReclam().get(1).getMontant(), client.getListRemb().get(1).getMontant(), 0.01);
        assertEquals(90, client.getListRemb().get(2).getMontant(), 0.01);
        assertEquals(100, client.getListRemb().get(0).getMontant(), 0.01);
        
        assertEquals(0, client2.getListRemb().get(0).getMontant(), 0.01);
        assertEquals(0, client2.getListRemb().get(1).getMontant(), 0.01);
        assertEquals(client2.getListReclam().get(2).getMontant()*0.25, client2.getListRemb().get(2).getMontant(), 0.01);
        
        
    }
    
}
