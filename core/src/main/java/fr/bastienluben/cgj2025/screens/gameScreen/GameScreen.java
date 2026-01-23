package fr.bastienluben.cgj2025.screens.gameScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import fr.bastienluben.cgj2025.Main;
import fr.bastienluben.cgj2025.lib.AssetManager;
import fr.bastienluben.cgj2025.lib.Chrono;
import fr.bastienluben.cgj2025.screens.AbstractScreen;

public class GameScreen extends AbstractScreen {

    public GameScreen(Main game, AssetManager assets) {
        super(game, assets);
    }

    Chrono test;
    BarreDeVie vie;
    FeuxDartificeManager feux;

    @Override
    public void onLoad(AssetManager assets)
    {
        vie = new BarreDeVie(100, assets);
    }

    @Override
    public void start()
    {
        test = new Chrono(() ->
        {
            vie.takeDamage(-10);
        }, 1f);

        feux = new FeuxDartificeManager(16);
    }

    @Override
    public void update(float delta)
    {
        test.update(delta);
        feux.update(delta);
        if (Gdx.input.isTouched())
        {
            feux.createExplosionAt(
                new Vector2(
                Gdx.input.getX(),
                Gdx.graphics.getHeight() - Gdx.input.getY()
                ), 2f, Color.RED);
        }
    }

    @Override
    public void draw(SpriteBatch batch)
    {
        batch.begin();
        vie.draw(batch);
        feux.draw(batch);
        batch.end();
    }
}
