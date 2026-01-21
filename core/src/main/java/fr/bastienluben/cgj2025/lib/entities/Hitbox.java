package fr.bastienluben.cgj2025.lib.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Hitbox extends Entity{
    private boolean solid; // Si la hitbox doit être solide (comme un mur ou un sol)
    private Rectangle box;

    public Hitbox(Sprite sprite, Vector2 position, boolean solid){
        super(sprite, position);
        this.solid = solid;
    }

    public Hitbox(Sprite sprite, Vector2 position) {
        this(sprite, position, false);
        this.box = new Rectangle();
    }

    public Hitbox(Sprite sprite, Vector2 position, Vector2 taille, boolean solid){
        this(sprite, position, solid);
        this.box = new Rectangle(position.x, position.y, taille.x, taille.y);
    }

    public Hitbox(Sprite sprite, Vector2 position, Vector2 taille){
        this(sprite, position, taille, false);
    }

    public boolean ilToucheLaHitbox(Hitbox hitbox){
        return this.box.contains(hitbox.box);
    }
}
