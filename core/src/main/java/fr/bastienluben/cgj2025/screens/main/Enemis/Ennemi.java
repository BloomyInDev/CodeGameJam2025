package fr.bastienluben.cgj2025.screens.main.Enemis;

import fr.bastienluben.cgj2025.screens.main.Attaques.Attaque;
import fr.bastienluben.cgj2025.screens.main.Entite;

public abstract class Ennemi extends Entite {
    protected void ajouterAttaque(Attaque attaqueAjouter){
        this.listesAttaques.add(attaqueAjouter);
    }

}
