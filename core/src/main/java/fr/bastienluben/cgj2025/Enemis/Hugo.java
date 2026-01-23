package fr.bastienluben.cgj2025.Enemis;

import com.badlogic.gdx.math.Vector2;

import fr.bastienluben.cgj2025.Attaques.Attaque;
import fr.bastienluben.cgj2025.Attaques.TirDeBalle;

public class Hugo extends Ennemi {

    @Override
    public void attaquer() {
        Attaque tirDeBalle = new TirDeBalle(10,this);
    }

    @Override
    public Vector2 getPosition() {
        return new Vector2(0, 0);
    }
    
}
