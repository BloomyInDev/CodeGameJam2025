package fr.bastienluben.cgj2025.Enemis;

import fr.bastienluben.cgj2025.Attaques.Attaque;
import fr.bastienluben.cgj2025.Entite.Entite;

public abstract class Ennemi extends Entite {
    protected void ajouterAttaque(Attaque attaqueAjouter){
        this.listesAttaques.add(attaqueAjouter);
    }

}
