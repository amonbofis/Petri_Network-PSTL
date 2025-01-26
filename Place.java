import java.util.ArrayList;

public class Place {
    private int nbJetonMax;
    private int nbJeton;
    private int numId;
    private MatriceEntree transEntree;
    private MatriceSortie transSortie;


    // Constructor
    public Place(int nbJetonMax, int nbJeton, int numId) {
        this.nbJetonMax = nbJetonMax;
        this.nbJeton = nbJeton;
        this.numId = numId;
        this.transEntree = new MatriceEntree();
        this.transSortie = new MatriceSortie();
    }

    public Place createPlace(int nbJetonMax, int nbJeton, int numId){
        return new Place(nbJetonMax, nbJeton, numId);
    }

    // Getters and Setters

    public int getNbJeton() {
        return nbJeton;
    }

    public void setNbJeton(int nbJeton) {
        this.nbJeton += nbJeton;
    }

    public void deleteJeton(int nbJeton) {
        this.nbJeton -= nbJeton;
    }

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

    public MatriceEntree getTransEntree() {
        return transEntree;
    }

    public void setTransEntree(MatriceEntree transEntree) {
        this.transEntree = transEntree;
    }

    public MatriceSortie getTransSortie() {
        return transSortie;
    }

    public void setTransSortie(MatriceSortie transSortie) {
        this.transSortie = transSortie;
    }
}
