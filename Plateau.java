import java.util.ArrayList;

public class Plateau {
    ArrayList<Place> places;
    ArrayList<Transition> transitions;
    ArrayList<Jeton> jetons;
    // MatriceEntree matE;
    // MatriceSortie matS;
    int[][] matE;
    int[][] matS;

    public Plateau(ArrayList<Place> places, 
                    ArrayList<Transition> transitions,
                    ArrayList<Jeton> jetons,
                    int[][] matE,
                    int[][] matS){
                        this.places = places;
                        this.transitions = transitions;
                        this.jetons = jetons;
                        this.matE= matE;
                        this.matS = matS;
    }

    public void showPlateau(){
        int i = 0;
        System.out.print("(");
        for(Place p: places){
            if(i != (places.size() -1)){
                System.out.print(p.getNbJeton() + ", ");
            }else{
                System.out.print(p.getNbJeton());
            }  
            i++;  
        }
        System.out.print(")\n");
    }


    // Getters
    public ArrayList<Place> getPlaces() {
        return places;
    }

    public ArrayList<Transition> getTransitions() {
        return transitions;
    }

    public ArrayList<Jeton> getJetons() {
        return jetons;
    }

    public int[][] getMatE() {
        return matE;
    }

    public int[][] getMatS() {
        return matS;
    }

    // Setters
    public void setPlaces(ArrayList<Place> places) {
        this.places = places;
    }

    public void setTransitions(ArrayList<Transition> transitions) {
        this.transitions = transitions;
    }

    public void setJetons(ArrayList<Jeton> jetons) {
        this.jetons = jetons;
    }

    public void showMatEntree(){
        for(int a=0; a<places.size(); a++){
            System.out.print("(");
            for(int c=0; c<transitions.size(); c++ ){
                System.out.print(matE[a][c] +" ");
            }
            System.out.println(")");
        }
    }

    public void showMatSortie(){
        for(int a=0; a<places.size(); a++){
            System.out.print("(");
            for(int c=0; c<transitions.size(); c++ ){
                System.out.print(matS[a][c] +" ");
            }
            System.out.println(")");
        }
    }

    public void update() {
        
        for(int i =0; i<matE.length; i++){
            for(int j =0; j<matE[1].length; j++){
                //check transition that exists in the network
                if(matE[i][j] != 0){

                    // check if there are enough jeton in the place to start the transition
                    if(places.get(i).getNbJeton() >= matE[i][j]){

                        //delete the jetons that are consummed in the transition
                        places.get(i).deleteJeton(matE[i][j]);
                        boolean updated = false;
                        for(int b =0; b<matS.length; b++){
                            if(matS[b][j] != 0){      
                                places.get(b).setNbJeton(matS[b][j]);
                                updated = true;
                            }                                
                        }
                        if(updated){
                            return; // this is to do only one transition by tour, for now the first avaible
                        }
                    }
                }
            }
        }
    }

    /*public void setMatE(MatriceEntree matE) {
        this.matE = matE;
    }

    public void setMatS(MatriceSortie matS) {
        this.matS = matS;
    }*/

}
