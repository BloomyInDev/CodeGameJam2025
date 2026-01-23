package fr.bastienluben.cgj2025.lib;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import fr.bastienluben.cgj2025.lib.AssetManager;
import fr.bastienluben.cgj2025.lib.IScript;

public class Chrono
{
    private float timer;
    private final Runnable action;
    private final float delay;

    public Chrono(Runnable tache, float delay)
    {
        action = tache;
        this.delay = delay;
        timer = delay + 1f;
    }

    public void reStart()
    {
        timer = 0f;
    }

    public void update(float dt)
    {
        timer += dt;
        if (timer > delay)
        {
            action.run();
            reStart();
        }
    }
}
