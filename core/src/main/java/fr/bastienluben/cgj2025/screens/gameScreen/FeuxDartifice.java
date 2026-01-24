package fr.bastienluben.cgj2025.screens.gameScreen;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import fr.bastienluben.cgj2025.Main;
import fr.bastienluben.cgj2025.lib.Lerps;
import fr.bastienluben.cgj2025.lib.entities.ISpriteDrawable;
import fr.bastienluben.cgj2025.lib.ui.Image;

import java.util.Random;

public class FeuxDartifice implements ISpriteDrawable
{
    private static final int lumCount = 32;
    private Vector2 pos;
    private Vector2[] lums;
    private Vector2[] bet;
    private Vector2[] targs;
    public boolean alive;
    private final Random rnd;
    private float timer;
    final float ft;
    private final Texture tex;
    private float size;

    public FeuxDartifice(Random rnd, float ft, Texture tex)
    {
        this.ft = ft;
        this.tex = tex;
        alive = false;
        this.rnd = rnd;
        lums = new Vector2[lumCount];
        targs = new Vector2[lumCount];
        bet = new Vector2[lumCount];
        for (int i = 0; i < lumCount; i++)
        {
            bet[i] = new Vector2();
            lums[i] = new Vector2();
            targs[i] = new Vector2();
        }
    }

    public void start(Vector2 startPos, float ampli, Color c)
    {
        for (int i = 0; i < lumCount; i++)
        {
            float dir = rnd.nextFloat((float) Math.PI * 2);
            float amp = rnd.nextFloat(200f);
            lums[i].x = startPos.x;
            lums[i].y = startPos.y;
            targs[i].x = startPos.x + (float)(Math.cos(dir) * amp * ampli);
            targs[i].y = startPos.y + (float)(Math.sin(dir) * amp * ampli);
        }

        timer = 0f;
        alive = true;
        this.color = c;
        size = 8f;
    }

    public void update(float dt)
    {
        if (timer > 1f)
        {
            alive = false;
        }

        color.a = Lerps.EaseIn(1f, 0f, timer);

        size = Lerps.EaseIn(6f, 0f, timer);

        if (alive)
        {
            for (int i = 0; i < lumCount; i++)
            {
                bet[i].x = Lerps.CubeOut(lums[i].x, targs[i].x,
                    ft > 10 ? timer : timer / 6, (byte)48);
                bet[i].y = Lerps.CubeOut(lums[i].y, targs[i].y,
                    ft > 10 ? timer : timer / 6, (byte)48);
            }
        }
        timer += dt / ft;
    }

    private Color color;

    public void draw(SpriteBatch batch)
    {
        if (alive)
        {
            batch.setColor(color);
            for (int i = 0; i < lumCount; i++)
            {
                batch.draw(tex,
                    bet[i].x - size + Main.camera.x,
                    bet[i].y - size + Main.camera.x,
                    size * 2, size * 2);
            }
            batch.setColor(Color.WHITE);
        }
    }
}
