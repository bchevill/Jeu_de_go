/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package go;

import java.awt.geom.Point2D;
import java.util.ArrayList;
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
public class PierreTest {
    
    /**
     * Test of nbLibertes method, of class Pierre. Dans un coin
     */
    @Test
    public void testNbLibertesCoin()
    {
        PlateauDeJeu plateau = new PlateauDeJeu(19);
        Joueur joueur = new Joueur("Noir");
        Pierre pierre1 = new Pierre("Rouge", new Point2D.Float(0,0));
        Pierre pierre2 = new Pierre("Jaune", new Point2D.Float(0,1));
        
        plateau.ajouterPierre(pierre1,joueur);
        plateau.ajouterPierre(pierre2,joueur);
        
        assertEquals(1,pierre1.nbLibertes(plateau));
    }
    
    /**
    * Test of nbLibertes method, of class Pierre. Sur un bord
    */
    @Test
    public void testNbLibertesBord()
    {
        PlateauDeJeu plateau = new PlateauDeJeu(19);
        Joueur joueur = new Joueur("Noir");
        Pierre pierre1 = new Pierre("Rouge", new Point2D.Float(4,4));
        Pierre pierre2 = new Pierre("Jaune", new Point2D.Float(4,5));
        
        plateau.ajouterPierre(pierre1,joueur);
        plateau.ajouterPierre(pierre2,joueur);
        
        assertEquals(3,pierre1.nbLibertes(plateau));
    }
    
        /**
     * Test of nbLibertes method, of class Pierre. En général : Lorsque toutes les cases voisines sont libres
     */
    @Test
    public void testNbLibertesGeneral()
    {
        PlateauDeJeu plateau = new PlateauDeJeu(19);
        Joueur joueur = new Joueur("Noir");
        Pierre pierre1 = new Pierre("Rouge", new Point2D.Float(0,6));
        Pierre pierre2 = new Pierre("Jaune", new Point2D.Float(0,5));
        
        plateau.ajouterPierre(pierre1,joueur);
        plateau.ajouterPierre(pierre2,joueur);
        
        assertEquals(2,pierre1.nbLibertes(plateau));
    }

}
