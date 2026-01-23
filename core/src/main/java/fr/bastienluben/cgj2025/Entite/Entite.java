package fr.bastienluben.cgj2025.Entite;

import java.util.List;

import javax.swing.text.Position;

import com.badlogic.gdx.math.Vector2;

import fr.bastienluben.cgj2025.lib.entities.Hitbox;
import fr.bastienluben.cgj2025.Attaques.Attaque;

public abstract class Entite {
    protected Vector2 position;
    protected double pointDeVie;
    private double pointDeVieMax;
    protected double pointDeArmure;

    private Hitbox hitbox;
    protected String nom;
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

    public abstract void attaquer();

    public double guerison(double nbVie) {
        pointDeVie = Math.min(pointDeVie + nbVie, pointDeVieMax);
        return pointDeVie;
    }

    public String getNom() {
        return nom;
    }

    public double getPointDeVie() {
        return pointDeVie;
    }

    public boolean estMort() {
        return pointDeVie <= 0;
    }

    public abstract Vector2 getPosition();
}
