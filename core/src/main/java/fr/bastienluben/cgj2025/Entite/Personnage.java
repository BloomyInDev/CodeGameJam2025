package fr.bastienluben.cgj2025.Entite;

import java.util.List;

import fr.bastienluben.cgj2025.Stats.Difficulte;
import fr.bastienluben.cgj2025.Stats.Force;
import fr.bastienluben.cgj2025.Stats.PV;
import fr.bastienluben.cgj2025.Attaques.Attaque;

public abstract class Personnage extends Entite{
    protected List<Attaque> listesAttaques;
    private PV vie;
    private Force force;
    private Difficulte difficulte;

    public Personnage(double maxPV, double forceDefaut, double difficulteDefaut){
        double statsMax = 5;
        vie = new PV(maxPV, maxPV);
        force = new Force(forceDefaut, statsMax);
        difficulte = new Difficulte(difficulteDefaut, statsMax);
    }

    public PV getVie(){
        return this.vie;
    }

    public Force getForce(){
        return this.force;
    }

    public Difficulte getDefense(){
        return this.difficulte;
    }

    public void attaquer(Personnage adversaire, Attaque attaque){
        attaque.attaquer(this, adversaire);
    }
}
