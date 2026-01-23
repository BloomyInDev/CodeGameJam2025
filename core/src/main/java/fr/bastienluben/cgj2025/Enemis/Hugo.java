package fr.bastienluben.cgj2025.Enemis;

import fr.bastienluben.cgj2025.Attaques.Attaque;
import fr.bastienluben.cgj2025.Attaques.TirDeBalle;

public class Hugo extends Ennemi {

    @Override
    public void attaquer() {
        Attaque tirDeBalle = new TirDeBalle(10,this);
    }
    
}
