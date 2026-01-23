package fr.bastienluben.cgj2025.Stats;

import fr.bastienluben.cgj2025.Attaques.Attaque;
import fr.bastienluben.cgj2025.Entite.Personnage;

public class PV extends Stat {
    private double pointDeArmure;

    public PV(double statBase, double statMax) {
        super(statBase, statMax);
    }

    public double getBouclier() {
        return pointDeArmure;
    }

    public double enleverBouclier(double degat) {
        double bouclierSansFiltre = pointDeArmure - degat;
        pointDeArmure = Math.max(bouclierSansFiltre, 0);

        return bouclierSansFiltre;
    }
}
