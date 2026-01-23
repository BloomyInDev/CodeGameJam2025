package fr.bastienluben.cgj2025.screens.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

import fr.bastienluben.cgj2025.Attaques.Bombe;
import fr.bastienluben.cgj2025.Attaques.kamikaze;
import fr.bastienluben.cgj2025.Main;
import fr.bastienluben.cgj2025.lib.AssetManager;
import fr.bastienluben.cgj2025.lib.fonts.FontLoader;
import fr.bastienluben.cgj2025.lib.fonts.FontParameterBuilder;
import fr.bastienluben.cgj2025.screens.AbstractScreen;

public class MainKamikazeScreen extends AbstractScreen implements Screen {
    private SpriteBatch batch;
    private Texture bombeTexture;
    private BitmapFont font, redFont, orangeFont;
    private kamikaze kamikaze;
    private List<Bombe> bombes;
    private float screenWidth;
    private float screenHeight;

    public MainKamikazeScreen(Main game, AssetManager assets) {
        super(game, assets);
        batch = new SpriteBatch();
        bombeTexture = new Texture(Gdx.files.internal("bombe.png"));
        font = FontLoader.getInstance().getFont("default", new FontParameterBuilder().build());
        redFont = FontLoader.getInstance().getFont("default", new FontParameterBuilder().setColor(Color.RED).build());
        orangeFont = FontLoader.getInstance().getFont("default", new FontParameterBuilder().setColor(Color.ORANGE).build());
        kamikaze = new kamikaze();
        bombes = new ArrayList<>();
        screenWidth = Gdx.graphics.getWidth();
        screenHeight = Gdx.graphics.getHeight();
    }

    @Override
    public void show() {
        // Initialisation si nécessaire
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        // Logique de jeu
        if (MathUtils.randomBoolean(0.01f)) { // 1% de chance de poser une bombe à chaque frame
            int x = MathUtils.random(0, (int) screenWidth - 50);
            int y = MathUtils.random(0, (int) screenHeight - 50);
            Bombe bombe = new Bombe(60, x, y);
            bombes.add(bombe);
        }

        // Mettre à jour les bombes
        Iterator<Bombe> iterator = bombes.iterator();
        while (iterator.hasNext()) {
            Bombe bombe = iterator.next();
            bombe.update();
            if (bombe.isEstClique() || bombe.getTimer() <= 0) {
                iterator.remove();
            } else {
                // Dessiner la bombe
                batch.draw(bombeTexture, bombe.getX(), bombe.getY(), 50, 50);
                // Dessiner le compteur
                if (bombe.getTimer() < 10) {
                    redFont.draw(batch, String.valueOf(bombe.getTimer()), bombe.getX() + 25, bombe.getY() + 25);
                } else if (bombe.getTimer() > 10 && bombe.getTimer() < 20) {
                    orangeFont.draw(batch, String.valueOf(bombe.getTimer()), bombe.getX() + 25, bombe.getY() + 25);
                } else {
                    font.draw(batch, String.valueOf(bombe.getTimer()), bombe.getX() + 25, bombe.getY() + 25);
                }
            }
        }

        batch.end();

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
    public void resize(int width, int height) {
        // Gestion du redimensionnement si nécessaire
    }

    @Override
    public void pause() {
        // Pause si nécessaire
    }

    @Override
    public void resume() {
        // Reprise si nécessaire
    }

    @Override
    public void hide() {
        // Masquage si nécessaire
    }

    @Override
    public void dispose() {
        batch.dispose();
        bombeTexture.dispose();
        font.dispose();
    }

    @Override
    public void start() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'start'");
    }
}