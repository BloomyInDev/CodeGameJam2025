package fr.bastienluben.cgj2025.Stats;

public abstract class Stat {
    protected double nbStat;
    private final double nbStatMax;
    private final double nbStatDefaut;

    public Stat(double nbStatMax, double statBase) {
        this.nbStatMax = nbStatMax;
        this.nbStatDefaut = statBase;
        this.nbStat = statBase;
    }


    private void retirerStat(double changement) {
        this.nbStat = Math.max(this.nbStat - changement, 0);
    }


    private void ajoutStat(double ajout) {
        this.nbStat = Math.min(this.nbStat + ajout, this.nbStatMax);
    }
}
