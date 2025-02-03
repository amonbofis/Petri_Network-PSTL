import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Plateau {
    ArrayList<Place> places;
    ArrayList<Transition> transitions;
    ArrayList<Jeton> jetons;

    public Plateau(ArrayList<Place> places,
            ArrayList<Transition> transitions,
            ArrayList<Jeton> jetons) {
        this.places = places;
        this.transitions = transitions;
        this.jetons = jetons;
    }

    public void showPlateau() {
        int i = 0;
        System.out.print("(");
        for (Place p : places) {
            if (i != (places.size() - 1)) {
                System.out.print(p.getNbJeton() + ", ");
            } else {
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

    public void activateTransition(Transition transition) {
        for (Place place : transition.getPlacesEntrees())
            place.setNbJeton(place.getNbJeton() - 1);
        for (Place place : transition.getPlacesSorties())
            place.setNbJeton(place.getNbJeton() + 1);
    }

    public Set<Transition> update() {

        Set<Transition> transitionsPossibles = new HashSet<>();

        for (Place place : places) {

            if (place.getNbJeton() > 0) {
                for (Transition tr_sortie : place.getTransSorties()) {

                    boolean appendTrans = true;
                    for (Place place_entree : tr_sortie.getPlacesEntrees()) {

                        if (place_entree.getNbJeton() == 0) {
                            appendTrans = false;
                            break;
                        }
                    }

                    if (appendTrans)
                        transitionsPossibles.add(tr_sortie);
                }
            }
        }

        return transitionsPossibles;
    }

    public void randomTransition(int maxTransitions) {
        Random random = new Random();

        for (int i = 0; i < maxTransitions; i++) {
            Set<Transition> transitionsPossibles = update();
            System.out.print("Transition possible : ");

            for (Transition t : transitionsPossibles)
                System.out.print("t" + t.numId() + " ");

            System.out.println();

            if (transitionsPossibles.isEmpty()) {
                System.out.println("Aucune transition possible.");
                break;
            }

            List<Transition> listeTransitions = new ArrayList<>(transitionsPossibles);
            Transition transitionChoisie = listeTransitions.get(random.nextInt(listeTransitions.size()));

            System.out.println("Transition choisie : t" + transitionChoisie.numId());

            activateTransition(transitionChoisie);
            showPlateau();
        }
    }

    // Fonction pour afficher les transitions possibles et permettre le choix
    public void manualTransition(Scanner scanner) {
        Set<Transition> transitionsPossibles = update();
        if (transitionsPossibles.isEmpty()) {
            System.out.println("Aucune transition possible.");
            return;
        }

        System.out.println("Transitions possibles :");
        List<Transition> listeTransitions = new ArrayList<>(transitionsPossibles);

        for (int i = 0; i < listeTransitions.size(); i++)
            System.out.println((i + 1) + ". Transition " + listeTransitions.get(i).numId());

        System.out.print("Choisissez une transition : ");
        int choix = scanner.nextInt();

        if (choix < 1 || choix > listeTransitions.size()) {
            System.out.println("Choix invalide.");
            return;
        }

        Transition transitionChoisie = listeTransitions.get(choix - 1);
        activateTransition(transitionChoisie);
        showPlateau();
    }

}