/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package go;

import java.util.ArrayList;

/**
 *
 * @author NguyenQuoc
 */
public class GroupeDePierre {
    /* Variables de classe*/
    
    ArrayList<Pierre> pierres;
    
    /* Constructeurs */
    
    public GroupeDePierre(Pierre pierre){
        pierres.add(pierre);
        
    }
    
    /* Getters et Setters */
    
    
    /* Méthodes de classe */
    
    /**
     * Compte le nombre de liberté autour du groupe de pierre (afin de savoir s'il est capturé ou non)
     * @param plateau Le plateau de jeu
     * @return Le nombre de degré de liberté du groupe de pierre
     */
    private int nbLibertes(PlateauDeJeu plateau)
    {
        int somme=0;
        for(Pierre pierre : pierres)
        {
            somme+=pierre.nbLibertes(plateau);
        }
        return somme;
    }
    
    /**
     * Capture le groupe de pierre (si possible)
     * @param plateau 
     */
    public void capturer(PlateauDeJeu plateau)
    {
        if(nbLibertes(plateau)==0)
        {
            for(Pierre pierre : pierres)
            {
                plateau.supprimerPierre(pierre);
            }
        }
    }
    
}
