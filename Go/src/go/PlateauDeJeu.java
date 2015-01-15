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
    
    public ArrayList<Pierre> getPierres(){
        return plateau;
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
     * @return 0 si aucun probleme, 1 si problème de ko, 2 si l'emplacement
     * est déjà pris et 3 s'il y a suicide.
     */
    public int ajouterPierre(Pierre pierre)
    {
        // TODO Appeler la "fonction groupe de pierres"
        GroupeDePierre groupe;
        
        int flag; // Message à renvoyer
        
        //Vérifie si la pierre ne remplit pas les conditions de ko
        if (!ko(pierre.getPosition()))
        {
            // Vérifie si la position est libre
            if (estVide(pierre.getPosition()))
            {
                groupe = new GroupeDePierre(pierre, this);
                if(groupe.nbLibertes(this)==0){
                    flag=3; // C'est un suicide
                }
                else{
                    plateau.add(pierre);

                    //On verifie les captures
                    groupe.captureSiBesoin(this); 
                    flag=0;
                }    
            } else
            {
                flag=2; // L'emplacement est déjà pris
            }
        } else
        {
            flag=1; // C'est un KO
        }
        return flag;
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
    
    /**
     * Fonction pour savoir si le tour se fini car il n'y a plus de degré de liberté
     * @return result : Revoie 0 s'il n'y a plus de degrée de liberté restant sur tout le plateau (en prennant en compte toutes les pierres)
     */
    public boolean resteDegreeLiberte(){
        int result=0;
            if(plateau.isEmpty()){
                return false;
            }
            else{
                for(Pierre pierre : plateau){
                    result+=pierre.nbLibertes(this);
                }
            }
        return result==0;
    }
    
    @Override
    public String toString(){
        String resultPlateau="";
        
        boolean isPierrePosition;
        String color="";
        
        for(int i=taille-1;i>=0;i--){
            for(int j=0;j<taille;j++){
                isPierrePosition=false;
                for(Pierre pierre : plateau){
                    if(pierre.getPosition().getX()==j && pierre.getPosition().getY()==i){
                        isPierrePosition=true;
                        if(pierre.getCouleur().equals("Noir")){
                            color="Noir";
                        }
                        else{
                            color="Blanc";
                        }
                    }
                }
                if(isPierrePosition){
                    if(color=="Blanc"){
                        resultPlateau+="O ";
                    }
                    else{
                        resultPlateau+="0 ";
                    }
                }
                else{
                    resultPlateau+="- ";
                }
            }
            resultPlateau+=" \n";
        }
        return resultPlateau;
        
    }
        
}
