package go;

import java.awt.geom.Point2D;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author NguyenQuoc
 */
public class plateauDeJeu {

    /* Variables de classes */
    ArrayList<Pierre> plateau;
    int taille;
    Point2D ko;

    /* Constructeurs */
    /**
     *
     * @param taille La taille du plateau
     */
    public plateauDeJeu(int taille)
    {
        this.taille = taille;
    }

    /* Getters et Setters */
    public setKo(Point2D ko)
    {
        this.ko = ko;
    }

    /* Méthodes de classes */
    
    /**
     * 
     * @param pierrePos Position de la pierre que l'on veut tester
     * @return true si on est en situation de ko, false sinon
     */
    private boolean ko(Point2D pierrePos)
    {
        if (pierrePos.equals(ko))
        {
            return true;
        }
        return false;
    }

    /**
     * 
     * @param pierrePos Position de la pierre que l'on veut tester
     * @return  true si l'emplacement est libre, false sinon
     */
    public boolean estVide(Point2D pierrePos)
    {
        for (Pierre pierre : plateau)
        {
            if (pierre.getPosition().equals(pierrePos))
            {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param pierre Pierre que l'on veut ajouter
     * @return 0 si aucun probleme, 1 si problème de ko et 2 si l'emplacement
     * est déjà pris
     */
    public int ajouterPierre(Pierre pierre)
    {

        //Vérifie si la pierre ne remplit pas les conditions de ko
        if (!ko(pierre.getPosition()))
        {
            // Vérifie si la position est libre
            if (estVide(pierre.getPosition()))
            {
                plateau.add(pierre);
                return 0;
            } else
            {
                return 2;
            }
        } else
        {
            return 1;
        }
    }
    
    /**
     * 
     * @param pierreSup Pierre à supprimer
     * @return 1 si la pierre à bien été supprimé, 0 si la pierre n'a été trouvé
     */
    public boolean supprimerPierre(Pierre pierreSup)
    {
        for (Pierre pierre : plateau)
        {
            return plateau.remove(pierre);
        }
    }
}
