package fr.bastienluben.cgj2025.Entite;

import java.util.ArrayList;

import fr.bastienluben.cgj2025.Objets.Objet;

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

    @Override
    public void attaquer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'attaquer'");
    }


}
