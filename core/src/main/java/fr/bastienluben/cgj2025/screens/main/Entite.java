package fr.bastienluben.cgj2025.screens.main;

import java.util.List;

import fr.bastienluben.cgj2025.lib.entities.Hitbox;
import fr.bastienluben.cgj2025.screens.main.Attaques.Attaque;

public abstract class Entite {
    protected double pointDeVie;
    private double pointDeVieMax;
    protected double pointDeArmure;

    private Hitbox hitbox;
    private String nom;
    protected List<Attaque> listesAttaques;

    public void attaquer(Entite adversaire, Attaque attaqueUtilise) {
        double degat = attaqueUtilise.getNbDegatAuHit();
        boolean degatSuperieurAPointArmure = degat > adversaire.pointDeArmure;
        adversaire.pointDeArmure -= degat;

        if (degatSuperieurAPointArmure) {
            adversaire.pointDeVie += adversaire.pointDeArmure;
            adversaire.pointDeArmure = 0;
        }
    }

    public double guerison(double nbVie){
        pointDeVie = Math.min(pointDeVie + nbVie, pointDeVieMax);
        return pointDeVie;
    }

    public String getNom(){
        return nom;
    }
}
