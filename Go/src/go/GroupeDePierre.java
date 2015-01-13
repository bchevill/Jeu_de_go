/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package go;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author NguyenQuoc
 */
public class GroupeDePierre {
    /* Variables de classe*/

    ArrayList<Pierre> pierres;

    /* Constructeurs */
    /**
     * Creer un groupe de pierres
     * @param pierre la noouvelle pierre à ajouter au groupe de pierres
     * @param plateau indique l'emplacement des pierres existantes pour reformer les groupes
     */
    public GroupeDePierre(Pierre pierre, PlateauDeJeu plateau) {
        pierres.add(pierre);
        Pierre traitee;
        LinkedList<Pierre> aTraiter = new LinkedList<Pierre>();
        for (Pierre pierrevoisine : pierre.amiesVoisines(plateau)) {
            aTraiter.push(pierrevoisine);
        }

        while (!aTraiter.isEmpty()) {
            traitee = aTraiter.pop();
            pierres.add(traitee);
            for (Pierre pierrevoisine : pierre.amiesVoisines(plateau)) {
                if (!pierres.contains(pierrevoisine)) {
                    aTraiter.push(pierrevoisine);
                }
            }
        }
    }

    /* Getters et Setters */
    
    /**
     * Getter de pierre
     * @return retourne la liste des pierres dans le groupe
     */
    public ArrayList<Pierre> getPierres(){
        return pierres;
    }
    /* Méthodes de classe */
    /**
     * Compte le nombre de liberté autour du groupe de pierre (afin de savoir
     * s'il est capturé ou non)
     *
     * @param plateau Le plateau de jeu
     * @return Le nombre de degré de liberté du groupe de pierre
     */
    private int nbLibertes(PlateauDeJeu plateau) {
        int somme = 0;
        for (Pierre pierre : pierres) {
            somme += pierre.nbLibertes(plateau);
        }
        return somme;
    }

    /**
     * Capture le groupe de pierres (si possible)
     *
     * @param plateau
     */
    public void capturer(PlateauDeJeu plateau) {
        if (nbLibertes(plateau) == 0) {
            for (Pierre pierre : pierres) {
                plateau.supprimerPierre(pierre);
            }
        }
    }

}
