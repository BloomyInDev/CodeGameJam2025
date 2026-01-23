package fr.bastienluben.cgj2025.Entite;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Circle;

public class Balle extends Entite {
    private Circle hitbox;
    private boolean estDetruite;
    private float vitesse;
    private Vector2 direction;

    public Balle(float x, float y, float rayon, Vector2 cible) {
        super();
        this.position = new Vector2(x, y);
        this.nom = "Balle";
        this.pointDeVie = 1; // Une balle a 1 PV
        this.hitbox = new Circle(x, y, rayon);
        this.estDetruite = false;
        this.vitesse = 200f; // 200 pixels par seconde

        // Calculer la direction vers la cible
        this.direction = new Vector2(cible.x - x, cible.y - y).nor();
    }

    @Override
    public void attaquer() {
        // Les balles n'attaquent pas activement, elles infligent des dégâts au contact
    }

    @Override
    public Vector2 getPosition() {
        return position;
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
        // Se déplacer dans la direction de la cible
        this.position.x += direction.x * vitesse * delta;
        this.position.y += direction.y * vitesse * delta;
        this.hitbox.setPosition(position.x, position.y);
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
}
