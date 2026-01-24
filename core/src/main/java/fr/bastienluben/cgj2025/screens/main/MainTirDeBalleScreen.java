package fr.bastienluben.cgj2025.screens.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import fr.bastienluben.cgj2025.Enemis.Ennemi;
import fr.bastienluben.cgj2025.lib.AssetManager;
import fr.bastienluben.cgj2025.Main;
import fr.bastienluben.cgj2025.Attaques.TirDeBalle;
import fr.bastienluben.cgj2025.Entite.Balle;
import fr.bastienluben.cgj2025.Entite.Hero;
import fr.bastienluben.cgj2025.lib.ui.UI;
import fr.bastienluben.cgj2025.screens.AbstractScreen;

import java.util.Random;

public class MainTirDeBalleScreen extends AbstractScreen {
    private Hero hero;
    private TirDeBalle tirDeBalle;
    private float vitesseMin;
    private float vitesseMax;

    public MainTirDeBalleScreen(Main game, AssetManager assets, float vitesseMin, float vitesseMax) {
        super(game, assets);
        this.vitesseMin = vitesseMin;
        this.vitesseMax = vitesseMax;
    }

    public MainTirDeBalleScreen(Main game, AssetManager assets) {
        this(game, assets, 200f, 700f);
    }

    @Override
    public void start() {
        this.hero = Hero.getInstance();

        // Créer l'attaque TirDeBalle : cible, délai 1s, rayon 60, 1 dégât par balle
        // Chaque balle est l'attaquant
        this.tirDeBalle = new TirDeBalle( vitesseMin, vitesseMax);
    }

    @Override
    public void update(float delta) {
        // Déléguer toute la logique des balles à TirDeBalle
        tirDeBalle.mettreAJour(delta);

        // Gérer les clics pour détruire les balles (justTouched = nouveau clic
        // uniquement)
        if (Gdx.input.justTouched()) {
            Vector2 clickPosition = new Vector2(Gdx.input.getX(), Gdx.input.getY());
            clickPosition = UI.normalToGdx(clickPosition);
            tirDeBalle.gererClic(clickPosition.x, clickPosition.y);
        }
    }

    @Override
    public void draw(SpriteBatch batch) {
        // Dessiner les ennemis (images enerve.png) avec SpriteBatch

        for (Balle balle : tirDeBalle.getBalles()) {
            float rayon = balle.getHitbox().radius;
            float taille = rayon * ((float)1.3); // Diamètre
            float x = balle.getPosition().x - rayon;
            float y = balle.getPosition().y - rayon;
            batch.draw(balle.getTexture(), x, y, taille, taille);
        }

    }

    @Override
    public void draw(ShapeRenderer batch) {
        batch.begin(ShapeRenderer.ShapeType.Filled);
        batch.setColor(1, 1, 1, 1); // Blanc
        float heroX = hero.getPosition().x - hero.getTaille() / 2;
        float heroY = hero.getPosition().y - hero.getTaille() / 2;
        batch.rect(heroX, heroY, hero.getTaille(), hero.getTaille());
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
