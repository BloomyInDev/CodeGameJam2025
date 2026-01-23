package fr.bastienluben.cgj2025.lib.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Hitbox {
    private static List<Hitbox> hitboxes = new ArrayList<Hitbox>();

    public static List<Hitbox> getHitboxes() {
        return hitboxes;
    }

    public static List<Hitbox> getHitboxesParentOf(Entity entity) {
        return Arrays.asList((Hitbox[]) hitboxes.stream().filter(h -> h.parent == entity).toArray());
    }

    private boolean solid; // Si la hitbox doit être solide (comme un mur ou un sol)
    private Rectangle box;
    private Entity parent;

    public Hitbox(Entity entite) {
        this.box = entite.getRectangle();
        hitboxes.add(this);
    }

    public Hitbox(Entity entite, boolean solid){
        this(entite);
        this.solid = solid;
    }

    public boolean ilToucheLaHitbox(Hitbox hitbox){
        return this.box.contains(hitbox.box);
    }
}
