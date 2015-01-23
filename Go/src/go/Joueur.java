package go;

import java.awt.geom.Point2D;
import java.util.Scanner;

/**
 *Classe Joueur
 * @author bchevill
 */
public class Joueur {
    private String couleur;
    private int pionCapture;
    
    // Constructeur
    
    /**
     * 
     */
    public Joueur(String couleur){
        this.couleur=couleur;
        this.pionCapture=0;
    }
    
    //Getters and Setters
    
    /**
     * 
     * @return couleur La couleur du joueur
     */
    public String getCouleur(){
        return couleur;
    }
    
    public int getPionCapture(){
        return pionCapture;
    }
    
    public void addPionCapture(int nb){
        this.pionCapture+=nb;
    }
    
    public int entrerX(int pierre, int taille){
        
        int pierreX = pierre;
        
        //On demande à l'utilisateur de rentrer l'abcisse de la pierre qu'il veut poser ou s'il veut passer son tour
        while (pierreX < -1 || pierreX > taille || pierreX == 0) {
            Scanner scannerPosX = new Scanner(System.in);
            System.out.println("L'abscisse de la case où vous voulez poser votre pierre : (Entre 1 et " + Integer.toString(taille) + " ou -1 pour passer son tour) :"); //NOSONAR
            while (!scannerPosX.hasNextInt()) {
                System.out.println("Ce n'est pas un nombre !"); //NOSONAR
                System.out.println("L'abscisse de la case où vous voulez poser votre pierre : (Entre 1 et " + Integer.toString(taille) + " ou -1 pour passer son tour) :"); //NOSONAR
                scannerPosX.next();
            }
            pierreX = scannerPosX.nextInt();
        }
        System.out.println("Vous avez rentré l'abscisse : " + pierreX); //NOSONAR
        return pierreX;
    }
    
    public int entrerY(int taille){
        //On demande à l'utilisateur de rentrer l'ordonnée de la pierre qu'il veut poser
        int pierreY = -1;

        while (pierreY < 0 || pierreY > taille) {
            Scanner scannerPosY = new Scanner(System.in);
            System.out.println("L'ordonnée de la case où vous voulez poser votre pierre : (Entre 1 et " + Integer.toString(taille) + " ou -1 pour passer son tour) :"); //NOSONAR
            while (!scannerPosY.hasNextInt()) {
                System.out.println("Ce n'est pas un nombre !"); //NOSONAR
                System.out.println("L'ordonnée de la case où vous voulez poser votre pierre : (Entre 1 et " + Integer.toString(taille) + " ou -1 pour passer son tour) :"); //NOSONAR
                scannerPosY.next();
            }
            pierreY = scannerPosY.nextInt();
        }
        System.out.println("Vous avez rentré l'ordonné : " + pierreY); //NOSONAR
        return pierreY;
    }
    
    public void jouer(PlateauDeJeu plateau, boolean[] passerTour, int taille){
        //int qui permet de vérfier que la pose de pierre s'est bien passé
        int okAjouterPierre = -1;

        //int qui permet de déterminer l'ordonnée de la nouvelle pierre OU d'indiquer que le joueur veut passer son tour (dans ce cas là =-1)
        // Sonar se plaint de la présence d'un "magic number", mais nous n'allons pas créer une constante d'initialisation de la variable...
        int pierreX = -2;  //NOSONAR   

        while (okAjouterPierre != 0 && pierreX != -1) {

            //On demande à l'utilisateur de rentrer l'abcisse de la pierre qu'il veut poser ou s'il veut passer son tour
            pierreX = this.entrerX(pierreX, taille);

            //Le joueur passe son tour ?
            if (pierreX == -1) {
                //On retient que le joueur passe son tour
                if (Go.BLANC.equals(this.getCouleur())) {
                    System.out.println("Le Joueur Blanc passe son tour \n"); //NOSONAR
                    passerTour[0] = true;
                } else {
                    System.out.println("Le Joueur Noir passe son tour \n"); //NOSONAR
                    passerTour[1] = true;
                }
            } else {

                //On demande à l'utilisateur de rentrer l'ordonnée de la pierre qu'il veut poser
                int pierreY=this.entrerY(taille);

                //On ajoute la pierre au plateau
                Point2D position = new Point2D.Double(pierreX - 1, pierreY - 1);
                Pierre pierre = new Pierre(this.getCouleur(), position);

                // On ajoute la pierre. Si ce n'est pas possible, on boucle
                okAjouterPierre = plateau.ajouterPierre(pierre, this);
                plateau.afficherPose(okAjouterPierre);
            }
        }
    }
}
