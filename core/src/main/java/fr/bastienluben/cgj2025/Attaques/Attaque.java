package fr.bastienluben.cgj2025.Attaques;

import fr.bastienluben.cgj2025.Entite.Entite;

public abstract class Attaque {
    private double nbDegatAuHit;
    private String nom;
    private float tempsExecution;
    private float delaiAvantProchaineAttaque;
    private Entite attaquant;

    protected Attaque (double nbDegat, String nom, float tempsExecution, float delaiAvantProchaineAttaque, Entite attaquant) {
        this.nom = nom;
        this.nbDegatAuHit = nbDegat;
        this.tempsExecution = tempsExecution;
        this.delaiAvantProchaineAttaque = delaiAvantProchaineAttaque;
        this.attaquant = attaquant;
    }

    public double getNbDegatAuHit() {
        return nbDegatAuHit;
    }

    public String getNom() {
        return nom;
    }

    public float getTempsExecution() {
        return tempsExecution;
    }

    public float getDelaiAvantProchaineAttaque() {
        return delaiAvantProchaineAttaque;
    }

    public Entite getAttaquant() {
        return attaquant;
    }

    protected abstract void attaque();

}
