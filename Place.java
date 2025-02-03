import java.util.ArrayList;

public class Place {
    private int nbJetonMax;
    private int nbJeton; // should be replace by ArrayList<Jeton>
    private int numId;
    private ArrayList<Transition> transEntrees;
    private ArrayList<Transition> transSorties;

    // Constructor
    public Place(int nbJetonMax, int nbJeton, int numId,
            ArrayList<Transition> transEntrees, ArrayList<Transition> transSorties) {
        this.nbJetonMax = nbJetonMax;
        this.nbJeton = nbJeton;
        this.numId = numId;
        this.transEntrees = transEntrees;
        this.transSorties = transSorties;
    }

    public int getNbJeton() {
        return nbJeton;
    }

    public void setNbJeton(int nbJeton) {
        this.nbJeton = nbJeton;
    }

    public ArrayList<Transition> getTransEntrees() {
        return transEntrees;
    }

    public ArrayList<Transition> getTransSorties() {
        return transSorties;
    }
}