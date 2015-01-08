package go;

import java.awt.geom.Point2D;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author NguyenQuoc
 */
public class PlateauDeJeu {

    /* Variables de classes */
    ArrayList<Pierre> plateau;
    int taille;
    Point2D ko;

    /* Constructeurs */
    /**
     *
     * @param taille La taille du plateau
     */
    public PlateauDeJeu(int taille)
    {
        this.taille = taille;
        plateau = new ArrayList<Pierre>();
    }

    /* Getters et Setters */
    public void setKo(Point2D ko)
    {
        this.ko = ko;
    }
    
    public Pierre getPierre(Point2D pierrePos) throws ExceptionNoPierreExist
    {
        for(Pierre pierre : plateau)
        {
            if (pierre.getPosition().equals(pierrePos))
            {
                return pierre;
            }
        }
        throw new ExceptionNoPierreExist();
    }
    
    public int getTaille(){
        return taille;
    }

    /* Méthodes de classes */
    
    /**
     * Dit si la pierre que l'on veut ajouter est dans une situation de ko
     * @param pierrePos Position de la pierre que l'on veut tester
     * @return true si on est en situation de ko, false sinon
     */
    private boolean ko(Point2D pierrePos)
    {
        if(pierrePos.equals(ko))
        {
            return true;
        }
        return false;
    }

    /**
     * Dit si la case indiqué est vide ou non
     * @param pierrePos Position de la pierre que l'on veut tester
     * @return  true si l'emplacement est libre, false sinon
     */
    public boolean estVide(Point2D pierrePos)
    {
        if(plateau!=null){
            for(Pierre pierre : plateau)
            {
                if (pierre.getPosition().equals(pierrePos))
                {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Ajoute la pierre sur le plateau
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
     * Indique si la pierre est bien sur le plateau et la supprime la pierre du plateau
     * @param pierreSup Pierre à supprimer
     * @return 1 si la pierre à bien été supprimé, 0 si la pierre n'a été trouvé
     */
    public boolean supprimerPierre(Pierre pierreSup)
    {
        return plateau.remove(pierreSup);
    }
}
