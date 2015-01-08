/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package go;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bertille
 */
public class JoueurTest {
    
    public JoueurTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getCouleur method, of class Joueur.
     */
    @Test
    public void testGetCouleur() {
        System.out.println("getCouleur");
        Joueur instance = new Joueur("noir");
        String expResult = "noir";
        String result = instance.getCouleur();
        assertEquals(expResult, result);
    }
    
}
