/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

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
public class MontantIT {
    
    public MontantIT() {
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
     * Test of lireMontant method, of class Montant.
     */
    @Test
    public void testLireMontant() {
        System.out.println("lireMontant");
        String montant = "";
        Double expResult = null;
        Double result = Montant.lireMontant(montant);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ecrireMontant method, of class Montant.
     */
    @Test
    public void testEcrireMontant() {
        System.out.println("ecrireMontant");
        Double montant = null;
        String expResult = "";
        String result = Montant.ecrireMontant(montant);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of formaterDouble method, of class Montant.
     */
    @Test
    public void testFormaterDouble() {
        System.out.println("formaterDouble");
        double unDouble = 0.0;
        String expResult = "";
        String result = Montant.formaterDouble(unDouble);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
