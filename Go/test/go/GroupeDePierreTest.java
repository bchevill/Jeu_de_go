/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package go;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bertille
 */
public class GroupeDePierreTest {
    
    public GroupeDePierreTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of GroupeDePierre (le constructeur) method, of class GroupeDePierre.
     */
    @Test
    public void GroupeDePierre() {
        System.out.println("GroupeDePierre");
        Pierre pion= new Pierre ("noir", new Point2D.Double(2,2));
        Pierre pion2= new Pierre ("noir",new Point2D.Double(1,2));
        Pierre pion3= new Pierre ("noir",new Point2D.Double(1,3));
        ArrayList<Pierre> listPierres = new ArrayList<>();
        listPierres.add(pion);
        listPierres.add(pion2);
        listPierres.add(pion3);
        PlateauDeJeu plateau = new PlateauDeJeu(10);
        GroupeDePierre result = new GroupeDePierre(pion);
        ArrayList<Pierre> expresult = listPierres;
        assertEquals(expresult, result);
    }
    
}
