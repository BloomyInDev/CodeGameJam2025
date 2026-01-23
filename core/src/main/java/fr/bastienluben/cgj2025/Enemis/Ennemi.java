package fr.bastienluben.cgj2025.Enemis;

import fr.bastienluben.cgj2025.Attaques.Attaque;
import fr.bastienluben.cgj2025.Entite.Personnage;

public abstract class Ennemi extends Personnage {
    protected void ajouterAttaque(Attaque attaqueAjouter){
        this.listesAttaques.add(attaqueAjouter);
    }

}
