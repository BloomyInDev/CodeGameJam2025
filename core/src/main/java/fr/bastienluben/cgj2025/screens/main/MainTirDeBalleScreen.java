package fr.bastienluben.cgj2025.screens.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import fr.bastienluben.cgj2025.lib.AssetManager;
import fr.bastienluben.cgj2025.Main;
import fr.bastienluben.cgj2025.Entite.Balle;
import fr.bastienluben.cgj2025.lib.IScript;
import fr.bastienluben.cgj2025.lib.ui.Button;
import fr.bastienluben.cgj2025.lib.ui.UI;
import fr.bastienluben.cgj2025.screens.AbstractScreen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainTirDeBalleScreen extends AbstractScreen {
    private List<Balle> balles;
    private Random random;
    private float tempsDepuisDerniereBalle;
    private float delaiEntreBalles = 1f; // 1 seconde entre chaque balle
    private ShapeRenderer shapeRenderer;

    public MainTirDeBalleScreen(Main game, AssetManager assets) {
        super(game, assets);
        this.balles = new ArrayList<>();
        this.random = new Random();
        this.tempsDepuisDerniereBalle = 0f;
        this.shapeRenderer = new ShapeRenderer();
    }

    @Override
    public void onLoad(AssetManager assets) {
        // Initialisation des scripts ou autres ressources
    }

    @Override
    public void start() {
        // Initialisation supplémentaire si nécessaire
    }

    @Override
    public void update(float delta) {
        tempsDepuisDerniereBalle += delta;

        if (tempsDepuisDerniereBalle >= delaiEntreBalles) {
            ajouterBalle();
            tempsDepuisDerniereBalle = 0f;
        }

        // Mettre à jour la position des balles
        for (Balle balle : balles) {
            balle.mettreAJour(delta);
        }

        // Détecter les clics sur les balles
        if (Gdx.input.isTouched()) {
            Vector2 clickPosition = new Vector2(Gdx.input.getX(), Gdx.input.getY());
            clickPosition = UI.normalToGdx(clickPosition);

            for (Balle balle : balles) {
                if (balle.estTouche(clickPosition.x, clickPosition.y)) {
                    balle.detruire();
                }
            }
        }

        // Retirer les balles détruites ou sorties de l'écran
        balles.removeIf(balle -> balle.estDetruite() || balle.getPosition().y < 0);
    }

    private void ajouterBalle() {
        float x = random.nextFloat() * Gdx.graphics.getWidth();
        float y = Gdx.graphics.getHeight(); // Les balles apparaissent en haut de l'écran
        float rayon = 30f; // Rayon de la balle
        balles.add(new Balle(x, y, rayon));
    }

    @Override
    public void draw(SpriteBatch batch) {
            batch.begin();
        // Dessiner d'autres éléments avec SpriteBatch si nécessaire
        batch.end();

        // Dessiner les balles avec ShapeRenderer
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(1, 0, 0, 1); // Rouge
        for (Balle balle : balles) {
            shapeRenderer.circle(balle.getPosition().x, balle.getPosition().y, balle.getHitbox().radius);
        }
        shapeRenderer.end();
    }

    
}
