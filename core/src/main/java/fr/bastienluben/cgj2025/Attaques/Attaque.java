package fr.bastienluben.cgj2025.Attaques;

import fr.bastienluben.cgj2025.Entite.Personnage;

public abstract class Attaque {
    private double nbDegatAuHit;
    private String nom;
    private float tempsExecution;
    private float delaiAvantProchaineAttaque;

    protected Attaque (double nbDegat, String nom, float tempsExecution, float delaiAvantProchaineAttaque) {
        this.nom = nom;
        this.nbDegatAuHit = nbDegat;
        this.tempsExecution = tempsExecution;
        this.delaiAvantProchaineAttaque = delaiAvantProchaineAttaque;
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

    public void attaquer(Personnage adversaire, double coefForce) {
        double degat = getNbDegatAuHit();
        boolean degatSuperieurAPointArmure = degat > adversaire.vie.getBouclier();
        double bouclierRestant = adversaire.vie.enleverBouclier(degat);

        if (degatSuperieurAPointArmure) {
            adversaire.vie.ajoutStat(bouclierRestant);
        }
    }


}
