package fr.bastienluben.cgj2025.screens.main;

import java.util.List;

import fr.bastienluben.cgj2025.lib.entities.Hitbox;
import fr.bastienluben.cgj2025.screens.main.Attaques.Attaque;

public abstract class Entite {
    private double pointDeVie;
    private double pointDeVieMax;
    private double pointDeArmure;

    private Hitbox hitbox;
    private String nom;
    private List<Attaque> listesAttaques;
    
    protected abstract void attaquer(Attaque attaque);
    
    public void subitDegat(double degat) {
        boolean degatSuperieurAPointArmure = degat > pointDeArmure;
        pointDeArmure -= degat;

        if (degatSuperieurAPointArmure) {
            pointDeVie += pointDeArmure;
            pointDeArmure = 0;
        }
    }
}
