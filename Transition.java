import java.util.ArrayList;

public class Transition {
    private int nbJetonMax; 
    private int numId; 
    private MatriceEntree placesEntree; 
    private MatriceSortie placesSortie; 
    
    // Constructor
    public Transition(int nbJetonMax, int numId) {
        this.nbJetonMax = nbJetonMax;
        this.numId = numId;
        this.placesEntree = new MatriceEntree();
        this.placesSortie = new MatriceSortie();
    }

    public Transition createTrans(int nbJetonMax, int numId){
        return new Transition(nbJetonMax, numId);
    }

    // Getters and Setters
    public int getNbJetonMax() {
        return nbJetonMax;
    }

    public void setNbJetonMax(int nbJetonMax) {
        this.nbJetonMax = nbJetonMax;
    }

    public int getNumId() {
        return numId;
    }

    public void setNumId(int numId) {
        this.numId = numId;
    }

    public MatriceEntree getPlacesEntree() {
        return placesEntree;
    }

    public void setPlacesEntree(MatriceEntree placesEntree) {
        this.placesEntree = placesEntree;
    }

    public MatriceSortie getPlacesSortie() {
        return placesSortie;
    }

    public void setPlacesSortie(MatriceSortie placesSortie) {
        this.placesSortie = placesSortie;
    }
}