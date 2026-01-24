package fr.bastienluben.cgj2025.screens.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

import fr.bastienluben.cgj2025.Attaques.Kamikaze;
import fr.bastienluben.cgj2025.Entite.Bombe;
import fr.bastienluben.cgj2025.Entite.Hero;
import fr.bastienluben.cgj2025.Main;
import fr.bastienluben.cgj2025.lib.AssetManager;
import fr.bastienluben.cgj2025.lib.fonts.FontLoader;
import fr.bastienluben.cgj2025.lib.fonts.FontParameterBuilder;
import fr.bastienluben.cgj2025.screens.AbstractScreen;

public class MainKamikazeScreen extends AbstractScreen {
    private SpriteBatch batch;
    private Texture bombeTexture;
    private BitmapFont font, redFont, orangeFont;
    private Kamikaze kamikaze;
    private List<Bombe> bombes;
    private float screenWidth;
    private float screenHeight;
    private int nbBombes;
    private float probabiliteApparitionBombe;

    public MainKamikazeScreen(Main game, AssetManager assets, int nbBombes, float probabiliteApparitionBombe) {
        super(game, assets);
        batch = new SpriteBatch();
        bombeTexture = new Texture(Gdx.files.internal("bombe.png"));
        font = FontLoader.getInstance().getFont("default", new FontParameterBuilder().build());
        redFont = FontLoader.getInstance().getFont("default", new FontParameterBuilder().setColor(Color.RED).build());
        orangeFont = FontLoader.getInstance().getFont("default", new FontParameterBuilder().setColor(Color.ORANGE).build());
        kamikaze = new Kamikaze(Hero.getInstance(), nbBombes);
        this.probabiliteApparitionBombe = probabiliteApparitionBombe;
        bombes = new ArrayList<>();
        screenWidth = Gdx.graphics.getWidth();
        screenHeight = Gdx.graphics.getHeight();
    }

    public MainKamikazeScreen(Main game, AssetManager assets) {
        this(game, assets, 8, .01f);
    }

    @Override
    public void show() {
        // Initialisation si nécessaire
    }

    @Override
    public void update(float delta) {
        // Logique de jeu
        if (MathUtils.randomBoolean(probabiliteApparitionBombe)) {
            int x = MathUtils.random(0, (int) screenWidth - 50);
            int y = MathUtils.random(0, (int) screenHeight - 50);
            Bombe bombe = new Bombe(60, x, y, 0);
            bombes.add(bombe);
        }

        Iterator<Bombe> iterator = bombes.iterator();
        while (iterator.hasNext()) {
            Bombe bombe = iterator.next();
            bombe.update(delta);
            if (bombe.isEstClique() || bombe.getTimer() <= 0) {
                iterator.remove();
            }
        }
        // Gestion des clics
        if (Gdx.input.justTouched()) {
            int x = Gdx.input.getX();
            int y = Gdx.graphics.getHeight() - Gdx.input.getY();
            for (Bombe bombe : bombes) {
                if (x >= bombe.getX() && x <= bombe.getX() + 50 && y >= bombe.getY() && y <= bombe.getY() + 50) {
                    bombe.click();
                }
            }
        }
    }

    @Override
    public void draw(SpriteBatch batch) {
        // Mettre à jour les bombes
        Iterator<Bombe> iterator = bombes.iterator();
        while (iterator.hasNext()) {
            Bombe bombe = iterator.next();
            if (!(bombe.isEstClique() || bombe.getTimer() <= 0)) {
                // Dessiner la bombe
                batch.draw(bombeTexture, bombe.getX(), bombe.getY(), 50, 50);
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
        batch.dispose();
        bombeTexture.dispose();
        font.dispose();
    }

    @Override
    public void start() {
    }
}
