package go;

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
}
