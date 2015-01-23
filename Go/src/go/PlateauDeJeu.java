package go;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



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
    
    //Déclaration des constantes car SonarQube n'aime pas les "magic number"
    public static final int PETIT_PLATEAU = 9;
    public static final int PLATEAU_MOYEN = 11;
    public static final int GRAND_PLATEAU = 19;
    
    public static final int FLAG_OK = 0;
    public static final int FLAG_SUICIDE = 3;
    public static final int FLAG_KO = 1;
    public static final int FLAG_OCCUPE = 2;

    
    
    


    /* Variables de classes */
    List<Pierre> plateau;
    int taille;
    Point2D ko;

    /* Constructeurs */
    /**
     *
     * @param taille La taille du plateau
     */
    public PlateauDeJeu(int taille) {
        this.taille = taille;
        plateau = new ArrayList<Pierre>();
    }

    /* Getters et Setters */
    public void setKo(Point2D ko) {
        this.ko = ko;
    }

    public Pierre getPierre(Point2D pierrePos) throws ExceptionNoPierreExist {
        for (Pierre pierre : plateau) {
            if (pierre.getPosition().equals(pierrePos)) {
                return pierre;
            }
        }
        throw new ExceptionNoPierreExist();
    }

    public List<Pierre> getPierres() {
        return plateau;
    }

    public int getTaille() {
        return taille;
    }
    
    public static int entrerTaille(){
        // On demande à l'utilisateur la taille du plateau
        int taille = -1;
        
        while (taille != PETIT_PLATEAU && taille != PLATEAU_MOYEN && taille != GRAND_PLATEAU) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Rentrer la taille du plateau de jeu : (9, 11 ou 19) :");  //NOSONAR
            while (!scanner.hasNextInt()) {
                System.out.println("Ce n'est pas un nombre !"); //NOSONAR
                scanner.next();
            }
            taille = scanner.nextInt();
        }
        return taille;
    }

    /* Méthodes de classes */
    /**
     * Dit si la pierre que l'on veut ajouter est dans une situation de ko
     *
     * @param pierrePos Position de la pierre que l'on veut tester
     * @return true si on est en situation de ko, false sinon
     */
    private boolean ko(Point2D pierrePos) {
        if (pierrePos.equals(ko)) {
            return true;
        }
        return false;
    }

    /**
     * Dit si la case indiqué est vide ou non
     *
     * @param pierrePos Position de la pierre que l'on veut tester
     * @return true si l'emplacement est libre, false sinon
     */
    public boolean estVide(Point2D pierrePos) {
        if (plateau != null) {
            for (Pierre pierre : plateau) {
                if (pierre.getPosition().equals(pierrePos)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Ajoute la pierre sur le plateau
     *
     * @param pierre Pierre que l'on veut ajouter
     * @return 0 si aucun probleme, 1 si problème de ko, 2 si l'emplacement est
     * déjà pris et 3 s'il y a suicide.
     */
    public int ajouterPierre(Pierre pierre, Joueur joueur) {
        
        GroupeDePierre groupe;
        
        // Message à renvoyer
        int flag; 

        //Vérifie si la pierre ne remplit pas les conditions de ko
        if (!ko(pierre.getPosition())) {
            // Vérifie si la position est libre
            if (estVide(pierre.getPosition())) {
                plateau.add(pierre);
                groupe = new GroupeDePierre(pierre, this);
                groupe.captureSiBesoin(this, joueur);
                if (groupe.nbLibertes(this) == 0) {
                    // C'est un suicide
                    flag = FLAG_SUICIDE; 
                    plateau.remove(pierre);
                } else {
                    //On verifie les captures
                    flag = FLAG_OK;
                }
            } else {
                // L'emplacement est déjà pris
                flag = FLAG_OCCUPE; 
            }
        } else {
            // C'est un KO
            flag = FLAG_KO; 
        }
        return flag;
    }
    
    /** 
     * Affiche le message lié au résultat de ajouterPierre
     * @param okAjouterPierre 
     */
    public void afficherPose(int okAjouterPierre){
        switch (okAjouterPierre) {
            case FLAG_OK:
                System.out.println("La pierre est posée"); //NOSONAR
                break;
            case FLAG_KO:
                System.out.println("La pierre n'a pas pu etre posée : \n Il y a un problème de KO"); //NOSONAR
                break;
            case FLAG_OCCUPE:
                System.out.println("La pierre n'a pas pu etre posée : \n L'emplacement est déjà pris"); //NOSONAR
                break;
            case FLAG_SUICIDE:
                System.out.println("La pierre n'a pas pu etre posée : \n C'est un sucide"); //NOSONAR
                break;
            default:
                break;
        }
    }

    /**
     * Indique si la pierre est bien sur le plateau et la supprime la pierre du
     * plateau
     *
     * @param pierreSup Pierre à supprimer
     * @return 1 si la pierre à bien été supprimé, 0 si la pierre n'a été trouvé
     */
    public boolean supprimerPierre(Pierre pierreSup) {
        return plateau.remove(pierreSup);
    }

    /**
     * Fonction pour savoir si le tour se finit car il n'y a plus de degré de
     * liberté
     *
     * @return result : Revoie vrai s'il n'y a plus de degrée de liberté restant
     * sur tout le plateau (en prennant en compte toutes les pierres)
     */
    public boolean plusDegresLiberte() {
        int result = 0;
        if (plateau.isEmpty()) {
            return false;
        } else {
            for (Pierre pierre : plateau) {
                result += pierre.nbLibertes(this);
            }
        }
        return result == 0;
    }

    @Override
    /**
     * String pour afficher le plateau dans le terminal
     */
    public String toString() {
        
        
        String resultPlateau="";

        for (int i = taille - 1; i >= 0; i--) {
            for (int j = 0; j < taille; j++) {
               resultPlateau += caseToString(i,j);
                
            }
            resultPlateau += " \n";
        }
        return resultPlateau;

    }
    
    public String caseToString(int i, int j){
        
        String resultPlateau = "";
        String color = "";
        boolean isPierrePosition = false;
        for (Pierre pierre : plateau) {
            if (pierre.getPosition().getX() == j && pierre.getPosition().getY() == i) {
                isPierrePosition = true;
                if ("Noir".equals(pierre.getCouleur())) {
                    color = "Noir";
                } else {
                    color = "Blanc";
                }
            }
        }
        if (isPierrePosition) {
            if ("Blanc".equals(color)) {
                resultPlateau += "O ";
            } else {
                resultPlateau += "0 ";
            }
        } else {
            resultPlateau += "- ";
        }
        return resultPlateau;
        
    }

}
