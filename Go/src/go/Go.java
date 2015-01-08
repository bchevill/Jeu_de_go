/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package go;

import java.awt.geom.Point2D;
import java.util.*;

/**
 *
 * @author NguyenQuoc
 */
public class Go {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {

        int taille = -1;

        // Réponse à la question "Voulez-vous passer votre tour"
        boolean reponsePasserTourJ1 = false, reponsePasserTourJ2 = false;

        // On demande à l'utilisateur la taille du plateau
        while (taille != 9 && taille != 11 && taille != 19)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Rentrer la taille du plateau de jeu : (9, 11 ou 19) :");
            taille = scanner.nextInt();
        }

        // On creer les joueurs et le plateau
        PlateauDeJeu plateau = new PlateauDeJeu(taille);

        Joueur joueur1 = new Joueur("Blanc");
        Joueur joueur2 = new Joueur("Noir");

        // Joueur fictif qui désigne le joueur qui est en train de jouer
        Joueur joueurActif = new Joueur("Gris");

        // Joueur1 est le 1er joueur à jouer
        joueurActif = joueur1;

        //On vérifie les conditions de fin : Plus d'espace pour jouer ou les 2 joueurs passe leurs tours respectifs
        while (plateau.resteDegreeLiberte() == false && !(reponsePasserTourJ1 == true && reponsePasserTourJ2 == true))
        {

            //On indique quel joueur doit jouer
            System.out.println("Début du tour de Joueur " + joueurActif.getCouleur());

            //int qui permet de vérfier que la pose de pierre s'est bien passé
            int okAjouterPierre = -1;

            //int qui permet de déterminé l'ordonnée de la nouvelle pierre OU d'indiquer que le joueur veut passer son tour (dans ce cas là =-1)
            int pierreX = -2;

            while (okAjouterPierre != 0 && pierreX != -1)
            {

                //On demande à l'utilisateur de rentrer l'abcisse de la pierre qu'il veut poser ou s'il veut passer son tour
                while (pierreX < -1 || pierreX > taille-1)
                {
                    Scanner scannerPosX = new Scanner(System.in);
                    System.out.println("L'abscisse de la case où vous voulez poser votre pierre : (Entre 0 et " + Integer.toString(taille - 1) + " ou -1 pour passer son tour) :");
                    pierreX = scannerPosX.nextInt();
                }

                //Le joueur passe son tour ?
                if (pierreX == -1)
                {
                    //On retient que le joueur passe son tour
                    if (joueurActif.getCouleur().equals("Blanc"))
                    {
                        System.out.println("Le Joueur Blanc passe son tour \n");
                        reponsePasserTourJ1 = true;
                    } else
                    {
                        System.out.println("Le Joueur Noir passe son tour \n");
                        reponsePasserTourJ2 = true;
                    }
                } else
                {

                    //On demande à l'utilisateur de rentrer l'ordonnée de la pierre qu'il veut poser
                    int pierreY = -1;

                    while (pierreY < 0 || pierreY > taille-1)
                    {
                        Scanner scannerPosY = new Scanner(System.in);
                        System.out.println("L'ordonnée de la case où vous voulez poser votre pierre : (Entre 0 et " + Integer.toString(taille - 1) + " ou -1 pour passer son tour) :");
                        pierreY = scannerPosY.nextInt();
                    }

                    //On ajoute la pierre au plateau
                    Point2D position = new Point2D.Double(pierreX, pierreY);
                    Pierre pierre = new Pierre(joueurActif.getCouleur(), position);

                    // On ajoute la pierre. Si ce n'est pas possible, on boucle
                    okAjouterPierre = plateau.ajouterPierre(pierre);
                    
                    switch (okAjouterPierre) {
                        case 0 :
                            System.out.println("La pierre est posée");
                            break;
                        case 1 :
                            System.out.println("La pierre n'a pas pu etre posée : \n Il y a un problème de KO");
                            break;
                        case 2 :
                            System.out.println("La pierre n'a pas pu etre posée : \n L'emplacement est déjà pris");
                            break;
                    }
                    
                }
            }

            //On change de joueur
            joueurActif = joueurActif.getCouleur().equals("Blanc") ? joueur2 : joueur1;
            
            System.out.println("Fin du tour \n");
        }
        
        System.out.println("Fin de la Partie");

    }

}
