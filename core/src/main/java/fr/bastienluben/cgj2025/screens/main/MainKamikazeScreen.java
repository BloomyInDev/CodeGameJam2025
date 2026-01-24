package fr.bastienluben.cgj2025.screens.main;

import java.util.Iterator;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

import com.badlogic.gdx.math.Vector2;
import fr.bastienluben.cgj2025.Attaques.Kamikaze;
import fr.bastienluben.cgj2025.Entite.Bombe;
import fr.bastienluben.cgj2025.Entite.Hero;
import fr.bastienluben.cgj2025.Main;
import fr.bastienluben.cgj2025.lib.AssetManager;
import fr.bastienluben.cgj2025.lib.fonts.FontLoader;
import fr.bastienluben.cgj2025.lib.fonts.FontParameterBuilder;
import fr.bastienluben.cgj2025.screens.AbstractGameScreen;
import fr.bastienluben.cgj2025.screens.gameScreen.FeuxDartificeManager;

public class MainKamikazeScreen extends AbstractGameScreen {
    private Texture bombeTexture;
    private BitmapFont font, redFont, orangeFont;
    private Kamikaze kamikaze;
    private float probabiliteApparitionBombe;

    private FeuxDartificeManager feux;

    public MainKamikazeScreen(Main game, AssetManager assets, int nbBombes, float probabiliteApparitionBombe, int nbBombesAvantFin) {
        super(game, assets);
        bombeTexture = new Texture(Gdx.files.internal("bombe.png"));
        font = FontLoader.getInstance().getFont("default", new FontParameterBuilder().build());
        redFont = FontLoader.getInstance().getFont("default", new FontParameterBuilder().setColor(Color.RED).build());
        orangeFont = FontLoader.getInstance().getFont("default", new FontParameterBuilder().setColor(Color.ORANGE).build());
        kamikaze = new Kamikaze(Hero.getInstance(), nbBombes, nbBombesAvantFin);
        this.probabiliteApparitionBombe = probabiliteApparitionBombe;
        feux = new FeuxDartificeManager(1f, assets);
    }

    public MainKamikazeScreen(Main game, AssetManager assets) {
        this(game, assets, 8, .01f, 30);
    }

    @Override
    public void show() {
        // Initialisation si nécessaire
    }

    @Override
    public void update(float delta) {
        // Logique de jeu - spawn de bombes via Kamikaze
        if (MathUtils.randomBoolean(probabiliteApparitionBombe) && kamikaze.peutSpawnerBombe()) {
            kamikaze.spawnBombe(60);
        }

        List<Bombe> bombes = kamikaze.getBombes();
        Iterator<Bombe> iterator = bombes.iterator();
        while (iterator.hasNext()) {
            Bombe bombe = iterator.next();
            bombe.update(delta);
            if (bombe.isEstClique()) {
                iterator.remove();
            }
            else if (bombe.getTimer() <= 0) {
                iterator.remove();
                Hero.getInstance().getVie().retirerStat(10);
            }
        }
        // Gestion des clics
        if (Gdx.input.justTouched()) {
            int x = Gdx.input.getX();
            int y = Gdx.graphics.getHeight() - Gdx.input.getY();
            for (Bombe bombe : bombes) {
                if (x >= bombe.getX() && x <= bombe.getX() + 50 && y >= bombe.getY() && y <= bombe.getY() + 50) {
                    bombe.click();
                    feux.createExplosionAt(
                        new Vector2(bombe.getX() + 25, bombe.getY() + 25), 1f, Color.ORANGE);
                    Main.shake(0.1f, 6);
                }
            }
        }

        feux.update(delta);
        Main.updateShake(delta);
    }

    @Override
    public void draw(SpriteBatch batch) {
        feux.draw(batch);

        // Dessiner les bombes
        for (Bombe bombe : kamikaze.getBombes()) {
            if (!(bombe.isEstClique() || bombe.getTimer() <= 0)) {
                // Dessiner la bombe
                batch.draw(bombeTexture,
                    bombe.getX() + Main.camera.x,
                    bombe.getY() + Main.camera.y, 50, 50);
                // Dessiner le compteur
                if (bombe.getTimer() < 10) {
                    redFont.draw(batch, String.valueOf(bombe.getTimerTexte()), bombe.getX() + 25, bombe.getY() + 25);
                } else if (bombe.getTimer() > 10 && bombe.getTimer() < 20) {
                    orangeFont.draw(batch, String.valueOf(bombe.getTimerTexte()), bombe.getX() + 25, bombe.getY() + 25);
                } else {
                    font.draw(batch, String.valueOf(bombe.getTimerTexte()), bombe.getX() + 25, bombe.getY() + 25);
                }
            }
        }

    }

    @Override
    public void dispose() {
        bombeTexture.dispose();
        font.dispose();
    }

    @Override
    public void start() {
    }

    @Override
    public boolean estTerminee() {
        return kamikaze.estTerminee();
    }
}
