package fr.bastienluben.cgj2025.screens.gameScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import fr.bastienluben.cgj2025.Entite.Hero;
import fr.bastienluben.cgj2025.Main;
import fr.bastienluben.cgj2025.lib.AssetManager;
import fr.bastienluben.cgj2025.lib.Chrono;
import fr.bastienluben.cgj2025.lib.ui.Image;
import fr.bastienluben.cgj2025.screens.AbstractScreen;

public class GameScreen extends AbstractScreen {
    private int level = 1;
    private FabriqueGame fabrique;
    private AbstractScreen currentScreen;
    private Image background;

    public GameScreen(Main game, AssetManager assets) {
        super(game, assets);
        fabrique = new FabriqueGame(game, assets);
    }

    Chrono test;
    BarreDeVieHero vie;
    FeuxDartificeManager feux;

    @Override
    public void onLoad(AssetManager assets)
    {
        vie = new BarreDeVieHero(assets);
        background = new Image(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), assets.getTexture("background.png"));
    }

    @Override
    public void start()
    {
        currentScreen = fabrique.fabriqueNiveauAleatoire(level, true);
    }

    @Override
    public void update(float delta)
    {
        vie.update(delta);
        if (currentScreen != null) {
            currentScreen.update(delta);
        }
    }

    @Override
    public void draw(SpriteBatch batch)
    {
        batch.begin();
        background.draw(batch);
        if (currentScreen != null) {
            currentScreen.draw(batch);
        }
        vie.draw(batch);
        batch.end();
    }

    @Override
    public void draw(ShapeRenderer batch) {
        if (currentScreen != null) {
            currentScreen.draw(batch);
        }
    }
}
