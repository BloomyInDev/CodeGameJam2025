package fr.bastienluben.cgj2025.lib.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Hitbox {
    private boolean solid; // Si la hitbox doit être solide (comme un mur ou un sol)
    private Rectangle box;
    private Entity parent;

    public Hitbox(Entity entite) {
        this.box = entite.getRectangle();
    }

    public Hitbox(Entity entite, boolean solid){
        this(entite);
        this.solid = solid;
    }

    public boolean ilToucheLaHitbox(Hitbox hitbox){
        return this.box.contains(hitbox.box);
    }
}
