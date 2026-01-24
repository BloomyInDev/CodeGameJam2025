package fr.bastienluben.cgj2025.Attaques;

import fr.bastienluben.cgj2025.Entite.Personnage;
import fr.bastienluben.cgj2025.lib.son.SoundManager;

public abstract class Attaque {
    private double nbDegatAuHit;
    private String nom;
    private float tempsExecution;
    private float delaiAvantProchaineAttaque;
    protected SoundManager soundManager;

    protected Attaque (double nbDegat, String nom, float tempsExecution, float delaiAvantProchaineAttaque) {
        this.nom = nom;
        this.nbDegatAuHit = nbDegat;
        this.tempsExecution = tempsExecution;
        this.delaiAvantProchaineAttaque = delaiAvantProchaineAttaque;
        soundManager = new SoundManager();
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

    public void attaquer(Personnage attaquant, Personnage adversaire) {
        double degat = getNbDegatAuHit() * attaquant.getForce().getNbStat();
        boolean degatSuperieurAPointArmure = degat > adversaire.getVie().getBouclier();
        double bouclierRestant = adversaire.getVie().enleverBouclier(degat);

        if (degatSuperieurAPointArmure) {
            adversaire.getVie().ajoutStat(bouclierRestant);
        }
    }


}
