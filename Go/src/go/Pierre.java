package go;

import java.awt.geom.Point2D;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe Pierre
 *
 * @author bchevill
 */
public class Pierre {

    private String couleur;
    private Point2D position;

    /**
     * Constructeur par défaut
     *
     * @param couleur
     * @param position
     */
    public Pierre(String couleur, Point2D position) {
        this.couleur = couleur;
        this.position = position;
    }

    /**
     * Getters et setters de position
     *
     * @return
     */
    public Point2D getPosition() {
        return position;
    }

    public void setPosition(Point2D position) {
        this.position = position;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    /**
     * Méthode permettant de retourner le nombre de libertés d'une pierre
     *
     * @return
     */
    public int nbLibertes(PlateauDeJeu plateau) {
        int ret = 0;
        Point2D pos = this.getPosition();

        if (plateau.estVide(new Point2D.Double(pos.getX() - 1, pos.getY())) && (pos.getX() - 1) >= 0) {
            ret++;
        }
        if (plateau.estVide(new Point2D.Double(pos.getX(), pos.getY() + 1)) && (pos.getY() + 1) < plateau.getTaille()) {
            ret++;
        }
        if (plateau.estVide(new Point2D.Double(pos.getX() + 1, pos.getY())) && (pos.getX() + 1) < plateau.getTaille()) {
            ret++;
        }
        if (plateau.estVide(new Point2D.Double(pos.getX(), pos.getY() - 1)) && (pos.getY() - 1) >= 0) {
            ret++;
        }
        return ret;
    }

    /**
     * Méthode permettant de vérifier que la pierre ne se suicide pas si true :
     * la pierre se suicide
     *
     * @return
     */
    public boolean verifSuicide(PlateauDeJeu plateau) {
        boolean ret = false;
        if (this.nbLibertes(plateau) == 0) {
            ret = true;
        }
        return ret;
    }

    /**
     * Méthode permettant de renvoyer la liste des cases de même couleur situées
     * autour de la case étudiée
     *
     * @param plateau
     * @return
     */
    public List<Pierre> amiesVoisines(PlateauDeJeu plateau) {
        List<Pierre> ret = new ArrayList<Pierre>();
        Point2D pos = this.getPosition();
        try {
            if (!(plateau.estVide(new Point2D.Double(pos.getX() - 1, pos.getY())))
                    && (this.couleur.equals(plateau.getPierre(new Point2D.Double(pos.getX() - 1, pos.getY())).getCouleur()))) {
                ret.add(plateau.getPierre(new Point2D.Double(pos.getX() - 1, pos.getY())));
            }
            if (!(plateau.estVide(new Point2D.Double(pos.getX(), pos.getY() + 1)))
                    && (this.couleur.equals(plateau.getPierre(new Point2D.Double(pos.getX(), pos.getY() + 1)).getCouleur()))) {
                ret.add(plateau.getPierre(new Point2D.Double(pos.getX(), pos.getY() + 1)));
            }
            if (!(plateau.estVide(new Point2D.Double(pos.getX() + 1, pos.getY())))
                    && (this.couleur.equals(plateau.getPierre(new Point2D.Double(pos.getX() + 1, pos.getY())).getCouleur()))) {
                ret.add(plateau.getPierre(new Point2D.Double(pos.getX() + 1, pos.getY())));
            }
            if (!(plateau.estVide(new Point2D.Double(pos.getX(), pos.getY() - 1)))
                    && (this.couleur == plateau.getPierre(new Point2D.Double(pos.getX(), pos.getY() - 1)).getCouleur())) {
                ret.add(plateau.getPierre(new Point2D.Double(pos.getX(), pos.getY() - 1)));
            }
        } catch (ExceptionNoPierreExist ex) {
            Logger.getLogger(Pierre.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    /**
     * Méthode permettant de renvoyer la liste des cases de couleur opposée
     * situées autour de la case étudiée
     *
     * @param plateau
     * @return
     */
    public List<Pierre> ennemiesVoisines(PlateauDeJeu plateau) {
        List<Pierre> ret = new ArrayList<Pierre>();
        Point2D pos = this.getPosition();
        try {
            if (!(plateau.estVide(new Point2D.Double(pos.getX() - 1, pos.getY())))
                    && (this.couleur != plateau.getPierre(new Point2D.Double(pos.getX() - 1, pos.getY())).getCouleur())) {
                ret.add(plateau.getPierre(new Point2D.Double(pos.getX() - 1, pos.getY())));
            }
            if (!(plateau.estVide(new Point2D.Double(pos.getX(), pos.getY() + 1)))
                    && (this.couleur != plateau.getPierre(new Point2D.Double(pos.getX(), pos.getY() + 1)).getCouleur())) {
                ret.add(plateau.getPierre(new Point2D.Double(pos.getX(), pos.getY() + 1)));
            }
            if (!(plateau.estVide(new Point2D.Double(pos.getX() + 1, pos.getY())))
                    && (this.couleur != plateau.getPierre(new Point2D.Double(pos.getX() + 1, pos.getY())).getCouleur())) {
                ret.add(plateau.getPierre(new Point2D.Double(pos.getX() + 1, pos.getY())));
            }
            if (!(plateau.estVide(new Point2D.Double(pos.getX(), pos.getY() - 1)))
                    && (this.couleur != plateau.getPierre(new Point2D.Double(pos.getX(), pos.getY() - 1)).getCouleur())) {
                ret.add(plateau.getPierre(new Point2D.Double(pos.getX(), pos.getY() - 1)));
            }
        } catch (ExceptionNoPierreExist ex) {
            Logger.getLogger(Pierre.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    /**
     * Cherche a savoir si les 2 pierres sont cote à cote (en forme de + : juste
     * au dessous, en dessous, a droite ou a gauche)
     *
     * @param pierre2 La deuxieme pierre
     * @return true si elles sont cote à cote, false sinon
     */
    public boolean estACoteDe(Pierre pierre2) {
        
        return (pierre2.getPosition().getX() == position.getX() + 1 && pierre2.getPosition().getY() == position.getY())     //NOSONAR
                || (pierre2.getPosition().getX() == position.getX() - 1 && pierre2.getPosition().getY() == position.getY())
                || (pierre2.getPosition().getX() == position.getX() && pierre2.getPosition().getY() == position.getY() - 1)
                || (pierre2.getPosition().getX() == position.getX() && pierre2.getPosition().getY() == position.getY() + 1); 
    }
}
