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
        Joueur joueur = new Joueur("Noir");
        Point2D pierrePos=new Point2D.Double(1,1);
        Pierre pierre1=new Pierre("jaune", new Point2D.Double(1,1));
        PlateauDeJeu plat = new PlateauDeJeu(19);
        
       // pierre1.setPosition(1,1);
        //pierrePos.setLocation(1,1);
        
        plat.ajouterPierre(pierre1,joueur);
        
        assertEquals(false,plat.estVide(pierrePos));
                
    }
    
        /**
     * Test of estVide method, of class plateauDeJeu. Result true
     */
    @Test
    public void testEstVideFalse()
    {
        Joueur joueur = new Joueur("Noir");
        Point2D pierrePos=new Point2D.Double(2,1);
        Pierre pierre1=new Pierre("rouge", new Point2D.Double(0,0));
        PlateauDeJeu plat = new PlateauDeJeu(19);
     
        //pierre1.setPosition(1,1);
        //pierrePos.setLocation(2,1);
        
        plat.ajouterPierre(pierre1,joueur);
        
        assertEquals(true,plat.estVide(pierrePos));
                
    }
    
    /**
     * Test of supprimerPierre method, of class plateauDeJeu.
     */
    @Test
    public void testSupprimerPierre()
    {
        Joueur joueur = new Joueur("Noir");
        Pierre pierreSup = new Pierre("noir", new Point2D.Double(1,1));
        PlateauDeJeu instance = new PlateauDeJeu(10);
        instance.ajouterPierre(pierreSup,joueur);
        boolean expResult = true;
        boolean result = instance.supprimerPierre(pierreSup);
        assertEquals(expResult, result);
    }
    
     /**
     * Test de la fonction ajouterPierre pour un emplacement déja pris
     */
    @Test
    public void testDejaPrisjouterPierre()
    {
        PlateauDeJeu plateau = new PlateauDeJeu(11);
        Joueur joueur = new Joueur("Noir");
        Pierre pierre1 = new Pierre("Noir", new Point2D.Float(1,1));
        Pierre pierre2 = new Pierre("Noir", new Point2D.Float(1,1));
        
        plateau.ajouterPierre(pierre1,joueur);
        
        assertEquals(2,plateau.ajouterPierre(pierre2,joueur));

    }
    
     /**
     * Test de la fonction ajouterPierre pour un emplacement libre sans aucun problème
     */
    @Test
    public void testAucunProblemejouterPierre()
    {
        PlateauDeJeu plateau = new PlateauDeJeu(11);
        Joueur joueur = new Joueur("Noir");
        Pierre pierre1 = new Pierre("Noir", new Point2D.Float(1,1));
        Pierre pierre2 = new Pierre("Noir", new Point2D.Float(1,2));
        
        plateau.ajouterPierre(pierre1,joueur);
        
        assertEquals(0,plateau.ajouterPierre(pierre2,joueur));

    }
    
         /**
     * Test de la fonction ajouterPierre pour une capture en suicide
     */
    @Test
    public void testCaptureEnSuicideAjouterPierre()
    {
        PlateauDeJeu plateau = new PlateauDeJeu(11);
        Joueur joueur1 = new Joueur("Noir");
        Joueur joueur2 = new Joueur("Blanc");
        Pierre pierre1 = new Pierre("Noir", new Point2D.Float(2,3));
        Pierre pierre2 = new Pierre("Noir", new Point2D.Float(3,2));
        Pierre pierre3 = new Pierre("Noir", new Point2D.Float(3,4));
        Pierre pierre4 = new Pierre("Blanc", new Point2D.Float(3,3));
        Pierre pierre5 = new Pierre("Blanc", new Point2D.Float(4,2));
        Pierre pierre6 = new Pierre("Blanc", new Point2D.Float(4,4));
        Pierre pierre7 = new Pierre("Blanc", new Point2D.Float(5,3));
        Pierre pierre8 = new Pierre("Noir", new Point2D.Float(4,3));
        
        plateau.ajouterPierre(pierre1,joueur1);
        plateau.ajouterPierre(pierre2,joueur1);
        plateau.ajouterPierre(pierre3,joueur1);
        plateau.ajouterPierre(pierre4,joueur2);
        plateau.ajouterPierre(pierre5,joueur2);
        plateau.ajouterPierre(pierre6,joueur2);
        plateau.ajouterPierre(pierre7,joueur2);
        
        
        assertEquals(0,plateau.ajouterPierre(pierre8,joueur1));

    }
    
         /**
     * Test de la fonction ajouterPierre pour une capture en suicide
     */
    @Test
    public void testKOAjouterPierre()
    {
        PlateauDeJeu plateau = new PlateauDeJeu(11);
        Joueur joueur1 = new Joueur("Noir");
        Joueur joueur2 = new Joueur("Blanc");
        Pierre pierre1 = new Pierre("Noir", new Point2D.Float(2,3));
        Pierre pierre2 = new Pierre("Noir", new Point2D.Float(3,2));
        Pierre pierre3 = new Pierre("Noir", new Point2D.Float(3,4));
        Pierre pierre4 = new Pierre("Blanc", new Point2D.Float(3,3));
        Pierre pierre5 = new Pierre("Blanc", new Point2D.Float(4,2));
        Pierre pierre6 = new Pierre("Blanc", new Point2D.Float(4,4));
        Pierre pierre7 = new Pierre("Blanc", new Point2D.Float(5,3));
        Pierre pierre8 = new Pierre("Noir", new Point2D.Float(4,3));
        Pierre pierre9 = new Pierre("Blanc", new Point2D.Float(3,3));
        
        plateau.ajouterPierre(pierre1,joueur1);
        plateau.ajouterPierre(pierre2,joueur1);
        plateau.ajouterPierre(pierre3,joueur1);
        plateau.ajouterPierre(pierre4,joueur2);
        plateau.ajouterPierre(pierre5,joueur2);
        plateau.ajouterPierre(pierre6,joueur2);
        plateau.ajouterPierre(pierre7,joueur2);
        plateau.ajouterPierre(pierre8,joueur1);
        
        System.out.println(plateau.toString());
        
        
        assertEquals(1,plateau.ajouterPierre(pierre9,joueur2));

    }
    
    
    
    /**
     * Test de la fonction ajouterPierre pour une situation de ko
     */
    @Test
    public void testSucidePierre()
    {
        PlateauDeJeu plateau = new PlateauDeJeu(11);
        Joueur joueur1 = new Joueur("Noir");
        Joueur joueur2 = new Joueur("Blanc");
        Pierre pierre1 = new Pierre("Noir", new Point2D.Float(2,1));
        Pierre pierre2 = new Pierre("Noir", new Point2D.Float(3,1));
        Pierre pierre3 = new Pierre("Noir", new Point2D.Float(1,2));
        Pierre pierre4 = new Pierre("Noir", new Point2D.Float(2,3));
        Pierre pierre5 = new Pierre("Noir", new Point2D.Float(3,3));
        Pierre pierre6 = new Pierre("Noir", new Point2D.Float(4,2));
        Pierre pierre7 = new Pierre("Blanc", new Point2D.Float(3,2));
        Pierre pierre8 = new Pierre("Blanc", new Point2D.Float(2,2));
        
        plateau.ajouterPierre(pierre1,joueur1);
        plateau.ajouterPierre(pierre2,joueur1);
        plateau.ajouterPierre(pierre3,joueur1);
        plateau.ajouterPierre(pierre4,joueur1);
        plateau.ajouterPierre(pierre5,joueur1);
        plateau.ajouterPierre(pierre6,joueur1);
        plateau.ajouterPierre(pierre7,joueur2);
  
        assertEquals(3,plateau.ajouterPierre(pierre8,joueur2));

    }
    
    
}
