/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package go;

import java.awt.geom.Point2D;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author NguyenQuoc
 */
public class plateauDeJeuTest {
    
    public plateauDeJeuTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of estVide method, of class plateauDeJeu. Result false
     */
    @Test
    public void testEstVideTrue()
    {
        Point2D pierrePos=new Point2D.Double(1,1);
        Pierre pierre1=new Pierre("jaune", new Point2D.Double(1,1));
        PlateauDeJeu plat = new PlateauDeJeu(19);
        
       // pierre1.setPosition(1,1);
        //pierrePos.setLocation(1,1);
        
        plat.ajouterPierre(pierre1);
        
        assertEquals(false,plat.estVide(pierrePos));
                
    }
    
        /**
     * Test of estVide method, of class plateauDeJeu. Result true
     */
    @Test
    public void testEstVideFalse()
    {
        Point2D pierrePos=new Point2D.Double(2,1);
        Pierre pierre1=new Pierre("rouge", new Point2D.Double(0,0));
        PlateauDeJeu plat = new PlateauDeJeu(19);
     
        //pierre1.setPosition(1,1);
        //pierrePos.setLocation(2,1);
        
        plat.ajouterPierre(pierre1);
        
        assertEquals(true,plat.estVide(pierrePos));
                
    }

    /**
     * Test of ajouterPierre method, of class plateauDeJeu.
     */
    @Test
    public void testAjouterPierre()
    {
        System.out.println("ajouterPierre");
        Pierre pierre = null;
        PlateauDeJeu instance = null;
        int expResult = 0;
        int result = instance.ajouterPierre(pierre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of supprimerPierre method, of class plateauDeJeu.
     */
    @Test
    public void testSupprimerPierre()
    {
        System.out.println("supprimerPierre");
        Pierre pierreSup = null;
        PlateauDeJeu instance = null;
        boolean expResult = false;
        boolean result = instance.supprimerPierre(pierreSup);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
