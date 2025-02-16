package test;
import java.util.ArrayList;

public class Transition {
    private int nbJetonMax;
    private int numId;
    private ArrayList<Place> placeEntre;
    private ArrayList<Place> placeSortie;

    // Constructor
    public Transition(int nbJetonMax, int numId, ArrayList<Place> entree, ArrayList<Place> sortie) {
        this.nbJetonMax = nbJetonMax;
        this.numId = numId;
        this.placeEntre = entree;
        this.placeSortie = sortie;
    }

    public int numId() {
        return numId;
    }

    public ArrayList<Place> getPlacesEntrees() {
        return placeEntre;
    }

    public ArrayList<Place> getPlacesSorties() {
        return placeSortie;
    }

}