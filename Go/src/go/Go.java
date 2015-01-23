/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package go;

/**
 *
 * @author NguyenQuoc
 */
public class Go {
    
    public static final String BLANC = "Blanc";
    public static final int NB_JOUEURS = 2;
    
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
        
        boolean[] passerTour = new boolean[NB_JOUEURS];
        passerTour[0]=false;
        passerTour[1]=false;

        //On récupère la taille voulue
        int taille = PlateauDeJeu.entrerTaille();

        // On creer les joueurs et le plateau
        PlateauDeJeu plateau = new PlateauDeJeu(taille);

        Joueur joueur1 = new Joueur(BLANC);
        Joueur joueur2 = new Joueur("Noir");

        // Joueur fictif qui désigne le joueur qui est en train de jouer. Joueur1 est le 1er joueur à jouer
        Joueur joueurActif = joueur1;

        //On vérifie les conditions de fin : Plus d'espace pour jouer ou les 2 joueurs passent leurs tours respectifs
        while (!plateau.plusDegresLiberte() && !(passerTour[0] && passerTour[1] )) {

            //On indique quel joueur doit jouer
            System.out.println("Début du tour de Joueur " + joueurActif.getCouleur()); //NOSONAR

            joueurActif.jouer(plateau, passerTour, taille);
            
            //On change de joueur
            joueurActif = BLANC.equals(joueurActif.getCouleur()) ? joueur2 : joueur1;

            System.out.println("Fin du tour \n"); //NOSONAR
            System.out.println(plateau.toString()); //NOSONAR
            System.out.println("Nb pion capturé par Blanc : " + joueur1.getPionCapture()); //NOSONAR
            System.out.println("Nb pion capturé par Noir  : " + joueur2.getPionCapture() + "\n"); //NOSONAR
        }
        System.out.println("Fin de la Partie"); //NOSONAR

    }

}
