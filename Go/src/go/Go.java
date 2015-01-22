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
     * Constructeur ajouté sur conseil de sonarqube. La classe Go n'étant pas censé être instanciée, on évite ainsi que 
     * java ne lui crée un constructeur par défaut public. Puis on lui ajoute le //NOSONAR sinon il se plaint du fait
     * que nous avons fait une méthode vide et qu'il faudrait donc la supprimer! Aie aie pas parfaitement au point encore!
     */
    private Go(){}; //NOSONAR

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Réponse à la question "Voulez-vous passer votre tour"
        boolean reponsePasserTourJ1 = false, reponsePasserTourJ2 = false;

        //On récupère la taille voulue
        int taille = PlateauDeJeu.entrerTaille();

        // On creer les joueurs et le plateau
        PlateauDeJeu plateau = new PlateauDeJeu(taille);

        Joueur joueur1 = new Joueur("Blanc");
        Joueur joueur2 = new Joueur("Noir");

        // Joueur fictif qui désigne le joueur qui est en train de jouer. Joueur1 est le 1er joueur à jouer
        Joueur joueurActif = joueur1;

        //On vérifie les conditions de fin : Plus d'espace pour jouer ou les 2 joueurs passent leurs tours respectifs
        while (!plateau.plusDegresLiberte() && !(reponsePasserTourJ1 && reponsePasserTourJ2 )) {

            //On indique quel joueur doit jouer
            System.out.println("Début du tour de Joueur " + joueurActif.getCouleur()); //NOSONAR

            //int qui permet de vérfier que la pose de pierre s'est bien passé
            int okAjouterPierre = -1;

            //int qui permet de déterminer l'ordonnée de la nouvelle pierre OU d'indiquer que le joueur veut passer son tour (dans ce cas là =-1)
            int pierreX = -2;

            while (okAjouterPierre != 0 && pierreX != -1) {

                //On demande à l'utilisateur de rentrer l'abcisse de la pierre qu'il veut poser ou s'il veut passer son tour
                pierreX = joueurActif.entrerX(pierreX, taille);

                //Le joueur passe son tour ?
                if (pierreX == -1) {
                    //On retient que le joueur passe son tour
                    if ("Blanc".equals(joueurActif.getCouleur())) {
                        System.out.println("Le Joueur Blanc passe son tour \n"); //NOSONAR
                        reponsePasserTourJ1 = true;
                    } else {
                        System.out.println("Le Joueur Noir passe son tour \n"); //NOSONAR
                        reponsePasserTourJ2 = true;
                    }
                } else {

                    //On demande à l'utilisateur de rentrer l'ordonnée de la pierre qu'il veut poser
                    int pierreY=joueurActif.entrerY(taille);

                    //On ajoute la pierre au plateau
                    Point2D position = new Point2D.Double(pierreX - 1, pierreY - 1);
                    Pierre pierre = new Pierre(joueurActif.getCouleur(), position);

                    // On ajoute la pierre. Si ce n'est pas possible, on boucle
                    okAjouterPierre = plateau.ajouterPierre(pierre, joueurActif);
                    plateau.afficherPose(okAjouterPierre);

                    

                }
            }

            //On change de joueur
            joueurActif = "Blanc".equals(joueurActif.getCouleur()) ? joueur2 : joueur1;

            System.out.println("Fin du tour \n"); //NOSONAR
            System.out.println(plateau.toString()); //NOSONAR
            System.out.println("Nb pion capturé par Blanc : " + joueur1.getPionCapture()); //NOSONAR
            System.out.println("Nb pion capturé par Noir  : " + joueur2.getPionCapture() + "\n"); //NOSONAR
        }
        System.out.println("Fin de la Partie"); //NOSONAR

    }

}
