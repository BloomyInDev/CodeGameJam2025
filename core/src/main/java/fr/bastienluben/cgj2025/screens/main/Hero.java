package fr.bastienluben.cgj2025.screens.main;

import java.util.ArrayList;
import fr.bastienluben.cgj2025.screens.main.Objets.Objet;

public class Hero extends Entite {
    private ArrayList<Objet> listeObjetDuHero;

    public Hero (String nom) {
        super();
        super.nom = nom;
        listeObjetDuHero = new ArrayList<>();
    }

    public void ajouterObjet(Objet objetAAJouter) {
        listeObjetDuHero.add(objetAAJouter);
    }


}
