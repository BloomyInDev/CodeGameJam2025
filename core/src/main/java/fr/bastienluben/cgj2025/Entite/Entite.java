package fr.bastienluben.cgj2025.Entite;

import com.badlogic.gdx.math.Vector2;
import fr.bastienluben.cgj2025.lib.entities.Hitbox;

public class Entite {
    protected Hitbox hitbox;
    protected String nom;
    protected Vector2 position;

    public String getNom(){
        return nom;
    }

    public Vector2 getPosition(){
        return this.position;
    }
}
