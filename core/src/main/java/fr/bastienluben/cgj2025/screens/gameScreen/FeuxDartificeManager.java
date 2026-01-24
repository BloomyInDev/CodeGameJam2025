package fr.bastienluben.cgj2025.screens.gameScreen;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import fr.bastienluben.cgj2025.lib.AssetManager;
import fr.bastienluben.cgj2025.lib.IScript;

import java.util.Random;

public class FeuxDartificeManager implements IScript
{
    private static final int maxfeux = 4096;
    private FeuxDartifice[] feux;
    private Random rnd;
    int currentIdex;

    public FeuxDartificeManager(float fadeTime)
    {
        feux = new FeuxDartifice[maxfeux];
        rnd = new Random();
        currentIdex = 0;
        for (int i = 0; i < maxfeux; i++)
        {
            feux[i] = new FeuxDartifice(rnd, fadeTime);
        }
    }

    @Override
    public void onLoad(AssetManager manager)
    {

    }

    @Override
    public void start()
    {

    }

    public void createExplosionAt(Vector2 pos, float aplification, Color c)
    {
        feux[currentIdex].start(pos, aplification, c);
        currentIdex++;
        if (currentIdex >= maxfeux)
        {
            currentIdex = 0;
        }
    }

    @Override
    public void update(float delta)
    {
        for (FeuxDartifice f : feux)
        {
            if (f.alive)
                f.update(delta);
        }
    }

    @Override
    public void draw(SpriteBatch batch)
    {
        for (FeuxDartifice f : feux)
        {
            if (f.alive)
                f.draw(batch);
        }
    }

    @Override
    public void draw(ShapeRenderer shape)
    {

    }
}
