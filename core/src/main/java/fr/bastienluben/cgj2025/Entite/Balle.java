package fr.bastienluben.cgj2025.Entite;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Circle;

public class Balle {
    private Vector2 position;
    private Circle hitbox;
    private boolean estDetruite;
    private float vitesse;


    public Balle(float x, float y, float rayon) {
        this.position = new Vector2(x, y);
        this.hitbox = new Circle(x, y, rayon);
        this.estDetruite = false;
    }

    public void mettreAJourPosition(float x, float y) {
        this.position.set(x, y);
        this.hitbox.setPosition(x, y);
    }

    public boolean estTouche(float clickX, float clickY) {
        return hitbox.contains(clickX, clickY);
    }

    public boolean estDetruite() {
        return estDetruite;
    }

    public void detruire() {
        estDetruite = true;
    }

    public Vector2 getPosition() {
        return position;
    }

    public Circle getHitbox() {
        return hitbox;
    }
    public void mettreAJour(float delta) {
        this.position.y -= vitesse * delta;
        this.hitbox.setPosition(position.x, position.y);
    }
}
