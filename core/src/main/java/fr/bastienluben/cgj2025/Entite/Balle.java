package fr.bastienluben.cgj2025.Entite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Circle;

import java.util.Random;

public abstract class Balle extends Entite {
    private int pointDeVie;
    private Circle hitbox;
    private boolean estDetruite;
    private float vitesse;
    private Vector2 direction;
    private Texture texture;
    private Random random;
    public final boolean isBoss;
    private TypeMouvementBalle typeMouvement;

    public int rotation;

    public Balle(float x, float y, float rayon, Vector2 cible, int pointDeVie,
                 String complementNom, boolean isBoss) {
        super();
        this.isBoss = isBoss;
        this.pointDeVie = pointDeVie;
        this.position = new Vector2(x, y);
        this.nom = "Balle " + complementNom;
        this.hitbox = new Circle(x, y, rayon);
        this.estDetruite = false;
        random = new Random();
        this.vitesse = 0f;

        // Calculer la direction vers la cible
        this.direction = new Vector2(cible.x - x, cible.y - y).nor();
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

    public Circle getHitbox() {
        return hitbox;
    }

    public void mettreAJour(float delta) {
        typeMouvement.mettreAJour(this, delta);
    }

    public boolean toucheHero(Vector2 heroPosition, float heroTaille) {
        // Vérifier si la balle touche le rectangle du héros
        float heroGauche = heroPosition.x - heroTaille / 2;
        float heroDroite = heroPosition.x + heroTaille / 2;
        float heroBas = heroPosition.y - heroTaille / 2;
        float heroHaut = heroPosition.y + heroTaille / 2;

        // Trouver le point le plus proche du cercle sur le rectangle
        float plusProcheX = Math.max(heroGauche, Math.min(position.x, heroDroite));
        float plusProcheY = Math.max(heroBas, Math.min(position.y, heroHaut));

        // Calculer la distance entre le centre du cercle et ce point
        float distanceX = position.x - plusProcheX;
        float distanceY = position.y - plusProcheY;
        float distanceCarree = distanceX * distanceX + distanceY * distanceY;

        return distanceCarree <= hitbox.radius * hitbox.radius;
    }

    public Texture getTexture() {
        return texture;
    }

    public Vector2 getDirection() {
        return direction;
    }

    public float getVitesse() {
        return vitesse;
    }

    public void setVitesse(float vitesse) {
        this.vitesse = vitesse;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public void setTypeMouvement(TypeMouvementBalle typeMouvement) {
        this.typeMouvement = typeMouvement;
    }

    public void retirerPV() {
        pointDeVie--;
    }

    public int getPointDeVie() {
        return pointDeVie;
    }

    public boolean estGrosseBalle() {
        return false;
    }
}
