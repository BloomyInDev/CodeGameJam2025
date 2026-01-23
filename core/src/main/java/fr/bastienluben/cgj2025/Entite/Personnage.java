package fr.bastienluben.cgj2025.Entite;

import java.util.List;

import fr.bastienluben.cgj2025.Stats.Defense;
import fr.bastienluben.cgj2025.Stats.Force;
import fr.bastienluben.cgj2025.Stats.PV;
import fr.bastienluben.cgj2025.Attaques.Attaque;

public abstract class Personnage extends Entite{
    protected List<Attaque> listesAttaques;
    private PV vie;
    private Force force;
    private Defense defense;

    public Personnage(double maxPV, double forceDefaut, double defenceDefaut){
        double statsMax = 5;
        vie = new PV(maxPV, maxPV);
        force = new Force(forceDefaut, statsMax);
        defense = new Defense(defenceDefaut, statsMax);
    }

    public PV getVie(){
        return this.vie;
    }

    public Force getForce(){
        return this.force;
    }

    public Defense getDefense(){
        return this.defense;
    }

    public void attaquer(Personnage adversaire, Attaque attaque){
        attaque.attaquer(this, adversaire);
    }
}
