package go;

/**
 *Classe Joueur
 * @author bchevill
 */
public class Joueur {
    private String couleur;
    
    // Constructeur
    
    /**
     * 
     */
    public Joueur(String couleur){
        this.couleur=couleur;
    }
    
    //Getters and Setters
    
    /**
     * 
     * @return couleur La couleur du joueur
     */
    public String getCouleur(){
        return couleur;
    }
    
}
