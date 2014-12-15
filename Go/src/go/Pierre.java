package go;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *Classe Pierre
 * @author bchevill
 */
public class Pierre {
    private String couleur;
    private Point2D position;

    /**
     * Constructeur par défaut
     * @param couleur
     * @param position 
     */
    public Pierre(String couleur, Point2D position) {
        this.couleur = couleur;
        this.position = position;
    }

     
    /**
     * Getters et setters de position
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
     * @return 
     */
    public int nbLibertes(PlateauDeJeu plateau){
        int ret=0;
        Point2D pos=this.getPosition();
        
            if (plateau.estVide(new Point2D.Double(pos.getX()-1,pos.getY()))){
                ret++;}
            if(plateau.estVide(new Point2D.Double(pos.getX(),pos.getY()+1))){
                ret++;}
            if (plateau.estVide(new Point2D.Double(pos.getX()+1,pos.getY()))){
                ret++;}
            if(plateau.estVide(new Point2D.Double(pos.getX(),pos.getY()-1))){
                ret++;}
        return ret;
    }
    /**
     * Méthode permettant de vérifier que la pierre ne se suicide pas
     * si true : la pierre se suicide
     * @return 
     */
    public boolean verifSuicide (PlateauDeJeu plateau){
        boolean ret=false;
            if (this.nbLibertes(plateau)==0){
            ret=true;
            }
        return ret;        
    }
    
    /**
     * Méthode permettant de renvoyer la liste des cases de même couleur situées autour de la case étudiée
     * @param plateau
     * @return 
     */
    public ArrayList<Pierre> amiesVoisines(PlateauDeJeu plateau){
        ArrayList<Pierre> ret=new ArrayList<Pierre>();
        Point2D pos=this.getPosition();
        try {
            if (!(plateau.estVide(new Point2D.Double(pos.getX()-1,pos.getY())))
                    &&(this.couleur.equals(plateau.getPierre(new Point2D.Double(pos.getX()-1,pos.getY())).getCouleur()))){
                    ret.add(plateau.getPierre(new Point2D.Double(pos.getX()-1,pos.getY())));}
        } catch (ExceptionNoPierreExist ex) {
            Logger.getLogger(Pierre.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (!(plateau.estVide(new Point2D.Double(pos.getX(),pos.getY()+1)))
                    &&(this.couleur.equals(plateau.getPierre(new Point2D.Double(pos.getX(),pos.getY()+1)).getCouleur()))){
                     ret.add(plateau.getPierre(new Point2D.Double(pos.getX(),pos.getY()+1)));}
        } catch (ExceptionNoPierreExist ex) {
            Logger.getLogger(Pierre.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (!(plateau.estVide(new Point2D.Double(pos.getX()+1,pos.getY())))
                    &&(this.couleur.equals(plateau.getPierre(new Point2D.Double(pos.getX()+1,pos.getY())).getCouleur()))){
                     ret.add(plateau.getPierre(new Point2D.Double(pos.getX()+1,pos.getY())));}
        } catch (ExceptionNoPierreExist ex) {
            Logger.getLogger(Pierre.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (!(plateau.estVide(new Point2D.Double(pos.getX(),pos.getY()-1)))
                &&(this.couleur==plateau.getPierre(new Point2D.Double(pos.getX(),pos.getY()-1)).getCouleur())){
                     ret.add(plateau.getPierre(new Point2D.Double(pos.getX(),pos.getY()-1)));}
        } catch (ExceptionNoPierreExist ex) {
            Logger.getLogger(Pierre.class.getName()).log(Level.SEVERE, null, ex);
        }
       return ret; 
    }
    /**
     * Méthode permettant de renvoyer la liste des cases de couleur opposée situées autour de la case étudiée
     * @param plateau
     * @return 
     */
    public ArrayList<Pierre> ennemiesVoisines(PlateauDeJeu plateau){
        ArrayList<Pierre> ret=new ArrayList<Pierre>();
        Point2D pos=this.getPosition();
        try {
            if (!(plateau.estVide(new Point2D.Double(pos.getX()-1,pos.getY())))
                    &&(this.couleur!=plateau.getPierre(new Point2D.Double(pos.getX()-1,pos.getY())).getCouleur())){
                    ret.add(plateau.getPierre(new Point2D.Double(pos.getX()-1,pos.getY())));}
        } catch (ExceptionNoPierreExist ex) {
            Logger.getLogger(Pierre.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (!(plateau.estVide(new Point2D.Double(pos.getX(),pos.getY()+1)))
                    &&(this.couleur!=plateau.getPierre(new Point2D.Double(pos.getX(),pos.getY()+1)).getCouleur())){
                     ret.add(plateau.getPierre(new Point2D.Double(pos.getX(),pos.getY()+1)));}
        } catch (ExceptionNoPierreExist ex) {
            Logger.getLogger(Pierre.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (!(plateau.estVide(new Point2D.Double(pos.getX()+1,pos.getY())))
                    &&(this.couleur!=plateau.getPierre(new Point2D.Double(pos.getX()+1,pos.getY())).getCouleur())){
                     ret.add(plateau.getPierre(new Point2D.Double(pos.getX()+1,pos.getY())));}
        } catch (ExceptionNoPierreExist ex) {
            Logger.getLogger(Pierre.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (!(plateau.estVide(new Point2D.Double(pos.getX(),pos.getY()-1)))
                &&(this.couleur!=plateau.getPierre(new Point2D.Double(pos.getX(),pos.getY()-1)).getCouleur())){
                     ret.add(plateau.getPierre(new Point2D.Double(pos.getX(),pos.getY()-1)));}
        } catch (ExceptionNoPierreExist ex) {
            Logger.getLogger(Pierre.class.getName()).log(Level.SEVERE, null, ex);
        }
       return ret; 
    }
}
