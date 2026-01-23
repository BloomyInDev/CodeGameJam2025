package fr.bastienluben.cgj2025.screens.main.Attaques;

import fr.bastienluben.cgj2025.screens.main.Entite;

public abstract class Attaque {
    private double nbDegatAuHit;
    private String nom;
    private float tempsExecution;
    private float delaiAvantProchaineAttaque;

    public Attaque (double nbDegat, String nom, float tempsExecution, float delaiAvantProchaineAttaque) {
        this.nom = nom;
        this.nbDegatAuHit = nbDegat;
        this.tempsExecution = tempsExecution;
        this.delaiAvantProchaineAttaque = delaiAvantProchaineAttaque;
    }

    public void attaquer(Entite e) {
        e.subitDegat(nbDegatAuHit);
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

    
}
