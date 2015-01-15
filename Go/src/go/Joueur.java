package go;

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
    
}
