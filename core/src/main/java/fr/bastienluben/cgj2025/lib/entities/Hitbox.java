package fr.bastienluben.cgj2025.lib.entities;

import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hitbox {
    private static List<Hitbox> hitboxes = new ArrayList<Hitbox>();

    public static List<Hitbox> getHitboxes() {
        return hitboxes;
    }

    public static List<Hitbox> getHitboxesParentOf(Element element) {
        return Arrays.asList((Hitbox[]) hitboxes.stream().filter(h -> h.parent == element).toArray());
    }

    private boolean solid; // Si la hitbox doit être solide (comme un mur ou un sol)
    private Rectangle box;
    private Element parent;

    public Hitbox(Element entite) {
        this.box = entite.getRectangle();
        hitboxes.add(this);
    }

    public Hitbox(Element entite, boolean solid){
        this(entite);
        this.solid = solid;
    }

    public boolean ilToucheLaHitbox(Hitbox hitbox){
        return this.box.contains(hitbox.box);
    }
}
